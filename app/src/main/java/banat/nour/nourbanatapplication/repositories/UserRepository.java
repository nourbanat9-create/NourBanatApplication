package banat.nour.nourbanatapplication.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUserQuery;

public class UserRepository {
    private MyUserQuery UserQuery ;
    private LiveData<List<MyUser>>allUsers ;

    public UserRepository(Application application){

    }
}
