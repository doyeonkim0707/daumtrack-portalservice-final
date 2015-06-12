package kr.ac.jeju.model;


public class UserBasket {

    private String userName;
    private int productId;

    public UserBasket(String userName, int productId){
        this.userName = userName;
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
