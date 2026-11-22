package banat.nour.nourbanatapplication.ViewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import banat.nour.nourbanatapplication.R;

/**
 * شاشة إضافة كتاب جديد (AddBookActivity) لربط حقول الإدخال والتحقق من صحتها.
 */
public class AddBookActivity extends AppCompatActivity {

    // 1. تعريف عناصر الواجهة (Views)
    private ImageButton ibBack;
    private EditText etBookTitle;
    private EditText etAuthorName;
    private EditText etCategory;
    private RadioGroup rgOfferType;
    private RadioButton rbForSwap;
    private RadioButton rbForBorrow;
    private Button btnSaveBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_book);

        // ضبط الحواف لشريط النظام
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. ربط العناصر في ملف الجافا بملف الـ XML بواسطة findViewById
        initViews();

        // 3. إعداد مستمعات الأحداث والأزرار
        setupListeners();
    }

    /**
     * ربط متغيرات الجافا بمعرفات عناصر الـ XML
     */
    private void initViews() {
        ibBack = findViewById(R.id.ibBack);
        etBookTitle = findViewById(R.id.etBookTitle);
        etAuthorName = findViewById(R.id.etAuthorName);
        etCategory = findViewById(R.id.etCategory);
        rgOfferType = findViewById(R.id.rgOfferType);
        rbForSwap = findViewById(R.id.rbForSwap);
        rbForBorrow = findViewById(R.id.rbForBorrow);
        btnSaveBook = findViewById(R.id.btnSaveBook);
    }

    /**
     * إعداد الضغط على الأزرار (Back Button & Save Book Button)
     */
    private void setupListeners() {
        // عند الضغط على زر الرجوع العلوي يتم إغلاق الشاشة والعودة للشاشة السابقة
        ibBack.setOnClickListener(v -> finish());

        // عند الضغط على زر حفظ الكتاب
        btnSaveBook.setOnClickListener(v -> saveBook());
    }

    /**
     * التحقق من البيانات وحفظ الكتاب
     */
    private void saveBook() {
        // قراءة النصوص من حقول الإدخال
        String title = etBookTitle.getText().toString().trim();
        String author = etAuthorName.getText().toString().trim();
        String category = etCategory.getText().toString().trim();

        // معرفة نوع العرض المختار (تبادل أو استعارة)
        String offerType;
        if (rbForSwap.isChecked()) {
            offerType = "For Swap";
        } else {
            offerType = "For Borrow";
        }

        // التحقق من أن اسم الكتاب ليس فارغاً
        if (title.isEmpty()) {
            etBookTitle.setError("Please enter the book title");
            etBookTitle.requestFocus();
            return;
        }

        // التحقق من أن اسم الكاتب ليس فارغاً
        if (author.isEmpty()) {
            etAuthorName.setError("Please enter the author name");
            etAuthorName.requestFocus();
            return;
        }

        // إذا كانت الحقول صحيحة نفيّذ عملية الحفظ ونظهر رسالة نجاح تحتوي على التفاصيل
        String message = "Book '" + title + "' Added Successfully (" + offerType + ")";
        if (!category.isEmpty()) {
            message += " in " + category;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        // إغلاق الشاشة والعودة للرئيسية
        finish();
    }
}