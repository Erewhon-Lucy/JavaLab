package Lab;

import java.io.*;

/**
 * 文件类
 */
public class MyFile {

    private static final long serialVersionUID = 1L;

    private File opfile;

    public File getOpFile() {
        return opfile;
    }

    public MyFile(String FileName) throws IOException {
        this.opfile = new File(FileName);
        //如果文件不存在则创建
        if (!opfile.exists()) {
            opfile.createNewFile();
        }
        //文件不可读
        if (!opfile.canRead()) {
            System.out.println("file can't be read.");
        }
    }

    public void writeFile(Person person) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(person);
            System.out.println("Successfully write person.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Student student) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(student);
            System.out.println("Successfully write student.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Teacher teacher) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(teacher);
            System.out.println("Successfully write teacher.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Course course) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(course);
            System.out.println("Successfully write course.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Schedule schedule) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(schedule);
            System.out.println("Successfully write schedule.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(Electivecourse electiveCourse) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.opfile,true))) {
            os.writeObject(electiveCourse);
            System.out.println("Successfully write electiveCourse.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readFile(Person[] PersonList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                PersonList[i++] = (Person)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read person.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile(Student[] StudentList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                StudentList[i++] = (Student)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read student.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile(Teacher[] TeacherList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                TeacherList[i++] = (Teacher)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read teacher.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile(Course[] CourseList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                CourseList[i++] = (Course)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read course.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile(Schedule[] ScheduleList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                ScheduleList[i++] = (Schedule)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read schedule.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile(Electivecourse[] ElectivecourseList) throws Exception {
        try {
            FileInputStream in = new FileInputStream(this.opfile);
            ObjectInputStream ois = null;
            int i = 0;
            while(in.available() > 0) {
                ois = new ObjectInputStream(in);
                ElectivecourseList[i++] = (Electivecourse)ois.readObject();
            }
            ois.close();
            System.out.println("Successfully read electiveCourse.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}