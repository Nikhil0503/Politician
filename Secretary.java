import java.time.LocalDate;

public class Secretary extends Politician{

    private int votesIn;//Votes from the senate to be a secretary(part of the cabinet). 
    private String typeOfSecretary; 

    public Secretary(String name, LocalDate birth, String residence, LocalDate swornin, boolean isOutOfOffice, int votesIn, String party, String typeOfSecretary) {
        super(name, birth, residence, swornin, isOutOfOffice, party);
        this.votesIn = votesIn;
        this.typeOfSecretary = typeOfSecretary;
        //TODO Auto-generated constructor stub
    }
    
    // Create a method that takes in array of parameters as input.
    // Just simply iterate through each of the tasks.
    //Have like a bullet pt ig.  
    public void responsibilities(String[] tasks){
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
    //Create a method such that the number of votes describes the condition of how this secretary got voted to office.
    public StringBuilder conditionVotes(){
        StringBuilder condition = new StringBuilder();
        //If the votes are not between 50 to 100, then display invalid input. You need 50 to confirm a secretary to office.
        if(!(this.votesIn >= 50 && this.votesIn <= 100)) {
            condition.append("Invalid input. You need 50 to confirm a secretary to office.");
        }
        //If 85-100, unanimous among both parties.
        if(this.votesIn >= 85 && this.votesIn <= 100){
            condition.append("The confirmation was very unanimous among both parties.");
        } else if(this.votesIn >= 70 && this.votesIn < 85){
            condition.append("Most senators confirmed together.");
        } else if(this.votesIn >= 60 && this.votesIn < 70){
            condition.append("For this secretary, there was a fine confirmation.");
        } 
        else if(this.votesIn >= 55 && this.votesIn < 60){
            condition.append("Fortunately, still a safe confirmation.");
        } else if(this.votesIn >= 50 && this.votesIn < 55){
            condition.append("This secretary got lucky by some crucial votes.");
        } 
        return condition;
    }

}
