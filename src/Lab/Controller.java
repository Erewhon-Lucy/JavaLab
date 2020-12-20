package Lab;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.util.*;
import java.io.*;
import java.net.*;

public class Controller implements Initializable {
    public TextField stu_name;
    public TextField stu_sex;
    public TextField stu_age;
    public TextField stu_sid;
    public TextField stu_major;
    public Button stu_continue;
    public TextField tea_name;
    public TextField tea_sex;
    public TextField tea_age;
    public TextField tea_tid;
    public TextField tea_title;
    public Button tea_continue;
    public TextField cou_cname;
    public TextField cou_cid;
    public TextField cou_chour;
    public Button cou_continue;
    public TextField sch_classid;
    public TextField sch_cid;
    public TextField sch_tid;
    public TextField sch_classroom;
    public Button sch_continue;
    public TextField ele_elid;
    public TextField ele_sid;
    public TextField ele_classid;
    public Button ele_continue;
    public TableColumn cname_column;
    public TableColumn tname_column;
    public TableColumn classroom_column;
    public TextField find_sid_1;
    public Button check_button_1;

    String judge = new String();
    int i = 0;

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public Controller() throws IOException {
    }

    public String setStu_name() {
        return stu_name.getText();
    }

    public String setStu_sex() {
        return stu_sex.getText();
    }

    public int setStu_age() {
        return Integer.parseInt(stu_age.getText());
    }

    public String setStu_sid() {
        return stu_sid.getText();
    }

    public String setStu_major() {
        return stu_major.getText();
    }

    public void setStu_continue() {
        judge = "N";
        MyFile students_file = null;
        try {
            students_file = new MyFile(new File("Students.txt"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int j = 0; j < students_file.students.length; j++)
            students_file.students[j] = new Student();
        students_file.students[i].setName(setStu_name());
        students_file.students[i].setAge(setStu_age());
        students_file.students[i].setSex(setStu_sex());
        students_file.students[i].setSid(setStu_sid());
        students_file.students[i].setMajor(setStu_major());
        students_file.students[i].display();

        try {
            students_file.WriteFile(students_file.students[i]);
            i++;
            students_file.readFile(students_file.students);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        stu_major.setText("");
        stu_name.setText("");
        stu_age.setText("");
        stu_sex.setText("");
        stu_sid.setText("");
    }

    public String setTea_name() {
        return tea_name.getText();
    }

    public int setTea_age() {
        return Integer.parseInt(tea_age.getText());
    }

    public String setTea_sex() {
        return tea_sex.getText();
    }

    public String setTea_tid() {
        return tea_tid.getText();
    }

    public String  setTea_title() {
        return tea_title.getText();
    }

    MyFile teachers_file = new MyFile(new File("Teachers.txt"));

    public void setTea_continue(ActionEvent actionEvent) {
        judge = "N";
        for(int j = 0; j < teachers_file.teachers.length; j++)
            teachers_file.teachers[j] = new Teacher();

        teachers_file.teachers[i].setName(setTea_name());
        System.out.println(setTea_name());
        teachers_file.teachers[i].setAge(setTea_age());
        teachers_file.teachers[i].setSex(setTea_sex());
        teachers_file.teachers[i].setTid(setTea_tid());
        teachers_file.teachers[i].setTitle(setTea_title());
        teachers_file.teachers[i].display();

        try {
            teachers_file.WriteFile(teachers_file.teachers[i]);
            i++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        tea_name.setText("");
        tea_title.setText("");
        tea_tid.setText("");
        tea_sex.setText("");
        tea_age.setText("");
    }

    public String setCou_cname() {
        return cou_cname.getText();
    }

    public String setCou_cid( ) {
        return cou_cid.getText();
    }

    public int setCou_chour() {
        return Integer.parseInt(cou_chour.getText());
    }

    MyFile cou_file = new MyFile(new File("Courses.txt"));

    public void setCou_continue(ActionEvent actionEvent) {
        judge = "N";
        for(int j = 0; j < cou_file.courses.length; j++)
            cou_file.courses[j] = new Course();

        cou_file.courses[i].setCname(setCou_cname());
        cou_file.courses[i].setChour(setCou_chour());
        cou_file.courses[i].setCid(setCou_cid());
        cou_file.courses[i].display();

        try {
            cou_file.WriteFile(cou_file.courses[i]);
            i++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //      });
        cou_cname.setText("");
        cou_chour.setText("");
        cou_cid.setText("");
    }

    public String setSch_cid( ) {
        return sch_cid.getText();
    }

    public String setSch_classid( ) {
        return sch_classid.getText();
    }

    public String setSch_classroom( ) {
        return sch_classroom.getText();
    }

    public String setSch_tid( ) {
        return sch_tid.getText();
    }

    MyFile schedules_file = new MyFile(new File("Schedule.txt"));

    public void setSch_continue(ActionEvent actionEvent) {
        judge = "N";
        for(int j = 0; j < schedules_file.schedules.length; j++)
            schedules_file.schedules[j] = new Schedule();

        schedules_file.schedules[i].setCid(setSch_cid());
        System.out.println(setSch_cid());
        schedules_file.schedules[i].setClassid(setSch_classid());
        schedules_file.schedules[i].setClassroom(setSch_classroom());
        schedules_file.schedules[i].setTid(setSch_tid());
        schedules_file.schedules[i].display();

        try {
            schedules_file.WriteFile(schedules_file.schedules[i]);
            i++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        sch_tid.setText("");
        sch_classroom.setText("");
        sch_classid.setText("");
        sch_cid.setText("");
    }

    public String setEle_elid() {
        return ele_elid.getText();
    }

    public String setEle_classid() {
        return ele_classid.getText();
    }

    public String setEle_sid() {
        return ele_sid.getText();
    }

    MyFile elec_file =new MyFile(new File("elec.txt"));

    public void setEle_continue(ActionEvent actionEvent) {
        judge = "N";

        for(int j = 0; j < elec_file.electivecourses.length; j++)
            elec_file.electivecourses[j] = new Electivecourse();

        elec_file.electivecourses[i].setClassid(setEle_classid());
        System.out.println(setEle_classid());
        elec_file.electivecourses[i].setElid(setEle_elid());
        elec_file.electivecourses[i].setSid(setEle_sid());
        elec_file.electivecourses[i].display();

        try {
            elec_file.WriteFile(elec_file.electivecourses[i]);
            i++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ele_sid.setText("");
        ele_classid.setText("");
        ele_elid.setText("");
    }

    public void check_1(ActionEvent actionEvent) {

    }
}
