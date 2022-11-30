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
				
				System.out.println(temp.getChemical_no());
				System.out.println(temp.getChemical_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
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
				
				System.out.println(temp.getChemical_menufacture_no());
				System.out.println(temp.getChemical_manufacture_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
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
				
				System.out.println(temp.getWarehouse_no());
				System.out.println(temp.getWarehouse_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
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
				
				System.out.println(temp.getPatient_no());
				System.out.println(temp.getPatient_name());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
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

				System.out.println(temp.getDeal());
				System.out.println(temp.getDeal_time());
				System.out.println(temp.getPatient_no());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
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
				
				System.out.println(temp.getAdmin_name());
				System.out.println(temp.getPass_word());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			rs.close();
			conn.close();
		}
		return res;
	}
}