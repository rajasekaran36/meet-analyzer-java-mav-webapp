package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.rajasekarans.meettool.service.MeetAnalyzerService;

@WebServlet("/analize")
public class Analize extends HttpServlet{
    public static final String STU_MAPPING = "src/main/resources/map.csv";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("") + File.separator+"uploads";

        String meetFilePath = (String)req.getAttribute("filetoprocess");
        meetFilePath = uploadPath +"/"+ meetFilePath;
        MeetAnalyzerService meetAnalyzerService = new MeetAnalyzerService(STU_MAPPING, meetFilePath);
        
        resp.setContentType("text/html");
        resp.getWriter().println(meetAnalyzerService.reportString());
    }

}
