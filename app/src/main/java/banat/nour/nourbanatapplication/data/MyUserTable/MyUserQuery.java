package banat.nour.nourbanatapplication.data.MyUserTable;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;
@Dao
public interface MyUserQuery {
    @Query("SELECT * FROM MyUser")
    List<MyUser> getall();

    @Query("SELECT * FROM MyUser WHERE  keyid IN (:usersId)")

    List<MyUser> loadAllByIds (int [] usersId);

    @Query("SELECT * FROM MyUser WHERE  email = :myEmail and passw = :mypassw LIMIT 1 ")

    MyUser checkEmail (String myEmail , String mypassw ) ;
    MyUser checkEmail (String myEmail ) ;

    void insertAll (MyUser ... Users ) ;
    void delete (MyUser user );
    void delete ( int id );
    void insert ( MyUser myUser);

    void update (MyUser ... values ) ;
}
