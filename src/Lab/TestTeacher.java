package Lab;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher[] tch = new Teacher[5];

        Teacher tch0 = new Teacher("TCH00", "Aa", "F", 50, "Professor");
        Teacher tch1 = new Teacher("TCH01", "Bb", "M", 48, "Associate Professor");
        Teacher tch2 = new Teacher("TCH02", "Cc", "M", 38, "Professor");
        Teacher tch3 = new Teacher();
        Teacher tch4 = new Teacher();

        tch[0] = tch0;
        tch[1] = tch1;
        tch[2] = tch2;
        tch[3] = tch3;
        tch[4] = tch4;

        tch[3].setTid("TCH03");
        tch[3].setName("Dd");
        tch[3].setSex("M");
        tch[3].setAge(29);
        tch[3].setTitle("Assistant");

        for (int i = 0; i < tch.length; i++) {
            tch[i].display();
        }
    }
}
