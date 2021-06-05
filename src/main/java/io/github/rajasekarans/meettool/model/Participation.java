package io.github.rajasekarans.meettool.model;

import java.util.List;

public class Participation {
    private String gmeetName;
    private String arrivalTime;
    private String lastSeen;
    private Integer noOfChecks;
    private Integer joined;
    private List<String> details;


    public String getGmeetName() {
        return this.gmeetName;
    }

    public void setGmeetName(String gmeetName) {
        this.gmeetName = gmeetName;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLastSeen() {
        return this.lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Integer getNoOfChecks() {
        return this.noOfChecks;
    }

    public void setNoOfChecks(Integer noOfChecks) {
        this.noOfChecks = noOfChecks;
    }

    public Integer getJoined() {
        return this.joined;
    }

    public void setJoined(Integer joined) {
        this.joined = joined;
    }

    public List<String> getDetails() {
        return this.details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return "{" +
            " gmeetName='" + gmeetName + "'" +
            ", arrivalTime='" + arrivalTime + "'" +
            ", lastSeen='" + lastSeen + "'" +
            ", noOfChecks='" + noOfChecks + "'" +
            ", joined='" + joined + "'" +
            ", details='" + details + "'" +
            "}";
    }


}
