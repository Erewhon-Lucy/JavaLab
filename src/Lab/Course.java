package Lab;

import java.io.Serializable;

public class Course implements Serializable {
    private String cname;
    private String cid;
    private int chour;

    Course(String cid, String cname, int chour) {
        this.cid = cid;
        this.cname = cname;
        this.chour = chour;
    }

    Course() {
        this.cid = "";
        this.cname = "";
        this.chour = 0;
    }

    String getCid() {
        return cid;
    }

    String getCname() {
        return cname;
    }

    int getChour() {
        return chour;
    }

    void setCid(String cid) {
        this.cid = cid;
    }

    void setCname(String cname) {
        this.cname = cname;
    }

    void setChour(int chour) {
        this.chour = chour;
    }

    void display() {
        System.out.println("Cid: " + getCid());
        System.out.println("Cname: " + getCname());
        System.out.println("Chour: " + getChour());
    }
}
