package com.gym.utils;

/**
 * 常量类
 * 
 * @author Feng
 * 
 */
public class Constant {

	public static final int SUCCESS = 1000; // 操作成功
	public static final int ERROR = 1001; // 未知错误

	public static final int NOTONLINE = 1002; // 未登录
	public static final int PASSWORDDIFFER = 1003; // 两次输入密码不一致
	public static final int PERMISSIONDENIED = 1004; // 权限不足

	public static final int USEREXIST = 1010; // 用户存在
	public static final int USERNOTEXIST = 1011; // 用户不存在
	public static final int USERPWDERROR = 1012; // 用户密码错误

	public static final int ADMINEXIST = 1020; // 管理员存在
	public static final int ADMINNOTEXIST = 1021; // 管理员不存在
	public static final int ADMINPWDERROR = 1022; // 管理员密码错误

	public static final int PARAMEMPTY = 1030; // 必填参数为空错误
	public static final int TIMEERROR = 1031; // 日期时间错误
	public static final int TIMECLASH = 1032; // 预定或租借时间冲突

	public static final int GROUNDINVALID = 1040; // 场地无效
	public static final int EQUIPMENTINVALID = 1041; // 器材无效

	public static final int HASNOTBOOK = 1050; // 您没有预定此场地
	public static final int HASNOTRENT = 1051; // 您没有租借此器材

	public static final int NOTBOOKSTATUS = 1060; // 非预定状态
	public static final int NOTUSESTATUS = 1061; // 非使用状态

}
