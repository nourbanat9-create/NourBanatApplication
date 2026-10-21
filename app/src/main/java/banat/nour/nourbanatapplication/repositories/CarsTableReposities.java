package banat.nour.nourbanatapplication.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.Model.pkg_table.CarsTable;
import banat.nour.nourbanatapplication.Model.pkg_table.CarsTableQuery;

public class CarsTableReposities {
    private CarsTableQuery carstable ;
    private LiveData<List<CarsTable>> allcars ;
    public CarsTableReposities(Application application){
        AppDatabase db = AppDatabase.getDB(application);
        carstable = db.getCarsTableQuery();
        allcars = carstable.getAllCars();

    }


}
