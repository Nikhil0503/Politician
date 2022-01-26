import java.util.ArrayList;

public interface Endorsements {
    void politicianEndorsements(ArrayList<String> politicians);
    void peopleWhoThePoliticianEndorsed(ArrayList<String> politicians);
    int numberOfElectionsWon();
}
