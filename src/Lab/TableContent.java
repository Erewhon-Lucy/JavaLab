/**
 * 表格内容类，为了填充表格内容而创建
 * 为了填充 TableView,必须格式化字符串到 SimpleStringProperty
 * 配合 Controller中的 ObservableLists使用
 */

package Lab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableContent {

    public TableContent(String CourseName, String TeacherName, String Classroom) {
        this.setCourseName(CourseName);
        this.setTeacherName(TeacherName);
        this.setClassroom(Classroom);
    }

    private StringProperty CourseName;

    public void setCourseName(String value) {
        CourseNameProperty().set(value);
    }

    public String getCourseName() {
        return CourseNameProperty().get();
    }

    public StringProperty CourseNameProperty() {
        if (CourseName == null) CourseName = new SimpleStringProperty(this, "CourseName");
        return CourseName;
    }

    private StringProperty TeacherName;

    public void setTeacherName(String value) {
        TeacherNameProperty().set(value);
    }

    public String getTeacherName() {
        return TeacherNameProperty().get();
    }

    public StringProperty TeacherNameProperty() {
        if (TeacherName == null) TeacherName = new SimpleStringProperty(this, "TeacherName");
        return TeacherName;
    }

    private StringProperty Classroom;

    public void setClassroom(String value) {
        ClassroomProperty().set(value);
    }

    public String getClassroom() {
        return ClassroomProperty().get();
    }

    public StringProperty ClassroomProperty() {
        if (Classroom == null) Classroom = new SimpleStringProperty(this, "Classroom");
        return Classroom;
    }
}
