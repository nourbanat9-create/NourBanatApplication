package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;
@Dao
public interface tasksQuery {
    LiveData <List<CarsTable>> getAll () ;
}
