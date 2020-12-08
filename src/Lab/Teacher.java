package Lab;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private String tid;
    private String title;

    Teacher(String tid, String name, String sex, int age, String title) {
        super(name, sex, age);
        this.tid = tid;
        this.title = title;
    }

    Teacher() {
        super("", "", 0);
        this.tid = "";
        this.title = "";
    }

    String getTid() {
        return tid;
    }

    String getTitle() {
        return title;
    }

    void setTid(String tid) {
        this.tid = tid;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void display() {
        super.display();
        System.out.println("Tid: " + getTid());
        System.out.println("Title: " + getTitle());
    }
}
