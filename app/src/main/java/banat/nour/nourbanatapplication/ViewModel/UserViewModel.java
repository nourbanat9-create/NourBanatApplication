package banat.nour.nourbanatapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.repositories.TaskRepository;
import banat.nour.nourbanatapplication.repositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    public UserRepository repository;
    public LiveData<List<MyUser>> allUsers;
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }
}
