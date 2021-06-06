package io.github.rajasekarans.meettool.service;

import java.util.List;

import com.google.gson.Gson;

import io.github.rajasekarans.meettool.model.Session;

public class MeetAnalyzerService {

    private StudentMapService studentMapService;
    private MeetingService meetingService;
    private ReportRecordService reportRecordService;
    private ReportService reportService;

    public MeetAnalyzerService(){}
    public MeetAnalyzerService(String studentMappingFilePath, String meetFilePath){
        this.studentMapService = new StudentMapService().getService(studentMappingFilePath);
        this.meetingService = new MeetingService().getService(meetFilePath);
        this.reportRecordService = new ReportRecordService(studentMapService, meetingService);
        this.reportService = new ReportService(reportRecordService);
        
    }

    public static MeetAnalyzerService getServiceByMeetString(String studentMappingFilePath,String meetString){
        MeetAnalyzerService newService = new MeetAnalyzerService();
        newService.studentMapService = new StudentMapService().getService(studentMappingFilePath);
        newService.meetingService = new MeetingService().getServiceByMeetString(meetString);
        newService.reportRecordService = new ReportRecordService(newService.studentMapService,newService.meetingService);
        newService.reportService = new ReportService(newService.reportRecordService);
        return newService;
    }

    public boolean writeToCSVFile(String reportFilePath){
        return reportService.writeToCSVFile(reportFilePath);
    }

    public String reportString(){
        return reportService.reportString();
    }

    public List<Session> getSessions(){
        return reportService.getSessions();
    }
}
