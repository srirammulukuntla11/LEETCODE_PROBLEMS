class Solution {
    public int hIndex(int[] citations) {
              int n = citations.length;
        int[] freq = new int[n+1];
        for(int c : citations){
            if(c >= n) freq[n] = freq[n] + 1;
            else freq[c] = freq[c] + 1;
        }
        int total = 0;
        for(int i = n; i >= 0; i--){
            total += freq[i];
            if(total >= i){
                return i;
            }
        }
        return 0;
    
    }
}