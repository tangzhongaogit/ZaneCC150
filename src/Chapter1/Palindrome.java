package Chapter1;

import java.util.HashMap;

public class Palindrome {
    public static void main(String args[]) {
        String testCase1 = "";
        String testCase2 = null;
        String testCase3 = "aabbgg";
        String testCase4 = "abbag";
        String testCase5 = "Tact Coa";
        String testCase6 = "abba;";
//        System.out.println(checkPalindrome(testCase1));
//        System.out.println(checkPalindrome(testCase2));
//        System.out.println(checkPalindrome(testCase3));
//        System.out.println(checkPalindrome(testCase4));
//        System.out.println(checkPalindrome(testCase5));
//        System.out.println(checkPalindrome(testCase6));
        System.out.println(Character.getNumericValue('C'));
        System.out.println(Character.getNumericValue('c'));
    }
    
    public static boolean checkPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        HashMap<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (counterMap.containsKey(str.charAt(i))) {
                    int count = counterMap.get(str.charAt(i));
                    counterMap.put(str.charAt(i), count + 1);
                } else {
                    counterMap.put(str.charAt(i), 1);
                }
            }
        }
        int singleAllowed = 1;
        for (Character key : counterMap.keySet()) {
            int count = counterMap.get(key);
            if (count % 2 != 0) {
                singleAllowed--;
            }
        }
        return singleAllowed >= 0;
    }
}
