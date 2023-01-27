import java.util.TreeMap;

public class Validation {
    TreeMap<Character, Integer> checkerKeyMap = new TreeMap<>();
    public Validation() {
        checkerKeyMap.put('I',1);
        checkerKeyMap.put('V', 5);
        checkerKeyMap.put('X', 10);
        checkerKeyMap.put('L', 50);
        checkerKeyMap.put('C', 100);
        checkerKeyMap.put('D', 500);
        checkerKeyMap.put('M', 1000);
    }
    public boolean checkIfRoman(String number){
        return checkerKeyMap.containsKey(number.charAt(0));
    }
}
