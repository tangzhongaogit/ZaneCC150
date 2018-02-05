package chapter1;

public class StringCompression {
    public static void main(String args[]) {
        String test1 = "";
        String test2 = null;
        String test3 = "a";
        String test4 = "abc";
        String test5 = "aabccccaaaa";
        String test6 = "aabbccddee";
        String test7 = "abcdefg";
        String test8 = "abcddefgg";
        String test9 = "aabcccccaaa";
        System.out.println(compressString(test1));
        System.out.println(compressString(test2));
        System.out.println(compressString(test3));
        System.out.println(compressString(test4));
        System.out.println(compressString(test5));
        System.out.println(compressString(test6));
        System.out.println(compressString(test7));
        System.out.println(compressString(test8));
        System.out.println(compressString(test9));
    }
    
    public static String compressString(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        Character current = str.charAt(0);
        sb.append(current);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == current) {
                counter++;
            } else {
                sb.append(counter);
                counter = 1;
                sb.append(str.charAt(i));
                current = str.charAt(i);
            }
        }
        sb.append(counter);
        if (sb.length() > str.length()) return str;
        return sb.toString();
    }
}
