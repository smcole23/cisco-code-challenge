package stephen.cole;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final GNode B = new Node("B", new Node("E"), new Node("F"));
        final GNode C = new Node("C", new Node("G"), new Node("H"), new Node("I"));
        final GNode D = new Node("D", new Node("J"));
        final GNode rootNode = new Node("A", B, C, D);

        Main graph = new Main();

        System.out.println("");
        printNodes(graph.walkGraph(rootNode));
        System.out.print("\n\n");
        printPaths(graph.paths(rootNode));
    }

    /*
    return a ArrayList containing every GNode in the
    graph. Each node should appear in the ArrayList exactly once
    (i.e. no duplicates).
     */
    public ArrayList walkGraph(GNode root) {

        List<GNode> nodes = new ArrayList<GNode>();
        nodes.add(root);
        listNodes(root, nodes);
        return (ArrayList) nodes;
    }

    private void listNodes(GNode root, List<GNode> nodes) {

        for (GNode child : root.getChildren()) {
            nodes.add(child);
            listNodes(child, nodes);
        }
    }

    /*
    return a ArrayList of ArrayLists, representing all
    possible paths through the graph starting at 'node'. The ArrayList
    returned can be thought of as a ArrayList of paths, where each path
    is represented as an ArrayList of GNodes.
     */
    public ArrayList paths(GNode root) {

        List<List<GNode>> paths = new ArrayList<List<GNode>>();
        paths.addAll(listPaths(root));
        return (ArrayList) paths;
    }

    private ArrayList<ArrayList<GNode>> listPaths(GNode node) {

        List<List<GNode>> paths = new ArrayList<List<GNode>>();

        if (node.getChildren().length != 0) {

            for (GNode child : node.getChildren()) {
                paths.addAll(listPaths(child));
            }

            for (List<GNode> gNodes : paths) {
                gNodes.add(0, node);
            }

        } else {

            List<GNode> path = new ArrayList<GNode>();
            path.add(node);
            paths.add(path);
        }

        return (ArrayList) paths;
    }

    private static void printNodes(ArrayList<GNode> nodes) {

        System.out.print("\n\nnode list: " + "(");

        for (GNode node : nodes) {
            System.out.print(" " + node.getName());
        }

        System.out.println(" )");
    }

    private static void printPaths(ArrayList<ArrayList<GNode>> paths) {

        System.out.print("paths(" + paths.get(0).get(0).getName() + ") = (");

        for (List<GNode> path : paths) {

            System.out.print(" (");

            for (GNode node : path) {
                System.out.print(node.getName());
            }

            System.out.print(")");
        }

        System.out.print(" )\n\n");
    }




}
