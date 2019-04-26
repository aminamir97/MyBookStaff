package ju.com.mybookstaff;

public class StaffModel {
     String fullname;
     String password;
     String username;
     String phone;



    public StaffModel(String fullname, String password, String username, String phone) {
        this.fullname = fullname;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }
    public StaffModel() {
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
