package demo.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接
        jedisPoolConfig.setMaxTotal(8);
        //最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        //最小空闲连接
        jedisPoolConfig.setMinIdle(0);
        //设置最长等待时间，ms
        jedisPoolConfig.setMaxWaitMillis(200);

        jedisPool = new JedisPool(jedisPoolConfig,"meiluna.cn",6379,1000,"密码");
    }

    //获取jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
