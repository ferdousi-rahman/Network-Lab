package ru.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class MyServer {
    
    public static void main(String[] args) throws Exception
    {
    	System.out.println("hello");
        ServerSocket ss = new ServerSocket(8892);
        Socket s = ss.accept();  
    	DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    	DataInputStream input=new DataInputStream(s.getInputStream());
    	dout.writeUTF("Connected");
        while(true)
        {
        	String str = input.readUTF();
        	Date date = new Date();
        	if(str.equals("date"))
        	{
        		String ans = date.toString().substring(4,11)+date.toString().substring(25,29);
        		dout.writeUTF(ans);
        	}
        	else if(str.equals("time"))
        	{
        		String ans = date.toString().substring(12,20);
        		dout.writeUTF(ans);
        	}
        	else if(str.equals("stop"))
        	{
        		dout.writeUTF("stop");
        		break;
        	}
        	else 
        		dout.writeUTF("Envalid");
        	
        }
        ss.close();
    }
    
}

