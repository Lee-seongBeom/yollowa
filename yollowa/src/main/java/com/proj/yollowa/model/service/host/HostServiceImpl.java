package com.proj.yollowa.model.service.host;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.proj.yollowa.model.entity.UserVo;
import com.proj.yollowa.model.entity.host.AddLodgementPageDto;
import com.proj.yollowa.model.entity.host.LodgementUpdatePageDto;
import com.proj.yollowa.model.entity.host.LodgementVo;
import com.proj.yollowa.model.entity.host.RoomInfoVo;
import com.proj.yollowa.model.host.HostDao;

@Service
public class HostServiceImpl implements HostService {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public UserVo hostDetail(Model model, int user_number) throws SQLException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		UserVo bean = hostDao.userDetail(user_number);
		model.addAttribute("host",bean);
		return bean;
	}


	@Override
	public void selectHostLodgementList(Model model, UserVo userBean) {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		int user_number = userBean.getUser_number();
		ArrayList<LodgementVo> lodgementList = hostDao.selectHostLodgementList(user_number);
		model.addAttribute("lodgementList", lodgementList);
		
//		model.addAttribute("titleImgSize", lodgementList.size());
		// 호스트 인덱스 페이지에서 수정하기 클릭시 이미지
		System.out.println("호스트 숙박 글 사이즈 : "+lodgementList.size());
		if(lodgementList.size()!=0) {
			for(int i=0; i<lodgementList.size(); i++) {
				
				String[] imgs = lodgementList.get(i).getLodgement_img().split("&");
				model.addAttribute("titleImgSize"+i, imgs.length);
				
				for(int j=0; j<imgs.length; j++) {
					model.addAttribute("imgName"+i+j, imgs[j]);
				}
				
			}
			
			// 호스트 인덱스 페이지에서 수정하기 클릭 시 해시태그
			for(int i=0; i<lodgementList.size(); i++) {
				String[] hashTags = lodgementList.get(i).getLodgement_hashTag().split("&");
				System.out.println("해시태그 길이 :: "+hashTags.length);
				model.addAttribute("hashTagSize"+i, hashTags.length);
				
				for(int j=0; j<hashTags.length; j++) {
					model.addAttribute("hashTag"+i+j, hashTags[j]);
					System.out.println("해시태그 :: "+hashTags[j]);
				}
						
			}
		}
		
	}
	
	@Override
	public void updateHostLodgement(int lodgement_number, LodgementUpdatePageDto bean, HttpServletRequest req) throws IllegalStateException, IOException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		
		// 업데이트 타이틀이미지 업로드
		ArrayList<String> titleImgNames = new ArrayList<String>();
		String img = "";
		for(MultipartFile titleImg : bean.getTitleImg()) {
			String origin = lodgement_number+"_"+titleImg.getOriginalFilename();
			
			// 이미지 파일 사이에 &로 파싱 : (최종 데이터베이스 전달)
			img+=origin+"&";
			
			if(titleImg.getOriginalFilename().isEmpty()) {
				continue;
			}
			
			String path = "/upload/lodgement/titleImg/";
			ServletContext context = req.getSession().getServletContext();
			String realPath = context.getRealPath(path);
			
			File dest = new File(realPath+origin);
			System.out.println("이미지 저장위치"+dest.getAbsolutePath());
//			저장위치 /Users/moony/Desktop/yollowa/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yollowa/upload/lodgement/titleImg/1601213584288_bigmeet4.jpg
			
			titleImg.transferTo(dest);
			titleImgNames.add(origin);
		}
		String lodgement_img = img.substring(0,img.length()-1);
		// 파일 업로드 후 파싱하여 데이터베이스에 전달하기 위해 set
		bean.setLodgement_img(lodgement_img);
		
		// 해시태그 , 로 나눠져있는 것을 & 로 파싱
		String hash = bean.getLodgement_hashTag().replaceAll(",", "&");
		bean.setLodgement_hashTag(hash);
		
		hostDao.updateHostLodgement(lodgement_number, bean);
		
		
	}

	@Override
	public void insertLodgement(int user_number, AddLodgementPageDto bean) throws SQLException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		
		// 해쉬태그
		String lodgement_hashTag = bean.getLodgement_hashTag().replaceAll(",", "&");
		bean.setLodgement_hashTag(lodgement_hashTag);
		
		// 타이틀 이미지
//		String lodgement_img = bean.getLodgement_img().replaceAll(",", "&");
//		bean.setLodgement_img(lodgement_img);
		
		
		hostDao.insertLodgement(user_number, bean);
	}

	@Override
	public int selectLodgementNumber(int user_number, AddLodgementPageDto bean) throws SQLException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		int lodgementNumber = hostDao.selectLodgementNum(user_number, bean);
		return lodgementNumber;
	}
	
	@Override
	public String uploadLodgementImg(AddLodgementPageDto bean, int lodgementNumber, HttpServletRequest req) throws SQLException, IllegalStateException, IOException {
		List<String> titleImgNames = new ArrayList<String>();
				
		// lodgement 테이블에 update 시켜주기위해 이미지 파일 사이에 &로 파싱하기 위해 선언
		String img = "";
		
		for(MultipartFile titleImg : bean.getTitleImg()) {
			String origin = lodgementNumber+"_"+titleImg.getOriginalFilename();
			
			// 이미지 파일 사이에 &로 파싱 : (최종 데이터베이스 전달)
			img+=origin+"&";
			
			if(titleImg.getOriginalFilename().isEmpty()) {
				continue;
			}
			
			String path = "/upload/lodgement/titleImg/";
			ServletContext context = req.getSession().getServletContext();
			String realPath = context.getRealPath(path);
			
			File dest = new File(realPath+origin);
			System.out.println("이미지 저장위치"+dest.getAbsolutePath());
//			저장위치 /Users/moony/Desktop/yollowa/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/yollowa/upload/lodgement/titleImg/1601213584288_bigmeet4.jpg
			
			titleImg.transferTo(dest);
			titleImgNames.add(origin);
		}
		// 마지막에 붙은 문자 &를 삭제 하고 데이터 전송 
		String lodgement_img = img.substring(0,img.length()-1);
		System.out.println("이미지 파일 사이에 &로 파싱 : (최종 데이터베이스 전달)"+lodgement_img);
		return lodgement_img;
	}

	@Override
	public void updateLodgementImg(int lodgementNumber, String lodgement_img) throws SQLException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		hostDao.updateLodgementImg(lodgementNumber, lodgement_img);
	}

	@Override
	public void insertLodgeInfo(int lodgementNumber, AddLodgementPageDto bean) throws SQLException {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		
		// 공지사항
		if(bean.getInformation_notice().contains(",")) {
			String information_notice = bean.getInformation_notice().replaceAll(",", "&");
			bean.setInformation_notice(information_notice);
		}
		
		// 기본정보
		if(bean.getInformation_basicInfo().contains(",")) {
			String information_basicInfo = bean.getInformation_basicInfo().replaceAll(",", "&");
			bean.setInformation_basicInfo(information_basicInfo);
		}
		
		//인원 추가정보
		if(bean.getInformation_addPeopleInfo().contains(",")) {
			String information_addPeopleInfo = bean.getInformation_addPeopleInfo().replaceAll(",", "&");
			bean.setInformation_addPeopleInfo(information_addPeopleInfo);
		}
		
		// 편의시설 및 서비스
		if(bean.getInformation_service().contains(",")) {
			String information_service = bean.getInformation_service().replaceAll(",", "&");
			bean.setInformation_service(information_service);
		}
		
		// 취소 및 환불규정
		if(bean.getInformation_refundInfo().contains(",")) {
			String information_refundInfo = bean.getInformation_refundInfo().replaceAll(",", "&");
			bean.setInformation_refundInfo(information_refundInfo);
		}
		
		hostDao.insertLodgeInfo(lodgementNumber, bean);
	}

	// host/lodgeRoom -> 숙박업소명 select
	@Override
	public void selectLodgementName(int lodgement_number, Model model) {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		String lodgement_companyName = hostDao.selectLodgementName(lodgement_number);
		model.addAttribute("lodgement_companyName", lodgement_companyName);
		
	}
	
	// host/lodgeRoom -> 등록된 방 
	@Override
	public void selectLodgementRooms(int lodgement_number, Model model) {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		ArrayList<RoomInfoVo> roomList =  hostDao.selectLodgementRooms(lodgement_number);
		model.addAttribute("roomList", roomList);
	}
	
	// host/addRoom -> 유저넘버를 보내 lodgement table에 해당 유저번호로 등록 된 글이 있으면 lodgement_number return
	@Override
	public ArrayList<LodgementVo> hostNumberMatch(int user_number) {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		ArrayList<LodgementVo> matchUserNumber = hostDao.hostNumberMatch(user_number);
		
		if(matchUserNumber.size()!=0) {
			return matchUserNumber;
		}
		return null;
	}

	// host/lodgeRoom -> 방 삭제 버튼
	@Override
	public void deleteRoom(int articleNumber, int roomNumber) {
		HostDao hostDao = sqlSession.getMapper(HostDao.class);
		hostDao.deleteRoom(articleNumber,roomNumber);
			
	}


	



}