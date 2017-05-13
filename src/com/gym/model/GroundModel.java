package com.gym.model;

public class GroundModel {
	private String gId;
	private String gName;
	private String tId;
	private String gFee;
	private String gStatus;
	private String gRemark;

	private String tName; // 视图中的字段

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getgFee() {
		return gFee;
	}

	public void setgFee(String gFee) {
		this.gFee = gFee;
	}

	public String getgStatus() {
		return gStatus;
	}

	public void setgStatus(String gStatus) {
		this.gStatus = gStatus;
	}

	public String getgRemark() {
		return gRemark;
	}

	public void setgRemark(String gRemark) {
		this.gRemark = gRemark;
	}

}
