package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private String name;
  private String surname;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String email;
  private final String notes;
  private final String group;

  public ContactData(int id, String name, String surname, String company, String address, String homePhone, String email, String notes, String group) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.company = company;
    this.address = address;
    this.homePhone = homePhone;
    this.email = email;
    this.notes = notes;
    this.group = group;
  }

  public ContactData(String name, String surname, String company, String address, String homePhone, String email, String notes, String group) {
    this.id = Integer.MAX_VALUE;
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

  public void setId(int max) {
    this.id = max;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "surname='" + surname + '\'' +
            ", name='" + name + '\'' +
            ", id=" + id +
            '}';
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return surname != null ? surname.equals(that.surname) : that.surname == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
