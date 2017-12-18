package Servlets;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Models.purchasedStock;

@ManagedBean(name = "purchasedStock1")
@SessionScoped
public class purchasedStock1 {
    private String username, stock_symbol;
    private int id, qty;
    private double price, amt;

    

    public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getStock_symbol() {
		return stock_symbol;
	}



	public void setStock_symbol(String stock_symbol) {
		this.stock_symbol = stock_symbol;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getAmt() {
		return amt;
	}



	public void setAmt(double amt) {
		this.amt = amt;
	}



	public ArrayList<purchasedStock1> getMessages()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return purchasedStock.userDetailsFetch();
    }
}