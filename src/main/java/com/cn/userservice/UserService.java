package com.cn.userservice;

import java.util.List;

import com.cn.model.Mobile;
import com.cn.model.User;
import com.cn.model.UserType;

public interface UserService {
	public User queryUser(String name,String pass);
	
	public List<User> queryAllUsers();
	
	//��ѯ�û�����
    List<UserType> queryUserTypes();
    //����û�
    int addUser(User user);
    //ɾ���û�
    int deleteUser(List<Integer> list);
    //��ѯ�û��ĵ绰����
    List<Mobile> getUsermobiles(int id);
}
