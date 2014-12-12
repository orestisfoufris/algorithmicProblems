package com.topcoder.div2.stage1;

import com.google.common.base.Stopwatch;

/**
 * Created by Orestis on 16/09/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=2297&rd=4775&rm=&cr=8532153
 */

public class BettingMoney {
    public int moneyMade(int[] amounts, int[] centsPerDollars, int finalResult){
        int moneyToBePaid = 0;
        int restOfTheMoney = 0;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i =0; i < amounts.length; i++){
            if(finalResult == i){
                moneyToBePaid = amounts[i] * centsPerDollars[i];
            }else {
                restOfTheMoney += amounts[i] * 100;
            }
        }
        stopwatch.stop();
        System.out.println("loop took: " + stopwatch + " to run");
        return restOfTheMoney - moneyToBePaid;
    }
}
