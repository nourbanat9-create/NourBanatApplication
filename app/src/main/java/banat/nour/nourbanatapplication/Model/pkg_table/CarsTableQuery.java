package banat.nour.nourbanatapplication.Model.pkg_table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;

@Dao
public interface CarsTableQuery {
    @Query("SELECT * FROM CarsTable ")
        LiveData <List<CarsTable>> getAll () ;


    @Query("SELECT * FROM CarsTable")
    LiveData<List<CarsTable> >getAllCars();
    @Insert
    void insertCar (CarsTable car);

    @Query("SELECT * FROM CarsTable WHERE planteNumber IN (:userIds)")
    LiveData<List<MyUser> >loadAllByPlanteNum(int[] userIds);

   /** @Query("SELECT * FROM CarsTable WHERE email = :myEmail AND passw = :myPassw LIMIT 1")
    LiveData<List<MyUser>> checkEmailPassw(String myEmail, String myPassw);

    @Query("SELECT * FROM CarsTable WHERE planteNumber = :planteNum ")
    LiveData<List<MyUser>> checkEmail(long plantNum);
**/
    @Insert
        // إضافة مستعمل او مجموعة مستعملين
    void insertAll(CarsTable... cars);

    @Delete
        // حذف
    void delete(CarsTable... cars);

    // حذف حسب الرقم المميز id
    @Query("Delete From CarsTable WHERE planteNumber =:id ")
    void delete(int id);

    @Insert // إضافة مستعمل واحد
    void insert(CarsTable MyCar);

    @Update
    void update(CarsTable...Mycar);
}


