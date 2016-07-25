package cn.rainhowchan.servcie;

import java.sql.SQLException;

import cn.rainhowchan.dao.DbDao;
import cn.rainhowchan.domain.User;

public class UserService {
	private DbDao dao;
	
	public UserService(){
		dao=new DbDao();
	}
	
	public User userLogin(String username,String password) throws Exception{
		try {
			return dao.query(username,password);
		} catch (SQLException e) {
			throw new Exception("µÇÂ¼SQl´íÎó£¡");
		}
	}

	public int insertUser(User user) throws Exception{
		try {
			return dao.insert(user);
		} catch (SQLException e) {
			throw new Exception("×¢²áSQl´íÎó£¡");
		}
		
	}

	
}
