package EoPI.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * 19.1 Identify The Celebrity
 * Everyone knows the celebrity, but the celebrity knows none.
 * F[a][b] is true only if and only if a knows b.
 * Find the celebrity
 *
 * 05/11/2016.
 */
public class IdentifyTheCelebrity {

    // Although BFS is O(V + E) because we need to build
    // the adjacent list overall running time would be O(n^2)
    public static int findCelebrityBFS(List<List<Boolean>> F) {

        List<List<Integer>> A = F.stream()
                .map(list -> IntStream.range(0, list.size())
                        .mapToObj(i -> i)
                        .filter(value -> list.get(value).equals(Boolean.TRUE))
                        .collect(toList()))
                .collect(toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();

        int last = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int head = queue.pollFirst();
            List<Integer> adjacentList = A.get(head);
            last = head;

            for (Integer node : adjacentList) {
                if (!seen.contains(head)) {
                    queue.offer(node);
                }
            }
            seen.add(head);
        }

        return last;
    }


    public static void main(String[] args) {
        List<List<Boolean>> F = new ArrayList<>();
        List<Boolean> zero = Arrays.asList(false, true, true, true);
        List<Boolean> one = Arrays.asList(false, false, true, true);
        List<Boolean> two = Arrays.asList(false, false, false, false);
        List<Boolean> three = Arrays.asList(false, false, true, false);

        F.add(zero); F.add(one); F.add(two); F.add(three);

        System.out.println(findCelebrityBFS(F));
    }
}
