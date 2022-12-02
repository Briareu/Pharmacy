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

	public Vector<Storage> Storage_selectdata(String C_no, String W_no) throws SQLException{
		conn = getConnection();
		
		Vector<Storage> res = new Vector<Storage>();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			
			String slct = null;
			slct = "select * from Storage where Chemical_no='"+ C_no +"' and Warehouse_no='"+ W_no +"';";
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
	
	public int drug_update(String C_no, String C_name, String C_type, String C_standard, String C_m_no, String buy, String sell, String p_d, String v_d, String old_C_no) throws SQLException {
		Vector<drugInfo> res = new Vector<drugInfo>();
		res = drugInfo_selectdata(C_no, C_name, C_type, C_m_no, 0, -1, -1, -1);
		if(C_no.compareTo(old_C_no) != 0 && res.size() != 0)
			return -1;//failed at unique
		
		Vector<Manufacture> tempvec = new Vector<Manufacture>();
		tempvec = Manufacture_selectdata(C_m_no, C_name, 0, -1);
		if(tempvec.size() == 0)
			return -2;//do not match any 
		
		if(C_type.compareTo("注射") != 0 && C_type.compareTo("内服") != 0 && C_type.compareTo("外用") != 0)
			return -3;//type 
		if(C_standard.compareTo("处方") != 0 && C_standard.compareTo("非处方") != 0)
			return -3;//type
		if(Integer.parseInt(buy) <= 0 || Integer.parseInt(sell) <= 0)
			return -4;//should be larger than 0
		
		if(C_no.compareTo(old_C_no) != 0) {//foreign keys 
			Vector<Storage> temp_sto = new Vector<Storage>();
			temp_sto = Storage_selectdata(C_no, C_no, C_name, 0, -1, -1);
			if(temp_sto.size() > 0)
				return 1;
			
			Vector<Sell> temp_s = new Vector<Sell>();
			temp_s = Sell_selectdata(C_no, C_no, -1, 0);
			if(temp_s.size() > 0)
				return 2;
		}
		
		conn = getConnection();
		
		boolean rs = false;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.execute("update drugInfo set Chemical_no='"+ C_no +"', Chemical_name='"+ C_name +"', Chemical_type='"+ C_type +"', Chemical_standard='"+ C_type +"', Chemical_manufacture_no='"+ C_m_no +"', Chemical_buy_price='"+ buy +"', Chemical_sell_price='"+ sell +"' where Chemical_no='"+ old_C_no +"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("drugInfo: Successfully updated!");
		return 0;
	}
	
	public int Manufacture_update(String no, String name, String tel, String email, String old_no) throws SQLException{
		Vector<Manufacture> res = new Vector<Manufacture>();
		if(no.compareTo(old_no) != 0) {
			res = Manufacture_selectdata(no, name, 0, -1);
			if(res.size() != 0)
				return -1;//unique
			Vector<drugInfo> temp_d = new Vector<drugInfo>();
			temp_d = drugInfo_selectdata(no, name, name, no, -1, -1, -1, 0);
			if(temp_d.size() != 0)
				return -2;//foreign key
		}
		
		res = new Vector<Manufacture>();
		conn = getConnection();
		
		Boolean rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.execute("update Manufacture set Chemical_manufacture_no='"+ no +"', Chemical_manufacture_name='"+ name +"', Chemical_manufacture_tel='"+ tel +"', Chemical_email='"+ email +"' where Chemical_manufacture_no='"+ old_no +"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("Manufacture: Successfully updated!");
		return 0;
	}
	
	public int Storage_update(String C_no, String W_no, int num, String W_name, String old_C_no, String old_W_no) throws SQLException{
		if(C_no.compareTo(old_C_no) != 0 || W_no.compareTo(old_W_no) != 0) {
			Vector<drugInfo> temp_d = new Vector<drugInfo>();
			temp_d = drugInfo_selectdata(C_no, C_no, C_no, C_no, 0, -1, -1, -1);
			if(temp_d.size() == 0)
				return -1;//no match
			
			Vector<Storage> temp_s = new Vector<Storage>();
			temp_s = Storage_selectdata(C_no, W_no);
			if(temp_s.size() != 0)
				return -2;//unique
		}
		
		if(num < 0)
			return -3;//constraint
		
		conn = getConnection();
		
		Boolean rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.execute("update Storage set Chemical_no='"+ C_no +"', Warehouse_no='"+ W_no +"', Chemical_number='"+ num +"', Warehouse_name='"+ W_name +"' where Chemical_no='"+ C_no +"' and Warehouse_no='"+ W_no +"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("Storage: Successfully updated!");
		return 0;
	}
	
	public int Patient_update(String no, String name, String sex, int age, String tel, String add, String old_no) throws SQLException{
		Vector<Patient> res = new Vector<Patient>();
		if(no.compareTo(old_no) != 0) {
			res = Patient_selectdata(no, name, 0, -1);
			if(res.size() != 0)
				return -1;//unique
			res = new Vector<Patient>();
		}
		
		if(sex.compareTo("女") != 0 && sex.compareTo("男") != 0)
			return -2;
		
		if(age <= 0 && age >= 150)
			return -3;
		
		conn = getConnection();
		
		Boolean rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.execute("update Patient set Patient_no='"+ no +"', Patient_name='"+ name +"', Patient_sex='"+ sex +"', Patient_age='"+ age +"', Patient_tel='"+ age +"', Patient_add='"+ add +"' where Patient_no='"+ old_no +"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("Patient: Successfully selected!");
		return 0;
	}
	
	public int Sell_update(String P_no, String C_no, int cnt, String deal, String old_P_no, String old_C_no) throws SQLException{
		Vector<Sell> res = new Vector<Sell>();
		if(P_no.compareTo(old_P_no) != 0 || C_no.compareTo(old_C_no) != 0) {
			Vector<Patient> temp_p = new Vector<Patient>();
			temp_p = Patient_selectdata(P_no, P_no, 0, -1);
			if(temp_p.size() == 0)
				return -1;//no match
			
			res = Sell_selectdata(P_no, C_no, 0, 0);
			if(res.size() != 0)
				return -2;//unique
		}
		
		conn = getConnection();
		res = new Vector<Sell>();
		Boolean rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.execute("update Sell_rebate set Patient+no='"+ P_no +"', Chemical_no='"+ C_no +"', Count='"+ cnt +"', Deal_time='"+ deal +"' where Patient_no='"+ old_P_no +"' and Chemical='"+ old_C_no +"'");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
			conn.close();
		}
		System.out.println("Sell_rebate: Successfully updated!");
		return 0;
	}
}