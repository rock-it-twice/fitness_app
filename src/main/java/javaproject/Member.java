package javaproject;

/**
 *
 * @author Rock_it_twice
 */
public class Member {
    // Fields
    private char memberType;
    private int memberID;
    private String name;     
    private double fees;
    
    // Constructors    
    public Member(char pMemberType, int pMemberID, 
            String pMemberName, double pFees)
    {
        memberType = pMemberType;
        memberID = pMemberID;
        name = pMemberName;                
        fees = pFees;        
    }
    
    //get- set- Methods
    public void setMemberType(char pMemberType)
    {
        memberType = pMemberType;
    }    
    public void setMemberID(int pMemberID)
    {
        memberID = pMemberID;
    }
    public void setName(String pMemberName)
    {
        name = pMemberName;
    }
    public void setFees(double pFees)
    {
        fees = pFees;
    }
    
    public char getMemberType()
    {
        return memberType;
    }    
    public int getMemberID()
    {
        return memberID;
    }
    public String getName()
    {
        return name;
    }
    public double getFees()
    {
        return fees;
    }
    
    //toString
    @Override
    public String toString(){
        return memberType + " , " + memberID + " , " + name + " , " + fees;
    }
}
