package main.com.imooc.service;

import main.com.imooc.dao.ProductDao;
import main.com.imooc.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品管理的Service类
 */
public class ProductService {
    //业务层注入dao类
//    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * 业务层保存商品的方法
     * @param product
     */
    public void save(Product product) {
        productDao.save(product);
    }
}
