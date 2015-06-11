package kr.ac.jeju.service;


import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.repository.ProductDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoMapper productDaoMapper;

    @Inject private FileSystemResource fsResource;

    @Override
    public List<ProductItem> list() {
        return productDaoMapper.findAll();
    }

    @Override
    public void uploadProduct(ProductItem productItem, BindingResult result) {

        String filename = productItem.getFileData().getOriginalFilename();
        String imgExt = filename.substring(filename.lastIndexOf(".")+1, filename.length());

        //upload 가능한 파일 타입 지정
        if(imgExt.equalsIgnoreCase("JPG") || imgExt.equalsIgnoreCase("JPEG") || imgExt.equalsIgnoreCase("GIF") || imgExt.equalsIgnoreCase("PNG")){
            byte[] bytes = productItem.getFileData().getBytes();
            try{
                String path = fsResource.getPath()+"_"+filename;
                String url = "http://117.17.102.36:8083/resources/image/_"+ filename;
                File lOutFile = new File(path);
                FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);
                lFileOutputStream.write(bytes);
                lFileOutputStream.close();
                productItem.setUrl(url);
                productDaoMapper.insert(productItem);
            }catch(IOException ie){
                //Exception 처리
                System.err.println("File writing error! ");
            }
            System.err.println("File upload success! ");
        }else{
            System.err.println("File type error! ");
        }

        // Some type of file processing...
        System.err.println("-------------------------------------------");
        System.err.println("Test upload: " + productItem.getName());
        System.err.println("Test upload: " + productItem.getFileData().getOriginalFilename());
        System.err.println("-------------------------------------------");
    }

    @Override
    public ProductItem printProductInfo(int id) {
        return productDaoMapper.findById(id);
    }
}
