package banat.nour.nourbanatapplication.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.pkg_table.CarsTable;
import banat.nour.nourbanatapplication.Model.pkg_table.CarsTableQuery;

public class CarsTableReposity {
    private CarsTableQuery carstable ;
    private LiveData<List<CarsTable>> allcars ;
    public CarsTableReposity(Application application){
        AppDatabase db = AppDatabase.getDB(application);
        carstable = db.getCarsTableQuery();
        allcars = carstable.getAllCars();

    }
    public void delete (CarsTable ... cars ){
        carstable.delete(cars);
    }
    public void update (CarsTable...Mycar){
        carstable.delete(Mycar);
    }
    public void delete (int id ){
        carstable.delete(id);

    }
    public void insert(CarsTable MyCar){
        carstable.insert(MyCar);
    }
    public LiveData<List<CarsTable>> getAllcars ( ){
        return getAllcars() ;
    }
    public void insertAll(CarsTable... cars){
        carstable.insertAll(cars);
    }
    public LiveData<List<CarsTable>>checkPrice(String myBrand, String model1){
        return checkPrice(myBrand, model1);
    }

    public LiveData<List<CarsTable>> loadAllByPlanteNum(int[] userIds) {
        return loadAllByPlanteNum(userIds);
    }
}
