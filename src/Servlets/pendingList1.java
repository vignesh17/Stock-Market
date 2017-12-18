package Servlets;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import Models.Manager;
import Models.pendingList;
import Models.selectManager;

@ManagedBean(name = "pendingList1")
@ViewScoped
public class pendingList1 {
	
	private String firstname, lastname, address, email, username, option;

	List<String> Status;

	public pendingList1() {
		Status = new ArrayList<>();
		Status.add("YES");
		Status.add("NO");
	}

	
	public List<String> getStatus() {
		return Status;
	}
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	

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

	

	public ArrayList<pendingList1> getMessages()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return pendingList.pendingDetailsFetch();
	}

	public String result(String username, String option) throws SQLException {
		System.out.println(username +" "+ option +"inside pendingList1 - result1" );
		return pendingList.result(username, option);
	}

//	public void result(String username) throws SQLException {
//		System.out.println(username +" "+ option +"inside pendingList1 - result" );
//		 result1(username, option);
//	}





	

}