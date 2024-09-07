package vn.iotstar.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public List<UserModel> findAll(){
		String sql = "SELECT * FROM users";
		List<UserModel> list = new ArrayList<UserModel>();
		
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(
						new UserModel(
								rs.getInt("id"),
								rs.getString("username"),
								rs.getString("password"),
								rs.getString("email"),
								rs.getString("fullname"),
								rs.getString("images")
								)							
						);
			}
			return list;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM Users WHERE id = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, password, images, fullname) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = super.getDatabaseConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getPassword());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		
		
		//userDao.insert(new UserModel(5, "quynh", "quynh123@gmail.com", "123", "", "1234avcd"));
		UserModel user = userDao.findById(1);
		System.out.println(user);
	
//		List<UserModel> list = userDao.findAll();
//		for (UserModel user : list) {
//			System.out.println(user);
//		}
	}
}