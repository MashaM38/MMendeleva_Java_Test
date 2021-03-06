package ru.stqa.pft.addressbook.model;

public class GroupData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;
  private String group;


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

  public GroupData withId(int max) {
    this.id = max;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withGroup(String group) {
    this.group = group;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
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
