package banat.nour.nourbanatapplication.ViewPkg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.MySubjectTable.MySubject;
import banat.nour.nourbanatapplication.Model.MySubjectTable.MySubjectQuery;
import banat.nour.nourbanatapplication.R;

public class MainActivity extends AppCompatActivity {
    private Button btnSignIn ;
    private Button bntRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //بناء قاعدة بيانات وارجاع مؤشر عليها1
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computers";
//4 اضافة كائن للجدول
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });

        bntRegister = findViewById(R.id.bntRegister);
        bntRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true ;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.itmSettings){
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
            return true;
        }

        if (item.getItemId()==R.id.itmHistory){
            Toast.makeText(this,"History" , Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.itmSignout) {
            showYesNoDalog();
            return true;

        }
        return true ;
    }

    /**
     * بناء ديالوج
     */
    public void showYesNoDalog(){
        // تجهيز بنائ شباك حوار ريالوغ يتلقى بارامتر موشر للنشاط (اكتيفيتي ) الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out") ;
        builder.setMessage("Are you sure ? ") ;
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick (DialogInterface dialogInterface , int i ) {
                Toast.makeText(MainActivity.this , "Signing out" , Toast.LENGTH_SHORT).show();
                finish();
            }

        });
        builder.setNegativeButton("No ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this , "Singing out" , Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    }





