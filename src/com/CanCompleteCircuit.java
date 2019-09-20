package com;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_gas=0,total_gas=0,lens=gas.length,start_station=0;
        for (int i=0;i<lens;i++){
            curr_gas+=gas[i]-cost[i];
            total_gas+=gas[i]-cost[i];
            if (curr_gas<0){
                start_station++;
                curr_gas=0;
            }
        }
        return total_gas>=0?start_station:-1;
    }
}
