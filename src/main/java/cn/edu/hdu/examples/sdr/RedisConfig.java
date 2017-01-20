package cn.edu.hdu.examples.sdr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig
{
    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("127.0.0.1");
        connectionFactory.setPort(6379);
        return new JedisConnectionFactory();
    }

    @Bean
    @Autowired
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
        
//    @Bean
//    @Autowired
//    public StringRedisTemplate strRedisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
}