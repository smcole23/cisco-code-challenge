package stephen.cole;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by stephencole on 8/5/18.
 */
public class MainTest {

    private static GNode rootNode, B, C, D;

    @Before
    public void setUp() throws Exception {

        B = new Node("B", new Node("E"), new Node("F"));
        C = new Node("C", new Node("G"), new Node("H"), new Node("I"));
        D = new Node("D", new Node("J"));
        rootNode = new Node("A", B, C, D);
    }

    @Test
    public void testWalkGraph() throws Exception {

        List<GNode> nodes = new Main().walkGraph(rootNode);
        assertNotNull(nodes);
        assertTrue(nodes.size() == 10);
    }

    @Test
    public void testPaths() throws Exception {

        ArrayList paths = new Main().paths(rootNode);
        assertNotNull(paths);
        assertTrue(paths.size() != 0);
    }
}