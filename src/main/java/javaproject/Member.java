package javaproject;

/**
 *
 * @author Rock_it_twice
 */
public class Member {
    // Fields
    private int memberID;
    private String name;
    private char memberType; 
    private double fees;
    
    // Constructors    
    public Member()
    {
        memberType = pMemberType;
        int pMemberID;
        String pMemberName;
        double pFees;
        System.out.println("Member name: " + name + "/nMemberID: " + memberID);
        System.out.println("-----------------------");
    }
    
    //get- set- Methods
    public void setMemberType(char pMemberType)
    {
        memberType = pMemberType;
    }
    public char getMemberType()
    {
        return memberType;
    }
    
    public void setMemberID(int pMemberID)
    {
        memberID = pMemberID;
    }
    public int getMemberID()
    {
        return memberID;
    }
    
    public void setName(String pMemberName)
    {
        name = pMemberName;
    }
    public String getName()
    {
        return name;
    }
    
    public void setFees(double pFees)
    {
        fees = pFees;
    }
    public double getFees()
    {
        return fees;
    }
}
