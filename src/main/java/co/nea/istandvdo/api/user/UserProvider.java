package co.nea.istandvdo.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String builderInsertSql() {
        return new SQL() {{
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("username", "#{user.username}");
            VALUES("email", "#{user.email}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("phone", "#{user.phone}");
            VALUES("biography", "#{user.biography}");
            VALUES("password", "#{user.password}");
        }}.toString();
    }

    public String buildSelectByIdSQL() {
      return new SQL() {
        {
            INSERT_INTO("users");
            VALUES("uuid", "#{user.uuid}");
            VALUES("username", "#{user.username}");
            VALUES("family_name", "#{user.familyName}");
            VALUES("given_name", "#{user.givenName}");
            VALUES("gender", "#{user.gender}");
            VALUES("dob", "#{user.dob}");
            VALUES("phone", "#{user.phone}");
            VALUES("biography", "#{user.biography}");
            VALUES("status", "#{user.status}");
        }
    }.toString();
}
    public  String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("status = #{status}");
        }}.toString();
    }


}


