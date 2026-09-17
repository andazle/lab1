package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvLoader loader = new CsvLoader();
        try {
            List<Contact> contacts = loader.load(Path.of("test.csv"));

            System.out.println("Успешно загружено контактов: " + contacts.size());
            for (Contact c : contacts) {
                System.out.println(c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
