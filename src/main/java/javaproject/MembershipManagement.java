package javaproject;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Rock_it_twice
 */
public class MembershipManagement {
    //fields
    final private Scanner reader = new Scanner(System.in);
    
    //Methods
    private int getIntInput()
    {
        int choice = 0;
        while(choice == 0)       
        {
            try
            {   
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            }
            catch(InputMismatchException e)
            {
                System.out.println("ERROR: INVALID INPUT. Please try again:");                
            }
        }
        return choice;
    }
    
    public void printClubOptions()
    {
        System.out.println("club Mercury");
        System.out.println("club Neptune");
        System.out.println("club Jupiter");
        System.out.println("Multi Clubs");
    }
    
    public int getChoice()
    {
        int choice;
        System.out.println("Welcome to OZONE fitness center");
        System.out.println("===============================");
        System.out.println("1) Add member;");
        System.out.println("2) Remove member;");
        System.out.println("3) Display member information;");
        System.out.println("Please, select an option "
                + "(or enter \"-1\" to quit:)");
        choice = getIntInput();
        return choice;
    }
    
    public String addMembers(LinkedList<Member> m)
    {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;
    }
}
