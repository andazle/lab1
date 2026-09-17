package org.example;

import java.util.List;
import java.util.ArrayList;

public class CorporateContact extends Contact implements Editable {
    private String position;
    private String internalNumber;
    public CorporateContact(String name, String phone, String email, String organization, String position, String internalNumber) {
        super(name, phone, email, organization);
        this.internalNumber = internalNumber;
        this.position = position;
    }
    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Пустое имя");
        }
        if (internalNumber != null && !internalNumber.isEmpty() && !internalNumber.matches("\\d+")) {
            errors.add("Не цифры в номере");
        }
        return errors;
    }
    @Override
    public String toString() {
        return "CorporateContact{name='" + name + "', position='" + position + "', intNum='" + internalNumber + "'}";
    }

}
