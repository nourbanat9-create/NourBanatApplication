package banat.nour.nourbanatapplication.Model.mytasksTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * فئة تُمثل مهمة
 */
@Entity
public class MyTask
{
    @PrimaryKey(autoGenerate = true)
    /* رقم المهمة */
    public long taskId;
    /* درجة الاهمية 1-5 */
    public int priorty;
    /* عنوان قصير */
    public String title;
    /* نص المهمة */
    public String description;
    /* زمن بناء المهمة */
    public long time;
    /* هل تمت المهمة */
    public boolean isCompleted;
    /* رقم موضوع المهمة */
    public long subjId;
    /* رقم المستعمل الذي أضاف المهمة */
    public long userId;
}