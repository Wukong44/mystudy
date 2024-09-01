package com.xsy.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsy.json.Main;
import com.xsy.json.dto.Cat;
import com.xsy.json.dto.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

//@Import(JsonConfig.class) // 导入自定义的配置类
//@ExtendWith(SpringExtension.class)
//@ComponentScan(basePackages = {"com.xsy.json.configs"}) // 指定包含 JsonConfig 类的包路径
@SpringBootTest(classes = Main.class)
public class JsonTest {

    // 注入配置文件中自定义的Bean
    @Autowired
    private ObjectMapper mapper;

    /**
     * 将 Java 对象转换为 JSON 字符串
     *
     * @throws JsonProcessingException
     */
    @Test
    void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES); //如果 FAIL_ON_UNKNOWN_PROPERTIES 被配置为 false，则即使 JSON 中包含未知属性，反序列化也会继续进行而不抛出异常

        // 创建一个 Java 对象
        Person person = new Person("sisi", 20);

        // 将 Java 对象序列化为 JSON 字符串（就是序列化）
        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println(jsonString);


        String jsonString2 = "{\"name\":\"Jane Doe\",\"agee\":26,\"ageeqqq\":888}";
        Person person2 = objectMapper.readValue(jsonString2, Person.class);
        System.out.println(person2); // Person(name=Jane Doe, age=0)

    }

    /**
     * 将 JSON字符串解析为 Java对象
     *
     * @throws JsonProcessingException
     */
    @Test
    void test2() throws JsonProcessingException {
//         使用配置的ObjectMapper
        String jsonString = "{\"name\":\"Jane Doe\",\"age\":25}";

        // 将 JSON 字符串解析为 Java 对象（就是反序列化）
        Person person = mapper.readValue(jsonString, Person.class);
        System.out.println(person); // 输出：Person{name='Jane Doe', age=25}


        String jsonString2 = "{\"name\":\"Jane Doe\"}";
        Person person2 = mapper.readValue(jsonString2, Person.class);
        // 如果 Java 对象的构造函数要求所有属性都必须初始化，而 JSON 中缺少某些必要的属性，
        // 则反序列化时会抛出异常。如果 Java 对象的属性有默认值或可以使用默认初始化值，则反序列化时不会出现问题
        System.out.println(person2); // Person(name=Jane Doe, age=0)


        String jsonString3 = "{\"name\":\"Jane Doe\",\"agee\":26,\"ageeqqq\":888}";
        Person person3 = mapper.readValue(jsonString3, Person.class);
        System.out.println(person3); // Person(name=Jane Doe, age=0)

    }


    @Test
    void test3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
        String jsonString = "{\"age\":33}"; // 缺少 age 属性
//        String jsonString = "{\"name\":\"Jane Doe\"}"; // 缺少 age 属性
        Cat cat = mapper.readValue(jsonString, Cat.class);
        System.out.println(cat);
//        try {
//            String jsonString = "{\"name\":\"Jane Doe\"}"; // 缺少 age 属性
//            Cat cat = mapper.readValue(jsonString, Cat.class);
//            System.out.println(cat);
//        } catch (Exception e) {
//            if (e instanceof JsonMappingException) {
//                System.out.println("Error: " + e.getMessage());
//            } else {
//                e.printStackTrace();
//            }
//        }
    }


}


