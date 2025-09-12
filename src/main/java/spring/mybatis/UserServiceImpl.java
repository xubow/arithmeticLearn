package spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.mybatis.mapper.MemberMapper;
import spring.mybatis.mapper.UserMapper;

/**
 * @Author Yves
 * @Data 2023/4/17 下午2:59
 */

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberMapper memberMapper;

    public String getUser() {
        return userMapper.getInfo();
    }

    public String getMember() {
        return memberMapper.getMember();
    }
}
