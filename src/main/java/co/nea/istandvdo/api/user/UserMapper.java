package co.nea.istandvdo.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Mapper
@Repository
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyColumn = "id")

    @InsertProvider(type = UserProvider.class, method = "builderInsertSql")
    void insert(@Param("user") User user);  // make sure @Param()

    @SelectProvider(type = UserProvider.class, method = "buildSelectByIdSQL")
    Optional<User> selectByID(@Param("id")Integer id);

    @SelectProvider(type = UserProvider.class,method = "buildSelectSql")
    List<User> select(@Param("status") Boolean status);
}
