package io.github.rajasekarans.meettool.service;

public class MeetAnalyzerService {

    private StudentMapService studentMapService;
    private MeetingService meetingService;
    private ReportRecordService reportRecordService;
    private ReportService reportService;

    public MeetAnalyzerService(String studentMappingFilePath, String meetFilePath){
        this.studentMapService = new StudentMapService().getService(studentMappingFilePath);
        this.meetingService = new MeetingService().getService(meetFilePath);
        this.reportRecordService = new ReportRecordService(studentMapService, meetingService);
        this.reportService = new ReportService(reportRecordService);
        
    }

    public boolean writeToCSVFile(String reportFilePath){
        return reportService.writeToCSVFile(reportFilePath);
    }

    public String reportString(){
        return reportService.reportString();
    }
}
