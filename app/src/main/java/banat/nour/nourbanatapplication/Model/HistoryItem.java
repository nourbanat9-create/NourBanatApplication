package banat.nour.nourbanatapplication.Model;

/**
 * كائن نموذج لبيانات معاملة سابقة (استعارة أو تبادل كتاب).
 * متوافق مع قاعدة بيانات Firebase Firestore.
 */
public class HistoryItem {

    private String id;               // المعرف الفريد للفيلم / المستند في Firestore
    private String userId;           // معرف المستخدم الحالي
    private String bookTitle;        // عنوان الكتاب
    private String bookCoverUrl;     // رابط صورة غلاف الكتاب
    private String otherUserName;    // اسم المستخدم الآخر المشارك في المعاملة
    private String transactionType;  // نوع المعاملة: Exchange 🔄 أو Borrow 📖
    private String date;             // تاريخ المعاملة
    private String status;           // حالة المعاملة: Completed / Pending

    // 1. منشئ فارغ مطفي مطلوب لـ Firebase Firestore عند تحويل المستندات لكائنات Java
    public HistoryItem() {
    }

    // 2. منشئ كامل بإسناد كافة الخصائص
    public HistoryItem(String id, String userId, String bookTitle, String bookCoverUrl,
                       String otherUserName, String transactionType, String date, String status) {
        this.id = id;
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.bookCoverUrl = bookCoverUrl;
        this.otherUserName = otherUserName;
        this.transactionType = transactionType;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCoverUrl() {
        return bookCoverUrl;
    }

    public void setBookCoverUrl(String bookCoverUrl) {
        this.bookCoverUrl = bookCoverUrl;
    }

    public String getOtherUserName() {
        return otherUserName;
    }

    public void setOtherUserName(String otherUserName) {
        this.otherUserName = otherUserName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
/** كلاس المودل (HistoryItem في مجلد Model):

 ليش عمله؟ هاد بمثابة "القالب" أو "الهوية" للعملية الوحدة. بحدد شو المعلومات اللي رح تنحفظ لكل كتاب تبدّل أو استُعير (اسم الكتاب، التاريخ، الحالة، واسم الشخص الثاني).
 بدون هاد الكلاس، التطبيق ما بيعرف شو شكل البيانات اللي جاي من قاعدة البيانات (Firebase)
 */