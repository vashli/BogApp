package mariam.berishvili.ge.bogapp.model.login;

import com.google.gson.annotations.SerializedName;

public class ClientLoginInfo {
    @SerializedName("SessionDetails")
    private SessionDetails sessionDetails;
    @SerializedName("SessionId")
    private String sessionId;
    @SerializedName("UserDetails")
    private UserDetails userDetails;

    public SessionDetails getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(SessionDetails sessionDetails) {
        this.sessionDetails = sessionDetails;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
