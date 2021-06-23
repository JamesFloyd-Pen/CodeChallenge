package main.java.com.jf_challenge;

/*
    Main class file
*/
enum CommandPhase
{
    ALL("ALL"),
    CONTRACT("CONTRACT"),
    FULLTIME("FULL TIME"),
    PARTTIME("PART TIME");

    private String action;

    public String getAction()
    {
        return this.action;
    }

    private CommandPhase(String Action)
    {
        this.action = action;
    }
}

/*
    To perform either commands, I set the command a for the user to type all to see each  every named person's total salary.
    For command b, the user can type in CONTRACT, FULL TIME, or PARTTIME to get a specific group.
*/

public class App {
    static CalcSalary employed = (hours,rate)->(hours*rate);
    //static CalcSalary partTime = (hours, rate)->(10000+(hours*rate));
    static CalcSalary contractTime = (hours, rate)->(10000+(hours*rate));



    public static void main(String[] args) {
        String input  = "CONTRACT";
         //String input = args(0);
        int hours = 1001, rate = 50;
        int a = employed.times(hours, rate);
        if(a >= 50000)
        {
            a = 50000;
            System.out.print(a);
        }
    }

    interface CalcSalary
    {
        int times(int hours, int rate);
    }
}
