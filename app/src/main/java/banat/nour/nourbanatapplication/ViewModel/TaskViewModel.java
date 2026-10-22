package banat.nour.nourbanatapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.repositories.TaskRepository;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<MyTask>> allTasks ;

    public TaskViewModel (@NonNull Application application) {
        super(application);
        repository = new TaskRepository( application);
        allTasks = repository.getAllTasks();
    }
    public LiveData<List<MyTask>>getAllTasks() {
        return allTasks ;
    }
    public LiveData<List<MyTask>> getTasksByUserId (long userId){
        return repository.getTasksByUserId(userId);
    }
    public LiveData<MyTask> getTaskbyId (long userId){
        return repository.getAllTaskOrederBy(userId);
    }
}
