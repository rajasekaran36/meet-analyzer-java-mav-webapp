package io.github.rajasekarans.meettool.model;

public class Student {
    private Integer id;
    private String rollNo;
    private String name;

    public Student(Integer id, String rollNo, String name) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", rollNo='" + rollNo + "'" +
            ", name='" + name + "'" +
            "}";
    }

    
}
