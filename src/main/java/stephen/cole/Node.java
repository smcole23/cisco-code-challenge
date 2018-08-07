package stephen.cole;

/**
 * Created by stephencole on 8/6/18.
 */
public class Node implements GNode {

    private String name;
    private GNode[] children;

    public Node(String name, GNode... children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public String getName() {
        return name != null ? name : "";
    }

    @Override
    public GNode[] getChildren() {
        return children != null ? children.clone() : new GNode[0];
    }
}
