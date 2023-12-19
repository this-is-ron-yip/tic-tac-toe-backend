package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        Grid grid = new Grid();
        User user = new User();

        Scanner scanner = new Scanner(System.in);

        int player = 1;
        int[] idx;
        while (true) {
            idx = user.select(grid, scanner);
            grid.assign(player, idx[0], idx[1]);
            grid.print();

            if (grid.check(player, idx[0], idx[1])) {
                break;
            }
            player *= -1;

        }
        System.out.println("Player " + player + " won the game!");
        scanner.close();
    }
}
