import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import org.xml.sax.EntityResolver;

public class Politician implements Endorsements{
    //Create the necessary properties for politician.
    private String name;
    private LocalDate birth;
    private String residence;
    private LocalDate swornin;
    private boolean isOutOfOffice;
    private int yearsOfExperience;
    private String party;
    private President president;
    private Secretary secretary;
    private SupremeCourtJustice justice;
    private Senator senator;
    private Representative representative;
  
    public Politician(String name, LocalDate birth, String residence, LocalDate swornin, boolean isOutOfOffice, String party){
        this.name = name;
        this.birth = birth;
        this.residence = residence;
        this.swornin = swornin;
        this.isOutOfOffice = isOutOfOffice;
        this.yearsOfExperience = 0;
        this.party = party;
    }
    //Getter Methods
    public String getName() {
        return name;
    }

    public String getResidence() {
        return residence;
    }

    public LocalDate getSwornin() {
        return swornin;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getParty() {
        return party;
    }

    public boolean getIsOutOfOffice(){
        return isOutOfOffice;
    }

    public President getPresident() {
        return president;
    }
    
    public Secretary getSecretary() {
        return secretary;
    }

    public SupremeCourtJustice getSupremeCourtJustice(){
        return justice;
    }

    public Senator getSenator(){
        return senator;
    }

    public Representative getRepresentative(){
        return representative;
    }
    //Setter Methods for Residence, isOutOfOffice.
    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setOutOfOffice(boolean isOutOfOffice) {
        this.isOutOfOffice = isOutOfOffice;
    }

    public long findAge(){
        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(this.birth, now);
        return age;
    }

    public long ageSwornInOffice(){
        LocalDate now = LocalDate.now();
        return findAge() - ChronoUnit.YEARS.between(this.swornin, now);
    }
 
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience += yearsOfExperience;
    }

    public String textConditionString(){
        String text = "";
        if(this.isOutOfOffice == true){
            text += "is retired.";
        } else{
            text += "is still in office.";
        }
        return text;
    }

    public String toString(){
        return this.name + " was born in " + this.birth + ", and currently lives in " + this.residence + ". " + 
        this.name + " was sworn in " + this.swornin + " at the age of " + ageSwornInOffice() + "." + 
        this.name +  " "  + textConditionString() + ", and in total, " + this.name + " has " + this.getYearsOfExperience() + 
        " years of experience in politics.";
    } 
    
    public void politicianRating(int rating){
            if(rating > 9 && rating <= 10){
                System.out.println(this.name + " has done a lot for americans by having a plan to save the country " +
                 ", and is very likeable in this country.");
            } else if(rating > 8 && rating <= 9){
                System.out.println(this.name + " was a good politician, but didn't agree with everyone in the country.");
            } else if(rating > 6 && rating <= 8){
                System.out.println(this.name + " politician was decent. Supported some not so great bills that could've helped this country more.");
            } else if(rating > 4 && rating <= 6){
                System.out.println(this.name + " not a great politician. This politician works more for himself/rich than the hard-working citizens of this country.");
            } else{
                System.out.println(this.name + " is a terrible politician who spreads lies and believes in false information.");
            }
        }

        public void conditionPolitician(Condition type){
            switch (type) {
                case EXTREME_DEMOCRAT:
                    System.out.println(Condition.EXTREME_DEMOCRAT + ": Works for everyone and every individual must have fair shares, strongly believes in climate change.");
                    break;
                case DEMOCRAT:
                    System.out.println(Condition.DEMOCRAT + ": Strong healthcare measures for the country and is fair towards everyone.");
                    break;
                case MIDDLE:
                    System.out.println(Condition.MIDDLE + ": Not necessarily supporting Democratic/Republican policies: contrasts a lot.");
                    break;
                case REPUBLICAN:
                    System.out.println(Condition.REPUBLICAN + ": Doesn't necessarily believe in change: embraces the traditional values.");
                    break;
                case TRUMPIST:
                    System.out.println(Condition.TRUMPIST + ": Absolutely crazy in society and believes one leader is the party.");
            }
    }
        @Override
        public void politicianEndorsements(ArrayList<String> politicians) {
            System.out.println("These are the people who endorsed " + this.name + ":");
            for (String politician : politicians) {
                // TODO Auto-generated method stub
                System.out.println(politician);
            }
            
        }
        @Override
        public void peopleWhoThePoliticianEndorsed(ArrayList<String> politicians) {
            // TODO Auto-generated method stub
            System.out.println(this.name + " endorsed these politicians: ");
            for (String politician : politicians) {
                // TODO Auto-generated method stub
                System.out.println(politician);
            }
        }
        @Override
        public int numberOfElectionsWon() {
            // TODO Auto-generated method stub
            return 0;
        }
}