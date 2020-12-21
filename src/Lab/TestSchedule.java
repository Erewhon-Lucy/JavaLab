/**
 * 简单测试Schedule类
 */

package Lab;

public class TestSchedule {
    public static void main(String[] args) {
        Schedule[] scd = new Schedule[5];

        Schedule scd0 = new Schedule("Ban00", "CRS00", "LaoBai", "A100");
        Schedule scd1 = new Schedule("Ban01", "CRS01", "LaoMi", "A101");
        Schedule scd2 = new Schedule("Ban02", "CRS02", "LaoFei", "A102");
        Schedule scd3 = new Schedule();
        Schedule scd4 = new Schedule();

        scd[0] = scd0;
        scd[1] = scd1;
        scd[2] = scd2;
        scd[3] = scd3;
        scd[4] = scd4;

        scd[3].setClassid("Ban03");
        scd[3].setCid("CRS03");
        scd[3].setTid("LaoChen");
        scd[3].setClassroom("A103");

        for (int i = 0; i < scd.length; i++) {
            scd[i].display();
        }
    }
}
