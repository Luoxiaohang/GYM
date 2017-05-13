package com.gym.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gym.model.EquipmentModel;
import com.gym.model.EquipmentRentModel;
import com.gym.model.GroundBookModel;
import com.gym.model.GroundModel;

/**
 * 费用计算工具类
 * 
 * @author Feng
 * 
 */
public class CalculationUitl {

	/**
	 * 按预定小时数计算金额，不足一小时按一小时计
	 * 
	 * @param groundBookModel
	 * @param groundModel
	 * @return
	 */
	public float calculaBookMoney(GroundBookModel groundBookModel,
			GroundModel groundModel) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date begin = null;
		Date end = null;

		try {
			begin = dateFormat.parse(groundBookModel.getbStartTime());
			end = dateFormat.parse(groundBookModel.getbEndTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long l = end.getTime() - begin.getTime();

		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) + (l % (60 * 60 * 1000) > 0 ? 1 : 0)); // 不足一小时按一小时计

		float fee = Float.parseFloat(groundModel.getgFee()) * hour;

		return fee;
	}

	public float calculaRentMoney(EquipmentRentModel equipmentRentModel,
			EquipmentModel equipmentModel) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date begin = null;
		Date end = null;

		try {
			begin = dateFormat.parse(equipmentRentModel.getBorrowBegin());
			end = dateFormat.parse(equipmentRentModel.getBorrowEnd());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long l = end.getTime() - begin.getTime();

		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) + (l % (60 * 60 * 1000) > 0 ? 1 : 0)); // 不足一小时按一小时计

		float fee = Float.parseFloat(equipmentModel.geteFee()) * hour;

		return fee;
	}

}
