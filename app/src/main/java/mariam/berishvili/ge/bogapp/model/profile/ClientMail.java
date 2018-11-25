package mariam.berishvili.ge.bogapp.model.profile;

import com.google.gson.annotations.SerializedName;

public class ClientMail {

    @SerializedName("Contact")
    private String contact;
    @SerializedName("Route")
    private String route;
    @SerializedName("DefaultContact")
    private String defaultContact;
    @SerializedName("ContactName")
    private String contactName;
    @SerializedName("Mail")
    private String mail;
    @SerializedName("Mobile")
    private String mobile;
    @SerializedName("Device")
    private String device;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDefaultContact() {
        return defaultContact;
    }

    public void setDefaultContact(String defaultContact) {
        this.defaultContact = defaultContact;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
