package com.mycompany.jsf_act1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean(name = "myuser", eager = true)

public class User {
    String em;
    String fn;
    String mn;
    String ln;
    String ucn;
    String ua;
    int id;

    ArrayList userData;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  

    public int getId() {
    return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getUcn() {
        return ucn;
    }

    public void setUcn(String ucn) {
        this.ucn = ucn;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }
    
    
    public String delete(int id) 
             throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
      // we will execte an update sql to table user   
      // sending the new values passed to u from the sessionmap  
      
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/ciitjava_db1?zeroDateTimeBehavior=CONVERT_TO_NULL",
                         "root",
                         "");

        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("delete from `tbl_user`  where id="  +(id));
        return "grid.xhtml";
      
    }
    
    
    public String update(User u) 
             throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
      // we will execte an update sql to table user   
      // sending the new values passed to u from the sessionmap  
      
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/ciitjava_db1?zeroDateTimeBehavior=CONVERT_TO_NULL",
                         "root",
                         "");

        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("update `tbl_user` set em=\"" + u.getEm() +"\",fn=\"" + u.getFn() +"\",mn=\"" + u.getMn() +"\",ln=\"" + u.getLn() +"\",ucn=\"" + u.getUcn() +"\",ua=\"" + u.getUa() +"\" where id=" + u.getId());
        return "grid.xhtml";
      
    }
    
    public String edit(int id)
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        // edit will retrive the record from the mysql table
        
         // JDBC
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/ciitjava_db1?zeroDateTimeBehavior=CONVERT_TO_NULL",
                         "root",
                         "");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tbl_user where id=" +(id));
        
        if(rs.next())
        {
            User temp = new User();
            temp.id = rs.getInt("id");
            temp.em = rs.getString("em");
            temp.fn = rs.getString("fn");
            temp.mn = rs.getString("mn");
            temp.ln = rs.getString("ln");
            temp.ucn = rs.getString("ucn");
            temp.ua = rs.getString("ua");
            sessionMap.put("editUser", temp);
            
        }
        // JDBC
        // then, it will load the record into the edit.xhtml
        
        return "edit.xhtml";
    }
    
    public ArrayList getAll() 
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        userData = new ArrayList();
        
        // JDBC
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/ciitjava_db1?zeroDateTimeBehavior=CONVERT_TO_NULL",
                         "root",
                         "");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tbl_user");
        
        while(rs.next())
        {
            User temp = new User();
            temp.id = rs.getInt("id");
            temp.em = rs.getString("em");
            temp.fn = rs.getString("fn");
            temp.mn = rs.getString("mn");
            temp.ln = rs.getString("ln");
            temp.ucn = rs.getString("ucn");
            temp.ua = rs.getString("ua");
            userData.add(temp);
        }
        // JDBC
        return userData;
    }        
    
    
    
    public boolean save() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        // JDBC statements here
        // insert into tbl_user (`un`,`em`) values ('john doe', 'jdoe@gmail.com');
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
        Connection con = DriverManager.getConnection(
                         "jdbc:mysql://localhost:3306/ciitjava_db1?zeroDateTimeBehavior=CONVERT_TO_NULL",
                         "root",
                         "");

        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("insert into tbl_user (`id`,`em`,`fn`,`mn`,`ln`,`ucn`,`ua`) values ('"+ this.id +"','"+ this.em +"','"+ this.fn +"','"+ this.mn +"','"+ this.ln +"','"+ this.ucn +"','"+ this.ua +"');");
        if(result == 1)
            return true;
        else 
            return false;
        
    }        
    public String submit() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
       if(this.save())
           return "response.xhtml";
       else 
           return "register.xhtml";
    }
}
