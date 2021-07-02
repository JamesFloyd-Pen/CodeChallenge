package main.java.com.jf_challenge;
import java.io.FileReader;
import java.util.Scanner;

import com.opencsv.CSVReader;
/*
    Main class file

    To perform either command, I set the command a for the user to type all to see each every named person's total salary.   
     For command b, the user can type in CONTRACT, FULL TIME, or PARTTIME to get a specific group.
*/

public class App implements CalcSalary {
    //Lambda Statements to recall specific calculations for the total salary
    static CalcSalary employed = (hours,rate)->(hours*rate);
    static CalcSalary contractTime = (hours, rate)->(10000+(hours*rate));

    public static void main(String[] args) throws Exception {

        Scanner inputPhase = new Scanner(System.in);  
        System.out.println("Insert command: ");

        String input  = inputPhase.nextLine();
         //String input = args(0); For terminal command place holder
         //Due to a bug, I cannot get terminal commands to work, so the Scanner is an alternative for command lines. UPPER CASE SENSITIVE

         switch(input)
         {
            case "CONTRACT":
                printRow(input);
                break;
            case "FULL TIME":
                printRow(input);
                break;
            case "PART TIME":
                printRow(input);
                break;
            case "ALL":
                printAllRow();
                break;
            default:
                System.out.println("ERROR! Please input ALL, FULL TIME, PART TIME, or CONTRACT");
                break;
         }
    }
    
    /*
        This printRow method takes the phase input to only print out what GROUP the person is in. 
    */

    public static void printRow(String phase) throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader("./src/main/java/main/java/com/jf_challenge/Example1.csv"));
        String line[];
        int totalSalary = 0, rate=0, hours=0;
        String name = "", role="";
        while ((line = reader.readNext()) != null)
        {
            for(int i = 0 ; i<line.length; i++) {
                if(line[i].contains(phase))
                {
                    name =  line[0];
                    rate = Integer.parseInt(line[1]);
                    hours = Integer.parseInt(line[2]);
                    role = line[3];    
                    totalSalary = calc(hours, rate, role);
                    System.out.println(name + "'s total Salary is: $" + totalSalary);  
                }
           }
        }
    }

    /*
    This printAllRow method is a work-a-around. It is mostly duplicated code but works around one issue with the contain phase 
    (as in an OR phase=all prints out 4 times per name).

    */

    public static void printAllRow() throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader("./src/main/java/main/java/com/jf_challenge/Example1.csv"));
        String line[];
        int totalSalary = 0, rate=0, hours=0;
        String name = "", role="";
        while ((line = reader.readNext()) != null)
        {
            
            name =  line[0];
            rate = Integer.parseInt(line[1]);
            hours = Integer.parseInt(line[2]);
            role = line[3];    
            totalSalary = calc(hours, rate, role);
            System.out.println(name + "'s total Salary is: $" + totalSalary);    
        }
    }

    /*
        Takes arguments from the printAllRow/printRow loops and calculate them in the right role to create the total salary from hours*rates
    */

    public static int calc(int hours, int rate, String role)
    {
        int n = 0;
        if(role.equals("CONTRACT"))
            n = contractTime.times(hours, rate);
        if(role.equals("FULL TIME"))
            n = employed.times(hours, rate);
        if(role.equals("PART TIME"))
            n = employed.times(hours, rate);
                    if(n >= 50000)
                    n = 50000;
        return n;
    }

    /*
        7/1/2021 Update

        A simple change to the interface as I put CalcSalary in its own file.

        Here's a simple Lambda calculation for times.

    */

    @Override
    public int times(int hours, int rate) {
        // TODO Auto-generated method stub
        return hours*rate;
    }

}
