package Lab;

public class TestCourse {
    public static void main(String[] args) {
        Course[] crs = new Course[5];

        Course crs0 = new Course("CRS00", "Chinese", 28);
        Course crs1 = new Course("CRS01", "C-Programming", 18);
        Course crs2 = new Course("CRS02", "Java-Programming", 42);
        Course crs3 = new Course();
        Course crs4 = new Course();

        crs[0] = crs0;
        crs[1] = crs1;
        crs[2] = crs2;
        crs[3] = crs3;
        crs[4] = crs4;

        crs[3].setCid("TCH03");
        crs[3].setCname("Dd");
        crs[3].setChour(18);


        for (int i = 0; i < crs.length; i++) {
            crs[i].display();
        }
    }
}
