package com.gym.admin.service;

import java.util.List;

import com.gym.model.NoticeModel;

public interface NoticeService {

	public int addNotice(NoticeModel noticeModel);

	public int delNotice(String nId);

	public int alterNotice(NoticeModel noticeModel);

	public List queryNotice();

	public List queryById(String nId);

	public List queryByName(String nName);

}
