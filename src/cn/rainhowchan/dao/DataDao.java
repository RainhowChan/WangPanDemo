package cn.rainhowchan.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.rainhowchan.domain.Resource;
import cn.rainhowchan.utils.DSUtils;

public class DataDao {

	public List<Resource> searchDataByLimit(int itemCount, int currentPage) throws SQLException {
		int start=(currentPage-1)*itemCount;
		String sql="select * from resources limit "+start+","+itemCount;
		QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Resource>(Resource.class));
	}

	public int addNewFileInfo(Resource resource) throws SQLException {
		String sql="insert into resources values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
		return runner.update(sql,resource.getUuidname(),resource.getRealname(),
				resource.getSavepath(),null,resource.getDescription());
	}

	public int deleteResourceByUuidName(String uuidName) throws SQLException {
		String sql="delete from resources where uuidname=?";
		QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
		return runner.update(sql, uuidName);
	}

	public Resource searchResourceByUuidName(String uuidName) throws SQLException {
		String sql="select * from resources where uuidname=?";
		QueryRunner runner = new QueryRunner(DSUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Resource>(Resource.class),uuidName);
//		 return resource.getSavepath()+"\\"+resource.getRealname();
	}
	
}
