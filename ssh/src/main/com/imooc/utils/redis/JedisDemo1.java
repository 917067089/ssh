package main.com.imooc.utils.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 的测试
 */
public class JedisDemo1 {
    private final String url="47.105.169.147";
    private final int post=6379;
    @Test
    /**
     * 单实例的测试
     */
    public void demo1(){
        //1.设置ip和端口号
        Jedis jedis = new Jedis(url,post);
        //2.保存数据
        jedis.set("name1","imooc1");
        //3.获取数据
        String string = jedis.get("name");
        System.out.println(string);
        //删除key
        jedis.del("name1");
        //4.释放资源
        jedis.close();
    }
    /**
     * 连接池的链接
     */
    @Test
    public void demo2(){
        //获得连接池配置对象
        JedisPoolConfig config =new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲数
        config.setMaxIdle(10);
        //获得连接池
        JedisPool jedisPool =new JedisPool(config,url,post);
        //获得核心对象
        Jedis jedis = new Jedis();
        try{
            //获得连接池连接
            jedis = jedisPool.getResource();
            //设置数据
            jedis.set("name","张三");
            //获取数据
            String str = jedis.get("name");
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
