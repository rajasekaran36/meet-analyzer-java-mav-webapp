package api;

public class FormModel {
    private String classname;
    private String date;
    private String hour;
    private String minitue;
    private String map;
    private String meet;


    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return this.hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinitue() {
        return this.minitue;
    }

    public void setMinitue(String minitue) {
        this.minitue = minitue;
    }

    public String getMeet() {
        return this.meet;
    }

    public void setMeet(String meet) {
        this.meet = meet;
    }


    public String getMap() {
        return this.map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "{" +
            " classname='" + classname + "'" +
            ", date='" + date + "'" +
            ", hour='" + hour + "'" +
            ", minitue='" + minitue + "'" +
            ", map='" + map + "'" +
            ", meet='" + meet + "'" +
            "}";
    }




}
