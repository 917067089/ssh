package main.com.imooc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import main.com.imooc.entity.Product;
import main.com.imooc.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品管理的Action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
    //模型驱动使用的类
    private Product product = new Product();
    @Override
    public Product getModel() {
        return product;
    }
    //Struts 和Spring 整合过程中按名称自动注入的业务层类
//    @Autowired
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    /**
     * 保存商品的执行的方法：save
     */
    public String save(){
        productService.save(product);
        return NONE;
    }
}
