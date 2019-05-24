package com.zhaohuabing;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2 D array representing the territory of a country. The country has been divided into two
 * entities W and B. Calculate the number of W which are enclosed by B. By enclosing, I mean W
 * cannot reach the boundary.
 * 
 * Example:
 * 
 * B B B B 
 * W B W B 
 * B W W B 
 * B B B B
 * 
 * There are 3 Ws that have been enclosed by B. Only the W at (1,0) are not enclosed because it can
 * reach the boundary. The function should return 3.
 *
 */
public class Territory {

    public int findEnclosedEntity(char[][] territory) {
        int rows = territory.length;
        if (rows <= 1) {
            return 0;
        }
        int columns = territory[0].length;
        if (columns <= 1) {
            return 0;
        }

        // found all the Ws on the boundary
        List<int[]> entitiesOnBoundary = new ArrayList<int[]>();
        // Ws on the north boundary
        for (int column = 0; column < columns; column++) {
            if (territory[0][column] == 'W') {
                entitiesOnBoundary.add(new int[] {0, column});
            }
        }
        // Ws on the south boundary
        for (int column = 0; column < columns; column++) {
            if (territory[rows - 1][column] == 'W') {
                entitiesOnBoundary.add(new int[] {rows - 1, column});
            }
        }
        // Ws on the west boundary
        for (int row = 0; row < rows; row++) {
            if (territory[row][0] == 'W') {
                entitiesOnBoundary.add(new int[] {row, 0});
            }
        }
        // Ws on the east boundary
        for (int row = 0; row < rows; row++) {
            if (territory[row][columns - 1] == 'W') {
                entitiesOnBoundary.add(new int[] {row, columns - 1});
            }
        }

        int reachable = 0;
        // found all Ws that can be connected to the W on the boundary
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < entitiesOnBoundary.size(); i++) {
            reachable += findConnectedEntitiesBFS(entitiesOnBoundary.get(i), territory, rows, columns, visited);
        }

        // found all Ws
        int all = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (territory[i][j] == 'W') {
                    all++;
                }
            }
        }

        System.out.println("number of W that can reach the boundary: " + reachable);
        System.out.println("number of W that can't reach the boundary: " + (all - reachable));
        return all - reachable;
    }

    /**
     * @param is
     * @param territory
     * @return
     */
    private int findConnectedEntitiesBFS(int[] boundaryEntity, char[][] territory, int rows, int columns,
                    boolean[][] visited) {
        int[] root = boundaryEntity;
        List<int[]> queue = new ArrayList<int[]>();
        List<int[]> result = new ArrayList<int[]>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int[] node = queue.remove(0);
            if (!visited[node[0]][node[1]]) {
                result.add(node);
                visited[node[0]][node[1]] = true;
            }

            List<int[]> children = getChildren(node, territory, visited, rows, columns);
            for (int i = 0; i < children.size(); i++) {
                queue.add(children.get(i));
            }
        }
        return result.size();
    }

    /**
     * @param boundaryEntity
     * @param territory
     * @return
     */
    private List<int[]> getChildren(int[] node, char[][] territory, boolean[][] visited, int rows, int columns) {
        int row = node[0];
        int column = node[1];
        List<int[]> children = new ArrayList<int[]>();

        // north
        if (row - 1 >= 0) {
            if (territory[row - 1][column] == 'W') {
                if (!visited[row - 1][column]) {
                    children.add(new int[] {row - 1, column});
                }
            }
        }
        // south
        if (row + 1 < rows) {
            if (territory[row + 1][column] == 'W') {
                if (!visited[row + 1][column]) {
                    children.add(new int[] {row + 1, column});
                }
            }
        }
        // west
        if (column - 1 >= 0) {
            if (territory[row][column - 1] == 'W') {
                if (!visited[row][column - 1]) {
                    children.add(new int[] {row, column - 1});
                }
            }
        }
        // east
        if (column + 1 < columns) {
            if (territory[row][column + 1] == 'W') {
                if (!visited[row][column + 1]) {
                    children.add(new int[] {row, column + 1});
                }
            }
        }

        return children;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        /**
         * B B B B 
         * W B W B 
         * B W W B 
         * B B B B
         */
        char[][] input = new char[4][4];
        input[0] = new char[] {'B', 'B', 'B', 'B'};
        input[1] = new char[] {'W', 'B', 'W', 'B'};
        input[2] = new char[] {'B', 'W', 'W', 'B'};
        input[3] = new char[] {'B', 'B', 'B', 'B'};
        new Territory().findEnclosedEntity(input);


        /**
         * B B B B B
         * W B W W W
         * W W B W B
         * B W B W W
         * B B W B B
         * B B B B B
         */
        input = new char[6][5];
        input[0] = new char[] {'B', 'B', 'B', 'B', 'B'};
        input[1] = new char[] {'W', 'B', 'W', 'W', 'W'};
        input[2] = new char[] {'W', 'W', 'B', 'W', 'B'};
        input[3] = new char[] {'B', 'W', 'B', 'W', 'W'};
        input[4] = new char[] {'B', 'B', 'W', 'B', 'B'};
        input[5] = new char[] {'B', 'B', 'B', 'B', 'B'};
        new Territory().findEnclosedEntity(input);

    }

}
