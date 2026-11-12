package banat.nour.nourbanatapplication.ViewPkg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import banat.nour.nourbanatapplication.Model.HistoryItem;
import banat.nour.nourbanatapplication.R;

/**
 * شاشة سجل المعاملات (History Activity) لربط واستعراض معاملات التبادل والاستعارة السابقة من Firebase Firestore.
 */
public class History extends AppCompatActivity {

    // عناصر الواجهة
    private ImageButton ibBack;
    private ImageButton ibClearHistory;
    private RecyclerView rvHistory;
    private LinearLayout llEmptyState;

    // محول القائمة والبيانات

    private List<HistoryItem> historyList;

    // خدمات Firebase
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        // ضبط الهوامش البرمجية لمنطقة شريط النظام
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. ربط عناصر الواجهة
        initViews();

        // 2. إعداد Firebase
        initFirebase();


    }

    /**
     * ربط عناصر الـ XML بمتغيرات الجافا بواسطة findViewById
     */
    private void initViews() {
        ibBack = findViewById(R.id.ibBack);
        ibClearHistory = findViewById(R.id.ibClearHistory);
        rvHistory = findViewById(R.id.rvHistory);
        llEmptyState = findViewById(R.id.llEmptyState);
    }

    /**
     * تهيئة كائنات FirebaseAuth و FirebaseFirestore
     */
    private void initFirebase() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUserId = currentUser.getUid();
        } else {
            currentUserId = ""; // في حال عدم وجود مستخدم مسجل دخول
        }
    }






    /**
     * إظهار أو إخفاء الشاشة الفارغة (Empty State) وحاوية القائمة
     */
    private void showEmptyState(boolean isEmpty) {
        if (isEmpty) {
            llEmptyState.setVisibility(View.VISIBLE);
            rvHistory.setVisibility(View.GONE);
        } else {
            llEmptyState.setVisibility(View.GONE);
            rvHistory.setVisibility(View.VISIBLE);
        }
    }





}