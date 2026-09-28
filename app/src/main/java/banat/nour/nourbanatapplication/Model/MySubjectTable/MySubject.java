package banat.nour.nourbanatapplication.Model.MySubjectTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MySubject {
    @PrimaryKey (autoGenerate = true)
    public long key_id ;
    public String title ;

    public void setTitle(String math) {
    }

    public void setKey_id(long key_id) {
        this.key_id = key_id;
    }

    public long getKey_id() {
        return key_id;
    }
}
