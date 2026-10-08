package banat.nour.nourbanatapplication.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import banat.nour.nourbanatapplication.Model.AppDatabase;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTask;
import banat.nour.nourbanatapplication.Model.mytasksTable.MyTaskQuery;

/**
        * مستودع المهام (MyTask) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المهام (TaskRepository).
        * يقوم بفصل قاعدة بيانات
* Room  و {@link MyTaskQuery}
        * عن بقية أجزاء التطبيق (ViewModels).
        */


public class TaskRepository {
    private  MyTaskQuery taskQuery ; //واجهة الاستعلامات

    private  LiveData<List<MyTask>>allTasks ;//مبنى معطيات يحوي جميع المهلام المستخرجة
    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */


    public TaskRepository(Application application){
        AppDatabase db = AppDatabase.getDB(application);
        taskQuery = db.getMyTaskQuery();
        allTasks = taskQuery.getAllTasks();

    }
    /**
     *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks (){
        return allTasks ;
    }


    /**
     * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
     *
     * @param UserId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم المحدد.
     */
    public LiveData<List<MyTask>> getTasksByUserId (long UserId){
        return taskQuery.getAllTaskOrederBy(UserId);
    }
    /**
     * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة الفريد.
     * @return كائن المهمة المطلوب.
     */
    public LiveData<MyTask> getTaskById(long taskId){
        return taskQuery.getTasksBySubjId(taskId);

    }

}
