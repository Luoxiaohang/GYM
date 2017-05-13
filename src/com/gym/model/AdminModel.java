package com.gym.model;

public class AdminModel {

	private String aId;
	private String aName;
	private String aPassword;
	private String idCardNo;
	private String birthdate;
	private String power;
	private String email;
	private String phone;
	private String status;
	private String aEntry;

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getaEntry() {
		return aEntry;
	}

	public void setaEntry(String aEntry) {
		this.aEntry = aEntry;
	}

	@Override
	public String toString() {
		return "AdminModel [aId=" + aId + ", aName=" + aName + ", aPassword="
				+ aPassword + ", idCardNo=" + idCardNo + ", birthdate="
				+ birthdate + ", power=" + power + ", email=" + email
				+ ", phone=" + phone + ", status=" + status + ", aEntry="
				+ aEntry + "]";
	}

}
