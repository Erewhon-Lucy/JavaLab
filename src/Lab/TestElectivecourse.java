/**
 * 简单测试 ElectiveCourse类
 */

package Lab;

public class TestElectivecourse {
    public static void main(String[] args) {
        Electivecourse[] elc = new Electivecourse[5];

        Electivecourse elc0 = new Electivecourse("ELC00", "STD00", "BAN00");
        Electivecourse elc1 = new Electivecourse("ELC01", "STD01", "BAN00");
        Electivecourse elc2 = new Electivecourse("ELC02", "STD02", "BAN00");
        Electivecourse elc3 = new Electivecourse();
        Electivecourse elc4 = new Electivecourse();

        elc[0] = elc0;
        elc[1] = elc1;
        elc[2] = elc2;
        elc[3] = elc3;
        elc[4] = elc4;

        elc[3].setElid("ELC03");
        elc[3].setSid("STD03");
        elc[3].setClassid("BAN01");


        for (int i = 0; i < elc.length; i++) {
            elc[i].display();
        }
    }
}
