package org.example;

public class EmergencyContact extends Contact  {
    public EmergencyContact(String name, String phone, String email, String organization) {
        super(name, phone, email, organization);
    }
    @Override
    public String toString() {
        return "EmergencyContact{" + super.toString() + "}";
    }
}
