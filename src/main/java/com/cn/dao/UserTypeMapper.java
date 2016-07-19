package com.cn.dao;

import java.util.List;

import com.cn.model.UserType;

public interface UserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserType record);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);
    
  //��ѯ�û�����
    List<UserType> selectAllTypes();
}