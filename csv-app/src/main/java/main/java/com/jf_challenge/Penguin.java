package main.java.com.jf_challenge;
import java.io.FileReader;
import com.opencsv.CSVReader;

/*
    This file, Penguin File, is my first step to test the foundational steps and scalability on how the main program will perform. As such, the CSV reads a line from the CSV and prints out each line from the file itself. The last line's values are extracted for calculations of the Total Salary. This is unwanted for the final version of the program itself. Yet this helps me understand how to find the solution to this problem and build upon it for the next step.

    For the final implementation, please see App.Java.

*/

public class Penguin  {
    static int GroupSalary_Contract = 0;
    static int GroupSalary_PartTime = 0;
    static int GroupSalary_FullTime = 0;

    public static void main(String args[]) throws Exception 
    {  
        CSVReader reader = new CSVReader(new FileReader("./src/main/java/main/java/com/jf_challenge/Example1.csv"));
        //Reading the contents of the csv file
        String line[];
        String Name= "", Role ="", HourS ="", RateS="";
        int Hour = 0, Rate = 0, TotalSalary = 0, ContractTotalSal = 0;
        while ((line = reader.readNext()) != null) {
           for(int i = 0  ; i<line.length; i++) {
              System.out.print(line[i]+" ");
           }
           System.out.println(" ");
           Name = line[0];
           RateS = line[1];
           HourS = line[2];
           Role = line[3];
        
        
           Hour = Integer.parseInt(HourS);
           Rate = Integer.parseInt(RateS);

            if(Role.equals("CONTRACT"))
            {
                ContractTotalSal = 10000 + ( Hour*Rate);
                System.out.print("Total: $" + ContractTotalSal + "\n");
                GroupSalary_Contract += ContractTotalSal;
            }
            if(Role.equals("FULL TIME"))
            {
                TotalSalary = Hour*Rate;
                System.out.print("Total: $" +  TotalSalary + "\n");
                GroupSalary_FullTime+=TotalSalary;
            }
            if(Role.equals("PART TIME"))
            {
                TotalSalary = Hour*Rate;
                if(TotalSalary >= 50000)
                {
                    TotalSalary = 50000;
                }
                System.out.print("Total: $" +  TotalSalary + "\n");
                GroupSalary_PartTime+= TotalSalary;
            }

           System.out.println(Name + " " + Rate + " " + Hour + " " + Role);
        }

        System.out.println("Contract Group: "+ GroupSalary_Contract);
        System.out.println("Full Time Group: "+ GroupSalary_FullTime);
        System.out.println("Part Time Group: "+ GroupSalary_PartTime);
    }  
}
