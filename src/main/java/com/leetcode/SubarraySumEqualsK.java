import java.lang.*;
import java.util.*;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // key zero means we have found a result so should add 1

        int result = 0;

        int currentSum = 0;

        

        for (int i = 0; i < nums.length; ++i) {

            currentSum += nums[i];

            result += map.getOrDefault(currentSum - k, 0);
	    map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
	 }

        

        return result;   

    }

}
