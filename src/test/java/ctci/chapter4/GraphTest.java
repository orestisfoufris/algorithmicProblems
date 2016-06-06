package ctci.chapter4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * @author Orestis
 */
public class GraphTest {

    private Graph graph;

    @BeforeClass
    public void setup() {
        graph = new Graph();
        graph.addNode(1, 2, 4, 5);
        graph.addNode(2, 1);
        graph.addNode(4, 5, 2);
        graph.printGraph();
    }

    @Test
    public void checkPathExists_1() {
        assertTrue(graph.bfs(1, 5));
    }

    @Test
    public void checkPathExists_2() {
        assertTrue(graph.bfs(4, 2));
    }

    @Test
    public void checkPathExists_3() {
        assertTrue(graph.bfs(5, 5));
    }

    @Test
    public void checkPathNotExists_1() {
        assertFalse(graph.bfs(2, 4));
    }

    @Test
    public void checkPathNotExists_2() {
        assertFalse(graph.bfs(5, 1));
    }
}
