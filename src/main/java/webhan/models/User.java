package webhan.models;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String email;
	private String fullname;
	private String password;
	private int roleId;
	private String img;
	private String phone;
	
	public User(String id, String email, String fullname, String password, int roleId) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.roleId = roleId;
	}

	public User(String id, String email, String fullname, String password, int roleId, String img, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.roleId = roleId;
		this.img = img;
		this.phone = phone;
	}

	public String getImg() {
		return img;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		String phoneNumberPattern = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches())
        	this.phone = phone;
	}

	public void setImg(String img) {
		if (img == null || img.trim().equals(""))
			this.img = "profile-default.png";
		else
			this.img = img;
	}

	public User(String email, String fullname, String password) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.trim().equals("")) {			
			this.email = email;
		}
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		if (fullname != null && !fullname.trim().equals("")) {			
			this.fullname = fullname;
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password != null && !password.trim().equals("")) {			
			this.password = password;
		}
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullname=" + fullname + ", password=" + password + "]";
	}	
}