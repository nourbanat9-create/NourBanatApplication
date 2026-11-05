package banat.nour.nourbanatapplication.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.R;
import banat.nour.nourbanatapplication.ViewModel.UserViewModel;

public class SignUpActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextInputLayout tilFullName;
    private TextInputEditText etFullName;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;
    private TextInputLayout tilConfirmPassword;
    private TextInputEditText etConfirmPassword;
    private MaterialCheckBox cbTerms;
    private MaterialButton btnSignUp;
    private TextView tvOrSignUpWith;
    private MaterialButton btnGoogle;
    private MaterialButton btnApple;
    private TextView tvAlreadyHaveAccount;
    private TextView tvSignIn;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tilFullName = findViewById(R.id.tilFullName);
        etFullName = findViewById(R.id.etFullName);
        tilEmail = findViewById(R.id.tilEmail);
        etEmail = findViewById(R.id.etEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etPassword = findViewById(R.id.etPassword);
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        cbTerms = findViewById(R.id.cbTerms);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvOrSignUpWith = findViewById(R.id.tvOrSignUpWith);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnApple = findViewById(R.id.btnApple);
        tvAlreadyHaveAccount = findViewById(R.id.tvAlreadyHaveAccount);
        tvSignIn = findViewById(R.id.tvSignIn);

        btnSignUp.setOnClickListener(v -> signUpUser());
        tvSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void signUpUser() {
        String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

        if (fullName.isEmpty()) {
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please agree to the Terms & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        MyUser newUser = new MyUser();
        newUser.setFullName(fullName);
        newUser.email = email;
        newUser.passw = password;

        userViewModel.insert(newUser);
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}