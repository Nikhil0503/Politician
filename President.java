import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class President extends Politician implements Endorsements{
    public static final int TERM = 4;

    private ArrayList<String> billsPresident;
    private ArrayList<Integer> votesPerBill;

    public President(String nameOfPresident, LocalDate birth, String residence, LocalDate swornIn,
            boolean isOutOfOffice, List<String> billsPresident, List<Integer> votesPerBill, String party) {
                super(nameOfPresident, birth, residence, swornIn, isOutOfOffice, party);
                this.billsPresident = (ArrayList<String>) billsPresident;
                this.votesPerBill = (ArrayList<Integer>) votesPerBill;
            }

    public ArrayList<String> getBills() {
        return billsPresident;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.getName() + " was born in " + super.getBirth() + ", and currently lives in " + super.getResidence() + ". " + 
        super.getName() + " was sworn in " + super.getSwornin() + " at the age of " + super.ageSwornInOffice() + "." + 
        super.getName() +  " "  + textConditionString() + ", and in total, " + super.getName() + " has " + super.getYearsOfExperience() + 
        " years of experience in politics.";
    }
    public String isBillSuccessful(int vote){
        String successfulBill = "";
            if(vote >= 50 && vote <= 100){
                successfulBill += " was successful";
            } else{
                successfulBill += " wasn't successful";
            }
            return successfulBill;
    }
    public void isSuccessfulBills(){
        for (int i = 0; i < this.billsPresident.size(); i++) {
            System.out.println(this.billsPresident.get(i) + " " + isBillSuccessful(this.votesPerBill.get(i)));
        }
    }

    @Override
    public void politicianEndorsements(ArrayList<String> politicians) {
        // TODO Auto-generated method stub
        System.out.println("These are the people who endorsed " + super.getName() + ":");
            for (String politician : politicians) {
                // TODO Auto-generated method stub
                System.out.println(politician);
            }
    }

    @Override
    public void peopleWhoThePoliticianEndorsed(ArrayList<String> politicians) {
        // TODO Auto-generated method stub
            System.out.println("These are the people who endorsed " + super.getName() + ":");
            for (String politician : politicians) {
                // TODO Auto-generated method stub
                System.out.println(politician);
            }
    }
    @Override
    public int numberOfElectionsWon() {
        // TODO Auto-generated method stub
        return super.getYearsOfExperience() / TERM;
    }
}
