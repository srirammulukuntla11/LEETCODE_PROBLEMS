class Solution {
    public int firstMissingPositive(int[] arr) {
         Arrays.sort(arr);
        int missing_number = 1;
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i] == missing_number) missing_number++;
            else if(arr[i] < missing_number) continue;
            else break;
        }
        return missing_number;
    }
}