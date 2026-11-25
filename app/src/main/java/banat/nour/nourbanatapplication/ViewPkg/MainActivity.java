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
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import banat.nour.nourbanatapplication.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        if (savedInstanceState == null){
            replaceFragment(new fraMain());
        }
        bottomNav.setOnItemSelectedListener(Item -> {
            int itemId = Item.getItemId();
            if (itemId == R.id.nav_home){
                replaceFragment(new fraMain());
                return true ;
            }
            else if (itemId == R.id.nav_dashboard){
            //    replaceFragment(new D);
                return  true;
            }
            return false;
        });

        // Adjust layout padding for Edge-to-Edge window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void replaceFragment(Fragment fragment) { // داله مساعده ل تبديل المحتوى
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }


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