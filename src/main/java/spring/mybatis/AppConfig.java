package spring.mybatis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Yves
 * @Data 2023/4/17 下午2:58
 */
@Configuration
@ComponentScan("spring.mybatis")
@SelfMapperScan(path = "spring.mybatis.mapper")
public class AppConfig {

    public static void main(String[] args) {
        int finalize = 2;
        int system = 2;
    }


}
