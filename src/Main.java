import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] signs = {"+", "-", "*", "/"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для вычисления:");
        String data = scanner.nextLine();
        String[] dataSymbol = data.split(" ");
        int arrNum = -1;
        for (int i = 0; signs.length > i; i++) {
            if (data.contains(signs[i])) {
                arrNum = i;     //System.out.println(signs[arrNum]+ " " + arrNum + " " + Arrays.toString(dataSymbol)); Проверка знака
                break;
            }
        }
        if (arrNum == -1) {
            System.out.println("Допущена ошибка в выражении");
            return;
        }
        Validation checker = new Validation();
        if (checker.checkIfRoman(dataSymbol[0]) == checker.checkIfRoman(dataSymbol[2])) {
            int firstNumber, secondNumber;
            boolean zamnItsRoman = checker.checkIfRoman(dataSymbol[0]);
            if (zamnItsRoman) {
                firstNumber = NumericConverter.romanToArabic(dataSymbol[0]);
                secondNumber = NumericConverter.romanToArabic(dataSymbol[2]); //System.out.println(Num1 + " " + Num2);
            } else {
                firstNumber = Integer.parseInt(dataSymbol[0]);
                secondNumber = Integer.parseInt(dataSymbol[2]);
            }
            if (firstNumber > 10 || secondNumber > 10) {
                System.exit(0);
            }
            int result = 0;
            if (signs[arrNum].equals("+")) {
                result = firstNumber + secondNumber;
            }
            if (signs[arrNum].equals("-")) {
                result = firstNumber - secondNumber;
            }
            if (signs[arrNum].equals("*")) {
                result = firstNumber * secondNumber;
            }
            if (signs[arrNum].equals("/")) {
                result = firstNumber / secondNumber;
            }
            if (zamnItsRoman) {
                String resultRoman;
                resultRoman = NumericConverter.arabicToRoman(result);
                System.out.println("Результат равен:");
                System.out.println(resultRoman);
            } else {
                System.out.println("Результат равен:");
                System.out.println(result);
            }
        }
    }
}