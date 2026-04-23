class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
            int total_gas = 0;
        int total_cost = 0;
        for(int i =0;i<gas.length;i++)
        {
            total_gas+=gas[i];
            total_cost+=cost[i];
        }
        if(total_gas<total_cost) return -1;
        int currentGas = 0;
        int startIndex = 0;
        for(int i=0;i<gas.length;i++)
        {
            currentGas+=gas[i] - cost[i];
           // int remainingGas = currentGas - cost[i];
            if(currentGas<0)
            {
                startIndex = i+1;
                currentGas = 0;
                

            }
            
            
            
        }
        return startIndex;
    }
}