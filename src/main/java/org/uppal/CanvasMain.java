package org.uppal;

import org.uppal.commandExecution.CommandExecutor;

import java.util.Scanner;

public class CanvasMain {
    private static final Scanner inputScanner = new Scanner(System.in);

    private static final CommandExecutor commandExecutor = new CommandExecutor();

    public static void main(String[] args) {
        String inputCommand = null;
        while (true) {
            try {
                System.out.print("Please enter command: ");
                inputCommand = inputScanner.nextLine();
                if (inputCommand.equals("QUIT")) {
                    System.exit(0);
                    inputScanner.close();
                }
                System.out.println(commandExecutor.execute(inputCommand));
            } catch (Exception e) {
                System.out.println("Input command was not parsed correctly. Command entered: " + inputCommand + "\n" +
                        " Exception: " + e);
            }
        }
    }

}
