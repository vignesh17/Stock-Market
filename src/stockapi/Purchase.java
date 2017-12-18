package stockapi;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.DBConn;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/purchase")
public class Purchase extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Purchase() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = DBConn.getConn();
            Statement statement = conn.createStatement();
            String symbol = request.getParameter("symbol");
            String price = request.getParameter("price");
            String qty = request.getParameter("qty");
            String amt = request.getParameter("amt");
            Double amt1 = Double.parseDouble(amt);
            String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("username");
            PreparedStatement statement1 = conn.prepareStatement("select availableBalance from user where username = ?");
            statement1.setString(1, user);
            ResultSet rs = statement1.executeQuery();
            Double amount = null;
            while(rs.next()) {
            	amount = rs.getDouble("availableBalance");
            }
            
            if(amount >= amt1) {
            	amount = amount - amt1;
            	 PreparedStatement statement2 = conn.prepareStatement("update user set availableBalance = ? where username = ?");
            	 statement2.setDouble(1, amount);
            	 statement2.setString(2, user);
            	 statement2.executeUpdate();
            	statement.executeUpdate("insert into purchase (`uid`,`stock_symbol`,`qty`,`price`,`amt`)	VALUES "
                        + "(1111,'" + symbol + "','" + qty + "','" + price + "','" + (amt) + "')");
            	RequestDispatcher rd =request.getRequestDispatcher("userPage.xhtml");
            	rd.forward(request, response);
            	
            }
            
            else {
            	response.sendRedirect("userPage.xhtml");
            }
            	
            
            
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
