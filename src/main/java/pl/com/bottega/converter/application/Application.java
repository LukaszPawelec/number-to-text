package pl.com.bottega.converter.application;

import pl.com.bottega.converter.model.ConverterLogic;

import java.util.Scanner;

/**
 * Created by Nizari on 23.11.16.
 */
public class Application {

    //private static long choose;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Proszę podać liczbę do przekonwertowania na tekst: ");
        Long numberToConvert = input.nextLong();
        System.out.println("Twoja liczba w formie tekstu: " + ConverterLogic.allmightyConverter(numberToConvert));


    }


        /*for (;;) {
            if (!input.hasNextLong()) {
                System.out.println("Proszę podać tylko wartości liczbowe!");
                input.next();
                continue;
            }
            choose = input.nextLong();
            if (choose >= 0) {
                System.out.print("Twoja liczba w formie tekstu: " + ConverterLogic.allmightyConverter());

            } else {
                System.out.print("Proszę podać tylko wartości liczbowe!");

            }
            break;
        }*/
}


