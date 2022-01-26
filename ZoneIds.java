import java.sql.Blob;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZoneIds {
    public static void main(String[] args) {
        // for (String zoneID : ZoneId.getAvailableZoneIds()) {
        //     System.out.println(zoneID);
        // }

        try {
            String localBirth = "2003-05-20";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-DD-yyyy");
            LocalDate localDate = LocalDate.parse(localBirth, dateTimeFormatter);
        } catch (Exception e) {
            //TODO: handle exception
            e.fillInStackTrace();
        }
        LocalDate birth = LocalDate.of(1942, 11, 20);
        LocalDate swornIn = LocalDate.of(2021, 1, 20);
        System.out.println(DateTimeFormatter.class);

        Politician politician = new Politician("", birth, "", swornIn, false, "");
        System.out.println(politician.ageSwornInOffice());
    }
}