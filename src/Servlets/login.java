package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Models.Manager;
import Models.Update;

@ManagedBean(name = "login")
@SessionScoped
public class login {
	private String firstname;
	private String lastname;
	private String address;
	private int phonenumber;
	private String email;
	private String username;
	private String password;
	// private String user_Name;
	// private String password1;
	private String status;
	private String uid;
	private double availableBalance;


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	

	public String registerUser() {
		int valid = Manager.registerUser(firstname, lastname, address, phonenumber, email, username, password, availableBalance);
		if (valid != 0) {
			return "Registeration Successful";
		} else {
			return "Registeration Failure";
		}

	}

	public String registerManager() {
		int valid = Manager.registerManager(firstname, lastname, address, phonenumber, email, username, password,
				status);
		if (valid != 0) {
			return "Registeration Successful";
		} else {
			return "Registeration Failure";
		}

	}

	public String loginUser() throws SQLException {
		boolean valid = Manager.loginUser(username, password);
		if (valid == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd. Please enter correct username and Password", ""));
			return "Login";
		} else {
			return "userPage?faces-redirect = true";
		}
	}

	public String loginManager() throws SQLException {
		boolean valid = Manager.loginManager(username, password);
		if (valid == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd. Please enter correct username and Password", ""));
			return "Login";
		} else {
			return "managerPage?faces-redirect = true";
		}
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String fetchUserDetails()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Bean");
		System.out.println(username + "Hello");
		login check = Update.userDetailsFetch(username);
		System.out.println(firstname + "Test");
		System.out.println("After Fetch");
		if (!check.firstname.equals(null))
			return "success";
		else
			return "failed";
	}

	public String loginAdmin() throws SQLException {
		if (username.equals("admin") && password.equals("admin")) {
			return "adminHome?faces-redirect = true";
		} else {
			return "index";
		}

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
	
	public String Manager() {
		int valid = Update.updateManager(firstname, lastname, address, phonenumber, email, password);
		if (valid != 0) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Update Unsuccessful",""));
			return "managerPage?faces-redirect = true";
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Update Successful",""));
			return "managerPage?faces-redirect = true";
		}
				
	}
}
