package io.github.rajasekarans.meettool.model;
import java.util.List;

public class StudentMap {
    private Student student;
    private List<String> meetNames;

    public StudentMap(Student student, List<String> meetNames) {
        this.student = student;
        this.meetNames = meetNames;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<String> getMeetNames() {
        return this.meetNames;
    }

    public void setMeetNames(List<String> meetNames) {
        this.meetNames = meetNames;
    }


    @Override
    public String toString() {
        return "{" +
            " student='" + student + "'" +
            ", meetNames='" + meetNames + "'" +
            "}";
    }

}
