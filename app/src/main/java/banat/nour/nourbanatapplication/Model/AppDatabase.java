package banat.nour.nourbanatapplication.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import banat.nour.nourbanatapplication.Model.MySubjectTable.MySubject;
import banat.nour.nourbanatapplication.Model.MySubjectTable.MySubjectQuery;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.Model.MyUserTable.MyUserQuery;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTaskQuery;

@Database(entities = {MyUser.class, MySubject.class, MyTask.class , CarsTable.class }, version = 1)
/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
    public abstract class AppDataBase extends RoomDatabase {
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDataBase db;

    /**
     * يعيد كائن لعمليات جدول المستعملين
     *
     * @return
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول المواضيع
     *
     * @return
     */
    public abstract MySubjectQuery getMySubjectQuery();

    /**
     * يعيد كائن لعمليات جدول المهمات
     *
     * @return
     */
    public abstract MyTaskQuery getMyTaskQuery();

    /**
     * بناء قاعدة البيانات وإعادة كائن يؤشر عليها
     *
     * @param context
     * @return
     */
    public static AppDataBase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDataBase.class,
                            "samihDataBase") // اسم قاعدة البيانات
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

    //بناء قاعدة بيانات وارجاع مؤشر عليها1
    AppDataBase db=AppDataBase.getDB(getApplicationContext());
    //2 مؤشر لكائن عمليات  لجدول
    MySubjectQuery subjectQuery = db.getMySubjectQuery();
    //3  بناء كائن من نوع الجدول وتحديد قيم الصفات
    MySubject s1=new MySubject();
s1.setTitle("Math");
    MySubject s2=new MySubject();
    s2.title="Computers";
//4 اضافة كائن للجدول
subjectQuery.insert(s1);
subjectQuery.insert(s2);



}

