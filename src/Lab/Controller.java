/**
 * 控制器类
 * 能够运行的原因是继承自CLIMain，但不要运行
 */

package Lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Controller extends CLIMain {
    public TextField stu_name;
    public TextField stu_sex;
    public TextField stu_age;
    public TextField stu_sid;
    public TextField stu_major;
    public Button stu_continue;
    public TextField tea_name;
    public TextField tea_sex;
    public TextField tea_age;
    public TextField tea_tid;
    public TextField tea_title;
    public Button tea_continue;
    public TextField cou_cname;
    public TextField cou_cid;
    public TextField cou_chour;
    public Button cou_continue;
    public TextField sch_classid;
    public TextField sch_cid;
    public TextField sch_tid;
    public TextField sch_classroom;
    public Button sch_continue;
    public TextField ele_elid;
    public TextField ele_sid;
    public TextField ele_classid;
    public Button ele_continue;
    @FXML
    public TableColumn<TableContent, String> cname_column;
    @FXML
    public TableColumn<TableContent, String> tname_column;
    @FXML
    public TableColumn<TableContent, String> classroom_column;
    @FXML
    public TextField find_sid_1;
    @FXML
    public Button check_button_1;
    @FXML
    private TableView<TableContent> table;

    int i = 0;
    final ObservableList<TableContent> data = FXCollections.observableArrayList();

    public void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'View.fxml'.";
        assert cname_column != null : "fx:id=\"cname_column\" was not injected: check your FXML file 'View.fxml'.";
        assert tname_column != null : "fx:id=\"tname_column\" was not injected: check your FXML file 'View.fxml'.";
        assert classroom_column != null : "fx:id=\"classroom_column\" was not injected: check your FXML file 'View.fxml'.";
        assert check_button_1 != null : "fx:id=\"submit\" was not injected: check your FXML file 'GUIView.fxml'.";

        cname_column.setCellValueFactory(cellData -> cellData.getValue().CourseNameProperty());
        tname_column.setCellValueFactory(cellData -> cellData.getValue().TeacherNameProperty());
        classroom_column.setCellValueFactory(cellData -> cellData.getValue().ClassroomProperty());
        table.setItems(data);
        table.getColumns().addAll(cname_column,tname_column,classroom_column);
    }

    public Controller() throws Exception {
    }

    public String setStu_name() {
        return stu_name.getText();
    }

    public String setStu_sex() {
        return stu_sex.getText();
    }

    public int setStu_age() {
        return Integer.parseInt(stu_age.getText());
    }

    public String setStu_sid() {
        return stu_sid.getText();
    }

    public String setStu_major() {
        return stu_major.getText();
    }

    public void setStu_continue() throws Exception {
        String guidata = setStu_sid() + "," + setStu_name() + "," + setStu_sex() + "," + setStu_age() + "," + setStu_major();
        write5Files(1, guidata);
        read5Files();
        stu_name.clear();
        stu_sex.clear();
        stu_age.clear();
        stu_sid.clear();
        stu_major.clear();
    }

    public String setTea_name() {
        return tea_name.getText();
    }

    public int setTea_age() {
        return Integer.parseInt(tea_age.getText());
    }

    public String setTea_sex() {
        return tea_sex.getText();
    }

    public String setTea_tid() {
        return tea_tid.getText();
    }

    public String  setTea_title() {
        return tea_title.getText();
    }

    public void setTea_continue(ActionEvent actionEvent) throws Exception {
        String guidata = setTea_tid() + ',' + setTea_name() + ',' + setTea_sex() + ',' + setTea_age() + ',' + setTea_title();
        write5Files(2, guidata);
        read5Files();
        tea_name.clear();
        tea_age.clear();
        tea_sex.clear();
        tea_tid.clear();
        tea_title.clear();
    }

    public String setCou_cname() {
        return cou_cname.getText();
    }

    public String setCou_cid( ) {
        return cou_cid.getText();
    }

    public int setCou_chour() {
        return Integer.parseInt(cou_chour.getText());
    }

    public void setCou_continue(ActionEvent actionEvent) throws Exception {
        String guidata = setCou_cid() + ',' + setCou_cname() + ',' + setCou_chour();
        write5Files(3, guidata);
        read5Files();
        cou_cname.clear();
        cou_cid.clear();
        cou_chour.clear();
    }

    public String setSch_cid( ) {
        return sch_cid.getText();
    }

    public String setSch_classid( ) {
        return sch_classid.getText();
    }

    public String setSch_classroom( ) {
        return sch_classroom.getText();
    }

    public String setSch_tid( ) {
        return sch_tid.getText();
    }

    public void setSch_continue(ActionEvent actionEvent) throws Exception {
        String guidata = setSch_classid() + ',' + setSch_cid() + ',' + setSch_tid() + ',' + setSch_classroom();
        write5Files(4, guidata);
        read5Files();
        sch_cid.clear();
        sch_classid.clear();
        sch_tid.clear();
        sch_classroom.clear();
    }

    public String setEle_elid() {
        return ele_elid.getText();
    }

    public String setEle_classid() {
        return ele_classid.getText();
    }

    public String setEle_sid() {
        return ele_sid.getText();
    }

    public void setEle_continue(ActionEvent actionEvent) throws Exception {
        String guidata = setEle_elid() + ',' + setEle_sid() + ',' + setEle_classid();
        write5Files(5, guidata);
        read5Files();
        ele_elid.clear();
        ele_classid.clear();
        ele_sid.clear();
    }

    public void check_1(ActionEvent actionEvent) {
        table.getItems().clear();
        String text = find_sid_1.getText();
        SearchInfoBySid(text, data);
    }
}
