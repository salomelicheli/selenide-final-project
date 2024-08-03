package ge.tbc.itacademy.data;

public class BookingData {
    public static final String
            FIRST_NAME = "Some name",
            LAST_NAME = "Last Name",
            COUNTRY = "Georgia",
            CITY = "Tbilisi",
            ADDRESS = "Mukhiani",
            WRONG_FORMAT_PHONE_NUMBER = "2384487329847";
    public static String getFullName() {
        return FIRST_NAME + " " + LAST_NAME;
    }
}
