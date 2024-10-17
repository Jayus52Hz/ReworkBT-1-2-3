package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import vn.iotstar.models.User;

import vn.iotstar.config.DBconnectSQL;

public class UserDaoImpl implements UserDao{
	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	@Override
	public User get(String username) {
		String sql="SELECT * FROM nguoidung WHERE username=?";
		try
		{
			conn=new DBconnectSQL().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next())
			{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("pass"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO nguoidung(email,username,fullname,pass,avatar,roleid,phone,createdDate) VALUES (?,?,?,?,?,?,?,?)";
		try 
		{
			conn = new DBconnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("hello connection");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAvatar());
			ps.setInt(6,user.getRoleid());
			ps.setString(7,user.getPhone());
			ps.setDate(8, (Date) user.getCreatedDate());
			ps.executeUpdate();
		} 
		catch (Exception e) {e.printStackTrace();}

		
	}
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from nguoidung where email = ?";
		try 
		{
			conn = new DBconnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) 
			{
				duplicate = true;
			}
			ps.close();
			conn.close();
		} 
		catch (Exception ex) {}
		return duplicate;
	}
	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from nguoidung where username = ?";
		try 
		{
			conn = new DBconnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
			duplicate = true;
			}
			ps.close();
			conn.close();
		} 
		catch (Exception ex) {}
		return duplicate;

	}
	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from nguoidung where phone = ?";
		try 
		{
			conn = new DBconnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
			duplicate = true;
			}
			ps.close();
			conn.close();
		} 
		catch (Exception ex) {}
		return duplicate;
	}
	@Override
	public void modified(String username, String password) {
		String query="UPDATE nguoidung SET pass = ? WHERE username = ?";
		try
		{
			conn=new DBconnectSQL().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);
			ps.executeUpdate();
			rs=ps.executeQuery();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void updatefullname(String username, String fullname) {
		String query="UPDATE nguoidung SET fullname = ? WHERE username = ?";
		try
		{
			conn=new DBconnectSQL().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.executeUpdate();
			rs=ps.executeQuery();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void updatephone(String username, String phone) {
		String query="UPDATE nguoidung SET phone = ? WHERE username = ?";
		try
		{
			conn=new DBconnectSQL().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, phone);
			ps.setString(2, username);
			ps.executeUpdate();
			rs=ps.executeQuery();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void updateavatar(String username, String avatar) {
		String query="UPDATE nguoidung SET avatar = ? WHERE username = ?";
		try
		{
			conn=new DBconnectSQL().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, avatar);
			ps.setString(2, username);
			ps.executeUpdate();
			rs=ps.executeQuery();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}