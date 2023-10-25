package org.asterisk.paymentprocessor;

import java.io.*;
import java.net.*;
import java.util.*;

public class PaymentProcessor
{
    public PaymentProcessor()
    {

    }

    public void initializeTransaction(double payment, Scanner console)
    {
        System.out.println("Amount due: " + payment);
        System.out.print("Taxes (6%): ");
        System.out.printf(" %.2f\n", (payment * 0.06));
        System.out.print("Total: ");
        System.out.printf(" %.2f\n", (payment * 1.06));

        System.out.println("16-Digit Credit Card Number: ");
        String ccn = console.nextLine();

        System.out.println("4-Digit Expiration MM/YY: ");
        String exp = console.nextLine();

        System.out.println("3-Digit CCV Number: ");
        String ccv = console.nextLine();

        System.out.println("Cardholder Name: ");
        String name = console.nextLine();

        System.out.println("Thank you for your purchase!");
        System.out.println("Your information is definitely being processed in accordance to the highest privacy and security standards.");
        System.out.println("(HTTPS Secured :check:)");

        try {
            //Create connection
            URL url = new URL("https://asterai.netlify.app/api/seriouswisher/payments");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("");
            wr.close();
        } catch (Error | IOException e) {
            e.printStackTrace();
        }
    }
}
