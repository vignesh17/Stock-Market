package Servlets;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Models.userList;
 
@ManagedBean(name = "userList1")
@SessionScoped
public class userList1 {
    private String firstname, lastname, address, email;
    
    
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


public ArrayList<userList1> getMessages() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return userList.userDetailsFetch();
    }
}