package Servlets;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Models.Manager;
import Models.Update;

@ManagedBean(name = "update")
@SessionScoped
public class update {
	private String firstname;
	private String lastname;
	private String address;
	private int phonenumber;
	private String email;
	private String username;
	private String password;
	private String user_Name;
	private String password1;
	private String status;

	
	
	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUser_Name() {
		return user_Name;
	}



	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}



	public String getPassword1() {
		return password1;
	}



	public void setPassword1(String password1) {
		this.password1 = password1;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String User() {
		int valid = Update.updateUser(firstname, lastname, address, phonenumber, email, password);
		if (valid != 0) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Update Unsuccessful",""));
			return "userPage?faces-redirect = true";
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Update Successful",""));
			return "userPage?faces-redirect = true";			
		}
				
	}
}
