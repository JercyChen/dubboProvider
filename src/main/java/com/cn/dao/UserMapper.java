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

	// ��ѯ�����û�
	List<User> selectAllUsers();

	// ����ɾ���û�
	int deleteUsersByUserIds(@Param("userIds") List<Integer> list);
	
	//ͨ��id��ȡ�û��ĵ绰����
	User selectUser(Integer id);
	
}