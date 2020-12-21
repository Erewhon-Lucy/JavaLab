/**
 * 一些必要操作
 */

package Lab;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.Scanner;

public class CLIMain {
    MyFile myfile2 = new MyFile("student.txt");
    MyFile myfile3 = new MyFile("teacher.txt");
    MyFile myfile4 = new MyFile("course.txt");
    MyFile myfile5 = new MyFile("schedule.txt");
    MyFile myfile6 = new MyFile("electivecourse.txt");
    Student[] StudentList;
    Teacher[] TeacherList;
    Course[] CourseList;
    Schedule[] ScheduleList;
    Electivecourse[] ElectivecourseList;

    public CLIMain() throws Exception {
    }

    /**
     * 更新所有文件
     * 提示弹窗
     * @param guidatatype
     * @param guidata
     * @throws Exception
     */
    public void updateAllFiles(int guidatatype, String guidata) throws Exception {
        try {
            String p1 = null, p2 = null, p3 = null, p4 = null;
            int i1 = -1;
            String[] guidatalist;


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
                    MyFile myfile2 = new MyFile("student.txt");
                    Student s1 = new Student(p1, p2, p3, i1, p4);
                    myfile2.writeFile(s1);break;
                case 2:
                    MyFile myfile3 = new MyFile("teacher.txt");
                    Teacher t1 = new Teacher(p1,p2, p3, i1, p4);
                    myfile3.writeFile(t1);break;
                case 3:
                    MyFile myfile4 = new MyFile("course.txt");
                    Course c1 = new Course(p1, p2, i1);
                    myfile4.writeFile(c1);break;
                case 4:
                    MyFile myfile5 = new MyFile("schedule.txt");
                    Schedule sc1 = new Schedule(p1, p2, p3, p4);
                    myfile5.writeFile(sc1);break;
                case 5:
                    MyFile myfile6 = new MyFile("electivecourse.txt");
                    Electivecourse e1 = new Electivecourse(p1, p2, p3);
                    myfile6.writeFile(e1);break;
                default:
                    System.out.println("choice invalid!");
                    return;

            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successfully");
            alert.setHeaderText(null);
            alert.setContentText("The relevant files has been updated.");
            alert.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Error writing files.");
            alert.show();
        }
    }

    /**
     * 阅读所有文件，提示弹窗
     * @throws Exception
     */
    public void readAllFiles() throws Exception {
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
                alert.setContentText("The relevant files has been read.");
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
            alert.setContentText("Error reading files.");
            alert.show();
        }
    }

    /**
     * 根据sid寻找学生所选的所有课程及其相关信息
     * @param sid
     * @param data
     */
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

        for (Electivecourse ele:
                ElectivecourseList) {
            if(ele == null) {
                break;
            }else if(ele.getSid().equals(sid)) {
                ElectRecord[i++] = ele;
            }
        }
        i = 0;

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
        for (Schedule sch:
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
            System.out.println("");
            System.out.println("Choose function:");
            System.out.println("1.Write data");
            System.out.println("2.Read from file");
            System.out.println("3.Search information by sid");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    climain.updateAllFiles(0, null);break;
                case 2:
                    climain.readAllFiles();continue;
                case 3:
                    if(climain.StudentList != null && climain.TeacherList != null && climain.CourseList != null
                            && climain.ScheduleList != null && climain.ElectivecourseList != null) {
                        climain.SearchInfoBySid("sid1",null);
                    }else {
                        System.out.println("Check your file, please.");
                    }
            }
        }
    }
}

