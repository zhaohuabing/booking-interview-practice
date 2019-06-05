package com.zhaohuabing;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider an N*N game board, with a black and white pieces that can be placed on it. You are given a board with placed pieces around it in a random spots.
 *
 * You need to implement a function that determines if a piece (black or white) is captured on a given coordination (x, y).
 *
 * A piece is defined as captured by the following rules:
 * 1. If all sides (up, down, left &amp; right) contains an opposite piece that surrounds/blocking it.
 * 2. If some of the sides are blocked (for example, right and down) and the other ones arae out of bound (OOB defined for coords: x: &lt;= 0, y: &lt;= 0) it's considered as blocked.
 * 3. If one of the sides is empty, it's free.
 * 4. If one of the sides contains the same piece type, and that piece is not captured (by the rules above), it's free.
 * 5. Note that pieces may be captured in a clustered way (related to #4).
 *
 * For example, consider the following coordinates:
 * coord(1,1) = B
 * coord(1,2) = W
 * coord(2,1) = W
 */
public class GoGame {

    public static boolean isSurrounded(int x, int y, char[][] board) {
        int[] root = new int[] {x - 1, y - 1};
        char color = board[x - 1][y - 1];

        List<int[]> queue = new ArrayList<int[]>();
        queue.add(root);

        int[][] visited = new int[board.length][board[0].length];

        while (!queue.isEmpty()) {
            int[] cell = queue.remove(0);
            int cellX = cell[0];
            int cellY = cell[1];
            if (visited[cellX][cellY] == 1) {
                continue;
            }
            visited[cellX][cellY] = 1;

            char cellColor = board[cellX][cellY];
            if (isEmptyCell(cellColor)) {
                return false;
            }
            if (isSameColor(color, cellColor)) {
                List<int[]> neighbours = getNeighbours(cellX, cellY, board);
                for (int i = 0; i < neighbours.size(); i++) {
                    queue.add(neighbours.get(i));
                }
            }
        }

        return true;
    }

    private static List<int[]> getNeighbours(int x, int y, char[][] board) {
        List<int[]> neighbours = new ArrayList<int[]>();

        int[][] offset = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < offset.length; i++) {
            int neighbourX = x + offset[i][0];
            int neighbourY = y + offset[i][1];

            if (neighbourX < 0 || neighbourY < 0 || neighbourX >= board.length || neighbourY >= board[0].length) {
                continue;
            }
            neighbours.add(new int[] {neighbourX, neighbourY});
        }
        return neighbours;
    }

    private static boolean isEmptyCell(char cell) {
        return cell == 'E';
    }

    private static boolean isSameColor(char cell1, char cell2) {
        return cell1 == cell2;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'E', 'W', 'W', 'W', 'W', 'W', 'W'}, {'E', 'W', 'B', 'W', 'W', 'W', 'W'},
                        {'E', 'W', 'B', 'W', 'W', 'B', 'W'}, {'E', 'W', 'B', 'B', 'W', 'B', 'B'},
                        {'E', 'W', 'W', 'B', 'B', 'W', 'W'}, {'E', 'B', 'B', 'B', 'W', 'W', 'W'},
                        {'E', 'W', 'W', 'W', 'B', 'W', 'W'}, {'E', 'W', 'W', 'W', 'W', 'W', 'W'}

        };
        System.out.println(GoGame.isSurrounded(1, 3, board));
        System.out.println(GoGame.isSurrounded(4, 4, board));
        System.out.println(GoGame.isSurrounded(7, 5, board));
        System.out.println(GoGame.isSurrounded(4, 6, board));
    }
}
