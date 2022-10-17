package com.example.comp1011s1st200496893;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBUtilities {

        private static String user = "Ashmeet200496893"; //MySQL server username
        private static String pw = "Wd_qBy-drd";   //MySQL server password
        private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Ashmeet200496893";

    public static ArrayList<CarSold> getCarSoldFromDB()
    {
        ArrayList<CarSold> carsSold = new ArrayList();

        String sql = "SELECT * FROM carSales;";


        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {

            while (resultSet.next())
            {
                int carId = resultSet.getInt("carID");
                int modelYear = resultSet.getInt("modelYear");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                LocalDate dateSold = resultSet.getDate("dateSold").toLocalDate();

                CarSold carSold = new CarSold(carId, modelYear,price,make,model,dateSold);

                carsSold.add(carSold);
            }
        }
        catch (Exception e)
        {e.printStackTrace();}

        return carsSold;
    }
    public static ArrayList<Integer>  getYears() {
        ArrayList<Integer> carSoldByYears = new ArrayList();
        String sql = "SELECT dateSold FROM carSales;";

        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                LocalDate dateSold = resultSet.getDate("dateSold").toLocalDate();
                carSoldByYears.add(dateSold.getYear());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return carSoldByYears;
    }


    public static XYChart.Series<String,Integer> getCarSoldByMake()
    {
        XYChart.Series<String,Integer> carSoldByMake = new XYChart.Series<>();

        //query the DB to get a list of Artists
        String sql = "SELECT make , count(model) as 'car Sold' " +
                "FROM carSales " +
                "Group By make;" ;

        //the try() is called "try with resources"
        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //loop over the resultset and returen the top 10 movies
            while (resultSet.next())
            {
                String make = resultSet.getString("make");
                int carAmount = resultSet.getInt("car Sold");
                carSoldByMake.getData().add(new XYChart.Data<>(make,carAmount));
            }
        }
        catch (Exception e)
        {e.printStackTrace();}

        return carSoldByMake;
    }
}
