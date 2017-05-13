package com.gym.dao;

import java.util.List;

import com.gym.model.GroundModel;

public interface GroundDao {

	public int addGround(GroundModel groundModel);

	public int delGround(String gId);

	public int alterGround(GroundModel groundModel);

	public List queryGround();

	public GroundModel queryById(String gId);

	public GroundModel queryByName(String gName);

	public List queryAllType();
}
