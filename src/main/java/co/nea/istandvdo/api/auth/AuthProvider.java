package co.nea.istandvdo.api.auth;

import org.apache.ibatis.jdbc.SQL;

public class AuthProvider {

    public  String bulidRegisterSQL(){
        return  new SQL(){{
            INSERT_INTO("users");
            VALUES("email","#{user.email}");
            VALUES("username","#{user.username}");
            VALUES("family_name","#{user.familyName");
            VALUES("given_name","#{user.givenName}");
            VALUES("gender","#{user.gender}");
            VALUES("password","#{user.password}");
        }}.toString();
    }
}
