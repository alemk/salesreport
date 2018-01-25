package com.salesreport.salesreport;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class Salesreport
{
    @RequestMapping("/")
    public String salesreport()
    {
        double salestax =0;
        double totalamountdue = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter customer number");
        int customernumber = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("enter customer name");
        String customername = keyboard.nextLine();
        System.out.println("enter sales amount");
        int salesamount = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("enter the tax code");
        String taxcode = keyboard.nextLine();

        if (taxcode.equals(0))
           {
               totalamountdue = salesamount;
           }
        else if (taxcode.equals("1"))
        {
            salestax = 0.03;
            totalamountdue = salesamount + (salesamount*salestax);
        }
        else if (taxcode.equals("2"))
        {
            salestax = 0.05;
            totalamountdue = salesamount + (salesamount*salestax);
        }
        return "Sales Report " + "<br/>" + customernumber +"  ,  "+ customername +"  ,   " +
                salesamount +"  ,  " +  salestax  + "  ,  " + totalamountdue;
       }

}
