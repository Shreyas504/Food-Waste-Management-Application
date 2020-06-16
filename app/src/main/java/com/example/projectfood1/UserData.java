package com.example.projectfood1;

public class UserData {
    String uadd,uarea,uphn,upin;
    String id;
    String type;
    public UserData(){

    }
    public UserData(String uadd, String uarea, String uphn, String upin, String type) {

        this.uadd = uadd;
        this.uarea = uarea;
        this.uphn = uphn;
        this.upin = upin;
        this.type = type;
    }

    public UserData(String uadd, String uarea) {
        this.uadd = uadd;
        this.uarea = uarea;

    }


    public String getUadd() {
        return uadd;
    }

    public String getUarea() {
        return uarea;
    }

    public String getUphn() {
        return uphn;
    }

    public String getUpin() {
        return upin;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
