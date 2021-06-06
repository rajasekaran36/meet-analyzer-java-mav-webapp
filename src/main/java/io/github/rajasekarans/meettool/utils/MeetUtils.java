package io.github.rajasekarans.meettool.utils;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetUtils {
    /* public static List<String> cleanUp(String filePath){
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
            List<String> c_lines = new ArrayList<>();
            
            for(String line:lines){
                String c_line = "";
                for(String word:line.split(",")){
                    String c_word = word.replace("\"", "").trim();
                    c_line = c_line + c_word+",";
                }
                c_lines.add(c_line);
            }
            return c_lines;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    */ 
    public static List<String> cleanupString(String meetString){
        List<String> lines = Arrays.asList(meetString.split("\n"));
        List<String> c_lines = new ArrayList<>();
        
        for(String line:lines){
            String c_line = "";
            for(String word:line.split(",")){
                String c_word = word.replace("\"", "").trim();
                c_line = c_line + c_word+",";
            }
            c_lines.add(c_line);
        }
        return c_lines;
    }
}
