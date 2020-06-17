package com.dao;



import org.apache.ibatis.annotations.Param;

import com.pojo.User;

public interface UserDao {
		//验证登陆
		//查询select
		User login(User user);
		void register(User user);
}
