package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;

@Dao
public interface tasksQuery {
    @Query("SELECT * FROM CarsTable ")
        LiveData <List<CarsTable>> getAll () ;
}
