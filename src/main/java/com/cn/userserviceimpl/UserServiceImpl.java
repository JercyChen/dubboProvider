package com.cn.userserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.UserMapper;
import com.cn.dao.UserTypeMapper;
import com.cn.model.Mobile;
import com.cn.model.User;
import com.cn.model.UserType;
import com.cn.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired(required=true)
	private UserMapper userMapper;
	
	@Autowired(required=true)
	private UserTypeMapper userTypeMapper;
	@Override
	public User queryUser(String name,String pass) {
		return userMapper.selectOneUser(name, pass);
	}
	@Override
	public List<User> queryAllUsers() {
		return userMapper.selectAllUsers();
	}
	@Override
	public List<UserType> queryUserTypes() {
		return userTypeMapper.selectAllTypes();
	}
	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}
	@Override
	public int deleteUser(List<Integer> list) {
		return userMapper.deleteUsersByUserIds(list);
	}
	@Override
	public List<Mobile> getUsermobiles(int id) {
		return userMapper.selectUser(id).getMobiles();
	}
}
