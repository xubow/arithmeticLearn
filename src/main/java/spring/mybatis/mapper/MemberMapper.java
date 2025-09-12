package spring.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author Yves
 * @Data 2023/4/17 下午3:15
 */
public interface MemberMapper {

    @Select("select 'member'")
    String getMember();
}
