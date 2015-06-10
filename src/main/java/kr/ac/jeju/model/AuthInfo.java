package kr.ac.jeju.model;

public class AuthInfo {

    private String id;
    private String name;
    private int authority;
    private boolean loginStatus;

    public AuthInfo(String id, String name, int authority, boolean loginStatus){
        this.id = id;
        this.name = name;
        this.authority = authority;
        this.loginStatus = loginStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
