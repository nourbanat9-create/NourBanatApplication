package banat.nour.nourbanatapplication.repositories;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUserQuery;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.ViewPkg.MainActivity;
import banat.nour.nourbanatapplication.ViewPkg.SignInActivity;

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
    public MyUser getUserByEmail(String email) {
        return UserQuery.getUserByEmail(email);
    }
    /**
     * التحقق من بيانات تسجيل الدخول (تسجيل الدخول / Sign In).
     *
     * @param email    البريد الإلكتروني للمستخدم.
     * @param password كلمة المرور.
     * @return كائن {@link MyUser} المطابق للبيانات، أو null في حال خطأ البريد أو كلمة المرور.
     */
    public MyUser login(String email, String password) {
        return UserQuery.login(email, password);
    }

//    FirebaseAuth auth = FirebaseAuth.getInstance();
//            auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//            if (task.isSuccessful()) {
//                // إذا نجح تسجيل الدخول
//                Toast.makeText(SignInActivity.this, "Signing in Succeeded", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(SignInActivity.this, MainActivity.class);
//                startActivity(i);
//                finish(); // لإغلاق شاشة الدخول وعدم العودة إليها بالرجوع
//            } else {
//                // إذا فشل تسجيل الدخول (مثلاً: كلمة مرور خاطئة أو حساب غير موجود)
//                Toast.makeText(SignInActivity.this, "Signing in Failed", Toast.LENGTH_SHORT).show();
//                etEmail.setError(task.getException().getMessage());
//            }
//        }
//    });
//
//}
//@Override
//protected void onStart() {
//    super.onStart();
//    if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//        Intent i = new Intent(SignInActivity.this, MainActivity.class);
//        startActivity(i);
//        finish();
//    }
//}


}
