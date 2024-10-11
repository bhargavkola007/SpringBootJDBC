package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.main.dao.UserDao;
import com.main.entity.User;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner{
	@Autowired
	private UserDao user;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1=new User(1234,"Bharati","bharati@gmail.com");
		
		boolean status=user.insertUser(user1);
		if(status) {
			System.out.println("Success");
		}
		else {
			System.out.println("failed");
		}
//		
//				
//		User user1=new User(140,"Bhargav","bhargav@gmail.com");
//		boolean status=user.UpdateUser(user1);
//		if(status) {
//			System.out.println("Success");
//		}else {
//			System.out.println("Failed");
//		}
//		
//		
//		boolean status=user.Deleteuser(140);
//		if(status) {
//			System.out.println("Sucess");
//		}else {
//			System.out.println("Failed");
//		}
//		
//		
//		User user1 = user.selectUser(1432);
//		if (user1 != null) {
//		    System.out.println("Name : " + user1.getName());
//		    System.out.println("id : " + user1.getId());
//		    System.out.println("Email : " + user1.getEmail());
//		} else {
//		    System.out.println("User not found!");
//		}
		
//		List<User> list = user.allusers();
//		for(User user1:list) {
//		    System.out.println("Name : " + user1.getName());
//		    System.out.println("id : " + user1.getId());
//		    System.out.println("Email : " + user1.getEmail());
//		    System.out.println("---------------------");
//		}
	}

}
