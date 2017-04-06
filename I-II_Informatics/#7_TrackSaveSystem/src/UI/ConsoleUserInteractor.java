package UI;

import java.util.Scanner;


public class ConsoleUserInteractor implements UserInteractor {
    private Scanner sc;

    public ConsoleUserInteractor () throws UserInteractorException {
        sc = new Scanner(System.in);
    }


    @Override
    public String readCommand() throws UserInteractorReadException {
        String command;
        command = sc.nextLine();

        if(command == null) {
            throw new UserInteractorReadException("Строка не введена");
        }

        return command;
    }

    @Override
    public void print(String output) throws UserInteractorWriteException {
        try {
            System.out.println(output);
        } catch (Exception ex) {
            throw new UserInteractorWriteException("Ошибка вывода");
        }
    }
}
