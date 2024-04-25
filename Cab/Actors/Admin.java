package Actors;
import java.util.*;
import Cab.CabService;
import Exceptions.*;

public class Admin {
    private String username;
    private String Pwd;
    private static boolean isLogin=false;

    public Admin(String username, String Pwd)
    {
        this.username = username;
        this.Pwd =Pwd;      
    }

    public void AdminLogin(String name,String password)
    {
    	if(AdminMap.containsKey(name))
    	{
    		String CorrectPass;
    		CorrectPass=AdminMap.get(name).getPwd();
    		if (password.equals(CorrectPass))
    		{
    			Admin.isLogin=true;
    			System.out.println("Welcome");
    		}
    		else 
    		{
    			try 
    			{
     	            throw new AdminException("Incorrect Pssword");
     	        }
     	        catch (AdminException ex) 
     		    {
     	   
     	            System.out.println(ex.getMessage());
     	        }
    		}
    			
    	}
    	else
    	{
    		 try 
    		 {
    	       throw new AdminException("You are not a registered user");
    	     }
    	        catch (AdminException ex) 
    		 {
    	            System.out.println(ex.getMessage());
    	     }
    	}
    }

    public String getUserName() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwd() {
        return this.Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }
   public static boolean getLogin() {
        return Admin.isLogin;
    }

    public static void setLogin(boolean b) {
        Admin.isLogin = b;
    }
    
}

