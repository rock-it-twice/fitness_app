package javaproject;

/**
 *
 * @author Rock_it_twice
 */
public class SingleClubMember extends Member{
    // fields
    private int club;
    
    //Constructors
    public SingleClubMember(char pMemberType, int pMemberID, 
            String pMemberName, double pFees, int pClub)
    {
        super(pMemberType, pMemberID, pMemberName, pFees);
        club = pClub;        
    }
    
    //get- set- Methods
    public void setClub(int pClub)
    {
        club = pClub;
    }
    
    public int getClub()
    {
        return club;
    }
    
    //toString
    @Override
    public String toString(){
        return super.toString() + " , " + club;
    }
}   

