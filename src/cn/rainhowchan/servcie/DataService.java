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
			throw new Exception("��ѯ��ԴSQL����");
		}
		
	}

	public void addNewFileInfo(Resource resource) throws Exception {
		try {
			dataDao.addNewFileInfo(resource);
		} catch (SQLException e) {
			throw new Exception("������ԴSQL����");
		}
		
	}

	public int deleteResourceByUuidName(String uuidName) throws Exception {
		try {
			return dataDao.deleteResourceByUuidName(uuidName);
		} catch (SQLException e) {
			throw new Exception("ɾ����ԴSQL����");// TODO Auto-generated catch block
		}
		
	}

	public String searchDataByUuidName(String uuidName) throws Exception {
		try {
			return dataDao.searchResourceByUuidName(uuidName);
		} catch (SQLException e) {
			throw new Exception("����ɾ����ԴSQL����");// TODO Auto-generated catch block
		}
		
	}
	
	
}
