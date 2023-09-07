import java.io.*;
import java.util.*;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите данные (Фамилия Имя Отчество номер_телефона):");
        String inputLine = scanner.nextLine();
        
        try {
            String[] userData = inputLine.split(" ");
            
            if (userData.length != 4) {
                throw new InvalidDataFormatException("Неверное количество данных. Требуется 4 элемента.");
            }
            
            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            
            long phoneNumber = Long.parseLong(userData[3]);
            
            File file = new File(lastName + ".txt");
            FileWriter writer = new FileWriter(file);
            
            writer.write(lastName +" "+ firstName +" "+ middleName +" "+ phoneNumber + "\n");
            
            writer.close();
            
            System.out.println("Данные успешно записаны в файл: " + file.getName());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат номера телефона.");
            e.printStackTrace();
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}