package io.github.rajasekarans.meettool.service;

import io.github.rajasekarans.meettool.model.Meeting;
import io.github.rajasekarans.meettool.model.Participation;
import io.github.rajasekarans.meettool.utils.MeetUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingService {

    private Meeting meeting;

    public MeetingService() {
        meeting = new Meeting();
    }


    public Meeting getMeeting() {
        return this.meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public MeetingService getService(String filePath) {

        List<String> lines = MeetUtils.cleanUp(filePath);

        // Setting up session details
        meeting.setClassName(lines.get(0).split(",")[1]);
        String[] session = lines.get(1).split(",");
        meeting.setDate(session[1]);
        meeting.setTime(session[3]);
        meeting.setMeedID(session[5]);

        // Loading Participation Details
        List<Participation> participations = new ArrayList<>(); 
        for (String line : lines.subList(4, lines.size() - 4)) {
            List<String> data = Arrays.asList(line.split(","));
            
            //participated in meeting
            if(data.size()>1){
                Participation participation = new Participation();
                participation.setGmeetName(data.get(0));
                participation.setArrivalTime(data.get(4));
                participation.setLastSeen(data.get(5));
                participation.setNoOfChecks(Integer.parseInt(data.get(6)));
                participation.setJoined(Integer.parseInt(data.get(7)));
                participation.setDetails(data.subList(8, data.size()));
                participations.add(participation);
            }
        }
        meeting.setParticipations(participations);
        return this;
    }
}
