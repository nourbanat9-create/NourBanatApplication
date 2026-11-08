package banat.nour.nourbanatapplication.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.R;
import banat.nour.nourbanatapplication.ViewModel.UserViewModel;
import banat.nour.nourbanatapplication.repositories.UserRepository;

public class SignInActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;
    private TextView tvForgotPassword;
    private MaterialButton btnSignIn;
    private TextView tvOrContinueWith;
    private MaterialButton btnGoogle;
    private MaterialButton btnApple;
    private TextView tvDontHaveAccount;
    private TextView tvSignUp;
    private UserViewModel userViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tilEmail = findViewById(R.id.tilEmail);
        etEmail = findViewById(R.id.etEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etPassword = findViewById(R.id.etPassword);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvOrContinueWith = findViewById(R.id.tvOrContinueWith);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnApple = findViewById(R.id.btnApple);
        tvDontHaveAccount = findViewById(R.id.tvDontHaveAccount);
        tvSignUp = findViewById(R.id.tvSignUp);

        btnSignIn.setOnClickListener(v -> signInUser());
        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }
        private void signInUser () {
            // etEmail btnSignIn etPassword
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            // يحذف أي مسافات زائدة في البداية أو النهاية (trim())
            if (email.isEmpty()) {
                etEmail.setError("Email is required");
                etEmail.requestFocus();
                // الشرح: ينقل تركيز المؤشر (Focus) إلى حقل البريد مباشرةً ليكتب فيه المستخدم.
                return;

            }
            if (password.isEmpty()) {
                etPassword.setError("password is required");
                etPassword.requestFocus();
                return;
            }
            MyUser user = userViewModel.login(email,password);
            if (user != null ){
                Toast.makeText(this,"welcome" + user.getFullName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignInActivity.this , MainActivity.class) ;
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this , "Invalid email or password" , Toast.LENGTH_SHORT).show();
            }
        }



    }