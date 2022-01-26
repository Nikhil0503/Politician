import java.time.LocalDate;
import java.util.ArrayList;

public class Representative extends Politician{
    public static final int TERM = 2;
    private String districtRepresented;

    public Representative(String name, LocalDate birth, String residence, LocalDate swornin, boolean isOutOfOffice,
            String districtRepresented, String party) {
        super(name, birth, residence, swornin, isOutOfOffice, party);
        this.districtRepresented = districtRepresented;
        //TODO Auto-generated constructor stub
    }

    public String getDistrictRepresented(){
        return districtRepresented;
    }

    public String secretaryMeeting(Secretary secretary, String condition){
        if(("The meeting with the secretary was proper and organized.").contains(condition)){
            condition = super.getName() + " favors " + secretary.getName();
        }

        else if(("The meeting with the secretary had some arguments but some agreements.").contains(condition)){
            condition = super.getName() + " somewhat agreees " + secretary.getName();
        }

        else if(("The meeting with the secretary was filled with arguments.").contains(condition)){
            condition = super.getName() + " doesn't favor " + secretary.getName();
        }
    return condition;
    }

    public void retiredRepresentativeBills(String[] bills){
        System.out.println(super.getName());
        for (String bill : bills) {
            System.out.println("- " + bill);
        }
    }

    public void activeRepresentativeBills(ArrayList<String> bills){
        System.out.println(super.getName());
        for (int i = 0; i < bills.size(); i++) {
            System.out.println("- " + bills.get(i));
        }
    }
}