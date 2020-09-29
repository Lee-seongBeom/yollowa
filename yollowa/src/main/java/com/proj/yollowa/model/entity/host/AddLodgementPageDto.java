package com.proj.yollowa.model.entity.host;


import java.io.File;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class AddLodgementPageDto {
	private String lodgement_category;
	private String lodgement_companyName;
	private String lodgement_location;
	private String lodgement_LatLng;
	private String lodgement_hashTag;
	private String lodgement_img;
	private String information_comment;
	private String information_notice;
	private String information_basicInfo;
	private String information_addPeopleInfo;
	private String information_service;
	private String information_refundInfo;
	private MultipartFile[] titleImg;
	
	public AddLodgementPageDto() {
		
	}

	@Override
	public String toString() {
		return "AddLodgementPageDto [lodgement_category=" + lodgement_category + ", lodgement_companyName="
				+ lodgement_companyName + ", lodgement_location=" + lodgement_location + ", lodgement_LatLng="
				+ lodgement_LatLng + ", lodgement_hashTag=" + lodgement_hashTag + ", lodgement_img=" + lodgement_img
				+ ", information_comment=" + information_comment + ", information_notice=" + information_notice
				+ ", information_basicInfo=" + information_basicInfo + ", information_addPeopleInfo="
				+ information_addPeopleInfo + ", information_service=" + information_service
				+ ", information_refundInfo=" + information_refundInfo + ", titleImg=" + Arrays.toString(titleImg)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((information_addPeopleInfo == null) ? 0 : information_addPeopleInfo.hashCode());
		result = prime * result + ((information_basicInfo == null) ? 0 : information_basicInfo.hashCode());
		result = prime * result + ((information_comment == null) ? 0 : information_comment.hashCode());
		result = prime * result + ((information_notice == null) ? 0 : information_notice.hashCode());
		result = prime * result + ((information_refundInfo == null) ? 0 : information_refundInfo.hashCode());
		result = prime * result + ((information_service == null) ? 0 : information_service.hashCode());
		result = prime * result + ((lodgement_LatLng == null) ? 0 : lodgement_LatLng.hashCode());
		result = prime * result + ((lodgement_category == null) ? 0 : lodgement_category.hashCode());
		result = prime * result + ((lodgement_companyName == null) ? 0 : lodgement_companyName.hashCode());
		result = prime * result + ((lodgement_hashTag == null) ? 0 : lodgement_hashTag.hashCode());
		result = prime * result + ((lodgement_img == null) ? 0 : lodgement_img.hashCode());
		result = prime * result + ((lodgement_location == null) ? 0 : lodgement_location.hashCode());
		result = prime * result + Arrays.hashCode(titleImg);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddLodgementPageDto other = (AddLodgementPageDto) obj;
		if (information_addPeopleInfo == null) {
			if (other.information_addPeopleInfo != null)
				return false;
		} else if (!information_addPeopleInfo.equals(other.information_addPeopleInfo))
			return false;
		if (information_basicInfo == null) {
			if (other.information_basicInfo != null)
				return false;
		} else if (!information_basicInfo.equals(other.information_basicInfo))
			return false;
		if (information_comment == null) {
			if (other.information_comment != null)
				return false;
		} else if (!information_comment.equals(other.information_comment))
			return false;
		if (information_notice == null) {
			if (other.information_notice != null)
				return false;
		} else if (!information_notice.equals(other.information_notice))
			return false;
		if (information_refundInfo == null) {
			if (other.information_refundInfo != null)
				return false;
		} else if (!information_refundInfo.equals(other.information_refundInfo))
			return false;
		if (information_service == null) {
			if (other.information_service != null)
				return false;
		} else if (!information_service.equals(other.information_service))
			return false;
		if (lodgement_LatLng == null) {
			if (other.lodgement_LatLng != null)
				return false;
		} else if (!lodgement_LatLng.equals(other.lodgement_LatLng))
			return false;
		if (lodgement_category == null) {
			if (other.lodgement_category != null)
				return false;
		} else if (!lodgement_category.equals(other.lodgement_category))
			return false;
		if (lodgement_companyName == null) {
			if (other.lodgement_companyName != null)
				return false;
		} else if (!lodgement_companyName.equals(other.lodgement_companyName))
			return false;
		if (lodgement_hashTag == null) {
			if (other.lodgement_hashTag != null)
				return false;
		} else if (!lodgement_hashTag.equals(other.lodgement_hashTag))
			return false;
		if (lodgement_img == null) {
			if (other.lodgement_img != null)
				return false;
		} else if (!lodgement_img.equals(other.lodgement_img))
			return false;
		if (lodgement_location == null) {
			if (other.lodgement_location != null)
				return false;
		} else if (!lodgement_location.equals(other.lodgement_location))
			return false;
		if (!Arrays.equals(titleImg, other.titleImg))
			return false;
		return true;
	}

	public AddLodgementPageDto(String lodgement_category, String lodgement_companyName, String lodgement_location,
			String lodgement_LatLng, String lodgement_hashTag, String lodgement_img, String information_comment,
			String information_notice, String information_basicInfo, String information_addPeopleInfo,
			String information_service, String information_refundInfo, MultipartFile[] titleImg) {
		super();
		this.lodgement_category = lodgement_category;
		this.lodgement_companyName = lodgement_companyName;
		this.lodgement_location = lodgement_location;
		this.lodgement_LatLng = lodgement_LatLng;
		this.lodgement_hashTag = lodgement_hashTag;
		this.lodgement_img = lodgement_img;
		this.information_comment = information_comment;
		this.information_notice = information_notice;
		this.information_basicInfo = information_basicInfo;
		this.information_addPeopleInfo = information_addPeopleInfo;
		this.information_service = information_service;
		this.information_refundInfo = information_refundInfo;
		this.titleImg = titleImg;
	}

	public String getLodgement_category() {
		return lodgement_category;
	}

	public void setLodgement_category(String lodgement_category) {
		this.lodgement_category = lodgement_category;
	}

	public String getLodgement_companyName() {
		return lodgement_companyName;
	}

	public void setLodgement_companyName(String lodgement_companyName) {
		this.lodgement_companyName = lodgement_companyName;
	}

	public String getLodgement_location() {
		return lodgement_location;
	}

	public void setLodgement_location(String lodgement_location) {
		this.lodgement_location = lodgement_location;
	}

	public String getLodgement_LatLng() {
		return lodgement_LatLng;
	}

	public void setLodgement_LatLng(String lodgement_LatLng) {
		this.lodgement_LatLng = lodgement_LatLng;
	}

	public String getLodgement_hashTag() {
		return lodgement_hashTag;
	}

	public void setLodgement_hashTag(String lodgement_hashTag) {
		this.lodgement_hashTag = lodgement_hashTag;
	}

	public String getLodgement_img() {
		return lodgement_img;
	}

	public void setLodgement_img(String lodgement_img) {
		this.lodgement_img = lodgement_img;
	}

	public String getInformation_comment() {
		return information_comment;
	}

	public void setInformation_comment(String information_comment) {
		this.information_comment = information_comment;
	}

	public String getInformation_notice() {
		return information_notice;
	}

	public void setInformation_notice(String information_notice) {
		this.information_notice = information_notice;
	}

	public String getInformation_basicInfo() {
		return information_basicInfo;
	}

	public void setInformation_basicInfo(String information_basicInfo) {
		this.information_basicInfo = information_basicInfo;
	}

	public String getInformation_addPeopleInfo() {
		return information_addPeopleInfo;
	}

	public void setInformation_addPeopleInfo(String information_addPeopleInfo) {
		this.information_addPeopleInfo = information_addPeopleInfo;
	}

	public String getInformation_service() {
		return information_service;
	}

	public void setInformation_service(String information_service) {
		this.information_service = information_service;
	}

	public String getInformation_refundInfo() {
		return information_refundInfo;
	}

	public void setInformation_refundInfo(String information_refundInfo) {
		this.information_refundInfo = information_refundInfo;
	}

	public MultipartFile[] getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(MultipartFile[] titleImg) {
		this.titleImg = titleImg;
	}

	
}
