package spring.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author Yves
 * @Data 2023/4/17 下午2:49
 */
public interface UserMapper {

    @Select("select 'user'")
    String getInfo();
}
