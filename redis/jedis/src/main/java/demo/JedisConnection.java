package demo;

import demo.util.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

public class JedisConnection {

    private static Jedis jedis;

    public static void main(String[] args) {
//        connectNotPool();
        connectWithPool();
    }

    //无连接池建立连接
    static void connectNotPool(){
        //建立连接
        jedis = new Jedis("meiluna.cn",6379);
        jedis.auth("密码");
        jedis.select(1);

        jedis.set("name","meilun");
        String name = jedis.get("name");
        System.out.println(name);

        if (jedis != null){
            jedis.close();
        }
    }

    //连接池建立连接
    static void connectWithPool(){
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.hset("user","age","18");
        String age = jedis.hget("user", "age");
        System.out.println("age:"+age);

        if(jedis!=null){
            jedis.close();
        }
    }
}
