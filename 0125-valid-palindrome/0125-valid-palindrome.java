class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        boolean found = true;
        while(left < right)
        {
            while( left < right && !Character.isLetterOrDigit(str.charAt(left)))
            {
                left++;
            }
            while(right > left && !Character.isLetterOrDigit(str.charAt(right)))
            {
                right--;
            }
            if(str.charAt(left) != str.charAt(right))
            {
                found = false;
                break;
            }
            left++;
            right--;
        }
        return found;

    }
}