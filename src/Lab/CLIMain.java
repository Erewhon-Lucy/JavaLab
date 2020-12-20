package Lab;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.Scanner;

public class CLIMain {
    MyFile myfile2 = new MyFile("student.data");
    MyFile myfile3 = new MyFile("teacher.data");
    MyFile myfile4 = new MyFile("course.data");
    MyFile myfile5 = new MyFile("schedule.data");
    MyFile myfile6 = new MyFile("electivecourse.data");
    Student[] StudentList;
    Teacher[] TeacherList;
    Course[] CourseList;
    Schedule[] ScheduleList;
    Electivecourse[] ElectivecourseList;

    public CLIMain() throws Exception {
    }

    public void write5Files(int guidatatype, String guidata) throws Exception {
        try {
            String p1 = null, p2 = null, p3 = null, p4 = null;
            int i1 = -1;
            String[] guidatalist;

            //将输入的内容按逗号分隔开
            guidatalist = guidata.split(",");
            switch (guidatatype) {
                case 1:
                case 2:
                    p1 = guidatalist[0];
                    p2 = guidatalist[1];
                    p3 = guidatalist[2];
                    i1 = Integer.parseInt(guidatalist[3]);
                    p4 = guidatalist[4];break;
                case 3:
                    p1 = guidatalist[0];
                    p2 = guidatalist[1];
                    i1 = Integer.parseInt(guidatalist[2]);break;
                case 4:
                    p1 = guidatalist[0];
                    p2 = guidatalist[1];
                    p3 = guidatalist[2];
                    p4 = guidatalist[3];break;
                case 5:
                    p1 = guidatalist[0];
                    p2 = guidatalist[1];
                    p3 = guidatalist[2];break;
            }

            switch (guidatatype) {
                case 1:
                    MyFile myfile2 = new MyFile("student.data");
                    Student s1 = new Student(p1, p2, p3, i1, p4);
                    myfile2.writeFile(s1);break;
                case 2:
                    MyFile myfile3 = new MyFile("teacher.data");
                    Teacher t1 = new Teacher(p1,p2, p3, i1, p4);
                    myfile3.writeFile(t1);break;
                case 3:
                    MyFile myfile4 = new MyFile("course.data");
                    Course c1 = new Course(p1, p2, i1);
                    myfile4.writeFile(c1);break;
                case 4:
                    MyFile myfile5 = new MyFile("schedule.data");
                    Schedule sc1 = new Schedule(p1, p2, p3, p4);
                    myfile5.writeFile(sc1);break;
                case 5:
                    MyFile myfile6 = new MyFile("electivecourse.data");
                    Electivecourse e1 = new Electivecourse(p1, p2, p3);
                    myfile6.writeFile(e1);break;
                default:
                    System.out.println("choice invalid!");
                    return;

            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successfully");
            alert.setHeaderText(null);
            alert.setContentText("Wrote 5 files success!");
            alert.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Writing Files Failed!");
            alert.show();
        }
    }

    public void read5Files() throws Exception {
        int arraylength = 100;

        try {
            StudentList = new Student[arraylength];
            myfile2.readFile(StudentList);

            TeacherList = new Teacher[arraylength];
            myfile3.readFile(TeacherList);

            CourseList = new Course[arraylength];
            myfile4.readFile(CourseList);

            ScheduleList = new Schedule[arraylength];
            myfile5.readFile(ScheduleList);

            ElectivecourseList = new Electivecourse[arraylength];
            myfile6.readFile(ElectivecourseList);

            if(StudentList != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Read 5 files success!");
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Had Read Empty Files!");
                alert.show();

            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Reading Files Failed!");
            alert.show();
        }
    }

    public void SearchInfoBySid(String sid, ObservableList<TableContent> data) {
        Electivecourse[] ElectRecord = new Electivecourse[100];
        Schedule[] ScheRecord = new Schedule[100];
        Course[] CourRecord = new Course[100];
        Teacher[] TeachRecord = new Teacher[100];
        Student student = null;

        for (Student stu : StudentList) {
            if(stu != null) {
                if(stu.getSid().equals(sid)) {
                    student = stu;
                }
            }else {
                break;
            }
        }
        if(student == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("The student doesn't exist!");
            alert.show();
            return;
        }

        int i = 0;
        //从Elect中选出该学生所有选课记录
        for (Electivecourse ele:
                ElectivecourseList) {
            if(ele == null) {
                break;
            }else if(ele.getSid().equals(sid)) {
                ElectRecord[i++] = ele;
            }
        }
        i = 0;
        //用ElectList的classid值选出所有符合条件的schedule
        for (Electivecourse ele:
                ElectRecord) {
            if(ele != null) {
                for (Schedule sch:
                        ScheduleList) {
                    if(sch == null) {
                        break;
                    }else if(ele.getClassid().equals(sch.getClassid())) {
                        ScheRecord[i++] = sch;
                    }
                }
            }else{
                break;
            }
        }
        i = 0;
        //用schedule的cid值选出所有符合条件的course
        for (Schedule sch:
                ScheRecord) {
            if(sch != null) {
                for (Course cou:
                        CourseList) {
                    if(cou == null) {
                        break;
                    }else if(sch.getCid().equals(cou.getCid())) {
                        CourRecord[i++] = cou;
                    }
                }
            }else{
                break;
            }
        }
        i = 0;
        for (Schedule sch://用schedule的tid值选出所有符合条件的teacher
                ScheRecord) {
            if(sch != null) {
                for (Teacher teach:
                        TeacherList) {
                    if(teach == null) {
                        break;
                    }else if(sch.getTid().equals(teach.getTid())) {
                        TeachRecord[i++] = teach;
                    }
                }
            }else{
                break;
            }
        }

        //信息输出部分
        for (i = 0; i < 100; i++) {
            if (ElectRecord[i] != null && ScheRecord[i] != null
                    && CourRecord[i] != null && TeachRecord[i] != null) {
                data.add(new TableContent(CourRecord[i].getCname(),TeachRecord[i].getName(),ScheRecord[i].getClassroom()));
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CLIMain climain = new CLIMain();
        while (true) {
            int choice = 0;
            System.out.printf("\n\nWelcome to Course-Schedule Manage System");
            System.out.printf("Please input the index you want:\n1.Write data\n2.Read from exist files\n" +
                    "3.Search Student Course Infomation By Student's sid\nYour Choice:");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    climain.write5Files(0, null);break;
                case 2:
                    climain.read5Files();continue;
                case 3:
                    if(climain.StudentList != null && climain.TeacherList != null && climain.CourseList != null
                            && climain.ScheduleList != null && climain.ElectivecourseList != null) {
                        climain.SearchInfoBySid("sid1",null);
                    }else {
                        System.out.println("Please fullfill or read the file first!");
                    }
            }
        }
    }
}

