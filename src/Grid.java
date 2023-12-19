package src;


public class Grid {
    private int[][] matrix;

    public Grid() {
        this.matrix = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.matrix[row][col] = 0;
            }
        }
    }

    public boolean is_assignable(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && matrix[row][col] == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public void assign(int player, int row, int col) {
        matrix[row][col] = player;
    }

    public boolean check(int player, int selected_row, int selected_col) {

        // check selected cell's row state
        for (int row = 0; row < 3; row++) {
            if (matrix[row][selected_col] != player) {
                break;
            } else if (row == 2) {
                return true;
            }
        }

        // check selected cell's column state
        for (int col = 0; col < 3; col++) {
            if (matrix[selected_row][col] != player) {
                break;
            } else if (col == 2) {
                return true;
            }
        }

        // check top-left-bottom-right diagonal (00, 11, 22)
        if (selected_row == selected_col) {
            for (int idx = 0; idx < 3; idx++) {
                if (matrix[idx][idx] != player) {
                    break;
                } else if (idx == 2) {
                    return true;
                }
            }
        }

        // check top-right-bottom-left diagonal (02, 11, 20)
        if (selected_row + selected_col == 2) {
            for (int idx = 0; idx < 3; idx++) {
                if (matrix[idx][2 - idx] != player) {
                    break;
                } else if (idx == 2) {
                    return true;
                }
            }
        }

        // no one wins
        return false;
    }

    public void print() {

        System.out.println("  A B C");
        System.out.println("  _____");

        for (int row = 0; row < 3; row++) {
            System.out.print(row + 1);
            System.out.print('|');
            for (int col = 0; col < 3; col++) {
                if (matrix[row][col] == 1) {
                    System.out.print("○ ");
                } else if (matrix[row][col] == -1) {
                    System.out.print("⨯ ");
                } else {
                    System.out.print("  ");

                }
            }
            System.out.println();
        }
    }

}
