package src;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    public int[] select(Grid grid, Scanner scanner) {

        Pattern pattern = Pattern.compile("^[a-z][1-3] *$", Pattern.CASE_INSENSITIVE);
        int[] idx = new int[2];
        System.out.print("Please select a cell:");

        while (true) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                idx[0] = input.charAt(1) - '1';
                idx[1] = input.toUpperCase().charAt(0) - 'A';

                if (grid.is_assignable(idx[0], idx[1])) {
                    break;
                }
            }
            System.out.print("Please select a valid cell:");
        }
        return idx;
    }
}
