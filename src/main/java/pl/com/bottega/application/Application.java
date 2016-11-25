package pl.com.bottega.application;

import pl.com.bottega.model.ConverterLogic;

import java.util.Scanner;

/**
 * Created by Nizari on 23.11.16.
 */
public class Application {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Proszę podać liczbę do przekonwertowania na tekst: ");
        Long numberToConvert = input.nextLong();
        System.out.println("Twoja liczba w formie tekstu: " + ConverterLogic.allmightyConverter(numberToConvert));

    }
}