package cn.supermarket.manager.entity;

import java.util.Date;

public class AccountBean {

	private int a_id;
	private String a_name;
	private int a_nums;
	private double a_amount;
	private String a_unit;

	private int a_ispayed;
	private int s_id;
	private String s_name;
	private String a_Info;
	private Date a_Date;
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String aName) {
		a_name = aName;
	}
	public int getA_nums() {
		return a_nums;
	}
	public void setA_nums(int aNums) {
		a_nums = aNums;
	}
	public double getA_amount() {
		return a_amount;
	}
	public void setA_amount(double aAmount) {
		a_amount = aAmount;
	}
	public String getA_unit() {
		return a_unit;
	}
	public void setA_unit(String aUnit) {
		a_unit = aUnit;
	}
	public int getA_ispayed() {
		return a_ispayed;
	}
	public void setA_ispayed(int aIspayed) {
		a_ispayed = aIspayed;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String sName) {
		s_name = sName;
	}
	public String getA_Info() {
		return a_Info;
	}
	public void setA_Info(String aInfo) {
		a_Info = aInfo;
	}
	public Date getA_Date() {
		return a_Date;
	}
	public void setA_Date(Date aDate) {
		a_Date = aDate;
	}


}
