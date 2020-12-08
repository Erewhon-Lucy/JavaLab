package Lab;

public class TestStudent {
    public static void main(String[] args) {
        Student[] stu = new Student[5];

        Student st0 = new Student("STD00", "Jack", "F", 19, "International class");
        Student st1 = new Student("STD01", "Mary", "M", 20, "System and technology");
        Student st2 = new Student("STD02", "Jasen", "M", 21, "Network Security");
        Student st3 = new Student();
        Student st4 = new Student();

        stu[0] = st0;
        stu[1] = st1;
        stu[2] = st2;
        stu[3] = st3;
        stu[4] = st4;

        stu[3].setSid("STD03");
        stu[3].setName("Pat");
        stu[3].setSex("F");
        stu[3].setAge(18);
        stu[3].setMajor("Embedded system");

        for (int i = 0; i < stu.length; i++) {
            stu[i].display();
        }
    }
}


