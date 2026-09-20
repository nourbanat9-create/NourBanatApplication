package banat.nour.nourbanatapplication.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import banat.nour.nourbanatapplication.data.MySubjectTable.MySubject;
import banat.nour.nourbanatapplication.data.MySubjectTable.MySubjectQuery;
import banat.nour.nourbanatapplication.data.MyUserTable.MyUser;
import banat.nour.nourbanatapplication.data.MyUserTable.MyUserQuery;
import banat.nour.nourbanatapplication.data.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.data.mytasksTable.MyTaskQuery;

@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version = 1)
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

}

