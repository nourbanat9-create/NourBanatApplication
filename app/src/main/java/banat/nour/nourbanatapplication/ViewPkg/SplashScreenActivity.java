package banat.nour.nourbanatapplication.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import banat.nour.nourbanatapplication.R;

public class SplashScreenActivity extends AppCompatActivity {
    //  private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //mAuth = FirebaseAuth.getInstance();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        }, 2500);
    }
   /** public void checkUserStatus(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Intent intent;
        if (currentUser != null ){
            intent = new Intent(SplashScreenActivity.this , MainActivity.class);

        }else {
            intent = new Intent (SplashScreenActivity.this , SignInActivity.class);

        }
        startActivity(intent);
        finish();
    } **/
}