package io.github.rajasekarans.meettool.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportRecord{
    private Student student;
    private Participation participation;
    private Long totalDuration;
    private String status = "AB";
    private String comments = "";


    public ReportRecord(Student student,Participation participation){
        this.student = student;
        this.participation = participation;
        this.analize();
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Participation getParticipation() {
        return this.participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public Long getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



    @Override
    public String toString() {
        return "{" +
            " student='" + student + "'" +
            ", participation='" + participation + "'" +
            ", totalDuration='" + totalDuration + "'" +
            ", status='" + status + "'" +
            ", comments='" + comments + "'" +
            "}";
    }



    public void analize(){
        if(student!=null && participation!=null){
            String start = participation.getArrivalTime();
            String end = participation.getLastSeen();
            this.totalDuration = computeDuration(start, end);
            if(this.totalDuration>=30){
                this.status = "P";
            }
            else{
                this.status = "LE";
                this.comments = "Left Early";
            }
        }
    }

    private  Long computeDuration(String start,String end){
        Long duration = 0L;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            Date startTime = format.parse(start);
            Date endTime = format.parse(end);
            duration = (endTime.getTime() - startTime.getTime()) / (1000 * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return duration;
    }

}
