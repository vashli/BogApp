package mariam.berishvili.ge.bogapp.model.login;

import com.google.gson.annotations.SerializedName;

public class SessionDetails {
    @SerializedName("IsChannelActive")
    private boolean isChannelActive;
    @SerializedName("SessionTimeout")
    private int sessionTimeout;

    public boolean isChannelActive() {
        return isChannelActive;
    }

    public void setChannelActive(boolean channelActive) {
        isChannelActive = channelActive;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
