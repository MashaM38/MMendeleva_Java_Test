package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String surname;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String email;
  private final String notes;
  private final String group;

  public ContactData(String name, String surname, String company, String address, String homePhone, String email, String notes, String group) {
    this.name = name;
    this.surname = surname;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.notes = notes;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }
}
