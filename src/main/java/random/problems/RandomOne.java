package random.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by sweetleaf on 11/10/2014
 */
public class RandomOne {

    public ArrayList<ArrayList<Integer>> solution(List<Integer> input) {
        ArrayList<ArrayList<Integer>> result = newArrayList();
        Collections.sort(input);
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> temp = newArrayList(input.get(i));
            while((i != input.size() - 1) && ( (input.get(i+1) - input.get(i) == 1) || (input.get(i+1) - input.get(i) == 0 ))){
                if(!temp.contains(input.get(i+1))) {
                    temp.add(input.get(i + 1));
                }
                i++;
            }
            result.add(temp);
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> solutionBad(List<Integer> input){
        ArrayList<ArrayList<Integer>> result = newArrayList();
        Collections.sort(input);
        for(int i=0; i<input.size();i++) {
            ArrayList<Integer> temp = newArrayList();
            if ((i != input.size() - 1) && (input.get(i) == input.get(i + 1) - 1)) {
                int j = i;
                while ((input.get(j) == input.get(j + 1) - 1) && j < input.size()) {
                    if(!temp.contains(input.get(j))) {
                        temp.add(input.get(j));
                    }
                    temp.add(input.get(j + 1));
                    j++; i++;
                }
                result.add(temp);
            } else {
                result.add(newArrayList(input.get(i)));
            }
        }
        return result;
    }
}