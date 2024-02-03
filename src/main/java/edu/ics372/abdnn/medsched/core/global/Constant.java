package edu.ics372.abdnn.medsched.core.global;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.*;

public final class Constant {
    public static String[] FIRST_NAMES = {
        "Kailahni", "Marlaina", "Addisynn", "Solana", "Andrey", "Ailis", "Trysten",
        "Diallo", "Kariah", "Welles", "Terriona", "Jermal", "Jaydence", "Kyus", "Zaleia",
        "Mansoor", "Aria", "Anthem", "Joliet", "Curosh", "Fred", "Brett", "Wan", "Kednick",
        "Jan", "Lisa", "Ali", "Lakshmi", "Tukulti", "Hans", "Naguib", "James", "Gawande",
        "Sunday", "Xenophon", "Adewole", "Hiram", "Boonsri", "Nicola", "Boris", "Deepika",
        "Tom", "Jane", "Olga", "Helga", "Circe"
    };

    public static String[] LAST_NAMES = {
        "Sherwood", "Branson", "Andre", "Borden", "Thorn", "Santos", "Rockwell", "Barrientos",
        "Ammons", "Atkinson", "Nielson", "Ferris", "Coffman", "Katz", "Negrete", "Smart", "Tavares",
        "Hudgins", "Caballero", "Moody", "Montgomery", "Cheeseburger", "Elisah", "Xiolu", "Thompson",
        "van Artevelde", "Daniels", "Ibn Battuta", "Prasad", "Ninurta", "von Luck", "Mahfouz", "Granola",
        "Babtunde", "Picolomini", "Ogioustogryllus", "Omotoso", "Abiff", "Savinkov", "Pineworm", "Jones",
        "Atul", "Blue", "Cake", "Spice", "Orange",
    };


    public static String[] DOMAINS = {
        "google", "outlook", "yahoo", "proton_mail", "yepmail", "grape"
    };


    public static String[] SEPARATORS = { ".", "_", "-", ""};


    public static String[] LETTERS = {
        "A", "B", "C"
//            , "D", "E", "F", "G",
//        "H", "J", "K", "M", "N", "P", "Q", "R",
//        "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    public static String[] DEPARTMENT_NAMES = {
        "Primary Care", "Surgery", "Behavioral Health",
        "Dentistry", "Ophthalmology"
    };

    public static long CALENDAR_SIZE = 5;
    public static int ROOMS_PER_LETTER = 3;
    public static int EXAM_ROOM_CAPACITY = 3;
    public static int MINIMUM_ENTITY_ID = 1;
    public static int TIMESLOTS_PER_DAY = 4;
    public static int TIMESLOT_MINUTES = 50;
    public static int APPOINTMENT_SWITCH_OVER_TIME = 10;
    public static int LATE_MINUTES_THRESHOLD = 10;

    public static int MINIMUM_PROVIDER_COUNT = 5;

    public static int MINIMUM_APPOINTMENT_COUNT = MINIMUM_PROVIDER_COUNT;
    public static int MINIMUM_PATIENT_COUNT = MINIMUM_PROVIDER_COUNT * 2;

    public static LocalTime OPENING_TIME = LocalTime.of(8, 0, 0);
    public static LocalTime CLOSING_TIME = OPENING_TIME.plusHours(TIMESLOTS_PER_DAY);
    public static LocalDate INITIAL_CALENDAR_DATE = LocalDate.of(2023, 12, 31);
    public static LocalDate LAST_CALENDAR_DATE = INITIAL_CALENDAR_DATE.plusDays(CALENDAR_SIZE);

    public static String randomLastname () {
        return randomArrayEntry(LAST_NAMES);
    }

    public static String randomFirstname () {
        return randomArrayEntry(FIRST_NAMES);
    }


    public static String randomEmail (String firstname, String lastname) {
        String domain = randomArrayEntry(DOMAINS);
        String separator = randomArrayEntry(SEPARATORS);
        return (firstname + separator + lastname + "@" + domain + ".com").toLowerCase();
    }

    private static String randomArrayEntry (String[] stringArray) {
        int index = (int) (Math.random() * (stringArray.length));
        return stringArray[index];
    } // close randomStringArrayEntryName
} // end class Constant
