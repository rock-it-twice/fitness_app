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
    final private LinkedList<String> clubOptionsList = new LinkedList();
    
    //Methods    
    private void addClub()
    {       
            clubOptionsList.clear();
            clubOptionsList.add("club Mercury");
            clubOptionsList.add("club Neptune");
            clubOptionsList.add("club Jupiter");
            clubOptionsList.add("Multi Clubs");
    }
    
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
        addClub();
        for(int i = 0; i < clubOptionsList.size(); i++)
        {
            System.out.println((i+1) + ") " + clubOptionsList.get(i));        
        }
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
        int clubsInList = clubOptionsList.size();
        
        //Name
        System.out.print("Enter name of member: ");
        name = reader.nextLine();
        
        //club selector
        printClubOptions();
        System.out.print("Enter a number in the proposed range: ");        
        club = getIntInput();
        while(club < 1 || club > (clubsInList))
        {
            System.out.print("Please, enter a number in the proposed range: ");
            club = getIntInput();
        }
        
        //memberID generator
        if(m.size() > 0)
        {
            memberID = m.getLast().getMemberID() + 1;
        }
        else
            memberID = 1;
        
        //abstract method realization of func interface
        if (club != clubsInList)
        {
            cal = (n)->{
                switch(n)
                {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nStatus: New single member added.\n");
        }
        else
        {
            cal = (n)->{
                switch(n)
                {
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nStatus: New multi member added.\n");                   
        }        
        return mem;
    }
    
    public void removeMember(LinkedList<Member> m)
    {
        int memberID;
        System.out.println("Please, enter the member ID, "
                + "that you want to delete");
        memberID = getIntInput();
        for(int i = 0; i<m.size(); i++)
        {
            if(m.get(i).getMemberID() == memberID)
            {
                m.remove(i);
                System.out.println("Member with ID " + memberID + " removed");
                return;
            }            
        }
        System.out.println("Can't find member with " + memberID + " ID.");
        
    }
    
    public void printMemberInfo(LinkedList<Member> m)
    {
        int memberID;
        System.out.println("Enter the member ID, for more getting INFO: ");
        memberID = getIntInput();
        for(int i = 0; i<m.size(); i++)
        {
            if(m.get(i).getMemberID() == memberID)
            {
                String[] memberInfo = m.get(i).toString().split(" , ");
                
                System.out.println("Member type: " + memberInfo[0]);
                System.out.println("Member ID: " + memberInfo[1]);
                System.out.println("Member name: " + memberInfo[2]);
                System.out.println("Member fees: " + memberInfo[3]);
                if(memberInfo[0].equals('S'))
                {                
                System.out.println("Club ID: " + memberInfo[4]);
                }
                else
                System.out.println("Membership points: " + memberInfo[4]);                
            }
        }
    }
}
