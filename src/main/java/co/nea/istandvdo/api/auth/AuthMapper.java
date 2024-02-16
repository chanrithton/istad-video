package co.nea.istandvdo.api.auth;

import co.nea.istandvdo.api.user.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthMapper {

    @InsertProvider(type = AuthProvider.class, method = "bulidRegisterSQL")
    void register(@Param("user")User user);
}
