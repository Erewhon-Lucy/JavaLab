/**
 * 测试Person类
 */

package Lab;

public class TestPerson {
    public static void main(String[] args) {
        Person[] people = new Person[5];

        Person person0 = new Person("Name01", "m", 21);
        Person person1 = new Person("Name02", "f", 22);
        Person person2 = new Person("Name03", "m", 23);
        Person person3 = new Person();
        Person person4 = new Person();

        people[0] = person0;
        people[1] = person1;
        people[2] = person2;
        people[3] = person3;
        people[4] = person4;

        people[3].setName("Name04");
        people[3].setSex("f");
        people[3].setAge(17);

        for (int i = 0; i < people.length; i++) {
            people[i].display();
        }
    }
}