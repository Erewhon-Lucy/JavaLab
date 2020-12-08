package Lab;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String classid;
    private String cid;
    private String tid;
    private String classroom;

    Schedule(String classid, String cid, String tid, String classroom) {
        this.classid = classid;
        this.cid = cid;
        this.tid = tid;
        this.classroom = classroom;
    }

    Schedule() {
        this.classid = "";
        this.cid = "";
        this.tid = "";
        this.classroom = "";
    }

    String getClassid() {
        return classid;
    }

    String getCid() {
        return cid;
    }

    String getTid() {
        return tid;
    }

    String getClassroom() {
        return classroom;
    }

    void setClassid(String classid) {
        this.classid = classid;
    }

    void setCid(String cid) {
        this.cid = cid;
    }

    void setTid(String tid) {
        this.tid = tid;
    }

    void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    void display() {
        System.out.println("Classid: " + getClassid());
        System.out.println("Cid: " + getCid());
        System.out.println("Tid: " + getTid());
        System.out.println("Classroom: " + getClassroom());
    }
}
