package kr.ac.jeju.model;

public class AuthInfo {

    private String id;
    private String name;
    private int authority;

    public AuthInfo(String id, String name, int authority){
        this.id = id;
        this.name = name;
        this.authority = authority;
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
}
