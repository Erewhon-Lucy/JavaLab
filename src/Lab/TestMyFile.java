package Lab;

/**
 * 文件的测试类
 */
public class TestMyFile {
    public static void main(String[] args) throws Exception {
        int arraylength1 = 3;
        MyFile myfile1 = new MyFile("person.data");
        Person p1 = new Person("person1", "male", 1);
        Person p2 = new Person("person2", "female", 2);
        Person p3 = new Person("person3", "universal", 3);
        myfile1.writeFile(p1);
        myfile1.writeFile(p2);
        myfile1.writeFile(p3);
        Person[] PersonList = new Person[arraylength1];
        myfile1.readFile(PersonList);
        for (Person person : PersonList) {
            if(person != null) {
                person.display();
            }
            else {
                break;
            }
        }

        int arraylength2 = 3;
        MyFile myfile2 = new MyFile("student.data");
        Student s1 = new Student("sid1", "stu1","male", 1,"major1");
        Student s2 = new Student("sid2","stu2", "female", 2,"mmajor2");
        Student s3 = new Student("sid3","stu3", "universal", 3,"major3");
        myfile2.writeFile(s1);
        myfile2.writeFile(s2);
        myfile2.writeFile(s3);
        Student[] StudentList = new Student[arraylength2];
        myfile2.readFile(StudentList);
        for (Student student : StudentList) {
            if(student != null) {
                student.display();
            }
            else {
                break;
            }
        }

        int arraylength3 = 3;
        MyFile myfile3 = new MyFile("teacher.data");
        Teacher t1 = new Teacher("tid1","teacher1", "male", 1,"title1");
        Teacher t2 = new Teacher("tid2","teacher2", "female", 2,"titlle2");
        Teacher t3 = new Teacher("tid3","teacher3", "universal", 3,"tttle3");
        myfile3.writeFile(t1);
        myfile3.writeFile(t2);
        myfile3.writeFile(t3);
        Teacher[] TeacherList = new Teacher[arraylength3];
        myfile3.readFile(TeacherList);
        for (Teacher teacher : TeacherList) {
            if(teacher != null) {
                teacher.display();
            }
            else {
                break;
            }
        }

        int arraylength4 = 3;
        MyFile myfile4 = new MyFile("course.data");
        Course c1 = new Course("cid1", "cname1", 1);
        Course c2 = new Course("cid2", "cnama2", 2);
        Course c3 = new Course("cid3", "cname3", 3);
        myfile4.writeFile(c1);
        myfile4.writeFile(c2);
        myfile4.writeFile(c3);
        Course[] CourseList = new Course[arraylength4];
        myfile4.readFile(CourseList);
        for (Course course : CourseList) {
            if(course != null) {
                course.display();
            }
            else {
                break;
            }
        }

        int arraylength5 = 3;
        MyFile myfile5 = new MyFile("schedule.data");
        Schedule sc1 = new Schedule("classid1", "cid1", "11","classroom1");
        Schedule sc2 = new Schedule("classid2", "cid2", "22","classroom2");
        Schedule sc3 = new Schedule("classid3", "cid3", "33","classroom3");
        myfile5.writeFile(sc1);
        myfile5.writeFile(sc2);
        myfile5.writeFile(sc3);
        Schedule[] ScheduleList = new Schedule[arraylength5];
        myfile5.readFile(ScheduleList);
        for (Schedule schedule : ScheduleList) {
            if(schedule != null) {
                schedule.display();
            }
            else {
                break;
            }
        }

        int arraylength6 = 3;
        MyFile myfile6 = new MyFile("electivecourse.data");
        Electivecourse e1 = new Electivecourse("elid1", "sid1", "classid1");
        Electivecourse e2 = new Electivecourse("elid2", "sid2", "classid2");
        Electivecourse e3 = new Electivecourse("elid3", "sid3", "classid3");
        myfile6.writeFile(e1);
        myfile6.writeFile(e2);
        myfile6.writeFile(e3);
        Electivecourse[] ElectivecourseList = new Electivecourse[arraylength6];
        myfile6.readFile(ElectivecourseList);
        for (Electivecourse electivecourse : ElectivecourseList) {
            if(electivecourse != null) {
                electivecourse.display();
            }
            else {
                break;
            }
        }
    }
}