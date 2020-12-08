package Lab;

import java.io.*;
import java.util.Scanner;

class MyObjectOutputStream extends ObjectOutputStream {

    protected void writeStreamHeader() throws IOException {
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}

class MyFile implements Serializable {
    File opfile = new File(".");
    protected Person[] people = new Person[10];
    Student[] students = new Student[10];
    Teacher[] teachers = new Teacher[10];
    Course[] courses = new Course[10];
    Schedule[] schedules = new Schedule[10];
    Electivecourse[] electivecourses = new Electivecourse[10];

    MyFile(File file) throws IOException {
        this.opfile = file;
        if (!file.exists()) {
            String s;
            Scanner scanner = new Scanner(System.in);
            System.out.println("DO YOU WANT TO STORY IT? Y / N");
            s = scanner.nextLine();
            if (s.equals("N"))
                opfile.createNewFile();
            if (opfile.exists())
                System.out.println("Create successfully");
        }
    }

    void readFile(Person[] people) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Person person;
        try {
            while (true) {
                person = (Person) objectInputStream.readObject();
                person.display();
                people[i++] = person;
            }
        } catch (EOFException e) {
            System.out.println("People read finish");
        }
    }

    void readFile(Student[] students) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Student student;
        try {
            while (true) {
                student = (Student) objectInputStream.readObject();
                student.display();
                students[i++] = student;
            }
        } catch (EOFException e) {
            System.out.println("Students read finish");
        }
    }

    void readFile(Teacher[] teachers) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Teacher teacher;
        try {
            while (true) {
                teacher = (Teacher) objectInputStream.readObject();
                teacher.display();
                teachers[i++] = teacher;
            }
        } catch (EOFException e) {
            System.out.println("Teachers read finish");
        }
    }

    void readFile(Course[] courses) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Course course;
        try {
            while (true) {
                course = (Course) objectInputStream.readObject();
                course.display();
                courses[i++] = course;
            }
        } catch (EOFException e) {
            System.out.println("Courses read finish");
        }
    }

    void readFile(Schedule[] schedules) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Schedule schedule;
        try {
            while (true) {
                schedule = (Schedule) objectInputStream.readObject();
                schedule.display();
                schedules[i++] = schedule;
            }
        } catch (EOFException e) {
            System.out.println("Schedules read finish");
        }
    }

    void readFile(Electivecourse[] electivecourses) throws IOException, ClassNotFoundException {
        int i = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(opfile));
        Electivecourse electivecourse;
        try {
            while (true) {
                electivecourse = (Electivecourse) objectInputStream.readObject();
                electivecourse.display();
                electivecourses[i++] = electivecourse;
            }
        } catch (EOFException e) {
            System.out.println("Electivecourses read finish");
        }
    }

    void WriteFile(Person person) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(person);
            myObjectOutputStream.close();
        }
    }

    void WriteFile(Student student) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(student);
            myObjectOutputStream.close();
        }
    }

    public void WriteFile(Teacher teacher) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(teacher);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(teacher);
            myObjectOutputStream.close();
        }
    }

    public void WriteFile(Course course) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(course);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(course);
            myObjectOutputStream.close();
        }
    }

    public void WriteFile(Schedule schedule) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(schedule);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(schedule);
            myObjectOutputStream.close();
        }
    }

    public void WriteFile(Electivecourse electivecourse) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(opfile, true);
        if (opfile.length() < 1) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(electivecourse);
            objectOutputStream.close();
        } else {
            MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
            myObjectOutputStream.writeObject(electivecourse);
            myObjectOutputStream.close();
        }
    }
}