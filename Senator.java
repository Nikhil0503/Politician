import java.time.LocalDate;
import java.util.ArrayList;

public class Senator extends Politician implements Endorsements{
    public static final int TERM = 6;
    private String stateRepresented;

    public Senator(String name, LocalDate birth, String residence, LocalDate swornin, boolean isOutOfOffice,
    String stateRepresented, String party) {
        super(name, birth, residence, swornin, isOutOfOffice, party);
        this.stateRepresented = stateRepresented;
        //TODO Auto-generated constructor stub
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

    //This is only for one bill. We will have a for loop in the main method to print out the votes for bills.
    //Create a method that takes a String as a parameter which is the vote.
    //If a person says Aye = Yes, Nay = No(Switch case statement(compatible for lowercase + uppercase))
    public String yesOrNoVoteBills(String vote){
        String condition = "";
        switch (vote) {
            case "Aye":
                condition = "Yes";
                break;
            case "Nay":
                condition = "No";
                break;
        }
        return condition;
    }
    public String yesOrNoSupremeCourtJudge(String vote){
        String condition = "";
        switch (vote) {
            case "Aye":
            case "aye":
                condition = "Yes";
                break;
            case "Nay":
            case "nay":
                condition = "No";
                break;
        }
        return condition;
    }

    public String yesOrNoSecretaries(String vote){
        String condition = "";
        switch (vote) {
            case "Aye":
            case "aye":
                condition = "Yes";
                break;
            case "Nay":
            case "nay":
                condition = "No";
                break;
        }
        return condition;
    }
    
    public String republicanOrDemocrat(){
        String party = "";
        switch (this.stateRepresented) {
            case "Alabama":
            case "Alaska":
            case "Arizona":
            case "Arkansas":
            case "Florida":
            case "Georgia":
            case "Idaho":
            case "Indiana":
            case "Iowa":
            case "Maryland":
            case "Massachusetts":
            case "Mississippi":
            case "Missouri":
            case "Montana":
            case "Nebraska":
            case "New Hampshire":
            case "North Dakota":
            case "Ohio":
            case "Oklahoma":
            case "South Carolina":
            case "South Dakota":
            case "Tennesssee":
            case "Texas":
            case "Utah":
            case "Vermont":
            case "Virginia":
            case "West Virginia":
            case "Wyoming":
                party = "Republican";
                break;
            case "California":
            case "Colorado":
            case "Connecticut":
            case "Delaware":
            case "Hawaii":
            case "Illinois":
            case "Kansas":
            case "Kentucky":
            case "Louisiana":
            case "Maine":
            case "Michigan":
            case "Minnesota":
            case "Nevada":
            case "New Jersey":
            case "New Mexico":
            case "New York":
            case "North Carolina":
            case "Pennsylvania":
            case "Rhode Island":
            case "Washington":
            case "Wisconsin":
            party = "Democrat";
                break;
        }
        return party;
    }
    
    public void isDangerOfReelection(){
        if(republicanOrDemocrat().equals(this.stateRepresented)){
            System.out.println(super.getName() + " is in danger of reelection.");
        } else{
            System.out.println("All is good for " + super.getName());
        }
    }

    public void retiredSenatorBills(String[] bills){
        System.out.println(super.getName());
        for (String bill : bills) {
            System.out.println("- " + bill);
        }
    }

    public void activeSenatorBills(ArrayList<String> bills){
        System.out.println(super.getName());
        for (int i = 0; i < bills.size(); i++) {
            System.out.println("- " + bills.get(i));
        }
    }

    public void majority(LocalDate currentDate, int numOfGopSenators, int numOfDemSenators, 
    String leaderName){

        if(currentDate.isBefore(LocalDate.of(1789, 3, 4))){
            System.out.println("Invalid input.");
        }

        if(numOfGopSenators > numOfDemSenators){
            System.out.println("Republicans have majority. The majority leader is " + leaderName);
        } else{
            System.out.println("Democrats have majority. The majority leader is " + leaderName);
        }
        
    }
}