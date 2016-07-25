package cn.rainhowchan.servcie;

import java.sql.SQLException;

import cn.rainhowchan.dao.UserDao;
import cn.rainhowchan.domain.User;

public class UserService {
	private UserDao dao;
	
	public UserService(){
		dao=new UserDao();
	}
	
	public User userLogin(String username,String password) throws Exception{
		try {
			return dao.query(username,password);
		} catch (SQLException e) {
			throw new Exception("��¼SQl����");
		}
	}

	public int insertUser(User user) throws Exception{
		try {
			return dao.insert(user);
		} catch (SQLException e) {
			throw new Exception("ע��SQl����");
		}
		
	}

	
}
