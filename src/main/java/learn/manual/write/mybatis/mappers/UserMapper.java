package learn.manual.write.mybatis.mappers;

import learn.manual.write.mybatis.annotation.Mapper;
import learn.manual.write.mybatis.beans.User;

@Mapper
public interface UserMapper {

    void insert(User user);

    User select(long id);

    void update(long id);
}
