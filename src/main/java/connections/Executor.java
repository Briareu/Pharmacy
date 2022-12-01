package connections;

import java.sql.*;
import java.util.Vector;

import classes.*;

public class Executor extends Connector{
	
	public Vector<drugInfo> drug_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<drugInfo> res = new Vector<drugInfo>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from drugInfo");
			while(rs.next()) {
				drugInfo temp = new drugInfo(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getTime(8), rs.getTime(9), rs.getDate(8), rs.getDate(9));
				res.addElement(temp);
				
				//System.out.println(temp.getProduct_date());
				//System.out.println(temp.getValidity_date());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("drugInfo: Successfully get all messages!");
		return res;
	}
	
	public Vector<Manufacture> Manufacture_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<Manufacture> res = new Vector<Manufacture>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from Manufacture");
			while(rs.next()) {
				Manufacture temp = new Manufacture(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				res.addElement(temp);
				
				//System.out.println(temp.getChemical_menufacture_no());
				//System.out.println(temp.getChemical_manufacture_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Manufacture: Successfully get all messages!");
		return res;
	}
	
	public Vector<Storage> Storage_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<Storage> res = new Vector<Storage>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from Storage");
			while(rs.next()) {
				Storage temp = new Storage(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4));
				res.addElement(temp);
				
				//System.out.println(temp.getWarehouse_no());
				//System.out.println(temp.getWarehouse_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Storage: Successfully get all messages!");
		return res;
	}
	
	public Vector<Patient> Patient_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<Patient> res = new Vector<Patient>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from Patient");
			while(rs.next()) {
				Patient temp = new Patient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				res.addElement(temp);
				
				//System.out.println(temp.getPatient_no());
				//System.out.println(temp.getPatient_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Patient: Successfully get all messages!");
		return res;
	}
	
	public Vector<Sell> Sell_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<Sell> res = new Vector<Sell>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from Sell_rebate");
			while(rs.next()) {
				Sell temp = new Sell(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTime(4), rs.getDate(4));
				res.addElement(temp);

				//System.out.println(temp.getDeal_date());
				//System.out.println(temp.getPatient_no());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Sell_rebate: Successfully get all messages!");
		return res;
	}
	
	public Vector<AdminInfo> AdminInfo_getdata() throws SQLException{
		conn = getConnection();
		
		Vector<AdminInfo> res = new Vector<AdminInfo>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from AdminInfo");
			while(rs.next()) {
				AdminInfo temp = new AdminInfo(rs.getString(1), rs.getString(2), rs.getString(3));
				res.addElement(temp);
				
				//System.out.println(temp.getAdmin_name());
				//System.out.println(temp.getPass_word());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("AdminInfo: Successfully get all messages!");
		return res;
	}
	
	public Vector<drugInfo> drugInfo_selectdata(String no, String name, String type, String M_n, int c1, int c2, int c3, int c4) throws SQLException{
		conn = getConnection();
		
		Vector<drugInfo> res = new Vector<drugInfo>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = "select * from drugInfo";
			if(c1 != -1) {
				slct += " where Chemical_no='"+ no +"'";
			}
			if(c2 != -1) {
				if(c1 != -1)
					slct += " and Chemical_name='"+ name +"'";
				else
					slct += " where Chemical_name='"+ name +"'";
			}
			if(c3 != -1) {
				if(c1 != -1 || c2 != -1)
					slct += " and Chemical_type='"+ type +"'";
				else
					slct += " where Chemical_type='"+ type +"'";
			}
			if(c4 != -1) {
				if(c1 != -1 || c2 != -1 || c3 != -1)
					slct += " and Chemical_manufacture_no='"+ M_n +"'";
				else
					slct += " where Chemical_manufacture_no='"+ M_n +"'";
			}
			slct += ";";
			rs = st.executeQuery(slct);
			
			System.out.println(slct);
			
			while(rs.next()) {
				drugInfo temp = new drugInfo(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getTime(8), rs.getTime(9), rs.getDate(8), rs.getDate(9));
				res.addElement(temp);
				
				//System.out.println(temp.getProduct_date());
				//System.out.println(temp.getValidity_date());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("drugInfo: Successfully get selected messages!");
		return res;
	}
	
	public Vector<Manufacture> Manufacture_selectdata(String no, String name, int c1, int c2) throws SQLException{
		conn = getConnection();
		
		Vector<Manufacture> res = new Vector<Manufacture>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = null;
			if(c1 != -1 && c2 == -1) {
				slct = "select * from Manufacture where Chemical_manufacture_no='"+ no +"';";
			}
			if(c2 != -1 && c1 != -1) {
				slct = "select * from Manufacture where Chemical_manufacture_no='"+ no +"' and Chemical_manufacture_no in ("
						+ " select Chemical_manufacture_no from Manufacture where Chemical_manufacture_name='"+ name +"');";
			}
			if(c1 == -1 && c2 != -1) {
				slct = "select * from Manufacture where Chemical_manufacture_name='"+ name +"';";
			}
			if(c1 == -1 && c2 == -1) {
				slct = "select * from Manufacture;";
			}
			rs = st.executeQuery(slct);
			
			System.out.println(slct);
			
			while(rs.next()) {
				Manufacture temp = new Manufacture(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				res.addElement(temp);
				
				//System.out.println(temp.getChemical_menufacture_no());
				//System.out.println(temp.getChemical_manufacture_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Manufacture: Successfully get selected messages!");
		return res;
	}
	
	public Vector<Storage> Storage_selectdata(String C_no, String W_no, String name, int c1, int c2, int c3) throws SQLException{
		conn = getConnection();
		
		Vector<Storage> res = new Vector<Storage>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = "select * from Storage";
			if(c1 != -1) {
				slct += " where Chemical_no='"+ C_no +"'";
			}
			if(c2 != -1) {
				if(c1 != -1)
					slct += " and Warehouse_no='"+ W_no +"'";
				else
					slct += " where Warehouse_no='"+ W_no +"'";
			}
			if(c3 != -1) {
				if(c1 != -1 || c2 != -1)
					slct += " and Warehouse_name='"+ name +"'";
				else
					slct += " where Warehouse_name='"+ name +"'";
			}
			slct += ";";
			rs = st.executeQuery(slct);
			
			System.out.println(slct);
			
			while(rs.next()) {
				Storage temp = new Storage(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4));
				res.addElement(temp);
				
				//System.out.println(temp.getWarehouse_no());
				//System.out.println(temp.getWarehouse_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Storage: Successfully get selected messages!");
		return res;
	}
	
	public Vector<Patient> Patient_selectdata(String no, String name, int c1, int c2) throws SQLException{
		conn = getConnection();
		
		Vector<Patient> res = new Vector<Patient>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = null;
			if(c1 != -1 && c2 == -1) {
				slct = "select * from Patient where Patient_no='"+ no +"';";
			}
			if(c1 == -1 && c2 != -1) {
				slct = "select * from Patient where Patient_name='"+ name +"';";
			}
			if(c1 == -1 && c2 == -1) {
				slct = "select * from Patient;";
			}
			if(c2 != -1 && c2 != -1) {
				slct = "select * from Patient P1 join Patient P2 on P1.Patient_no = P2.Patient_no "
						+ "where P1.Patient_no='"+ no +"' and P2.Patient_name='"+ name +"';";
			}
			rs = st.executeQuery(slct);
			
			System.out.println(slct);
			
			while(rs.next()) {
				Patient temp = new Patient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				res.addElement(temp);
				
				//System.out.println(temp.getPatient_no());
				//System.out.println(temp.getPatient_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Patient: Successfully get selected messages!");
		return res;
	}
	
	public Vector<Sell> Sell_selectdata(String P_no, String C_no, int c1, int c2) throws SQLException{
		conn = getConnection();
		
		Vector<Sell> res = new Vector<Sell>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = "select * from Sell_rebate";
			if(c1 != -1) {
				slct += " where Patient_no='"+ P_no +"'";
			}
			if(c2 != -1) {
				if(c1 != -1)
					slct += " and Chemical_no='"+ C_no +"'";
				else
					slct += " where Chemical_no='"+ C_no +"'";
			}
			slct += ";";
			rs = st.executeQuery(slct);
			
			System.out.println(slct);
			
			while(rs.next()) {
				Sell temp = new Sell(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTime(4), rs.getDate(4));
				res.addElement(temp);

				//System.out.println(temp.getDeal_date());
				//System.out.println(temp.getPatient_no());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("Sell: Successfully get selected messages!");
		return res;
	}
	
	public Vector<AdminInfo> AdminInfo_selectdata(String no) throws SQLException{
		conn = getConnection();
		
		Vector<AdminInfo> res = new Vector<AdminInfo>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from AdminInfo where Admin_no='"+ no +"'");
			while(rs.next()) {
				AdminInfo temp = new AdminInfo(rs.getString(1), rs.getString(2), rs.getString(3));
				res.addElement(temp);
				
				//System.out.println(temp.getAdmin_name());
				//System.out.println(temp.getPass_word());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		System.out.println("AdminInfo: Successfully get selected messages!");
		return res;
	}
	
	public int AdminInfo_insertdata(String no, String name, String pswd)  throws SQLException{
		Vector<AdminInfo> res = AdminInfo_selectdata(no);
		if(res.size() != 0)
			return -1;
		
		conn = getConnection();

		boolean rs = false;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			rs = st.execute("insert into AdminInfo(Admin_no, Admin_name, Pass_word) values('"+ no +"', '"+ name +"', '"+ pswd +"')");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("AdminInfo: Successfully insert!");
		return 0;
	}
}