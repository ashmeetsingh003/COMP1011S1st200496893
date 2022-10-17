package com.example.comp1011s1st200496893;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CarSold {
    private int carId, modelYear, price;
    private String make ,model;
    LocalDate dateSold;

    public CarSold(int carId, int modelYear, int price, String make, String model, LocalDate dateSold) {
        setCarId(carId);
        setModelYear(modelYear);
        setPrice(price);
        setMake(make);
        setModel(model);
        setDateSold(dateSold);
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        if (carId>0)
            this.carId = carId;
        else
            throw new IllegalArgumentException("Car ID should be greater than 0");

    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price>0)
        this.price = price;
        else
            throw new IllegalArgumentException("The price should be greater than 0");
    }

    public String getMake() {
        return make;
    }
    public static List<String> getListOfMake(){
        return Arrays.asList("Acura", "Ford", "Honda", "Nissan","Tesla");
    }

    public void setMake(String make) {
        if(getListOfMake().contains(make))
            this.make = make;
        else
            throw new IllegalArgumentException("Make should be Acura, Ford, Honda, Nissan or Tesla");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.length()>2)
            this.model = model;
        else
            throw new IllegalArgumentException("Model should be at least 2 characters long ");
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public void setDateSold(LocalDate dateSold) {
        if(dateSold.isBefore(LocalDate.now()))
        this.dateSold = dateSold;
        else
            throw new IllegalArgumentException("The date sold should be no later than today ");

    }
}
