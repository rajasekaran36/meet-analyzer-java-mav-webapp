package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
  maxFileSize = 1024 * 1024 * 5, 
  maxRequestSize = 1024 * 1024 * 5 * 5)
public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("") + File.separator+"uploads";
        File uploadDir = new File(uploadPath);
        
        String fileName = "";
        fileName += req.getParameter("date")+"_";
        fileName += req.getParameter("hour")+"_";
        fileName += req.getParameter("minute")+"_";
        fileName += req.getParameter("classname")+"_meet_record.csv";

        System.out.println(fileName);

        if (!uploadDir.exists())
            uploadDir.mkdir();       

        for (Part part : req.getParts()) {          
                
                if(part.getName().equals("upload")){
                    part.write(uploadPath + File.separator + fileName);
                }
        }
        
        req.setAttribute("filetoprocess", fileName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/analize");
        dispatcher.forward(req, resp);
    }
}
