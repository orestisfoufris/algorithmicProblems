package com.topcoder.div2.stage1;

/**
 * Created by Orestis on 17/09/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=2403&rd=4780&rm=150835&cr=8472634
 */
public class BoxLoader {

    public int mostItems(int boxX, int boxY, int boxZ, int itemX, int itemY, int itemZ){
        int[] box = {boxX, boxY, boxZ};
        int[] item = {itemX, itemY, itemZ};

        int j = 0;
        int max = (boxX /item[0]) * (boxY /item[1]) * (boxZ /item[2]);
        while(j < 6) {
            for(int i = 0; i < box.length; i++) {
                if(i+1 != box.length) {
                    int curr = item[i];
                    item[i] = item[i + 1];
                    item[i + 1] = curr;
                }else{
                    int last = item[2];
                    item[i] = item[0];
                    item[0] = last;
                }
                max = Math.max(max,( (boxX /item[0]) * (boxY /item[1]) * (boxZ /item[2]) ));
                j += 1;
            }
        }
        return max;
    }
}
