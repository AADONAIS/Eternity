package cn.supermarket.manager.entity;

public class UserBean {

	private int u_id;  //用户id
	private String u_name;  //用户名
	private String u_password; //用户密码
	private String u_gender;  //用户性别
	private int u_age;  //用户年龄
	private String u_phone;  //用户手机号
	private String u_address;  //用户地址
	private String u_auth;  //用户可信度


	public UserBean() {
		super();
	}



	public UserBean(int u_id, String u_name, String u_password, String u_gender, int u_age, String u_phone, String u_address, String u_auth) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_gender = u_gender;
		this.u_age = u_age;
		this.u_phone = u_phone;
		this.u_address = u_address;
		this.u_auth = u_auth;
	}



	public int getU_id() {
		return u_id;
	}
	public void setU_id(int uId) {
		u_id = uId;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String uName) {
		u_name = uName;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String uPassword) {
		u_password = uPassword;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String uGender) {
		u_gender = uGender;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int uAge) {
		u_age = uAge;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String uPhone) {
		u_phone = uPhone;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String uAddress) {
		u_address = uAddress;
	}
	public String getU_auth() {
		return u_auth;
	}
	public void setU_auth(String uAuth) {
		u_auth = uAuth;
	}



	@Override
	public String toString() {
		return "UserBean [u_address=" + u_address + ", u_age=" + u_age + ", u_auth=" + u_auth + ", u_gender=" + u_gender + ", u_id=" + u_id + ", u_name=" + u_name + ", u_password=" + u_password
				+ ", u_phone=" + u_phone + "]";
	}


}
