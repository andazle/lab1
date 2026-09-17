package org.example;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.nio.file.Files;

public class CsvLoader {
    public List<Contact> load(Path file) throws IOException{
        List<Contact> result = new ArrayList<>();
        List<CsvParseException> errors = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            reader.readLine();
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null){
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(";", -1);
                try {
                    if (parts.length < 5) {
                        throw new CsvParseException("Недостаточно полей", lineNumber, CsvErrorCode.WRONG_FIELD_COUNT);
                    }
                    String type = parts[0].trim();
                    String name = parts[1].trim();
                    String phone = parts[2].trim();
                    String email = parts[3].trim();
                    String organization = parts[4].trim();
                    if (type.equalsIgnoreCase("Corporate")) {
                        if (parts.length < 7) {
                            throw new CsvParseException("Недостаточно полей для Corporate", lineNumber, CsvErrorCode.WRONG_FIELD_COUNT);
                        }
                        String position = parts[5].trim();
                        String internalNumber = parts[6].trim();

                        CorporateContact contact = new CorporateContact(name, phone, email, organization, position, internalNumber);
                        result.add(contact);

                    } else if (type.equalsIgnoreCase("Emergency")) {
                        EmergencyContact contact = new EmergencyContact(name, phone, email, organization);
                        result.add(contact);

                    } else {
                        Contact contact = new Contact(name, phone, email, organization);
                        result.add(contact);
                    }
                } catch (CsvParseException e) {
                    errors.add(e);
                }
            }
        }
        return result;
    }
}
