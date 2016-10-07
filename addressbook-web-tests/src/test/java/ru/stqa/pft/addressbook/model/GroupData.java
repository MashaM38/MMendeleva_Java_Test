package ru.stqa.pft.addressbook.model;

public class GroupData {
  private int id;
  private String name;
  private final String header;
  private final String footer;
  private final String group;

  public GroupData(int id, String name, String header, String footer, String group) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.group = group;
  }

  public GroupData(String name, String header, String footer, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
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

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
