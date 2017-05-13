package com.gym.admin.service;

import java.util.List;

import com.gym.model.AdminModel;

public interface AdminService {

	public int addAdmin(AdminModel adminModel);

	public int delAdmin(String aId);

	public int alterAdmin(AdminModel adminModel);

	public AdminModel queryById(String aId);

	public AdminModel queryByName(String aName);

	public List queryAllAdmin();

	public List queryAllUser();

	public int delUser(String uId);

	public int isExist(String aId);

	public int login(AdminModel adminModel);

}
