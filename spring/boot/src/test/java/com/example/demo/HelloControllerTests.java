//package com.example.demo;
//
//import com.example.demo.config.AppProperties;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
//public class HelloControllerTests {
//    private MockMvc mvc;
//
//    @Before
//    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//    }
//
//    @After
//    public void cleanUp() {
//
//    }
//
//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(
//                // 构造一个get请求
//                MockMvcRequestBuilders.get("/hello")
//                        .contentType(MediaType.APPLICATION_JSON))
//                // 添加ResultMathcers验证规则，验证控制器执行完成后结果是否正确，【这是一个断言】
//                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                // 假定返回的结果中，期望为hello，并给出期望值和实际值
//                .andExpect(MockMvcResultMatchers.content().string("hello"))
//                // 添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
//                .andDo(MockMvcResultHandlers.print())
//                // 返回相应的MvcResult
//                .andReturn();
//    }
//}
