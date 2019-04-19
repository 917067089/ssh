package main.com.imooc.entity;

/**
 * 商品的实体
 */
public class Product {
    /**
     * id
     */
    private int pid;

    /**
     * 名字
     */
    private String pname;

    /**
     * 价格
     */
    private Double price;

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPid(int pid) {

        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
