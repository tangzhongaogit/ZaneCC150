package chapter1;

public class OneAway {
    public static void main(String args[]) {
        String[] testCase1 = {"", "a"};
        String[] testCase2 = {"z", ""};
        String[] testCase3 = {"", "abdc"};
        String[] testCase4 = {"abdc", "a"};
        String[] testCase5 = {"abcd", "abce"};
        String[] testCase6 = {"abcef", "abce"};
        String[] testCase7 = {"bcd", "abcd"};
        String[] testCase8 = {"abcdefg", "abcde"};
        String[] testCase9 = {null, null};
        System.out.println(oneAway(testCase1[0], testCase1[1]));
        System.out.println(oneAway(testCase2[0], testCase2[1]));
        System.out.println(oneAway(testCase3[0], testCase3[1]));
        System.out.println(oneAway(testCase4[0], testCase4[1]));
        System.out.println(oneAway(testCase5[0], testCase5[1]));
        System.out.println(oneAway(testCase6[0], testCase6[1]));
        System.out.println(oneAway(testCase7[0], testCase7[1]));
        System.out.println(oneAway(testCase8[0], testCase8[1]));
        System.out.println(oneAway(testCase9[0], testCase9[1]));
    }
    
    public static boolean oneAway(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.length() == str2.length()) {
            return oneAwayReplace(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return oneAwayInsert(str1, str2);
        } else if (str2.length() + 1 == str1.length()) {
            return oneAwayInsert(str2, str1);
        } else {
            return false;
        }
    }
    
    private static boolean oneAwayReplace(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }
    
    private static boolean oneAwayInsert(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index2 > index1) {
                    return false;
                } else {
                    index2++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
