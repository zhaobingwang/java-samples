package demo.springboot.orm.mybatis;

import demo.springboot.orm.mybatis.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@MapperScan(basePackages = {"demo.springboot.orm.mybatis.mapper"})
@SpringBootApplication
@RestController
public class SpringBootDemoOrmMybatisApplication {

    @Autowired
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmMybatisApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        return userMapper.getAllWithCondition(who).get(0).getName();
//        return String.format("Hello,%s!", who);
    }
}
