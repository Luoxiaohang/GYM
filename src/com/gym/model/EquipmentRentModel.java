package com.gym.model;

public class EquipmentRentModel {

	private String eRentId;
	private String eId;
	private String uId;
	private String borrowBegin;
	private String borrowEnd;
	private String borrowFee;
	private String status;

	public String geteRentId() {
		return eRentId;
	}

	public void seteRentId(String eRentId) {
		this.eRentId = eRentId;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getBorrowBegin() {
		return borrowBegin;
	}

	public void setBorrowBegin(String borrowBegin) {
		this.borrowBegin = borrowBegin;
	}

	public String getBorrowEnd() {
		return borrowEnd;
	}

	public void setBorrowEnd(String borrowEnd) {
		this.borrowEnd = borrowEnd;
	}

	public String getBorrowFee() {
		return borrowFee;
	}

	public void setBorrowFee(String borrowFee) {
		this.borrowFee = borrowFee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
