package com.zhaohuabing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
 *
 */
public class ShortestReachInGraph {


    public static int[] calDistances(int nodes, int[][] edges, int startNode) {
        //key label, value Node
        Map<Integer, Node> graph = new HashMap<Integer, Node>();

        //Construct the graph
        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new Node(i));
        }

        for (int i = 0; i < edges.length; i++) {
            Node leftNode = graph.get(edges[i][0]);
            Node rightNode = graph.get(edges[i][1]);
            leftNode.addNeighbour(rightNode);
            rightNode.addNeighbour(leftNode);
        }

        //Use BFS to calculate the distance of each node from root
        Set<Node> visited = new HashSet<Node>();
        List<Node> queue = new ArrayList<Node>();

        Node root = graph.get(startNode);
        root.distance = 0;
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Node curNode = queue.remove(0);
            //System.out.println("Cur Node: "+curNode.label);
            Iterator<Node> neighbours = curNode.neighbours.iterator();
            while (neighbours.hasNext()) {
                Node neighbour = neighbours.next();
                if (visited.contains(neighbour)) {
                    continue;
                }
                visited.add(neighbour);
                //System.out.println("neighbour: "+neighbour.label);
                neighbour.distance = curNode.distance + 6;
                queue.add(neighbour);
            }
        }

        int[] distances = new int[nodes - 1];
        for (int i = 1; i <= nodes - 1; i++) {
            if (i >= startNode) {
                distances[i - 1] = graph.get(i + 1).distance;
            } else {
                distances[i - 1] = graph.get(i).distance;
            }
        }

        return distances;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfQueries = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < numOfQueries; j++) {
            String[] tmpStr = scanner.nextLine().split(" ");
            int numOfNodes = Integer.parseInt(tmpStr[0]);
            int numOfEdges = Integer.parseInt(tmpStr[1]);

            int[][] edges = new int[numOfEdges][2];
            for (int i = 0; i < numOfEdges; i++) {
                tmpStr = scanner.nextLine().split(" ");
                edges[i][0] = Integer.parseInt(tmpStr[0]);
                edges[i][1] = Integer.parseInt(tmpStr[1]);
            }

            int startNode = Integer.parseInt(scanner.nextLine());

            int[] result = ShortestReachInGraph.calDistances(numOfNodes, edges, startNode);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}


class Node {
    int label = 0;
    int distance = -1;
    List<Node> neighbours = new ArrayList<Node>();

    public Node(int label) {
        this.label = label;
    }

    public void addNeighbour(Node neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            return ((Node) o).label == label;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new Integer(label).hashCode();
    }
}


