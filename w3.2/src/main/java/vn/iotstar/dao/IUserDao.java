package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findOne(int id);
	
	void insert(UserModel user);
	void edit(UserModel user);
	void delete(int id);
	
}
