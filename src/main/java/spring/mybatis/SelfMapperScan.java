package spring.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author Yves
 * @Data 2023/4/17 下午2:46
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SelfImportBeanDefinitionRegistrar.class)
@MapperScan
public @interface SelfMapperScan {

    String path() default "";
}
