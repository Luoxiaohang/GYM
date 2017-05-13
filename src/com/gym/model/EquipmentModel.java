package com.gym.model;

public class EquipmentModel {

	private String eId;
	private String eTypeId;
	private String buyDate;
	private String buyCost;
	private String eFee;
	private String status;

	private String borrowCount;

	private String eTypeName; // 种类名称

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteTypeId() {
		return eTypeId;
	}

	public void seteTypeId(String eTypeId) {
		this.eTypeId = eTypeId;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getBuyCost() {
		return buyCost;
	}

	public void setBuyCost(String buyCost) {
		this.buyCost = buyCost;
	}

	public String geteFee() {
		return eFee;
	}

	public void seteFee(String eFee) {
		this.eFee = eFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(String borrowCount) {
		this.borrowCount = borrowCount;
	}

	public String geteTypeName() {
		return eTypeName;
	}

	public void seteTypeName(String eTypeName) {
		this.eTypeName = eTypeName;
	}

}
