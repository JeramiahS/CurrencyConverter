package application;

import utilityclasses.APIHandler;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
       try {
           double value = Double.parseDouble(args[0]);
           if(!(args[1].length() == 3 && args[2].length() == 3)) {
               throw new IllegalArgumentException("Country codes must be 3 characters (ex. 'USD').");
           } else {
               System.out.println(APIHandler.getConversionResult(value, args[1], args[2]));
           }
       } catch(NumberFormatException _) {
           System.out.println("Enter a numerical value as the first argument.");
       } catch(IOException | InterruptedException | IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
       }
    }

}