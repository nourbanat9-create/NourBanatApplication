package banat.nour.nourbanatapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.Model.pkg_table.CarsTable;
import banat.nour.nourbanatapplication.repositories.CarsTableReposity;
import banat.nour.nourbanatapplication.repositories.TaskRepository;

public class CarsTableViewModel extends AndroidViewModel {
    private CarsTableReposity repository;
    private LiveData<List<CarsTable>> allCars ;
    public CarsTableViewModel (@NonNull Application application) {
        super(application);
        repository = new CarsTableReposity( application);
        allCars = repository.getAllcars();
    }
    public LiveData<List<CarsTable>> checkPrice (String myBrand, String model1){
        return repository.checkPrice(myBrand , model1);
    }
    public LiveData<List<CarsTable>>loadAllByPlanteNum (int[] userIds){
        return repository.loadAllByPlanteNum(userIds);
    }
    public void insert (CarsTable MyCar){
        repository.insert(MyCar);
    }
    public void delete (CarsTable ... cars ){
        repository.delete(cars);
    }
    public void update (CarsTable...Mycar){
        repository.delete(Mycar);
    }
    public void delete (int id ){
        repository.delete(id);

    }
    public void insertAll(CarsTable... cars){
        repository.insertAll(cars);
    }
    public LiveData<List<CarsTable>> getAllcars ( ){
        return getAllcars() ;
    }







}
