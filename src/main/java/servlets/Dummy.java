package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import api.FormModel;
import api.Sample;
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

        String report = null;
        if(meetAnalyzerService!=null)
           report = meetAnalyzerService.reportString();
        else
            System.out.println("Analizer not created");

        if(report!=null){
            resp.setContentType("text/plain");
            resp.addHeader("Access-Control-Allow-Origin", "*");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(report);
        }
    }
}
