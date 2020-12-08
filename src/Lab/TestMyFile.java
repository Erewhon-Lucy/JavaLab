package Lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMyFile {
    protected static int length = 1;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyFile people_file = new MyFile(new File("People.txt"));
        WritePerson(people_file);
        people_file.readFile(people_file.people);

        MyFile studnets_file = new MyFile(new File("Students.txt"));
        WriteStudent(studnets_file);
        studnets_file.readFile(studnets_file.students);

        MyFile teachers_file = new MyFile(new File("Teachers.txt"));
        WriteTeachers(teachers_file);
        teachers_file.readFile(teachers_file.teachers);

        MyFile courses_file = new MyFile(new File("Courses.txt"));
        WriteCourses(courses_file);
        courses_file.readFile(courses_file.courses);

        MyFile schedule_file = new MyFile(new File("Schedule.txt"));
        WriteSchedlue(schedule_file);
        schedule_file.readFile(schedule_file.schedules);

        MyFile elec_file = new MyFile(new File("elec.txt"));
        WriteElec(elec_file);
        elec_file.readFile(elec_file.electivecourses);

        System.out.println("Please enter sid");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sid = bufferedReader.readLine();
        for (int i = 0; i < 5; i++) {
            if (sid.compareTo(elec_file.electivecourses[i].getSid()) == 0) {
                for (int j = 0; j < 5; j++) {
                    if (elec_file.electivecourses[i].getClassid().compareTo(schedule_file.schedules[j].getClassid()) == 0) {
                        System.out.println("classroom is " + schedule_file.schedules[j].getClassroom());
                        for (int k = 0; k < 5; k++) {
                            if (schedule_file.schedules[j].getCid().compareTo(courses_file.courses[k].getCid()) == 0 && schedule_file.schedules[j].getTid().compareTo(teachers_file.teachers[k].getTid()) == 0) {
                                System.out.println("course name is " + courses_file.courses[k].getCname());
                                System.out.println("teacher's name is " + teachers_file.teachers[k].getName());
                            }
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < 5; i++) {
//            if (sid. compareTo(elec_file.electivecourses[i].getSid()) == 0) {
//                for (int j = 0; j < 5; j++) {
//                    if (elec_file.electivecourses[i].getClassid().compareTo(schedule_file.schedules[j].getClassid()) == 0) {
//                        for (int k = 0; k < 5; k++) {
//                            if (schedule_file.schedules[j].getTid().compareTo(teachers_file.teachers[k].getTid()) == 0) {
//                                System.out.println("teacher's name is " + teachers_file.teachers[k].getName());
//                            }
//                        }
//                    }
//                }
//            }
//        }
        System.out.println("If no information found, please check sid you input.");
    }

    private static void WritePerson(MyFile myfile) throws IOException {

        String s = "";
        String name;
        String sex;
        int age;
        for (int j = 0; j < myfile.people.length; j++)
            myfile.people[j] = new Person(null, null, 0);
        System.out.println("please enter the " + length + " person's information, press F to quit");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.people[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.people[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.people[i].setAge(age);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.people[i]);
            i++;
        }
    }

    private static void WriteStudent(MyFile myfile) throws IOException {
        String s = "";
        String name;
        String sex;
        String sid;
        String major;
        int age;
        for (int j = 0; j < myfile.students.length; j++)
            myfile.students[j] = new Student();
        length = 1;
        System.out.println("Please enter the " + length + " student's information.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.students[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.students[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.students[i].setAge(age);

            System.out.println("please enter sid: ");
            sid = bufferedReader.readLine();
            myfile.students[i].setSid(sid);

            System.out.println("please enter major: ");
            major = bufferedReader.readLine();
            myfile.students[i].setMajor(major);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.students[i]);
            i++;
        }
    }

    private static void WriteTeachers(MyFile myfile) throws IOException {
        String s = "";
        String name;
        String sex;
        String tid;
        String title;
        int age;
        for (int j = 0; j < myfile.teachers.length; j++)
            myfile.teachers[j] = new Teacher();
        length = 1;
        System.out.println("please enter the " + length + " teacher's information.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter name: ");
            name = bufferedReader.readLine();
            myfile.teachers[i].setName(name);

            System.out.println("please enter sex: ");
            sex = bufferedReader.readLine();
            myfile.teachers[i].setSex(sex);

            System.out.println("please enter age: ");
            age = Integer.parseInt(bufferedReader.readLine());
            myfile.teachers[i].setAge(age);

            System.out.println("please enter tid: ");
            tid = bufferedReader.readLine();
            myfile.teachers[i].setTid(tid);

            System.out.println("please enter title: ");
            title = bufferedReader.readLine();
            myfile.teachers[i].setTitle(title);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.teachers[i]);
            i++;
        }
    }

    private static void WriteCourses(MyFile myfile) throws IOException {
        String s = "";
        String cname;
        String cid;
        int chour;
        for (int j = 0; j < myfile.teachers.length; j++)
            myfile.courses[j] = new Course(null, null, 0);
        length = 1;
        System.out.println("please enter the " + length + " course's information.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter course name: ");
            cname = bufferedReader.readLine();
            myfile.courses[i].setCname(cname);

            System.out.println("please enter course id: ");
            cid = bufferedReader.readLine();
            myfile.courses[i].setCid(cid);

            System.out.println("please enter course hour: ");
            chour = Integer.parseInt(bufferedReader.readLine());
            myfile.courses[i].setChour(chour);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.courses[i]);
            i++;
        }
    }

    private static void WriteSchedlue(MyFile myfile) throws IOException {
        String s = "";
        String classid;
        String cid;
        String tid;
        String classroom;
        for (int j = 0; j < myfile.schedules.length; j++)
            myfile.schedules[j] = new Schedule(null, null, null, null);
        length = 1;
        System.out.println("please enter the " + length + " Schedule's information.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter class id: ");
            classid = bufferedReader.readLine();
            myfile.schedules[i].setClassid(classid);

            System.out.println("please enter course id: ");
            cid = bufferedReader.readLine();
            myfile.schedules[i].setCid(cid);

            System.out.println("please enter teacher's id: ");
            tid = bufferedReader.readLine();
            myfile.schedules[i].setTid(tid);

            System.out.println("please enter classroom: ");
            classroom = bufferedReader.readLine();
            myfile.schedules[i].setClassroom(classroom);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.schedules[i]);
            i++;
        }
    }

    private static void WriteElec(MyFile myfile) throws IOException {
        String s = "";
        String elid;
        String sid;
        String classid;
        for (int j = 0; j < myfile.electivecourses.length; j++)
            myfile.electivecourses[j] = new Electivecourse(null, null, null);
        length = 1;
        System.out.println("please enter the " + length + " elective course's information.");
        length++;
        int i = 0;
        while (s.compareTo("Y") != 0 && s.compareTo("y") != 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please enter elective course id: ");
            elid = bufferedReader.readLine();
            myfile.electivecourses[i].setElid(elid);

            System.out.println("please enter sid: ");
            sid = bufferedReader.readLine();
            myfile.electivecourses[i].setSid(sid);

            System.out.println("please enter class id: ");
            classid = bufferedReader.readLine();
            myfile.electivecourses[i].setClassid(classid);

            System.out.println("Do you want to exit?  Y/N");
            s = bufferedReader.readLine();

            myfile.WriteFile(myfile.electivecourses[i]);
            i++;
        }
    }

}