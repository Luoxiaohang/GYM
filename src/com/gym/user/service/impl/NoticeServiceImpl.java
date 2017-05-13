package com.gym.user.service.impl;

import java.util.List;

import com.gym.dao.impl.NoticeDaoImpl;
import com.gym.model.NoticeModel;
import com.gym.user.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	public List queryNotice() {
		// TODO Auto-generated method stub

		NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();

		return noticeDaoImpl.queryNotice();

	}

	public NoticeModel queryById(String nId) {
		// TODO Auto-generated method stub

		NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();

		return noticeDaoImpl.queryById(nId);

	}

	public NoticeModel queryByName(String nName) {
		// TODO Auto-generated method stub
		return null;
	}

}
