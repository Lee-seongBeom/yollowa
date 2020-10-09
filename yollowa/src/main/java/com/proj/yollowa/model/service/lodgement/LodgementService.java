package com.proj.yollowa.model.service.lodgement;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.proj.yollowa.model.entity.lodgement.LodgementDetailPageDto;
import com.proj.yollowa.model.entity.lodgement.LodgementRoomInfoVo;

public interface LodgementService {

	// 숙박 리스트
	void lodgementListAll(Model model) throws SQLException;
	// 숙박 리스트 temp=1인 전체 개수
	int lodgementListCnt() throws SQLException;
	
	//숙박 디테일 
	List<LodgementDetailPageDto> lodgementDetail(int articleNumber, Model model) throws SQLException;
	
	

}