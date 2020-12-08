package Lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestPerson {
    public static void main(String[] args) {
        String inputFile = "exp\\People.txt";
        ReadFile.ReadName(inputFile);
        ReadFile.ReadSex(inputFile);
        ReadFile.ReadAge(inputFile);
        Person[] p = new Person[5];

        for (int i = 0; i < ReadFile.NameArray.length; i++) {
            p[i] = new Person(ReadFile.NameArray[i], ReadFile.SexArray[i], ReadFile.AgeArray[i]);
            p[i].display();
        }
        System.out.println("Now test method: ");
        p[3].setName("Lucy");
        p[3].setSex("F");
        p[3].setAge(19);
        p[3].display();
    }
}

class ReadFile {
    static String[] NameArray = new String[5];
    static String[] SexArray = new String[5];
    static int[] AgeArray = new int[5];

    static void ReadName(String filename) {
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("name")) {
                    String str = tempString;
                    str = str.replaceAll("name=", "");
                    NameArray[i] = str;
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void ReadSex(String filename) {
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("sex")) {
                    String str = tempString;
                    str = str.replaceAll("sex=", "");
                    SexArray[i] = str;
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void ReadAge(String filename) {
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int i = 0;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("age")) {
                    String str = tempString;
                    str = str.replaceAll("age=", "");
                    AgeArray[i] = Integer.parseInt(str);
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
