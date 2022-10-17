package com.example.comp1011s1st200496893;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class CarSoldViewController {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private TableColumn<?, ?> carIdColumn;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private TableColumn<?, ?> dateSoldColumn;

    @FXML
    private TableColumn<?, ?> makeColumn;

    @FXML
    private TableColumn<?, ?> modelColumn;

    @FXML
    private TableColumn<?, ?> modelYearColumn;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private Label totalSoldLabel;

    @FXML
    private Label unitSoldLabel;

    @FXML
    private ComboBox<?> yearCombo;

}
