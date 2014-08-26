package user.parts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.bean.RegistrantInfo;

public class RegInfDAO {
	private InitialContext initCon;
	private DataSource ds;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public RegInfDAO(){
		try{
			this.initCon = new InitialContext();
			this.ds = (DataSource)this.initCon.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insert(String regId, String regName,String regAge){
		try {
			this.stmt = con.prepareStatement("INSERT INTO task.registrants VALUES(?,?,?)");
			this.stmt.setString(1,regId);
			this.stmt.setString(2,regName);
			this.stmt.setString(3,regAge);
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(String targetId, String regName, String regAge) {
		try {
			this.stmt = con.prepareStatement("UPDATE task.registrants SET registrant_name=?,registrant_age=? WHERE registrant_id=?");
			this.stmt.setString(1,regName);
			this.stmt.setString(2,regAge);
			this.stmt.setString(3,targetId);
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String targetId) {
		try {
			this.stmt = con.prepareStatement("DELETE FROM task.registrants WHERE registrant_id=?");
			this.stmt.setString(1,targetId);
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			if(this.rs != null){
				this.rs.close();
			}
			if(this.stmt != null){
				this.stmt.close();
			}
			this.con.close();
			ds = null;
			this.initCon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<RegistrantInfo> getReglist() {
		RegistrantInfo regInfo;
		ArrayList<RegistrantInfo> arrayRegInfo = new ArrayList<RegistrantInfo>();
		try {
			this.stmt = con.prepareStatement("SELECT * FROM task.registrants");
			rs = this.stmt.executeQuery();
			while(rs.next()){
				regInfo = new RegistrantInfo(rs.getString("registrant_id"),
											 rs.getString("registrant_name"),
											 rs.getString("registrant_age"));
				arrayRegInfo.add(regInfo);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayRegInfo;
	}
	public String getNextId() {
		String nextId = null;
		try {
			this.stmt = con.prepareStatement("SELECT MAX(registrant_id) as nextId FROM task.registrants");
			rs = this.stmt.executeQuery();
			while(rs.next()){
				nextId = rs.getString("nextId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(nextId == null){
			nextId = "001";
		} else{
			nextId = String.format("%1$03d", Integer.parseInt(nextId) + 1);
		}
		return nextId;
	}

}