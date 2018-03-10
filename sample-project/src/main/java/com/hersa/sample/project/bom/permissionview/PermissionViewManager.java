package com.hersa.sample.project.bom.permissionview;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hersa.sample.project.bom.AbstractBaseManager;
import com.hersa.sample.project.dao.permissionview.PermissionView;

public class PermissionViewManager extends AbstractBaseManager{
	
	public List<PermissionView> retrieveAllPermissionView() throws Exception{
		List<PermissionView> list = new ArrayList<PermissionView>();
		
		try {
			list = this.getPermissionViewDAO().listAllPermissionView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("An error occured while retrieving user permissons.");
		}
		return list;
	}
}
