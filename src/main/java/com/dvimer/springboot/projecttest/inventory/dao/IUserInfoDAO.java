package com.dvimer.springboot.projecttest.inventory.dao;

import com.dvimer.springboot.projecttest.inventory.entity.UserInfo;

public interface IUserInfoDAO
{
	UserInfo getActiveUser(String userName);

}
