package io.github.rajasekarans.meettool.service;

import io.github.rajasekarans.meettool.model.Participation;
import io.github.rajasekarans.meettool.model.ReportRecord;
import io.github.rajasekarans.meettool.model.Session;
import io.github.rajasekarans.meettool.model.Student;
import io.github.rajasekarans.meettool.model.StudentMap;
import io.github.rajasekarans.meettool.model.Meeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class ReportRecordService {

    public StudentMapService studentMapService;
    public MeetingService meetingService;
    List<ReportRecord> reportRecords = new ArrayList<>();

    public ReportRecordService(StudentMapService studentMapService,MeetingService meetingService){
        this.studentMapService = studentMapService;
        this.meetingService = meetingService;
        this.genaratReportRecords();
    }

    private void genaratReportRecords(){

        for(Participation  participation:meetingService.getMeeting().getParticipations()){
            Student student = studentMapService.getStudentByGmeetName(participation.getGmeetName());
            
            if(student!=null){
                ReportRecord reportRecord = new ReportRecord(student, participation);
                reportRecord.analize();
                reportRecords.add(reportRecord);
            }
        }
       
    }

    public ReportRecord getReportRecord(Integer studentID){
        for(ReportRecord reportRecord:reportRecords){
            if(reportRecord.getStudent().getId()==studentID){
                return reportRecord;
            }
        }
        return null;
    }


    public List<ReportRecord> getReportRecords(){
        return reportRecords;
    }

    public List<StudentMap> getStudentMaps(){
        return studentMapService.getStudentMaps();
    }

    public Meeting getMeeting(){
        return meetingService.getMeeting();
    }

    public String reportToCSV(){
        List<String> lines = new ArrayList<>();
        
        for(StudentMap studentMap:studentMapService.getStudentMaps()){
            List<String> words = new ArrayList<>();
            Student student = studentMap.getStudent();
            words.add(String.valueOf(student.getId()));
            words.add(String.valueOf(student.getRollNo()));
            words.add(String.valueOf(student.getName()));
            ReportRecord reportRecord = getReportRecord(student.getId());
            if(reportRecord!=null){
                Participation participation = reportRecord.getParticipation();
                words.add(participation.getGmeetName());
                words.add(participation.getArrivalTime());
                words.add(participation.getLastSeen());
                words.add(String.valueOf(reportRecord.getTotalDuration()));
                words.add(reportRecord.getStatus());
                words.add(reportRecord.getComments());

            }
            else{
                words.add("");
                words.add("");
                words.add("");
                words.add("");
                words.add("AB");
                words.add("ABSENT");
            }
            lines.add(String.join(",", words));
        }
        return String.join("\n", lines);
    }

    public List<Session> getSessions(){
        Meeting meeting = meetingService.getMeeting();
        List<Session> sessionrecords = new ArrayList<>();

        for(StudentMap studentMap:studentMapService.getStudentMaps()){
            Student student = studentMap.getStudent();
            Session session = new Session();
            session.setClassname(meeting.getClassName());
            session.setDate(meeting.getDate());
            session.setTime(meeting.getTime());
            session.setMeetid(meeting.getMeedID());
            session.setStudentid(String.valueOf(student.getId()));
            session.setStudentrollno(student.getRollNo());
            session.setStudentname(student.getName());

            ReportRecord reportRecord = getReportRecord(student.getId());
            if(reportRecord!=null){
                Participation participation = reportRecord.getParticipation();
                session.setGmeetname(participation.getGmeetName());
                session.setArrivaltime(participation.getArrivalTime());
                session.setLastseen(participation.getLastSeen());
                session.setTotalduration(String.valueOf(reportRecord.getTotalDuration()));
                session.setStatus(reportRecord.getStatus());
                session.setComments(reportRecord.getComments());
            }
            else{
                session.setGmeetname("");
                session.setArrivaltime("");
                session.setLastseen("");
                session.setTotalduration("0");
                session.setStatus("AB");
                session.setComments("ABSENT");
            }
            sessionrecords.add(session);
        }

        return sessionrecords;
    }
}
