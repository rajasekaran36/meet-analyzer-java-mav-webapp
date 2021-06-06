package io.github.rajasekarans.meettool.model;

public class Session{
    private String classname;
    private String date;
    private String time;
    private String meetid;
    private String studentid;
    private String studentrollno;
    private String studentname;
    private String gmeetname;
    private String arrivaltime;
    private String lastseen;
    private String totalduration;
    private String status;
    private String comments;

    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMeetid() {
        return this.meetid;
    }

    public void setMeetid(String meetid) {
        this.meetid = meetid;
    }

    public String getGmeetname() {
        return this.gmeetname;
    }

    public void setGmeetname(String gmeetname) {
        this.gmeetname = gmeetname;
    }

    public String getArrivaltime() {
        return this.arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getLastseen() {
        return this.lastseen;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public String getTotalduration() {
        return this.totalduration;
    }

    public void setTotalduration(String totalduration) {
        this.totalduration = totalduration;
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


    public String getStudentid() {
        return this.studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentrollno() {
        return this.studentrollno;
    }

    public void setStudentrollno(String studentrollno) {
        this.studentrollno = studentrollno;
    }

    public String getStudentname() {
        return this.studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }


    @Override
    public String toString() {
        return "{" +
            " classname='" + classname + "'" +
            ", date='" + date + "'" +
            ", time='" + time + "'" +
            ", meetid='" + meetid + "'" +
            ", studentid='" + studentid + "'" +
            ", studentrollno='" + studentrollno + "'" +
            ", studentname='" + studentname + "'" +
            ", gmeetname='" + gmeetname + "'" +
            ", arrivaltime='" + arrivaltime + "'" +
            ", lastseen='" + lastseen + "'" +
            ", totalduration='" + totalduration + "'" +
            ", status='" + status + "'" +
            ", comments='" + comments + "'" +
            "}";
    }


}