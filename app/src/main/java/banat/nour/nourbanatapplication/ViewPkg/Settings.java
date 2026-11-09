package banat.nour.nourbanatapplication.ViewPkg;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

import banat.nour.nourbanatapplication.Model.UserSettings;
import banat.nour.nourbanatapplication.R;

public class Settings extends AppCompatActivity {

    // View Components / UI Attributes
    private ImageButton ibBack;
    private ImageView ivAvatar;
    private ImageButton ibUploadAvatar;
    private TextInputEditText etFullName;
    private TextInputEditText etEmail;
    private MaterialButton btnChangePassword;
    private MaterialSwitch switchEmailNotifications;
    private MaterialSwitch switchPushNotifications;
    private AutoCompleteTextView actvLanguage;
    private MaterialSwitch switchDarkMode;
    private MaterialSwitch switch2FA;
    private MaterialButton btnActiveSessions;
    private MaterialButton btnDeleteAccount;
    private MaterialButton btnCancel;
    private MaterialButton btnSaveChanges;

    // Entity Model Attribute
    private UserSettings userSettingsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI Attributes via findViewById
        initViews();

        // Initialize Model Entity with Default / Saved Values
        initModel();

        // Populate UI with Model Data
        populateUIFromModel();

        // Set up Listeners and Event Handlers
        setupListeners();
    }

    private void initViews() {
        ibBack = findViewById(R.id.ibBack);
        ivAvatar = findViewById(R.id.ivAvatar);
        ibUploadAvatar = findViewById(R.id.ibUploadAvatar);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        btnChangePassword = findViewById(R.id.btnChangePassword);
        switchEmailNotifications = findViewById(R.id.switchEmailNotifications);
        switchPushNotifications = findViewById(R.id.switchPushNotifications);
        actvLanguage = findViewById(R.id.actvLanguage);
        switchDarkMode = findViewById(R.id.switchDarkMode);
        switch2FA = findViewById(R.id.switch2FA);
        btnActiveSessions = findViewById(R.id.btnActiveSessions);
        btnDeleteAccount = findViewById(R.id.btnDeleteAccount);
        btnCancel = findViewById(R.id.btnCancel);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);

        // Language Dropdown Setup
        String[] languages = new String[]{"English", "Arabic", "French", "Spanish"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, languages);
        actvLanguage.setAdapter(adapter);
    }

    private void initModel() {
        userSettingsModel = new UserSettings(
                "USER_101",
                "John Doe",
                "johndoe@example.com",
                "",
                true,
                true,
                "English",
                false,
                false,
                2
        );
    }

    private void populateUIFromModel() {
        if (userSettingsModel != null) {
            etFullName.setText(userSettingsModel.getUserName());
            etEmail.setText(userSettingsModel.getEmail());
            switchEmailNotifications.setChecked(userSettingsModel.isEmailNotificationsEnabled());
            switchPushNotifications.setChecked(userSettingsModel.isPushNotificationsEnabled());
            actvLanguage.setText(userSettingsModel.getSelectedLanguage(), false);
            switchDarkMode.setChecked(userSettingsModel.isDarkModeEnabled());
            switch2FA.setChecked(userSettingsModel.isTwoFactorEnabled());
        }
    }

    private void setupListeners() {
        ibBack.setOnClickListener(v -> finish());
        btnCancel.setOnClickListener(v -> finish());

        btnSaveChanges.setOnClickListener(v -> saveSettings());

        ibUploadAvatar.setOnClickListener(v ->
                Toast.makeText(this, "Avatar upload clicked", Toast.LENGTH_SHORT).show()
        );

        btnChangePassword.setOnClickListener(v ->
                Toast.makeText(this, "Change Password clicked", Toast.LENGTH_SHORT).show()
        );

        btnActiveSessions.setOnClickListener(v ->
                Toast.makeText(this, "Active Sessions: " + userSettingsModel.getActiveSessionsCount(), Toast.LENGTH_SHORT).show()
        );

        btnDeleteAccount.setOnClickListener(v ->
                Toast.makeText(this, "Delete Account clicked", Toast.LENGTH_SHORT).show()
        );
    }

    private void saveSettings() {
        if (userSettingsModel != null) {
            userSettingsModel.setUserName(etFullName.getText() != null ? etFullName.getText().toString().trim() : "");
            userSettingsModel.setEmail(etEmail.getText() != null ? etEmail.getText().toString().trim() : "");
            userSettingsModel.setEmailNotificationsEnabled(switchEmailNotifications.isChecked());
            userSettingsModel.setPushNotificationsEnabled(switchPushNotifications.isChecked());
            userSettingsModel.setSelectedLanguage(actvLanguage.getText() != null ? actvLanguage.getText().toString() : "English");
            userSettingsModel.setDarkModeEnabled(switchDarkMode.isChecked());
            userSettingsModel.setTwoFactorEnabled(switch2FA.isChecked());

            Toast.makeText(this, "Settings saved successfully!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}