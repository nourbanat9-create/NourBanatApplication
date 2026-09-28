package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity (tableName = "cars_table")
public class CarsTable {
    @PrimaryKey(autoGenerate = true)
    public long planteNumber ;

    public String color ;

    public String brand ;
    public Double price ;
    public String fuelType ;

    public String model1 ;

    public void setModel1(String model1) {
        this.model1 = model1;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlanteNumber(long planteNumber) {
        this.planteNumber = planteNumber;
    }

    public String getModel1() {
        return model1;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public long getPlanteNumber() {
        return planteNumber;
    }
}
