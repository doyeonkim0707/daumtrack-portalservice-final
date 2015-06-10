package kr.ac.jeju.model;

public class LoginCommand {

    private String id;
    private String password;
    private boolean rememberEmail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
