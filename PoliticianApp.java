import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.crypto.spec.DHGenParameterSpec;
import javax.swing.SortingFocusTraversalPolicy;
import javax.swing.text.DateFormatter;

public class PoliticianApp {
    public static void main(String[] args) {
        System.out.println(" ______");
        System.out.println("|     |        |");
        System.out.println("|     |        |");
        System.out.println("|_____|        |   _*    |    _*           _*           |_____");
        System.out.println("|              |    |   _|_   _|_   ____    |    ____   |    |");
        System.out.println("|       (   )  |    |    |     |    |       |   |    |  |    |");
        System.out.println("|       (   )  |    |_   |/    |_   |___    |_  |____|  |    |");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY hh:mm a");
            System.out.println(now.format(formatter));
            //Welcome to Politician. It is an app that is designed to pick/discover your own politicians.
            System.out.println("Welcome to Politician."  + 
            "This app is designed to pick/discover your own politicians by inputting attributes." +  
            "You can search up anything about the politician if necessary.");
            //Ask the user for name using scanner for user input. Say hello name!
            Scanner userInput = new Scanner(System.in);
            System.out.print("What is your name: ");
            String usersName = userInput.next();
            while(!(usersName.length() > 1) || (isValidName(usersName) == false)){
                System.out.println("Invalid input. Enter another name.");
                usersName = userInput.next();
            }

            System.out.println("Hello " + usersName + "!");
            System.out.println();
            //Give a description about the app below once you entered the name.
            System.out.println("In the politician app, there is various information that you can find out based on inputting the qualities of the politician." + 
            " The world may be filled with disinformation, especially throughout these troubled times. Now, I will make sure your inputs will be valid or not." + 
            " This app is to educate people about the people who serve or have served Congress and/or the White House.");
            System.out.println();
            System.out.println("By the way, if you want to exit a program, just use control C on Mac." + 
            "For non mac users, just search up the command used to exit this program.");
            System.out.println();
            //Find out how many politicians you will choose by telling the user to input a number.
            System.out.println("Enter the number of politicians that you want.");
            int numberOfPoliticians = userInput.nextInt();
            if(numberOfPoliticians > 2){
                System.out.println("You will get " + numberOfPoliticians + " politicians.");
            }else if(numberOfPoliticians == 1){
                System.out.println("You will get " + numberOfPoliticians + " politician.");
            } else{
                while (numberOfPoliticians <= 0) {
                    System.out.println("Invalid number. Enter a different number.");
                    numberOfPoliticians = userInput.nextInt();
                }
            }
            System.out.println();
            //Create a ArrayList that has all the types of politicians(Pres,Sec,Judge,Sen,Rep)
            List<String> typesOfPoliticians = new ArrayList<>();
            typesOfPoliticians.add(0, "President");
            typesOfPoliticians.add(1, "Secretary");
            typesOfPoliticians.add(2, "Judge");
            typesOfPoliticians.add(3, "Senator");
            typesOfPoliticians.add(4, "Representative");
            
            //Create an array to store the politician objects.
            Politician[] chosenPoliticians = new Politician[numberOfPoliticians];

            //Loop through numOfPoliticans times
            for(int i = 0; i < numberOfPoliticians; i++){
                System.out.println("Enter a numbered option from(1-5): ");
                //User another forloop to loop through the arraylist values.
                //Create a bullet pointed list by adding the bulletpt before getting the value.
                for(int j = 0; j < typesOfPoliticians.size(); j++){
                    System.out.println((j + 1) + ": " + typesOfPoliticians.get(j));
                }
                //Do a try catch statement.
                //Avoid using radixes(can be messy with try catch).
                int type = userInput.nextInt();
                while(!(type >= 1 && type <= 5)){
                    System.err.println("Invalid answer. Please enter a number betweeen 1-5.");
                    type = userInput.nextInt();
                }
                System.out.println();

                if(type == 1) {
                    System.out.println("You have entered a president. " + 
                    "A president consists of qualities that you should enter below.");
                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the president's name: ");
                    String nameOfPresident = userInput.nextLine();

                    while(isValidName(nameOfPresident) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the president's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the president's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the president's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the president's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the president's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the president was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the president was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the president was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the president was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1789){
                        System.err.println("Invalid year. George Washington was the first president sworn in 1789.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the president retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("White House".equals(residence)){
                            System.out.println("Invalid current residence for a former president.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "White House";
                    }

                    List<String> billsPresident = new ArrayList<>();
                    System.out.println();
                    System.out.println("How many bills do you want the president to have? ");
                    int numOfBills = userInput.nextInt();
                    System.out.println();
                    System.out.println("You will enter " + numOfBills + " bills.");
                    System.out.println();
                    userInput.nextLine();

                    String bill;
                    for (int h = 0; h < numOfBills; h++) {
                        System.out.println("Enter a bill: ");
                        bill = userInput.nextLine();
                        while (!(bill.length() >= 5)) {
                            System.err.println("Not a valid bill.Try not to abbrevate the bill. Try again.");
                            bill = userInput.nextLine();
                        }
                        billsPresident.add(bill);
                        System.out.println();
                    }
                    
                    List<Integer> votesPerBill = new ArrayList<>();
                    System.out.println();
                    System.out.println("You will enter the number of votes that made " + 
                    numOfBills + " bills be passed.");
                    System.out.println();
                    
                    int votes;
                    for(int c = 0; c < numOfBills; c++){
                        System.out.println("Enter a given number of votes for " + billsPresident.get(c)+ ": ");
                        votes = userInput.nextInt();
                        while (!(votes >= 50)) {
                            System.err.println("Invalid number of votes. You need 50 votes for a passing bill. Please enter another bill and the votes.");
                            bill = userInput.nextLine();
                            votes = userInput.nextInt();
                            System.out.println();
                        }
                        votesPerBill.add(votes);
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the president is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }
                    System.out.println();
                    //Create a new President and set it equal to chosenPoliticians.
                    //Then give a short description of the president by giving it's name and going through the rest of the methods. 
                    chosenPoliticians[i] = new President(nameOfPresident, birth, residence, swornIn,
                    isOutOfOffice, billsPresident, votesPerBill, party);
                    System.out.println("You have created a " + typesOfPoliticians.get(0).toLowerCase() + 
                    " whose name is " + nameOfPresident + ".");
                    System.out.println("Later, there will be several methods which allow you to discover more about this president.");
                    System.out.println();
                } else if(type == 2){
                    System.out.println("You have entered a secretary. " + 
                    "A secretary consists of qualities that you should enter below.");
                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's name: ");
                    String nameOfSecretary= userInput.nextLine();

                    while(isValidName(nameOfSecretary) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the secretary's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the secretary's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the secretary was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the secretary was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the secretary was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the secretary was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1790){
                        System.err.println("Invalid year. Thomas Jefferson was the first secretary sworn in 1790.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the secretary retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former secretary.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }
                    userInput.nextLine();
                    
                    System.out.println("Enter a number of votes for the secretary: ");
                    int votesIn = userInput.nextInt();
                    while (votesIn < 50 && votesIn > 100){
                        System.err.println("Invalid number. In order for a secretary to take office, there must be at least 50 votes. Please enter again.");
                        votesIn = userInput.nextInt();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the secretary is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println("Enter a type of secretary. Don't include the Secretary of part. Just include the position(f.x. State or Treasury)");
                    System.out.println();
                    String typeOfSecretary = userInput.nextLine();
                    while(!isValidSecretary(typeOfSecretary)){
                        System.out.println("Invalid input. Please make sure you follow the directions above and make sure the input is capitalized in the beginning. Enter another type of Secretary.");
                        typeOfSecretary = userInput.nextLine();
                    }
                    //Create a new President and set it equal to chosenPoliticians.
                    //Then give a short description of the president by giving it's name and going through the rest of the methods. 
                    chosenPoliticians[i] = new Secretary(nameOfSecretary, birth, residence, swornIn,
                    isOutOfOffice,votesIn, party, typeOfSecretary);
                    System.out.println("You have created a " + typesOfPoliticians.get(1).toLowerCase() + 
                    " whose name is " + nameOfSecretary + ".");
                    System.out.println("Later, there will be several methods which allow you to discover more about this secretary.");
                    System.out.println();

            } else if(type == 3){
                System.out.println("You have entered a supreme court justice. " + 
                    "A supreme court justice consists of qualities that you should enter below.");
                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the justice's name: ");
                    String nameOfJustice= userInput.nextLine();

                    while(isValidName(nameOfJustice) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the justice's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the justice's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the justice's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the justice's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the justice's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the justice was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the justice was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the justice was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the justice was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1790){
                        System.err.println("Invalid year. John Jay was the first supreme court justice sworn in 1790.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the justice retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former justice.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }
                    userInput.nextLine();
                    
                    System.out.println("Enter a number of votes for the justice: ");
                    int votesIn = userInput.nextInt();
                    while (votesIn < 50 && votesIn > 100){
                        System.err.println("Invalid number. In order for a Supreme Court Justice to take office, there must be at least 50 votes. Please enter again.");
                        votesIn = userInput.nextInt();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the justice is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println();
                    //Create a new President and set it equal to chosenPoliticians.
                    //Then give a short description of the president by giving it's name and going through the rest of the methods. 
                    chosenPoliticians[i] = new SupremeCourtJustice(nameOfJustice, birth, residence, swornIn,
                    isOutOfOffice,votesIn, party);
                    System.out.println("You have created a " + typesOfPoliticians.get(2).toLowerCase() + 
                    " whose name is " + nameOfJustice + ".");
                    System.out.println("Later, there will be several methods which allow you to discover more about this justice.");
                    System.out.println();
                    
            } else if(type == 4){
                System.out.println("You have entered a senator. " + 
                    "A senator consists of qualities that you should enter below.");
                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the senator's name: ");
                    String nameOfSenator = userInput.nextLine();

                    while(isValidName(nameOfSenator) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the senator's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the senator's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the senator's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the senator's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the senator's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the senator was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the senator was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the senator was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the senator was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1788){
                        System.err.println("Invalid year. The first senators were sworn in 1788.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the senator retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former senator.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }

                    userInput.nextLine();
                    //Get user input for the state
                    //If the state isn't valid, then tell the user it's invalid state and enter another one.
                    System.out.println("Enter the state the senator represents: ");
                    String stateRepresented = userInput.nextLine();

                    while(!isValidState(stateRepresented)){
                        System.out.println("Invalid state. Make sure the first letters of each word are capitalized.");
                        stateRepresented = userInput.nextLine();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the senator is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println();

                    chosenPoliticians[i] = new Senator(nameOfSenator, birth, residence, swornIn, 
                    isOutOfOffice, stateRepresented, party);
                    System.out.println("You have created a " + typesOfPoliticians.get(3).toLowerCase() + 
                    " whose name is " + nameOfSenator + ".");
                    System.out.println("Later, there will be several methods which allow you to discover more about this senator.");
                    System.out.println();

            } else if(type == 5){
                System.out.println("You have entered a representative. " + 
                    "A representative consists of qualities that you should enter below.");
                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the representative's name: ");
                    String nameOfRepresentative = userInput.nextLine();

                    while(isValidName(nameOfRepresentative) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the representative's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the representative's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the representative's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the representative's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the representative's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the representative was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the representative was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the representative was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the representative was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1789){
                        System.err.println("Invalid year. The first representatives were sworn in 1789.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the representative retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former representative.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }

                    System.out.println();
                    userInput.nextLine();

                    System.out.println("Enter the state the representative is representing his/her district: ");
                    String stateRepresented = userInput.nextLine();
                    while(!isValidState(stateRepresented)){
                        System.err.println("Invalid state. Please make sure the state starts off with capital letter(s).");
                        stateRepresented = userInput.nextLine();
                    }

                    System.out.println();
                    userInput.nextLine();

                    System.out.println("Enter the district the representative is representing: ");
                    String districtRepresented = userInput.nextLine();

                    while(!isValidDistrict(stateRepresented, districtRepresented)){
                        System.err.println("Invalid district. Please make sure the district is ordinal. Search up the districts in census.gov if you're confused.");
                        districtRepresented = userInput.nextLine();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the representative is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    chosenPoliticians[i] = new Representative(nameOfRepresentative, birth, residence, swornIn, isOutOfOffice,
                    districtRepresented, party);
                    System.out.println("You have created a " + typesOfPoliticians.get(4).toLowerCase() + 
                    " whose name is " + nameOfRepresentative + ".");
                    System.out.println("Later, there will be several methods which allow you to discover more about this representative.");
                    System.out.println();
                }
            }
            userInput.nextLine();
            System.out.println("You have a chance to delete some politicians, but it's your choice. To delete, enter how many politicians you want to keep from 0 to the number of politicians that you chose initially.");
            System.out.println("Enter another number from 0 to " + (chosenPoliticians.length));
            int anotherNumbar = userInput.nextInt();
            while(!(anotherNumbar >= 0 && anotherNumbar <= chosenPoliticians.length)){
                System.err.println("Invalid number. Please enter another number.");
                anotherNumbar = userInput.nextInt();
            }
            System.out.println("You have kept " + anotherNumbar + "politicians.");

            Politician[] newPoliticians = new Politician[anotherNumbar];

            ArrayList<String> optionList = new ArrayList<>();
            optionList.add("Get Bio");
            optionList.add("Bills/What the politician did during his/her tenure");
            optionList.add("Ratings as Politician");
            optionList.add("Endorsements/Support");

            for(int g = 0; g < newPoliticians.length; g++){
                userInput.nextLine(); 
                System.out.println("Enter a number from 0 - " + (anotherNumbar-1) + ": ");
                int numberedPolitician = userInput.nextInt();
                while(!(numberedPolitician >= 0 && numberedPolitician <= (anotherNumbar-1))){
                    System.err.println("Invalid number. Please enter another number from 0-5.");
                    numberedPolitician = userInput.nextInt();
                }
                newPoliticians[g] = chosenPoliticians[numberedPolitician];
                System.out.println("You chose " + newPoliticians[g].getName() + 
                ". Below, there are various choices to explore the politician by entering a number from 1-4");

                userInput.nextLine();
                System.out.println("Enter a numbered option(1-4): ");
                for (int j = 0; j < 4; j++) {
                    System.out.println((j+1) + ": " + optionList.get(j));
                }
                int option = userInput.nextInt();
                while(!(option >= 1 && option <= 4)){
                    System.err.println("Invalid number. Please enter another number from 1-4.");
                    option = userInput.nextInt();
                }
                userInput.nextLine();
                if(option == 1){
                    String newFormat = "MM-dd-yyyy";
                    DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern(newFormat);
                        newPoliticians[g].getBirth().format(newFormatter);
                        newPoliticians[g].getSwornin().format(newFormatter);
                        newPoliticians[g].toString();
                } else if(option == 2){
                    if(newPoliticians[g] instanceof President){
                        newPoliticians[g].getPresident().isSuccessfulBills();
                    } else if(newPoliticians[g] instanceof Secretary){
                            System.out.println("Enter a number of tasks that the Secretary does: ");
                            int number = userInput.nextInt();

                            String[] tasks = new String[number];

                            for(int i = 0; i < tasks.length; i++){
                                userInput.nextLine();
                                System.out.println("Enter a task: ");
                                String task = userInput.nextLine();
                                tasks[i] = task;
                            }
                            newPoliticians[g].getSecretary().responsibilities(tasks);
                    } else if(newPoliticians[g] instanceof SupremeCourtJustice){
                        System.out.println("Enter a number of tasks that the justice does: ");
                        int number = userInput.nextInt();

                        String[] responsibilities = new String[number];

                        for(int i = 0; i < responsibilities.length; i++){
                            userInput.nextLine();
                                System.out.println("Enter a task: ");
                                String responsibility = userInput.nextLine();
                                responsibilities[i] = responsibility;
                        }
                        newPoliticians[g].getSupremeCourtJustice().getResponsbilities(responsibilities);                       
                    } else if(newPoliticians[g] instanceof Senator){
                        if(newPoliticians[g].getIsOutOfOffice() == true){
                            System.out.println("Enter a given number of bills: ");
                            int number = userInput.nextInt();

                            String[] bills = new String[number];

                            for(int i = 0; i < bills.length; i++){
                                userInput.nextLine();
                                System.out.println("Enter a bill: ");
                                String bill = userInput.nextLine();
                                bills[i] = bill;
                            }

                            newPoliticians[g].getSenator().retiredSenatorBills(bills);
                        } else{
                            System.out.println("Enter a given number of bills: ");
                            int number = userInput.nextInt();

                            ArrayList<String> bills = new ArrayList<>();

                            for(int i = 0; i < bills.size(); i++){
                                userInput.nextLine();
                                System.out.println("Enter a bill: ");
                                String bill = userInput.nextLine();
                                bills.add(i, bill);
                            }

                            newPoliticians[g].getSenator().activeSenatorBills(bills);
                        }
                        ArrayList<Secretary> listOfSecretaries = new ArrayList<>();

                        userInput.nextLine();

                        System.out.println("Enter a number of secretaries: ");
                        int secretaryNumber = userInput.nextInt();

                 for(int i = 0; i < secretaryNumber; i++){
                     System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's name: ");
                    String nameOfSecretary= userInput.nextLine();

                    while(isValidName(nameOfSecretary) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the secretary's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the secretary's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the secretary was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the secretary was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the secretary was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the secretary was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1790){
                        System.err.println("Invalid year. Thomas Jefferson was the first secretary sworn in 1790.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the secretary retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former secretary.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }
                    userInput.nextLine();
                    
                    System.out.println("Enter a number of votes for the secretary: ");
                    int votesIn = userInput.nextInt();
                    while (!(votesIn <= 50 && votesIn >= 100)){
                        System.err.println("Invalid number. In order for a secretary to take office, there must be at least 50 votes. Please enter again.");
                        votesIn = userInput.nextInt();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the secretary is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println("Enter a type of secretary. Don't include the Secretary of part. Just include the position(f.x. State or Treasury)");
                    System.out.println();
                    String typeOfSecretary = userInput.nextLine();
                    while(!isValidSecretary(typeOfSecretary)){
                        System.out.println("Invalid input. Please make sure you follow the directions above. Enter another type of Secretary.");
                        typeOfSecretary = userInput.nextLine();
                    }
                    listOfSecretaries.add(new Secretary(nameOfSecretary, birth, residence, swornIn,
                    isOutOfOffice,votesIn, party, typeOfSecretary));         
                  }
                  System.out.println(newPoliticians[g].getSenator().getName() + 
                    " voted Aye or Nay for each Secretary: ");
                    String ayeOrNay;
                    for(int i = 0; i < listOfSecretaries.size(); i++){
                        userInput.nextLine();
                        ayeOrNay = userInput.nextLine();
                        while(!((ayeOrNay.equals("Aye") || ayeOrNay.equals("aye")) || (ayeOrNay.equals("No") || ayeOrNay.equals("no")))){
                            System.err.println("Invalid input. Please enter Aye/aye or Nay/nay.");
                            ayeOrNay = userInput.nextLine();   
                        }

                        System.out.println("\t - " + listOfSecretaries.get(i).getName() + ": " + newPoliticians[g].getSenator().yesOrNoSecretaries(ayeOrNay));
                    }

                    userInput.nextLine();
                    for(int i = 0; i < listOfSecretaries.size(); i++){
                        System.out.println("Enter aye or nay for the secretary: ");
                        String yesOrNoSecretary = userInput.nextLine();
                        while(!(yesOrNoSecretary.equals("Yes") || yesOrNoSecretary.equals("yes")) 
                        || !(yesOrNoSecretary.equals("No") || yesOrNoSecretary.equals("no"))){
                            System.err.println("Invalid input. Please enter yes or no another time.");
                            yesOrNoSecretary = userInput.nextLine();
                        }
                        System.out.println(listOfSecretaries.get(i).getName() + ": " + newPoliticians[g].getSenator().yesOrNoSecretaries(yesOrNoSecretary));
                    }

                    ArrayList<SupremeCourtJustice> listOfJustices = new ArrayList<>();
                    userInput.nextLine();
                    System.out.println("Enter a number of justices that you would like to input: ");
                    int justiceNumber = userInput.nextInt();

                    for(int i = 0; i < justiceNumber; i++){
                        userInput.nextLine();
                        System.out.println("Enter the justice's name: ");
                    String nameOfJustice= userInput.nextLine();

                    while(isValidName(nameOfJustice) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the justice's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the justice's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the justice's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the justice's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the justice's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the justice was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the justice was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the justice was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the justice was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1790){
                        System.err.println("Invalid year. John Jay was the first supreme court justice sworn in 1790.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the justice retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former justice.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }
                    userInput.nextLine();
                    
                    System.out.println("Enter a number of votes for the justice: ");
                    int votesIn = userInput.nextInt();
                    while (votesIn < 50){
                        System.err.println("Invalid number. In order for a Supreme Court Justice to take office, there must be at least 50 votes. Please enter again.");
                        votesIn = userInput.nextInt();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the justice is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println();

                    listOfJustices.add(new SupremeCourtJustice(nameOfJustice, birth, residence, swornIn, isOutOfOffice, votesIn, party));
                    }

                    userInput.nextLine();
                    for(int i = 0; i < listOfJustices.size(); i++){
                        System.out.println("Enter aye or nay for the secretary: ");
                        String yesOrNoJustice = userInput.nextLine();
                        while(!(yesOrNoJustice.equals("Yes") || yesOrNoJustice.equals("yes")) 
                        || !(yesOrNoJustice.equals("No") || yesOrNoJustice.equals("no"))){
                            System.err.println("Invalid input. Please enter yes or no another time.");
                            yesOrNoJustice = userInput.nextLine();
                        }
                        System.out.println(listOfJustices.get(i).getName() + ": " + newPoliticians[g].getSenator().yesOrNoSecretaries(yesOrNoJustice));
                    }
                  }else if(newPoliticians[g] instanceof Representative){
                    if(newPoliticians[g].getIsOutOfOffice() == true){
                        System.out.println("Enter a given number of bills: ");
                        int number = userInput.nextInt();

                        String[] bills = new String[number];

                        for(int i = 0; i < bills.length; i++){
                            userInput.nextLine();
                            System.out.println("Enter a bill: ");
                            String bill = userInput.nextLine();
                            bills[i] = bill;
                        }

                        newPoliticians[g].getRepresentative().retiredRepresentativeBills(bills);
                    } else{
                        System.out.println("Enter a given number of bills: ");
                        int number = userInput.nextInt();

                        ArrayList<String> bills = new ArrayList<>();

                        for(int i = 0; i < bills.size(); i++){
                            userInput.nextLine();
                            System.out.println("Enter a bill: ");
                            String bill = userInput.nextLine();
                            bills.add(i, bill);
                        }

                        newPoliticians[g].getRepresentative().activeRepresentativeBills(bills);
                    }
                    ArrayList<Secretary> listOfSecretaries = new ArrayList<>();

                        userInput.nextLine();

                        System.out.println("Enter a number of secretaries: ");
                        int secretaryNumber = userInput.nextInt();

                 for(int i = 0; i < secretaryNumber; i++){
                     System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's name: ");
                    String nameOfSecretary= userInput.nextLine();

                    while(isValidName(nameOfSecretary) == false){
                        System.err.println("Invalid name. Please enter another name.");
                        userInput.nextLine();
                    }
                    System.out.println();

                    System.out.println("Enter the secretary's date of birth using MM-DD-yyyy format(Numbers only): ");
                    System.out.println("January-December(1-12)");
                    System.out.println();

                    System.out.println("Enter the secretary's month of birth: ");
                    int month = userInput.nextInt();
                    while(!(month >= 1 && month <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        month = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's day of birth: ");
                    int day = userInput.nextInt();
                    while(!(day>= 1 && day <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        day = userInput.nextInt();
                    }
                    System.out.println("Enter the secretary's year of birth: ");
                    int year = userInput.nextInt();

                    while(year < 1700){
                        System.err.println("Invalid year. Enter a proper year.");
                        year = userInput.nextInt();
                    }

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate birth = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Enter the secretary's residence: ");
                    String residence = userInput.nextLine();
                    System.out.println();

                    System.out.println("Enter the day the secretary was sworn in using MM-DD-yyyy format: ");
                    System.out.println();

                    System.out.println("Enter the month the secretary was inaugurated: ");
                    int monthSworn = userInput.nextInt();
                    while(!(monthSworn >= 1 && monthSworn <= 12)){
                        System.err.println("Invalid month. Enter a proper month to move on to entering the day.");
                        monthSworn = userInput.nextInt();
                    }

                    System.out.println("Enter the day the secretary was inaugurated ");
                    int daySworn = userInput.nextInt();
                    while(!(daySworn>= 1 && daySworn <= 31)){
                        System.err.println("Invalid day. Enter a proper day per month to move on to entering the year.");
                        daySworn = userInput.nextInt();
                    }

                    System.out.println("Enter the year the secretary was inaugurated: ");
                    int yearSworn = userInput.nextInt();
                    while(yearSworn < 1790){
                        System.err.println("Invalid year. Thomas Jefferson was the first secretary sworn in 1790.");
                        yearSworn = userInput.nextInt();
                    }

                    DateTimeFormatter anotherDateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
                    LocalDate swornIn = LocalDate.of(year, month, day);

                    System.out.println();

                    userInput.nextLine();

                    System.out.println("Is the secretary retired/deceased(Yes or No): ");
                    String yesOrNo = userInput.nextLine();

                    while(!("Yes".equals(yesOrNo) || "No".equals(yesOrNo))){
                        System.err.println("Invalid input. Type in yes or no.");
                        yesOrNo = userInput.nextLine();
                    }

                    boolean isOutOfOffice = false;
                    if("Yes".equals(yesOrNo)){
                        isOutOfOffice = true;
                        if("Washington D.C.".equals(residence)){
                            System.out.println("Invalid current residence for a former secretary.");
                        }
                    } else{
                        isOutOfOffice = false;
                        residence = "Washington D.C.";
                    }
                    userInput.nextLine();
                    
                    System.out.println("Enter a number of votes for the secretary: ");
                    int votesIn = userInput.nextInt();
                    while (!(votesIn <= 50 && votesIn >= 100)){
                        System.err.println("Invalid number. In order for a secretary to take office, there must be at least 50 votes. Please enter again.");
                        votesIn = userInput.nextInt();
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter the party the secretary is in: ");
                    String party = userInput.nextLine();
                    while(!("Republican".equals(party) || "Democrat".equals(party) || "Independent".equals(party))){
                        System.err.println("Invalid answer. Make sure the party starts off with a capital letter.");
                        party = userInput.nextLine();
                    }

                    System.out.println("Enter a type of secretary. Don't include the Secretary of part. Just include the position(f.x. State or Treasury)");
                    System.out.println();
                    String typeOfSecretary = userInput.nextLine();
                    while(!isValidSecretary(typeOfSecretary)){
                        System.out.println("Invalid input. Please make sure you follow the directions above. Enter another type of Secretary.");
                        typeOfSecretary = userInput.nextLine();
                    }
                    listOfSecretaries.add(new Secretary(nameOfSecretary, birth, residence, swornIn,
                    isOutOfOffice,votesIn, party, typeOfSecretary));         
                  }
                  System.out.println();
                    //Secretary Meeting
                        //Get a list of secretaries(copying the secretaries above).
                        //For each secretary, ask the user to enter a condition.
                            //Display a list of options to choose from(Tell them to copy paste!)
                            //If user doesn't do that, then I can tell the user to enter another time. 
                            //Once the user follows directions, then I can just call the method. 
                    System.out.println(newPoliticians[g].getRepresentative().getName() + " had a meeting with each secretary about some important matters.");
                    System.out.println();

                    for (int i = 0; i < listOfSecretaries.size(); i++) {
                        userInput.nextLine();
                        System.out.println("Enter a condition for the meeting with the secretary using one of the following options below.");
                        System.out.println("1: The meeting with the secretary was proper and organized.");
                        System.out.println("2: The meeting with the secretary had some arguments but some agreements.");
                        System.out.println("3: The meeting with the secretary was filled with arguments.");
                        String condition = userInput.nextLine();

                        while(!("The meeting with the secretary was proper and organized.").contains(condition) ||
                        ("The meeting with the secretary had some arguments but some agreements.").contains(condition)||
                        ("The meeting with the secretary was filled with arguments.").contains(condition)){
                            System.err.println("Invalid input. Please enter using the 3 conditions above. You don't have to type in the secretary name.");
                            condition = userInput.nextLine();
                        }
                        newPoliticians[g].getRepresentative().secretaryMeeting(listOfSecretaries.get(i), condition);
                    }  
                 }
                } else if(option == 3){
                    long age = 0;
                    userInput.nextLine();

                    while(newPoliticians[g].ageSwornInOffice() < 35){
                        System.out.println("Invalid age. A politician has to be at least 35 to be sworn in office.");
                        System.out.println("Enter a number.");
                        age = userInput.nextLong();
                        if(age > 35){
                            age = newPoliticians[g].ageSwornInOffice();
                        }
                    }
                    userInput.nextLine();

                    if(newPoliticians[g].getIsOutOfOffice() == true){
                        System.out.println("Enter the year that" + newPoliticians[g].getName() + " retired: ");
                        int yearRetiredDeceased = userInput.nextInt();
                        
                        while(!(yearRetiredDeceased >= newPoliticians[g].getSwornin().getYear() && 
                        yearRetiredDeceased <= LocalDate.now().getYear())){
                            System.err.println("Invalid year. Please enter another year.");
                            yearRetiredDeceased = userInput.nextInt();
                        }
                        int yearsOfExperience = yearRetiredDeceased - newPoliticians[g].getSwornin().getYear();
                        newPoliticians[g].setYearsOfExperience(yearsOfExperience);
                    } else{
                        int yearsOfExperience = LocalDate.now().getYear()-newPoliticians[g].getSwornin().getYear();
                        newPoliticians[g].setYearsOfExperience(yearsOfExperience);
                    }
                    
                    userInput.nextLine();
                    System.out.println();

                    Condition[] conditions = {Condition.DEMOCRAT, Condition.EXTREME_DEMOCRAT, Condition.MIDDLE, Condition.REPUBLICAN, Condition.TRUMPIST};
                    int index = 1;

                    System.out.println("Enter a number from 1-5: ");
                    int conditionNum = userInput.nextInt();

                    for(Condition condition: conditions){
                        System.out.println((index) + ": " + condition);
                        index++;
                    }

                    System.out.println();
                    userInput.nextLine();
                    System.out.println("Enter a number from 1-10: ");
                    int rating = userInput.nextInt();

                    while(!(rating >= 1 && rating <= 10)){
                        System.err.println("Invalid rating. Please enter another rating from 1-10.");
                        rating = userInput.nextInt();
                    }
                    
                    //Non-User Input
                    System.out.println(newPoliticians[g].getName());
                    System.out.println("\t - Age: " + newPoliticians[g].findAge());
                    
                    if(newPoliticians[g] instanceof President){
                        System.out.println("\t - President");
                    } else if(newPoliticians[g] instanceof Secretary){
                        System.out.println("\t - Secretary");
                    }else if(newPoliticians[g] instanceof SupremeCourtJustice){
                        System.out.println("\t - Supreme Court Justice");
                    }else if(newPoliticians[g] instanceof Senator){
                        System.out.println("\t - Senator");
                    }else if(newPoliticians[g] instanceof Representative){
                        System.out.println("\t - Representative");
                    }

                    System.out.println("\t - Years of Experience: " + newPoliticians[g].getYearsOfExperience());
                    
                    if(conditionNum == 1){
                        System.out.print("\t - Type of Politician: ");
                        newPoliticians[g].conditionPolitician(conditions[conditionNum-1]);
                    } else if(conditionNum == 2){
                        System.out.print("\t - Type of Politician: ");
                        newPoliticians[g].conditionPolitician(conditions[conditionNum-1]);
                    }else if(conditionNum == 3){
                        System.out.print("\t - Type of Politician: ");
                        newPoliticians[g].conditionPolitician(conditions[conditionNum-1]);
                    }else if(conditionNum == 4){
                        System.out.print("\t - Type of Politician: ");
                        newPoliticians[g].conditionPolitician(conditions[conditionNum-1]);
                    }else if(conditionNum == 5){
                        System.out.print("\t - Type of Politician: ");
                        newPoliticians[g].conditionPolitician(conditions[conditionNum-1]);
                    }
                    System.out.println();
                    newPoliticians[g].politicianRating(rating);
                } else if(option == 4){
                    ArrayList<String> politicianEndorsedThesePoliticians = new ArrayList<>();
                    userInput.nextLine();

                    System.out.println("Enter another politician: ");
                    String nameOfEndorsedPolitician = userInput.nextLine();
                    politicianEndorsedThesePoliticians.add(nameOfEndorsedPolitician);

                    while(true && isValidName(nameOfEndorsedPolitician)){
                        System.out.println("Enter true or false if you want to enter more politicians: ");
                        boolean yourChoice = userInput.nextBoolean();

                        while(!(yourChoice == true || yourChoice == false)){
                            System.err.println("Invalid input. Please enter another input.");
                            yourChoice = userInput.nextBoolean();
                        }

                        if(yourChoice == false){
                            break;
                        }
                        System.out.println("Enter another politician: ");
                        nameOfEndorsedPolitician = userInput.nextLine();
                        politicianEndorsedThesePoliticians.add(nameOfEndorsedPolitician);
                    }
                    newPoliticians[g].peopleWhoThePoliticianEndorsed(politicianEndorsedThesePoliticians);

                    ArrayList<String> politiciansEndorsedThisPolitician = new ArrayList<>();
                    userInput.nextLine();

                    System.out.println("Enter another politician who endorsed" + newPoliticians[g].getName() + ": ");
                    String namePoliticianEndorsed = userInput.nextLine();
                    politiciansEndorsedThisPolitician.add(namePoliticianEndorsed);

                    while(true && isValidName(nameOfEndorsedPolitician)){
                        System.out.println("Enter true or false if you want to enter more politicians: ");
                        boolean yourChoice = userInput.nextBoolean();

                        while(!(yourChoice == true || yourChoice == false)){
                            System.err.println("Invalid input. Please enter another input.");
                            yourChoice = userInput.nextBoolean();
                        }

                        if(yourChoice == false){
                            break;
                        }

                        System.out.println("Enter another politician: ");
                        namePoliticianEndorsed = userInput.nextLine();
                        politiciansEndorsedThisPolitician.add(namePoliticianEndorsed);
                    }
                    newPoliticians[g].politicianEndorsements(politiciansEndorsedThisPolitician);

                    if(newPoliticians[g] instanceof Senator){
                        newPoliticians[g].getSenator().isDangerOfReelection();
                    }
                }
            }
        
        }
        public static boolean isValidName(String name){
            boolean isValid = true;
            for (int i = 0; i < name.length(); i++) {
                switch (name.charAt(i)){
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '!':
                    case '@':
                    case '#':
                    case '$':
                    case '%':
                    case '^':
                    case '&':
                    case '*':
                    case '(':
                    case ')':
                    case '_':
                    case '+':
                    case '=':
                    case '{':
                    case '}':
                    case '[':
                    case ']':
                    case '|':
                        isValid = false;
                        break;
                    default:
                        isValid = true;
                }
                if (isValid == false) {
                    break;
                }
            }
            return isValid;
        }

        public static boolean isValidState(String state){
            boolean isValidState = false;
            switch (state) {
                case "Alabama":
                case "Alaska": 
                case "Arizona": 
                case "Arkansas": 
                case "California": 
                case "Colorado": 
                case "Connecticut": 
                case "Delaware": 
                case "District of Columbia":
                case "Florida": 
                case "Georgia": 
                case "Hawaii": 
                case "Idaho": 
                case "Illinois": 
                case "Indiana": 
                case "Iowa": 
                case "Kansas": 
                case "Kentucky": 
                case "Louisiana": 
                case "Maine": 
                case "Maryland": 
                case "Massachusetts": 
                case "Michigan": 
                case "Minnesota": 
                case "Mississippi": 
                case "Missouri": 
                case "Montana": 
                case "Nebraska": 
                case "Nevada": 
                case "New Hampshire": 
                case "New Jersey": 
                case "New Mexico": 
                case "New York": 
                case "North Carolina": 
                case "North Dakota": 
                case "Ohio": 
                case "Oklahoma": 
                case "Oregon": 
                case "Pennsylvania": 
                case "Puerto Rico":
                case "Rhode Island": 
                case "South Carolina": 
                case "South Dakota": 
                case "Tennessee": 
                case "Texas": 
                case "Utah": 
                case "Vermont": 
                case "Virginia": 
                case "Washington": 
                case "West Virginia": 
                case "Wisconsin": 
                case "Wyoming": 
                    isValidState = true;
                    break;
            }
            return isValidState;
        }

        //Create a method that returns an array of districts based on the given state by using a switch case statement.
        public static String[] stateDistricts(String state){
            String[][] districts = {{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th"}, 
        {"At large"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th"}, 
        {"1st", "2nd", "3rd", "4th"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
    "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", 
    "26th", "27th", "28th", "29th", "30th", "31st", "32nd", "33rd", "34th", "35th", 
    "36th", "37th", "38th", "39th", "40th", "41st", "42nd", "43rd", "44th", "45th", 
    "46th", "47th", "48th", "49th", "50th", "51st", "52nd", "53rd"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th"}, {"1st", "2nd", "3rd", "4th", "5th"},
    {"At large"}, {"At large"},{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", 
    "11th", "12th", "13th","14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", 
    "23rd", "24th", "25th", "26th", "27th"}, {"1st", "2nd", "3rd", "4th", "5th", 
    "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th"}, {"1st", "2nd"},
    {"1st", "2nd"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", 
    "10th", "11th", "12th", "13th","14th", "15th", "16th", "17th", "18th"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", 
    "8th", "9th"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", 
    "7th", "8th", "9th"}, {"1st", "2nd", "3rd", "4th"}, {"1st", "2nd", "3rd", "4th", "5th", "6th"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th"},
    {"1st", "2nd"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", 
    "10th", "11th", "12th", "13th", "14th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th"}, 
    {"1st", "2nd", "3rd", "4th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}, 
    {"At large"}, {"1st", "2nd", "3rd"},
    {"1st", "2nd", "3rd"}, {"1st", "2nd"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", 
    "10th", "11th", "12th"}, {"1st", "2nd", "3rd"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
    "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", 
    "26th", "27th"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th"}, 
    {"At large"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
    "14th", "15th", "16th"}, {"1st", "2nd", "3rd", "4th", "5th"},
    {"1st", "2nd", "3rd", "4th", "5th"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
    "14th", "15th", "16th", "17th", "18th"}, {"At large"}, {"1st", "2nd"}, 
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th"},
    {"At large"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th",
    "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", 
    "26th", "27th", "28th", "29th", "30th", "31st", "32nd", "33rd", "34th", "35th", 
    "36th"}, {"1st", "2nd", "3rd", "4th"}, 
    {"At large"}, {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th"},
    {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th"}, 
    {"1st", "2nd", "3rd"}, {"1st", "2nd", "3rd"},
    {"At large"}};

        String[] stateDistricts = {};    

        if(isValidState(state) == true){
            switch(state){
                case "Alabama":
                    stateDistricts = districts[0];
                    break;
                case "Alaska":
                    stateDistricts = districts[1];
                    break;
                case "Arizona": 
                    stateDistricts = districts[2];
                    break;
                case "Arkansas": 
                    stateDistricts = districts[3];
                    break;
                case "California": 
                    stateDistricts = districts[4];
                    break;
                case "Colorado": 
                    stateDistricts = districts[5];
                    break;
                case "Connecticut": 
                    stateDistricts = districts[6];
                    break;
                case "Delaware": 
                    stateDistricts = districts[7];
                    break;
                case "District of Columbia": 
                    stateDistricts = districts[8];
                    break;
                case "Florida": 
                    stateDistricts = districts[9];
                    break;
                case "Georgia": 
                    stateDistricts = districts[10];
                    break;
                case "Hawaii": 
                    stateDistricts = districts[11];
                    break;
                case "Idaho": 
                    stateDistricts = districts[12];
                    break;
                case "Illinois": 
                    stateDistricts = districts[13];
                    break;
                case "Indiana":
                    stateDistricts = districts[14];
                    break; 
                case "Iowa": 
                    stateDistricts = districts[15];
                    break;
                case "Kansas": 
                    stateDistricts = districts[16];
                    break;
                case "Kentucky": 
                    stateDistricts = districts[17];
                    break;
                case "Louisiana": 
                    stateDistricts = districts[18];
                    break;
                case "Maine": 
                    stateDistricts = districts[19];
                    break;
                case "Maryland": 
                    stateDistricts = districts[20];
                    break;
                case "Massachusetts": 
                    stateDistricts = districts[21];
                    break;
                case "Michigan": 
                    stateDistricts = districts[22];
                    break;
                case "Minnesota": 
                    stateDistricts = districts[23];
                    break;
                case "Mississippi": 
                    stateDistricts = districts[24];
                    break;
                case "Missouri": 
                    stateDistricts = districts[25];
                    break;
                case "Montana": 
                    stateDistricts = districts[26];
                    break;
                case "Nebraska": 
                    stateDistricts = districts[27];
                    break;
                case "Nevada": 
                    stateDistricts = districts[28];
                    break;
                case "New Hamphshire": 
                    stateDistricts = districts[29];
                    break;
                case "New Jersey": 
                    stateDistricts = districts[30];
                    break;
                case "New Mexico": 
                    stateDistricts = districts[31];
                    break;
                case "New York": 
                    stateDistricts = districts[32];
                    break;
                case "North Carolina":
                    stateDistricts = districts[33];
                    break; 
                case "North Dakota": 
                    stateDistricts = districts[34];
                    break;
                case "Ohio":
                    stateDistricts = districts[35];
                    break; 
                case "Oklahoma": 
                    stateDistricts = districts[36];
                    break;
                case "Oregon": 
                    stateDistricts = districts[37];
                    break;
                case "Pennsylvania": 
                    stateDistricts = districts[38];
                    break;
                case "Puerto Rico": 
                    stateDistricts = districts[39];
                    break;
                case "Rhode Island": 
                    stateDistricts = districts[40];
                    break;
                case "South Carolina":
                    stateDistricts = districts[41];
                    break; 
                case "South Dakota": 
                    stateDistricts = districts[42];
                    break;
                case "Tennessee": 
                    stateDistricts = districts[43];
                    break;
                case "Texas": 
                    stateDistricts = districts[44];
                    break;
                case "Utah": 
                    stateDistricts = districts[45];
                    break;
                case "Vermont":
                    stateDistricts = districts[46];
                    break; 
                case "Virginia": 
                    stateDistricts = districts[47];
                    break;
                case "Washington": 
                    stateDistricts = districts[48];
                    break;
                case "West Virginia": 
                    stateDistricts = districts[49];
                    break;
                case "Wisconsin": 
                    stateDistricts = districts[50];
                    break;
                case "Wyoming": 
                    stateDistricts = districts[51];
                    break;
                }
            }
            return stateDistricts;
        }
        
        public static boolean isValidDistrict(String state, String districtRepresented){
            boolean isDistrictValid = false;
            if(isValidState(state)){
                String[] stateDistricts = stateDistricts(state);
                for(int i = 0; i < stateDistricts.length; i++){
                    if(districtRepresented == stateDistricts[i]){
                        isDistrictValid = true;
                    }
                }
            }
            return isDistrictValid;
        }

        public static boolean isValidSecretary(String typeOfSecretary){
            boolean isValid = false;
            switch (typeOfSecretary) {
                case "State":
                case "Treasury":
                case "Defense":
                case "Justice":
                case "Interior":
                case "Agriculture":
                case "Commerce":
                case "Labor":
                case "Health and Human Services":
                case "Housing and Urban Development":
                case "Transportation":
                case "Energy":
                case "Education":
                case "Veterans Affairs":
                case "Homeland Security":
                    isValid = true;
                    break;
            }
            return isValid;
        }
}