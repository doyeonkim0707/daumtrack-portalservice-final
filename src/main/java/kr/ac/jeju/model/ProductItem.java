package kr.ac.jeju.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by Administrator on 2015-06-11.
 */
public class ProductItem {

    private CommonsMultipartFile fileData;
    private String url;
    private String name;
    private int price;
    private String description;
    private String distributor;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CommonsMultipartFile getFileData()
    {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData)
    {
        this.fileData = fileData;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }
}
