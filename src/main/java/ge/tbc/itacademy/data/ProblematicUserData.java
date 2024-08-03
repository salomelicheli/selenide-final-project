package ge.tbc.itacademy.data;

import org.testng.annotations.DataProvider;

public class ProblematicUserData {
    @DataProvider
    public static Object[][] fakePassData(){
        return new Object[][] {
                {"1234567890", "Your password must include at least one uppercase letter"},
                {"1234567890S", "Your password must include at least one lowercase letter"},
                {"1234567890l", "Your password must include at least one uppercase letter"},
                {"123456789", "Your password must be at least 10 characters"},
        };
    }
}
