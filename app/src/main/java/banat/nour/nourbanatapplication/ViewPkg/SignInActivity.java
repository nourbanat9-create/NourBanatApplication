package banat.nour.nourbanatapplication.ViewPkg;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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

        btnSignIn.setOnClickListener(-> signInUser());
            @Override
            public void onClick(View v) {
                // etEmail btnSignIn etPassword
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (email.isEmpty()) {
                    etEmail.setError("please enter your email");
                    return;

                }
                if (password.isEmpty()) {
                    etPassword.setError("please enter your password");
                    return;
                }
                if (email.equals("user@email.com") && password.equals("123456")) {
                    Toast.makeText(SignInActivity.this, "تم تسجيل الدخول بنجاح!", Toast.LENGTH_SHORT).show();
                }
            }


    }