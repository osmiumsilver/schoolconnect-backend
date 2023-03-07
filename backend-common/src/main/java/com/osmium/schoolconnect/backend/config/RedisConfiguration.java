package com.osmium.schoolconnect.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
// 设置开启事务支持
        template.setEnableTransactionSupport(true);
        /// 设置 RedisConnection 工厂。😈 它就是实现多种 Java Redis 客户端接入的秘密工厂。
        template.setConnectionFactory(redisConnectionFactory);

        // 使用 String 序列化方式，序列化 KEY 。
        template.setKeySerializer(RedisSerializer.string());

        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }
}