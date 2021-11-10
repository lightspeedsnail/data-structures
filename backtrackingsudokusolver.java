package com.company;

public class backtrackingsudokusolver {
    public void prune(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    bt(board);
                }
            }
        }
    }

    private boolean validate(int[][] board, int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) {
                return false;
            }
            if (board[i][y] == num) {
                return false;
            }
        }
        int px = (x / 3) * 3;
        int py = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[px + i][py + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bt(int[][] board) {
        int x = -1;
        int y = -1;
        boolean vacant = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    vacant = true;
                }
            }
        }
        if (!vacant) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (validate(board, x, y, i)) {
                board[x][y] = i;
                if (bt(board)) {
                    return true;
                } else {
                    board[x][y] = 0;
                }
            }
        }
        return false;
    }
}
