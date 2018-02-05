package chapter1;

public class URLify {
    public static void main(String[] args) {
        char[] testcase1 = "Mr John Smith                              ".toCharArray();
        char[] testcase2 = "Mr   John Smith                              ".toCharArray();
        char[] testcase3 = "Mr   Zane                              ".toCharArray();
        char[] testcase4 = "Mr                 TANG                                                       ".toCharArray();
        char[] testcase5 = "Tang                           ".toCharArray();
        char[] testcase6 = "                           ".toCharArray();
        myURLify(testcase1, 15);
        myURLify(testcase2, 13);
        myURLify(testcase3, 9);
        myURLify(testcase4, 23);
        myURLify(testcase5, 4);
        myURLify(testcase6, 0);
        System.out.println(testcase1);
        System.out.println(testcase2);
        System.out.println(testcase3);
        System.out.println(testcase4);
        System.out.println(testcase5);
        System.out.println(testcase6);
        System.out.println("\0");
    }
    
    public static void myURLify(char[] url, int length) {
        if (length == 0) return;
        int spaceCounter = 0;
        for (int i = 0; i < length; i++) {
            if (url[i] == ' ') {
                spaceCounter++;
            }
        }
        int newLength = length + 2 * spaceCounter;
        if (newLength < url.length) url[newLength] = '\0';
        newLength -= 1;
        for (int i = length - 1; i >= 0; i--) {
            if (url[i] != ' ') {
                url[newLength--] = url[i];
            } else {
                url[newLength--] = '0';
                url[newLength--] = '2';
                url[newLength--] = '%';
            }
        }
    }
}
