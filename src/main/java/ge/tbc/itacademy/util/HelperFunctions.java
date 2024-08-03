package ge.tbc.itacademy.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.UUID;
public class HelperFunctions {
    public static double extractValueFromElement(SelenideElement element) {
        String numericText = element.getText().replaceAll("[^\\d.]", "");
        if (!numericText.isEmpty()) {
            try {
                return Double.parseDouble(numericText);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public static double convertToKilometers(String distanceText) {
        String[] parts = distanceText.trim().split(" ");
        double distance = Double.parseDouble(parts[0]);
        String unit = parts[1];
        if (unit.equalsIgnoreCase("m")) {
            distance /= 1000;
        }
        return distance;
    }

    public static String randomUserEmail() {
        String uniqueID = UUID.randomUUID().toString();
        return "user-" + uniqueID + "@gmail.com";
    }

    public static void clickElementUsingJSExecutor(SelenideElement selenideElement){
        Selenide.executeJavaScript("arguments[0].click()", selenideElement);
    }
}
