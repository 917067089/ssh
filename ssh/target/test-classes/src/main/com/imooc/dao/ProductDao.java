package main.com.imooc.dao;

import main.com.imooc.entity.Product;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 商品管理的Dao类
 */
public class ProductDao extends HibernateDaoSupport {
    /**
     * Dao保存商品的方法
     * @param product
     */
    public void save(Product product) {
        System.out.println("DAO保存的方法执行了");
        this.getHibernateTemplate().save(product);
    }

}
