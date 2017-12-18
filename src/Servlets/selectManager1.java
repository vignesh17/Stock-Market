package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Models.selectManager;

@ManagedBean(name = "selectManager1")
@SessionScoped
public class selectManager1 {
	private String firstname, lastname, address, email, username;

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
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<selectManager1> getMessages()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return selectManager.managerDetailsFetch();
	}
	
	public String select(String username) throws SQLException {
		return selectManager.select(username);
	}

}