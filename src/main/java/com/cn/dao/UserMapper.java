package com.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectOneUser(@Param("userName") String name,
			@Param("userPass") String pass);

	// 查询所有用户
	List<User> selectAllUsers();

	// 批量删除用户
	int deleteUsersByUserIds(@Param("userIds") List<Integer> list);
	
	//通过id获取用户的电话号码
	User selectUser(Integer id);
	
}