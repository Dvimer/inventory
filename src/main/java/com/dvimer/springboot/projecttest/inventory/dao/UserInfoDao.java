package com.dvimer.springboot.projecttest.inventory.dao;

import com.dvimer.springboot.projecttest.inventory.entity.Product;
import com.dvimer.springboot.projecttest.inventory.entity.UserInfo;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
class UserInfoDAO implements IUserInfoDAO
{
	@PersistenceContext
	private EntityManager entityManager;

	public UserInfo getActiveUser(String userName)
	{
//		UserInfo activeUserInfo = new UserInfo();
//		short enabled = 1;
//		List<?> list = entityManager.createQuery("SELECT users FROM UserInfo u WHERE userName=? and enabled=?")
//			.setParameter(1, userName).setParameter(2, enabled).getResultList();
//		if(!list.isEmpty()) {
//			activeUserInfo = (UserInfo)list.get(0);
//		}
//		return activeUserInfo;


		Session currentSession = entityManager.unwrap(Session.class);
		UserInfo userInfo = currentSession.get(UserInfo.class, userName);
		return userInfo;
	}
}