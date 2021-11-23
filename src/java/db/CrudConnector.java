/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author joao.souza
 */
public class CrudConnector {
    
    public static String TABLE_NAME = "JoaoGuilherme_tasks";
    
     public static ArrayList<String> getTasks(String user) throws Exception {
	        ArrayList<String> list = new ArrayList<>();
	        Connection con = JoaoGuilhermeDbListener.getConnection();
	        Statement stmt = con.createStatement();
                System.out.println(user + " / /* *");
	        ResultSet rs = stmt.executeQuery("select * from JoaoGuilherme_tasks where user = '" + user + "'");
	        
	        while(rs.next()) {
	            list.add(rs.getString("title"));
	        }
	        rs.close();
	        stmt.close();
	        con.close();
	        return list;
	    }
	    
	     public static void addTask(Tasks objeto) throws Exception {       
	        Connection con = JoaoGuilhermeDbListener.getConnection();
	        Statement stmt = con.createStatement();
	        System.out.println(objeto.getUser() +  " - " + objeto.getTitle());
	        stmt.execute("insert into JoaoGuilherme_tasks(title, user) values ('"+ objeto.getTitle() + "', '"+objeto.getUser()+"')");
                
	        stmt.close();
	        con.close();
	    }
	     
	     public static void removeTask(Integer taskId) throws Exception {       
	        Connection con = JoaoGuilhermeDbListener.getConnection();
	        Statement stmt = con.createStatement();
	       
	        stmt.execute("delete from "+TABLE_NAME+" where id = '"+taskId+"'");
	        stmt.close();
	        con.close();
	    }
}
