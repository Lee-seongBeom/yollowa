package com.proj.yollowa.controller.activity;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.yollowa.interceptor.Auth;
import com.proj.yollowa.interceptor.AuthUser;
import com.proj.yollowa.model.entity.UserVo;
import com.proj.yollowa.model.entity.activity.ActivityDetailPageDto;
import com.proj.yollowa.model.entity.activity.ActivityReservFormPageDto;
import com.proj.yollowa.model.service.activity.ActivityService;

@Controller
@RequestMapping("/activity/")
public class ActivityDetailController {

	@Inject
	ActivityService activityService;
	
	@RequestMapping("detail/{activity_number}")
	public String activityDetail(@AuthUser UserVo userVo, @PathVariable("activity_number") int activity_number, Model model) throws SQLException {
		// 디테일리스트
		List<ActivityDetailPageDto> list =activityService.activityDetail(activity_number,model);
		
		// 이미지들
		activityService.activityImgSelect(activity_number,model);
		
		// 기본정보들
		activityService.activityInfo(activity_number, 1, model);
		
		//리뷰
		activityService.reviewList(activity_number, 1, model);
		
		// 주소 위치
		String pin=list.get(0).getActivity_location();

		// 액티비티 이름
		String name = list.get(0).getActivity_title();
		
		// 해시태그
		String hash = list.get(0).getActivity_hashTag();
		String hashTag = hash.replaceAll("&", "  ");
		model.addAttribute("hashTag", hashTag);
		
		if(userVo==null) {
			// 로그인 안되어 있을 시
			// jsp에서 받을때 null이면 nullpoint때문에 임의적으로 0 을 보내준다.
			model.addAttribute("userNumber", 0);
		}else {
			// 로그인 되어있을 시
			model.addAttribute("userNumber", userVo.getUser_number());
		}
		
		model.addAttribute("pin", pin);
		model.addAttribute("companyName", name);
		model.addAttribute("startEndDay", list.get(0));
		model.addAttribute("article", activity_number);
		
		return "activity/activityDetail";
	}
	
	
	// 액티비티 예약 post 
	@Auth
	@RequestMapping(value="detail/reservation", method=RequestMethod.POST)
	public String activityReservation(ActivityReservFormPageDto bean) {
		
		System.out.println(bean);
		
		// 사용자가 선택한 옵션 수량
//		int AReservInfo_amount = Integer.parseInt(req.getParameter("AReservInfo_amount"));
//		int AReservInfo_articleNumber = Integer.parseInt(req.getParameter("AReservInfo_articleNumber"));
//		int AReservInfo_optionNumber = Integer.parseInt(req.getParameter("AReservInfo_optionNumber"));
//		int AReservInfo_unitPrice = Integer.parseInt(req.getParameter("AReservInfo_unitPrice"));
//		
//		
//		System.out.println("AReservInfo_amount :: "+AReservInfo_amount);
//		System.out.println("AReservInfo_articleNumber :: "+AReservInfo_articleNumber);
//		System.out.println("AReservInfo_optionNumber :: "+AReservInfo_optionNumber);
//		System.out.println("AReservInfo_unitPrice :: "+AReservInfo_unitPrice);
		
		return null;
	}
	
	
	// activity 찜목록
	@Auth
	@RequestMapping(value="detail/wishInsert", method=RequestMethod.POST)
	public void lodgementWishInsert(@AuthUser UserVo userVo ,HttpServletRequest req) {
		
		int userNumber = userVo.getUser_number();
		
		System.out.println("찜목록 activityNumber :: "+req.getParameter("number"));
		int activityNumber = Integer.parseInt(req.getParameter("number"));
		
		activityService.activityWishUpdate(activityNumber, userNumber);
	}
	
	
}
