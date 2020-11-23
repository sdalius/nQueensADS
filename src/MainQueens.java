import java.util.Scanner;

public class MainQueens
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the board: ");
        int keyboard = input.nextInt();
        new Queens(keyboard);
    }
}