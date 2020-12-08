package Lab;

import java.io.Serializable;

public class Electivecourse implements Serializable {
    private String elid;
    private String sid;
    private String classid;

    Electivecourse(String elid, String sid, String classid) {
        this.elid = elid;
        this.sid = sid;
        this.classid = classid;
    }

    Electivecourse() {
        this.elid = "";
        this.sid = "";
        this.classid = "";
    }

    String getElid() {
        return elid;
    }

    String getSid() {
        return sid;
    }

    String getClassid() {
        return classid;
    }

    void setElid(String elid) {
        this.elid = elid;
    }

    void setSid(String sid) {
        this.sid = sid;
    }

    void setClassid(String classid) {
        this.classid = classid;
    }

    void display() {
        System.out.println("Elid: " + getElid());
        System.out.println("Sid: " + getSid());
        System.out.println("Classid: " + getClassid());
    }
}
