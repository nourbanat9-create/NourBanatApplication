package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class CarsTable {
    @PrimaryKey(autoGenerate = true)
    public long planteNumber ;

    public String color ;

    public String brand ;
    public Double price ;
    public String fuelType ;

    public String model ;

}
