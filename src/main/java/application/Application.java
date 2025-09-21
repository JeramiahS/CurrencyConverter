package application;

import utilityclasses.APIHandler;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        if(args[0].contains(",")) {
            args[0] = args[0].replace(",", "");
        }
        if(argIsDouble(args[0]) && codesAreThreeChars(args[1], args[2])) {
            try {
                double value = Double.parseDouble(args[0]);
                System.out.printf("%.2f %s is %f %s",
                        value,
                        args[1],
                        APIHandler.getConversionResult(value, args[1], args[2]),
                        args[2]);
            } catch(IOException | InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    private static boolean argIsDouble(String arg) {
        try {
            double _ = Double.parseDouble(arg);
            return true;
        } catch(NumberFormatException _) {
            System.out.println("You must enter a numerical value as the first argument (Ex. '10' or '20,00').");
        }
        return false;
    }

    private static boolean codesAreThreeChars(String arg1, String arg2) {
        if((arg1.length() == 3 && arg2.length() == 3)) {
            return true;
        } else {
            System.out.println("Country codes must 3 characters (Ex. 'USD', 'EUR').");
        }
        return false;
    }

}