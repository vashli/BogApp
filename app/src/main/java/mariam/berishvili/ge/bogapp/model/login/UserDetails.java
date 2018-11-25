package mariam.berishvili.ge.bogapp.model.login;

import com.google.gson.annotations.SerializedName;

public class UserDetails {
    @SerializedName("UserId")
    private int userId;
    @SerializedName("Username")
    private String username;
    @SerializedName("Name")
    private String name;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("PhoneForSms")
    private String phoneForSms;
    @SerializedName("Active")
    private boolean active;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneForSms() {
        return phoneForSms;
    }

    public void setPhoneForSms(String phoneForSms) {
        this.phoneForSms = phoneForSms;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
