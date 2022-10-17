package com.example.comp1011s1st200496893;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class CarSoldViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private TableColumn<CarSold, Integer> carIdColumn;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private TableColumn<CarSold, LocalDate> dateSoldColumn;

    @FXML
    private TableColumn<CarSold, String> makeColumn;

    @FXML
    private TableColumn<CarSold,String > modelColumn;

    @FXML
    private TableColumn<CarSold, Integer> modelYearColumn;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private TableColumn<CarSold,Integer > priceColumn;

    @FXML
    private Label totalSoldLabel;

    @FXML
    private Label unitSoldLabel;

    @FXML
    private ComboBox<Integer> yearCombo;

    @FXML
    private TableView<CarSold> tableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carIdColumn.setCellValueFactory(new PropertyValueFactory<>("carId"));
        modelYearColumn.setCellValueFactory(new PropertyValueFactory<>("modelYear"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateSoldColumn.setCellValueFactory(new PropertyValueFactory<>("dateSold"));

        ArrayList<CarSold> carSold = DBUtilities.getCarSoldFromDB();
        tableView.getItems().addAll(DBUtilities.getCarSoldFromDB());

        yearCombo.getItems().addAll(DBUtilities.getYears());


        barChart.setLegendVisible(false);
        barChart.getData().addAll(DBUtilities.getCarSoldByMake());
    }
}
