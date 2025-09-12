package spring.mybatis;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author Yves
 * @Data 2023/4/17 下午3:21
 */
public class SelfImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(SelfMapperScan.class.getName());
        String path = (String) annotationAttributes.get("path");
        System.out.println(path);

        SelfBeanDefinitionScanner scanner = new SelfBeanDefinitionScanner(registry);
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(path);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
//            beanDefinition
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(SelfFactoryBean.class);
            beanDefinition.setBeanClassName(beanDefinitionHolder.getBeanName());
            registry.registerBeanDefinition(beanDefinitionHolder.getBeanName(), beanDefinition);
        }

    }
}
