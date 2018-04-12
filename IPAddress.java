package ru.main;
import java.util.Scanner;
import java.util.regex.Pattern;



	public class IPAddress {


        public static void main(String[] args){

        String IP="";
        Scanner Scr = new Scanner(System.in);
        System.out.println("Enter a valid network IP:");
        // thanks to this link http://www.mkyong.com/regular-expressions/how-to-validate-ip-address-with-regular-expression/
        String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        //String pattern = "[0-255][.][0-255][.][0-255][.][0-255]";
        boolean matches = false;
        do{

            IP = Scr.nextLine();
            matches = Pattern.matches(pattern, IP);
            if(matches==false)
                System.out.println("wrong range");
        }while(!matches);

        Scr.close();
    }
}