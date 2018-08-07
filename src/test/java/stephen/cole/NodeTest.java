package stephen.cole;

import org.junit.Test;

/**
 * Created by stephencole on 8/6/18.
 */
public class NodeTest {

    private static GNode A, B, C;

    @Test
    public void testNoName() throws Exception {

        A = new Node("");
        assert A.getName().isEmpty();

        B = new Node(null, null);
        assert B.getName() != null;
        assert B.getName().isEmpty();
    }

    @Test
    public void testNoChildren() throws Exception {

        A = new Node("A");
        assert A.getChildren().length == 0;

        B = new Node("B", null);
        assert B.getChildren().length == 0;

        C = new Node("C", A, B);
        assert C.getChildren().length == 2;
    }

}