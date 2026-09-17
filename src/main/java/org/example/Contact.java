package org.example;

public class Contact {
    protected String name;
    protected String phone;
    protected String email;
    protected String organization;

    public Contact(String name, String phone, String email, String organization) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.organization = organization;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return String.format("Contact{name='%s', phone='%s', email='%s', org='%s'}",
                name, phone, email, organization);
    }
}
