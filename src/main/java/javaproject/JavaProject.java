package javaproject;

import java.util.LinkedList;
/**
 *
 * @author Rock_it_twice
 */
public class JavaProject {
    public static void main(String[] args){
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();
        while(choice != -1)
        {
            switch (choice)
            {
                case 1:
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                case 3:
                    mm.printMemberInfo(members);
                default:
                    System.out.println("Number you have entered "
                            + "is out of range. Please, try again.");
            }
            choice = mm.getChoice();
        }
        System.out.print("Good bye.");
    }
}
