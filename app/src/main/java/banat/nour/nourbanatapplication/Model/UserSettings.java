package banat.nour.nourbanatapplication.Model;

public class UserSettings {
    private String userId;
    private String userName;
    private String email;
    private String avatarUrl;
    private boolean emailNotificationsEnabled;
    private boolean pushNotificationsEnabled;
    private String selectedLanguage;
    private boolean darkModeEnabled;
    private boolean twoFactorEnabled;
    private int activeSessionsCount;

    public UserSettings() {
    }

    public UserSettings(String userId, String userName, String email, String avatarUrl,
                        boolean emailNotificationsEnabled, boolean pushNotificationsEnabled,
                        String selectedLanguage, boolean darkModeEnabled,
                        boolean twoFactorEnabled, int activeSessionsCount) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.emailNotificationsEnabled = emailNotificationsEnabled;
        this.pushNotificationsEnabled = pushNotificationsEnabled;
        this.selectedLanguage = selectedLanguage;
        this.darkModeEnabled = darkModeEnabled;
        this.twoFactorEnabled = twoFactorEnabled;
        this.activeSessionsCount = activeSessionsCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    public boolean isPushNotificationsEnabled() {
        return pushNotificationsEnabled;
    }

    public void setPushNotificationsEnabled(boolean pushNotificationsEnabled) {
        this.pushNotificationsEnabled = pushNotificationsEnabled;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public boolean isDarkModeEnabled() {
        return darkModeEnabled;
    }

    public void setDarkModeEnabled(boolean darkModeEnabled) {
        this.darkModeEnabled = darkModeEnabled;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public int getActiveSessionsCount() {
        return activeSessionsCount;
    }

    public void setActiveSessionsCount(int activeSessionsCount) {
        this.activeSessionsCount = activeSessionsCount;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", emailNotificationsEnabled=" + emailNotificationsEnabled +
                ", pushNotificationsEnabled=" + pushNotificationsEnabled +
                ", selectedLanguage='" + selectedLanguage + '\'' +
                ", darkModeEnabled=" + darkModeEnabled +
                ", twoFactorEnabled=" + twoFactorEnabled +
                ", activeSessionsCount=" + activeSessionsCount +
                '}';
    }
}