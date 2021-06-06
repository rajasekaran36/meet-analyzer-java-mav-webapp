package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import api.FormModel;
import api.Sample;
import io.github.rajasekarans.meettool.model.Session;
import io.github.rajasekarans.meettool.service.MeetAnalyzerService;

@WebServlet("/dummy")
public class Dummy extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        MeetAnalyzerService meetAnalyzerService = null;
        //req.getReader().lines().forEach(System.out::println);

        if("POST".equalsIgnoreCase(req.getMethod())){
            Gson gson = new Gson();
            FormModel formModel = gson.fromJson(req.getReader(), FormModel.class);
            System.out.println(formModel.getUpload());
            meetAnalyzerService =  MeetAnalyzerService.getServiceByMeetString("src/main/resources/map.csv", formModel.getUpload());
        }

        List<Session> sessions = null;
        if(meetAnalyzerService!=null)
        sessions = meetAnalyzerService.getSessions();
        else
            System.out.println("Analizer not created");

        if(sessions!=null){
            ReportDetails reportDetails = new ReportDetails(sessions);
            resp.setContentType("text/plain");
            resp.addHeader("Access-Control-Allow-Origin", "*");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(new Gson().toJson(reportDetails));
        }
    }
    private class ReportDetails{
        private String info = "classinfo";
        private List<Session> sessions;
        public ReportDetails(List<Session> sessions){
            this.sessions = sessions;
        }
        public String getInfo() {
            return info;
        }
        public List<Session> getSessions() {
            return sessions;
        }
    }
}
