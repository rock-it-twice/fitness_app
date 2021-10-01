package javaproject;

/**
 *
 * @author Rock_it_twice
 */
public class MultiClubMember extends Member{
    //Fields
    int membershipPoints;
    
    //Constructors
    public MultiClubMember(char pMemberType, int pMemberID, 
            String pMemberName, double pFees, int pMembershipPoints)
    {
        super(pMemberType, pMemberID, pMemberName, pFees);
        membershipPoints = pMembershipPoints;
    }
    
    //set-get-Methods
    public void setMembershipPoints(int pMembershipPoints)
    {
        membershipPoints = pMembershipPoints;
    }
    public int getMembershipPoints()
    {
        return membershipPoints;
    }
    
    //toString
    @Override
    public String toString(){
        return super.toString() + " , " + membershipPoints;
    }
}
