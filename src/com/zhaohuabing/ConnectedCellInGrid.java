package com.zhaohuabing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
 *
 */
public class ConnectedCellInGrid {

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int columns = grid[0].length;
        if (columns == 0) {
            return 0;
        }

        // 1 visted, 0 unvisted
        int[][] visited = new int[rows][columns];

        int maxRegionSize = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } else if (isVisited(i, j, visited)) {
                    continue;
                } else {
                    //maxRegionSize = Math.max(sizeOfRegionBFS(i, j, grid, visited), maxRegionSize);
                    //maxRegionSize = Math.max(sizeOfRegionDFSStack(i, j, grid, visited), maxRegionSize);
                    maxRegionSize = Math.max(sizeOfRegionDFSRecursion(i, j, grid, visited), maxRegionSize);
                }
            }
        }

        return maxRegionSize;
    }

    private static boolean isVisited(int x, int y, int[][] visited) {
        return visited[x][y] == 1;
    }

    private static int sizeOfRegionBFS(int x, int y, int[][] grid, int[][] visited) {
        int size = 0;
        Cell root = new Cell(x, y);
        List<Cell> queue = new ArrayList<Cell>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Cell cell = queue.remove(0);
            if (!isVisited(cell.x, cell.y, visited)) {
                visited[cell.x][cell.y] = 1;
                size++;

                List<Cell> neighbours = getNeighbours(cell, grid);
                for (int i = 0; i < neighbours.size(); i++) {
                    queue.add(neighbours.get(i));
                }
            }
        }
        System.out.println("size: " + size);
        return size;
    }

    private static int sizeOfRegionDFSStack(int x, int y, int[][] grid, int[][] visited) {
        int size = 0;
        Cell root = new Cell(x, y);
        List<Cell> stack = new ArrayList<Cell>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Cell cell = stack.remove(0);
            if (!isVisited(cell.x, cell.y, visited)) {
                visited[cell.x][cell.y] = 1;
                size++;

                List<Cell> neighbours = getNeighbours(cell, grid);
                for (int i = 0; i < neighbours.size(); i++) {
                    stack.add(0, neighbours.get(i));
                }
            }
        }
        System.out.println("size: " + size);
        return size;
    }

    private static int sizeOfRegionDFSRecursion(int x, int y, int[][] grid, int[][] visited) {
        Cell root = new Cell(x, y);
        List<Cell> result = new ArrayList<Cell>();
        recursionDFS(root, grid, result, visited);
        System.out.println("size: " + result.size());
        return result.size();
    }

    private static void recursionDFS(Cell parent, int[][] grid, List<Cell> result, int[][] visited) {
        result.add(parent);
        visited[parent.x][parent.y] = 1;

        List<Cell> neighbours = getNeighbours(parent, grid);
        for (int i = 0; i < neighbours.size(); i++) {
            Cell cell = neighbours.get(i);
            if (!isVisited(cell.x, cell.y, visited)) {
                recursionDFS(cell, grid, result, visited);
            }
        }
    }

    private static List<Cell> getNeighbours(Cell cell, int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        List<Cell> neighbours = new ArrayList<Cell>();

        int[] offsetX = new int[] {-1, 0, 1};
        int[] offsetY = new int[] {-1, 0, 1};
        for (int i = 0; i < offsetX.length; i++) {
            for (int j = 0; j < offsetY.length; j++) {
                //Skip itself
                if (i == 0 && j == 0) {
                    continue;
                }

                int x = cell.x + offsetX[i];
                int y = cell.y + offsetY[j];

                //Skip if coordination is out of boundary
                if (x < 0 || y < 0 || x >= rows || y >= columns) {
                    continue;
                }

                //Skip if the cell is 0
                if (grid[x][y] == 0) {
                    continue;
                }

                neighbours.add(new Cell(x, y));
            }
        }
        return neighbours;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}


class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cell) {
            return this.x == ((Cell) o).x && this.y == ((Cell) o).y;
        }
        return false;
    }
}
