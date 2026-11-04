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
    public void insert(MyUser user) {
        repository.insert(user);
    }
    /**
     * إدراج مستخدم جديد في قاعدة البيانات (التسجيل / Sign Up).
     *
     * @param user كائن المستخدم المراد إضافته.
     */
    /**
     * البحث عن مستخدم بواسطة البريد الإلكتروني للتحقق من وجوده مسبقاً.
     *
     * @param email البريد الإلكتروني المراد البحث عنه.
     * @return كائن {@link MyUser} إن وجد، أو null إذا لم يوجد.
     */
    public MyUser getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }
    /**
     * التحقق من بيانات تسجيل الدخول (تسجيل الدخول / Sign In).
     *
     * @param email    البريد الإلكتروني للمستخدم.
     * @param password كلمة المرور.
     * @return كائن {@link MyUser} المطابق للبيانات، أو null في حال خطأ البريد أو كلمة المرور.
     */
    public MyUser login(String email, String password) {
        return repository.login(email, password);
    }





}
