class Solution {
    public int lengthOfLastWord(String s) {
        String arr[] = s.split(" ");
        // for(String word : arr)
        // {
        //     System.out.println(word);
        // }
        // System.out.println(arr.length);
        // return 0;
        String lastWord = arr[arr.length - 1];
        return lastWord.length();
    }
}