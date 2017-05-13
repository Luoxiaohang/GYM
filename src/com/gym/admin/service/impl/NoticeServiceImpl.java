package com.gym.admin.service.impl;

import java.util.List;

import com.gym.admin.service.NoticeService;
import com.gym.dao.impl.NoticeDaoImpl;
import com.gym.model.NoticeModel;
import com.gym.utils.Constant;

public class NoticeServiceImpl implements NoticeService {

	public int addNotice(NoticeModel noticeModel) {
		// TODO Auto-generated method stub

		NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();

		if (noticeDaoImpl.addNotice(noticeModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int delNotice(String nId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int alterNotice(NoticeModel noticeModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryById(String nId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryByName(String nName) {
		// TODO Auto-generated method stub
		return null;
	}

}
