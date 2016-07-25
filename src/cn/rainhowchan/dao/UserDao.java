package cn.rainhowchan.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.rainhowchan.domain.User;
import cn.rainhowchan.utils.DSUtils;
import cn.rainhowchan.utils.Md5Utils;

public class UserDao {

	/**
	 * 查询该用户是否在数据库存在
	 * @param user
	 * @return 
	 * @throws SQLException 
	 */
	public User query(String username,String password) throws SQLException {
		String sql="select * from user where id=? and password=?";
		QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,Md5Utils.md5(password));
		
	}

	public int insert(User user) throws SQLException {
		String sql="insert into user values(?,?,?,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(DSUtils.getDataSource());
		return queryRunner.update(sql,null,user.getUsername(),user.getPassword(),user.getGender(),user.getBirthdate(),user.getDesc());
	}

}
