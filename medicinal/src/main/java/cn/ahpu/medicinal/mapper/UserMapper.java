package cn.ahpu.medicinal.mapper;

import cn.ahpu.medicinal.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
@Mapper
public interface UserMapper {

    public User findUserByUsername(String username);

    public void upUser(User user);
}
