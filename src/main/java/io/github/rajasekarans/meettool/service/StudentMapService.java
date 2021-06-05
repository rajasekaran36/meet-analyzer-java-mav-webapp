package io.github.rajasekarans.meettool.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.github.rajasekarans.meettool.model.Student;
import io.github.rajasekarans.meettool.model.StudentMap;


public class StudentMapService {
    private List<StudentMap> studentMaps;

    public StudentMapService(){
        studentMaps = new ArrayList<>();
    }

    public void addStudentMap(String recordline){
        List<String> data =  Arrays.asList(recordline.split(","));
        Student student = new Student(Integer.parseInt(data.get(0)), data.get(1), data.get(2));
        StudentMap studentMap = new StudentMap(student, data.subList(3, data.size()));
        studentMaps.add(studentMap);
    }

    public Student getStudentByGmeetName(String gmeetName){
        for(StudentMap studentMap:studentMaps){
            if(studentMap.getMeetNames().contains(gmeetName)){
                return studentMap.getStudent();
            }
        }
        return null;  
    }

    public StudentMapService getService(String filePath){
        try {
            List<String> lines  = Files.readAllLines(Path.of(filePath),StandardCharsets.UTF_8);
            lines.stream().forEach(line->addStudentMap(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " studentMaps='" + studentMaps + "'" +
            "}";
    }

    public List<StudentMap> getStudentMaps() {
        return studentMaps;
    }
}
