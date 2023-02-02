package twoPointers;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(new ValidPalindrome125().isPalindrome(s));
    }


    public boolean isPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return true;
        }
        int left = 0;
        int right = size - 1;

        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (!Character.isLetterOrDigit(leftC)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightC)) {
                right--;
                continue;
            }
            if (Character.isLetter(leftC)) {
                leftC = Character.toLowerCase(leftC);
            }
            if (Character.isLetter(rightC)) {
                rightC = Character.toLowerCase(rightC);
            }
            if (leftC != rightC) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
