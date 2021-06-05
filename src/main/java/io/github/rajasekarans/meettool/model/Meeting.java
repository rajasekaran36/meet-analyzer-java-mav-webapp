package io.github.rajasekarans.meettool.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    
    private String className;
    private String date;
    private String time;
    private String meedID;
    private List<Participation> participations;

    public Meeting() {
        participations = new ArrayList<>();
    }


    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getMeedID() {
        return this.meedID;
    }

    public void setMeedID(String meedID) {
        this.meedID = meedID;
    }

    public List<Participation> getParticipations() {
        return this.participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
    

    @Override
    public String toString() {
        return "{" +
            " className='" + className + "'" +
            ", date='" + date + "'" +
            ", time='" + time + "'" +
            ", meedID='" + meedID + "'" +
            ", participations='" + participations + "'" +
            "}";
    }


}
