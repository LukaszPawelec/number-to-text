package pl.com.bottega.model;

import java.text.DecimalFormat;

/**
 * Created by Nizari on 23.11.16.
 */
public class ConverterLogic {

    private static final String[] mainNumbersInText = {"", "Jeden", "Dwa",
            "Trzy", "Cztery", "Pięć", "Sześć", "Siedem", "Osiem", "Dziewięć", "Dziesięć",
            "Jedenaście", "Dwanaście", "Trzynaście", "Czternaście",
            "Piętnaście", "Szesnaście", "Siedemnaście", "Osiemnaście",
            "Dziewiętnaście"};

    private static final String[] tensInText = {"", "Dziesięć", "Dwadzieścia ",
            "Trzydzieści ", "Czterdzieści ", "Pięćdziesiąt ", "Sześćdziesiąt ",
            "Siedemdziesiąt ", "Osiemdziesiąt ", "Dziewięćdziesiąt "};

    private static final String[] hundredsinText = {"", "Sto ", "Dwieście ", "Trzysta ", "Czterysta ",
            "Pięćset ", "Sześćset ", "Siedemset ", "Osiemset ", "Dziewięćset "};


    private ConverterLogic() {

    }

    private static String convertHundrets(int number) {

        String magicController;

        if (number % 100 < 20) {
            magicController = mainNumbersInText[number % 100];
            number /= 100;
        } else {
            magicController = mainNumbersInText[number % 10];
            number /= 10;

            magicController = tensInText[number % 10] + magicController;
            number /= 10;
        }
        if (number == 0) return magicController;
        return hundredsinText[number] + magicController;
    }

    public static String allmightyConverter(long number) {

        if (number == 0) {
            return "Zero";
        }

        String stringNumber = Long.toString(number);
        String mask = "000000000000";
        DecimalFormat decimalFormat = new DecimalFormat(mask);
        stringNumber = decimalFormat.format(number);

        int thousands = Integer.parseInt(stringNumber.substring(9, 12));
        int hundredOfThousands = Integer.parseInt(stringNumber.substring(6, 9));
        int millions = Integer.parseInt(stringNumber.substring(3, 6));


        String millionsMagicController;
        switch (millions) {
            case 0:
                millionsMagicController = "";
                break;
            case 1:
                millionsMagicController = "Milion ";
                break;
            default:
                millionsMagicController = convertHundrets(millions) + " Milionów ";
        }

        String result = millionsMagicController;

        String hundredOfThousandsMagicController;
        switch (hundredOfThousands) {
            case 0:
                hundredOfThousandsMagicController = "";
                break;
            case 1:
                hundredOfThousandsMagicController = "Tysiąc ";
                break;
            default:
                hundredOfThousandsMagicController = convertHundrets(hundredOfThousands) + " Tysięcy ";
        }

        result = result + hundredOfThousandsMagicController;

        String thousandsMagicController;
        thousandsMagicController = convertHundrets(thousands);
        result = result + thousandsMagicController;

        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
