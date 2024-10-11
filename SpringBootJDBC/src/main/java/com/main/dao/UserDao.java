package com.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.main.entity.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate template;
	public boolean insertUser(User user) {
		boolean status=false;
		try {
			String insert="INSERT INTO student(id,name,email) VALUES(?,?,?)";
			int i=template.update(insert,user.getId(),user.getName(),user.getEmail());
			if(i>0) {
				status=true;
			}
			else {
				status=false;
			}
		}catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;	
	}
	
	public boolean UpdateUser(User user) {
		boolean status=false;
		try {
			String update="UPDATE student SET email=? WHERE id=? AND name=?";
			int i=template.update(update,user.getEmail(),user.getId(),user.getName());
			if(i>0) {
				status=true;;
			}
			else {
				status=false;
			}
		}catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean Deleteuser(int id) {
		boolean status=false;
		try {
			String delete="DELETE FROM student WHERE ID=?";
			int i=template.update(delete,id);
			if(i>0) {
				status=true;
			}else {
				status=false;
			}
		}catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	public User selectUser(int id) {
		String select="SELECT * FROM student WHERE id=?";
		return template.queryForObject(select, new rowmapper(),id);
	}
	public List<User> allusers(){
		String select="SELECT * FROM student";
		return template.query(select,new rowmapper());
	}
	public static final class rowmapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setName(rs.getString("name"));
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			
			return user;
		}
	}
}
