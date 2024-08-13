package com.xsy.json.configs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
public class JsonConfig {

    @Bean
    public ObjectMapper customObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        /*
        下面两种写法作用是一样的：在反序列化时遇到 JSON 中的未知属性时不抛出异常
        在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        推荐第一种，更简洁明了
         */
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
//        mapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时自定义时间日期格式
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //在序列化时忽略值为默认值的属性
//        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        return mapper;
    }
}

















