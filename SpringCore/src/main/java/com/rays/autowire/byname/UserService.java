package com.rays.autowire.byname;

public class UserService {
	
	private UserDao userDao;

		public void testAdd() {
		userDao.add();
	}

		
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}

}
