package com.cn.userservice;

import java.util.List;

import com.cn.model.Mobile;
import com.cn.model.User;
import com.cn.model.UserType;

public interface UserService {
	public User queryUser(String name,String pass);
	
	public List<User> queryAllUsers();
	
	//查询用户类型
    List<UserType> queryUserTypes();
    //添加用户
    int addUser(User user);
    //删除用户
    int deleteUser(List<Integer> list);
    //查询用户的电话号码
    List<Mobile> getUsermobiles(int id);
}
