package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import user.dao.InitializeDao;


/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class InitializeDB {
	
	public void InitDB() {
		InitializeDao dao = new InitializeDao();
		dao.initDB();
	}
	
	
	
	
	
	
		
}
