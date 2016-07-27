package cn.rainhowchan.servcie;

import java.sql.SQLException;
import java.util.List;

import cn.rainhowchan.dao.DataDao;
import cn.rainhowchan.domain.Resource;

public class DataService {
	
	private DataDao dataDao;
	
	public DataService(){
		dataDao = new DataDao();
	}
	
	public List<Resource> searchDataByLimit(int itemCount, int currentPage) throws Exception {
		try {
			return dataDao.searchDataByLimit(itemCount,currentPage);
		} catch (SQLException e) {
			throw new Exception("查询资源SQL错误");
		}
		
	}

	public void addNewFileInfo(Resource resource) throws Exception {
		try {
			dataDao.addNewFileInfo(resource);
		} catch (SQLException e) {
			throw new Exception("存入资源SQL错误！");
		}
		
	}
	
	
}
