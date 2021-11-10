package com.company;

class minimax {
    // tictactoe
    class tictactoe {
        private char player;
        private char emp = '_';
        private char oppo;

        public void play(char[][] grid, char player, char oppo) {
            if (!vacant(grid)) {
                return;
            }
            this.player = player;
            this.oppo = oppo;
            int x = -1;
            int y = -1;
            int max = -10000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == emp) {
                        grid[i][j] = player;
                        int minmax = minmax(grid, player);
                        if (minmax > max) {
                            max = minmax;
                            x = i;
                            y = j;
                        }
                        grid[i][j] = emp;
                    }
                }
            }
            grid[x][y] = player;
        }

        private int score(char[][] grid) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                    if (grid[i][0] == player) {
                        return 10;
                    } else if (grid[i][0] != emp) {
                        return -10;
                    }
                }
                if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                    if (grid[0][i] == player) {
                        return 10;
                    } else if (grid[0][i] != emp) {
                        return -10;
                    }
                }
            }
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                if (grid[1][1] == player) {
                    return 10;
                } else if (grid[1][1] != emp) {
                    return -10;
                }
            }
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
                if (grid[1][1] == player) {
                    return 10;
                } else if (grid[1][1] != emp) {
                    return -10;
                }
            }
            return 0;
        }

        private boolean vacant(char[][] grid) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == emp) {
                        return true;
                    }
                }
            }
            return false;
        }

        private int minmax(char[][] grid, char pre) {
            int score = score(grid);
            if (score == 10 || score == -10) {
                return score;
            }
            if (!vacant(grid)) {
                return 0;
            }
            if (pre == player) // return min possible
            {
                int least = 1000;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (grid[i][j] == emp) {
                            grid[i][j] = oppo;
                            least = Math.min(least, minmax(grid, oppo));
                            grid[i][j] = emp;
                        }
                    }
                }
                return least;
            } else  // return max possible
            {
                int best = -1000;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (grid[i][j] == emp) {
                            grid[i][j] = player;
                            best = Math.max(best, minmax(grid, player));
                            grid[i][j] = emp;
                        }
                    }
                }
                return best;
            }
        }
    }

}
