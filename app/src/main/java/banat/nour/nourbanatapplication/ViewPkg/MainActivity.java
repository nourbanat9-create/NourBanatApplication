package banat.nour.nourbanatapplication.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import banat.nour.nourbanatapplication.R;

/**
 * MainActivity - BookLoop Platform
 * Handles the main screen UI, top Toolbar with Options Menu (res/menu/main_menu.xml),
 * and intent navigation to AddBookActivity, ProfileActivity, History, Settings, and SignInActivity.
 */
public class MainActivity extends AppCompatActivity {

    // 1. Declare UI Elements
    private MaterialToolbar toolbar;
    private EditText etSearch;
    private MaterialButton btnFilterAll;
    private MaterialButton btnFilterSwap;
    private MaterialButton btnFilterBorrow;
    private MaterialButton btnAddBook;

    // Sample Book Details Buttons
    private MaterialButton btnBook1Details;
    private MaterialButton btnBook2Details;
    private MaterialButton btnBook1Details3;

    // Top Header Profile Navigation Button
    private MaterialButton btnNavProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Adjust layout padding for Edge-to-Edge window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Set up the Toolbar as the ActionBar to display the 3-dots Options Menu
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 3. Initialize UI Views using findViewById
        initViews();

        // 4. Set up Click Listeners for Buttons
        setupClickListeners();
    }

    /**
     * Connects Java variables to XML view components by their IDs
     */
    private void initViews() {
        etSearch = findViewById(R.id.etSearch);
        btnFilterAll = findViewById(R.id.btnFilterAll);
        btnFilterSwap = findViewById(R.id.btnFilterSwap);
        btnFilterBorrow = findViewById(R.id.btnFilterBorrow);
        btnAddBook = findViewById(R.id.btnAddBook);

        // Book details buttons
        btnBook1Details = findViewById(R.id.btnBook1Details);
        btnBook2Details = findViewById(R.id.btnBook2Details);
        btnBook1Details3 = findViewById(R.id.btnBook1Details3);

        // Header Profile navigation button
        btnNavProfile = findViewById(R.id.btnNavProfile);
    }

    /**
     * Sets click listeners for screen interactive components
     */
    private void setupClickListeners() {

        // Category Filter Buttons
        btnFilterAll.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Showing All Books", Toast.LENGTH_SHORT).show()
        );

        btnFilterSwap.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Filtering Books for Swap", Toast.LENGTH_SHORT).show()
        );

        btnFilterBorrow.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Filtering Books for Borrow", Toast.LENGTH_SHORT).show()
        );

        // Add Book Button -> Navigates to AddBookActivity
        btnAddBook.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
            startActivity(intent);
        });

        // Sample Book Detail Buttons
        if (btnBook1Details != null) {
            btnBook1Details.setOnClickListener(v -> 
                Toast.makeText(MainActivity.this, "Details: The Great Gatsby", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnBook2Details != null) {
            btnBook2Details.setOnClickListener(v -> 
                Toast.makeText(MainActivity.this, "Details: To Kill a Mockingbird", Toast.LENGTH_SHORT).show()
            );
        }

        if (btnBook1Details3 != null) {
            btnBook1Details3.setOnClickListener(v -> 
                Toast.makeText(MainActivity.this, "Details: 1984", Toast.LENGTH_SHORT).show()
            );
        }

        // Profile Navigation
        if (btnNavProfile != null) {
            btnNavProfile.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            });
        }
    }

    // ==========================================
    // OPTIONS MENU METHODS (res/menu/main_menu.xml)
    // ==========================================

    /**
     * Inflates the top 3-dots Options Menu from res/menu/main_menu.xml
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Handles clicks on Options Menu items (Settings, History, Sign Out)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itmSettings) {
            // Navigate to Settings Screen
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.itmHistory) {
            // Navigate to History Screen
            Intent intent = new Intent(MainActivity.this, History.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.itmSignOut) {
            // Confirmation Dialog for Sign Out
            showSignOutDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Shows a confirmation dialog when the user clicks Sign Out
     */
    private void showSignOutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sign Out")
                .setMessage("Are you sure you want to sign out?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Signed out successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("No", null)
                .show();
    }
}