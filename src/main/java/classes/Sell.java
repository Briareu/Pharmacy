package classes;

import java.sql.Time;
import java.util.Date;

public class Sell {
	public String Patient_no;
	public String Chemical_no;
	public int Count;
	public Time Deal_time;
	public Date Deal;
	public String Deal_date;

	public Sell(String P_n, String C_n, int count, Time deal, Date d) {
		Patient_no = P_n;
		Chemical_no = C_n;
		Count = count;
		Deal_time = deal;
		Deal = d;
		
		Deal_date = Deal.toString() + " " + Deal_time.toString();
	}
	
	public Sell(Sell temp) {
		Patient_no = temp.getPatient_no();
		Chemical_no = temp.getChemical_no();
		Count = temp.getCount();
		Deal_time = temp.getDeal_time();
		Deal = temp.getDeal();
		
		Deal_date = temp.getDeal_date();
	}
	
	public String getDeal_date() {
		return Deal_date;
	}

	public void setDeal_date(String deal_date) {
		Deal_date = deal_date;
	}

	public String getPatient_no() {
		return Patient_no;
	}
	public void setPatient_no(String patient_no) {
		Patient_no = patient_no;
	}
	public String getChemical_no() {
		return Chemical_no;
	}
	public void setChemical_no(String chemical_no) {
		Chemical_no = chemical_no;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public Time getDeal_time() {
		return Deal_time;
	}
	public void setDeal_time(Time deal_time) {
		Deal_time = deal_time;
	}
	public Date getDeal() {
		return Deal;
	}
	public void setDeal(Date deal) {
		Deal = deal;
	}
}
