package xkq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xkq.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User getUserNameAndPwd(String username, String pwd);

}
