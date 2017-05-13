package com.gym.admin.service.impl;

import java.util.List;

import com.gym.admin.service.AdminService;
import com.gym.dao.impl.AdminDaoImpl;
import com.gym.dao.impl.UserDaoImpl;
import com.gym.model.AdminModel;
import com.gym.utils.Constant;

public class AdminServiceImpl implements AdminService {

	public int addAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub

		if (adminModel.getaEntry().equals("")
				|| adminModel.getaName().equals("")
				|| adminModel.getaPassword().equals("")
				|| adminModel.getBirthdate().equals("")
				|| adminModel.getEmail().equals("")
				|| adminModel.getIdCardNo().equals("")
				|| adminModel.getPhone().equals("")
				|| adminModel.getPower().equals("")
				|| adminModel.getStatus().equals("")) {
			return Constant.PARAMEMPTY;
		}
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		if (adminDaoImpl.addAdmin(adminModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}
	}

	public int delAdmin(String aId) {
		// TODO Auto-generated method stub
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		if (adminDaoImpl.delAdmin(aId) >= 1) {
			return Constant.SUCCESS;

		} else {
			return Constant.ERROR;
		}
	}

	public int alterAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public AdminModel queryById(String aId) {
		// TODO Auto-generated method stub

		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

		return adminDaoImpl.queryAdminById(aId);
	}

	public AdminModel queryByName(String aName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryAllAdmin() {
		// TODO Auto-generated method stub
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

		return adminDaoImpl.queryAdmin();
	}

	public List queryAllUser() {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		return userDaoImpl.queryUser();
	}

	public int delUser(String uId) {
		// TODO Auto-generated method stub
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		if (userDaoImpl.delUser(uId) == 1) {
			return Constant.SUCCESS;

		} else {
			return Constant.ERROR;
		}

	}

	public int isExist(String aId) {
		// TODO Auto-generated method stub

		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

		if (adminDaoImpl.isExist(aId)) {
			return Constant.ADMINEXIST;
		} else {
			return Constant.ADMINNOTEXIST;
		}

	}

	public int login(AdminModel adminModel) {
		// TODO Auto-generated method stub

		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		System.out.print("管理员登录 :" + adminModel.toString());
		if (adminDaoImpl.checkAdmin(adminModel)) {
			System.out.println("管理员数据库登陆成功 ");
			return Constant.SUCCESS;
		} else {
			System.out.println("管理员数据库登陆失败");
			return Constant.ADMINPWDERROR;
		}

	}
}
