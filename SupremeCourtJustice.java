import java.time.LocalDate;

public class SupremeCourtJustice extends Politician{

    private int votesIn;
    public SupremeCourtJustice(String name, LocalDate birth, String residence, LocalDate swornin, boolean isOutOfOffice, int votesIn, String party) {
        super(name, birth, residence, swornin, isOutOfOffice, party);
        this.votesIn = votesIn;
        System.out.println("Supreme Court Justices serve for life.");
        //TODO Auto-generated constructor stub
    }

    public StringBuilder conditionVotes() {
        StringBuilder condition = new StringBuilder();
        if(!(this.votesIn >= 50 && this.votesIn <= 100)) {
            condition.append("Invalid input. You need 50 to confirm a supreme court justice to office.");
        }
        //If 85-100, unanimous among both parties.
        if(this.votesIn >= 85 && this.votesIn <= 100){
            condition.append("The confirmation was very unanimous among both parties.");
        } else if(this.votesIn >= 70 && this.votesIn < 85){
            condition.append("Most senators confirmed together.");
        } else if(this.votesIn >= 60 && this.votesIn < 70){
            condition.append("For this supreme court justice, there was a fine confirmation.");
        } 
        else if(this.votesIn >= 55 && this.votesIn < 60){
            condition.append("Fortunately, still a safe confirmation.");
        } else if(this.votesIn >= 50 && this.votesIn < 55){
            condition.append("This secretary got lucky by some crucial votes.");
        } 
        return condition;
    }
    
    public void getBeliefs(String[] beliefs){
        System.out.println("This is what " + super.getName() + " believes in.");
        for (String belief : beliefs) {
            System.out.println("- " + belief);
        }
    }

    public void getResponsbilities(String[] responsibilities){
        System.out.println("This is what " + super.getName() + " believes in.");
        for (String responsibility : responsibilities) {
            System.out.println("- " + responsibility);
        }
    }
    
}
