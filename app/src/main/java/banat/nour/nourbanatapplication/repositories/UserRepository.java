package banat.nour.nourbanatapplication.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUserQuery;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;

public class UserRepository {
    private MyUserQuery UserQuery ;
    private LiveData<List<MyUser>>allUsers ;

    public UserRepository(Application application){
        AppDatabase db = AppDatabase.getDB(application);
        UserQuery = db.getMyUserQuery();
        allUsers = UserQuery.getAll();

    }
    public LiveData<List<MyUser>> getAllUsers(){
        return allUsers;
    }
    public LiveData<List<MyUser>> loadAllByIds (int[] Id ){
        return UserQuery.loadAllByIds(Id);
    }
    public LiveData<List<MyUser>>checkEmailPassw (String myEmail, String myPassw){
        return UserQuery.checkEmailPassw(myEmail , myPassw);
    }
    public LiveData<List<MyUser>>checkEmail (String myEmail){
        return UserQuery.checkEmail(myEmail);
    }

    public void insert (MyUser... Users){
        UserQuery.insertAll(Users);
    }
    public void delete (MyUser... Users){
        UserQuery.delete(Users);
    }
    public void delete (int id ) {
        UserQuery.delete(id);
    }
    public void insert (MyUser myUser){
        UserQuery.insert(myUser);
    }
    public void update (MyUser ... values){
        UserQuery.update(values);
    }



}
