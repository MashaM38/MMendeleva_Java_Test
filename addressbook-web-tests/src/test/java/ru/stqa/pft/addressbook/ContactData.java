package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String surname;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String email;
  private final String notes;

  public ContactData(String name, String surname, String company, String address, String homePhone, String email, String notes) {
    this.name = name;
    this.surname = surname;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.notes = notes;
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
}
