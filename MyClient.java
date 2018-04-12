package ru.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Calendar;
import java.util.Scanner;

public class MyClient {

		public static void main(String[] args) throws Exception
		{
			Socket soc = new Socket("10.110.50.152",8892);
			DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
	    	DataInputStream input=new DataInputStream(soc.getInputStream());
	    	Scanner scan = new Scanner(System.in);
	    	String ans = input.readUTF();
	    	System.out.println("Server: " + ans);
	    	while(true)
	        {
	    		System.out.print("Enter: ");
	        	String str = scan.next();
	        	dout.writeUTF(str);
	        	ans = input.readUTF();
	        	System.out.println("Server: " + ans);
	        	if(str.equals("stop"))
	        		break;
	        }
	    	soc.close();
		}
}
