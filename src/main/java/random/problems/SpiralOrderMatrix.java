package random.problems;

import java.util.ArrayList;
import java.util.List;


public class SpiralOrderMatrix {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();
        int k = 0;
        int l = 0;

        int xSize = a.size() - 1;
        int ySize = a.get(0).size() - 1;

        int i = 0;
        while (k <= xSize && l <= ySize) {
            for (i = l; i <= ySize; ++i) {
                if (!(k > xSize || l > ySize)) {
                    result.add(a.get(k).get(i));
                }
            }
            k++;

            for (i = k; i <= xSize; ++i) {
                if (!(k > xSize || l > ySize)) {
                    result.add(a.get(i).get(ySize));
                }
            }
            ySize--;

            for (i = ySize; i >= l; --i) {
                if (!(k > xSize || l > ySize)) {
                    result.add(a.get(xSize).get(i));
                }
            }
            xSize--;


            for (i = xSize; i >= k; --i) {
                if (!(k > xSize || l > ySize)) {
                    result.add(a.get(i).get(l));
                }
            }
            l++;
        }
        return result;
    }
}