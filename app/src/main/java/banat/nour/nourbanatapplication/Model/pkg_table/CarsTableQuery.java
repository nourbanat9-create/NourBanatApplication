package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarsTableQuery {
    @Query("SELECT * FROM CarsTable ")
        LiveData <List<CarsTable>> getAll () ;

    @Insert
    void insertCar (CarsTable car);
}
