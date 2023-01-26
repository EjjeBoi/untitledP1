import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] signs = {"+","-","*","/"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для вычисления:");
        String data = scanner.nextLine();
        String[] dataSymbol = data.split(" ");
        int arrNum = -1;
        for (int i = 0; signs.length > i; i++){
            if(data.contains(signs[i])) {
                arrNum = i;     //System.out.println(signs[arrNum]+ " " + arrNum + " " + Arrays.toString(dataSymbol)); Проверка знака
                break;
            }
        }
        if (arrNum == -1){
            System.out.println("Допущена ошибка в выражении");
            return;
        }
       CheckIf checker = new CheckIf();
        if (checker.zamnItsRoman(dataSymbol[0]) == checker.zamnItsRoman(dataSymbol[2])){
            int Num1, Num2;
            boolean zamnItsRoman = checker.zamnItsRoman(dataSymbol[0]);
            if (zamnItsRoman){
                Num1 = ArabicRoman.romanToArabic(dataSymbol[0]);
                Num2 = ArabicRoman.romanToArabic(dataSymbol[2]); //System.out.println(Num1 + " " + Num2);
            }
            else{
                Num1 = Integer.parseInt(dataSymbol[0]);
                Num2 = Integer.parseInt(dataSymbol[2]);
            }
            if (Num1 > 10 || Num2 > 10){
                System.exit(0);
            }
            int result = 0;
            if (signs[arrNum].equals("+")) {
                result = Num1 + Num2;
            }
            if (signs[arrNum].equals("-")) {
                result = Num1 - Num2;
            }
            if (signs[arrNum].equals("*")) {
                result = Num1 * Num2;
            }
            if (signs[arrNum].equals("/")) {
                result = Num1 / Num2;
            }
            if(zamnItsRoman){
                String resultRoman;
                resultRoman = ArabicRoman.arabicToRoman(result);
                System.out.println("Результат равен:");
                System.out.println(resultRoman);
            }
            else{
                System.out.println("Результат равен:");
                System.out.println(result);
            }
        }
    }
}