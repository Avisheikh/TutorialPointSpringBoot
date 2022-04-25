package com.example.oauth.Repo;

import com.example.oauth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class OAuthDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username)
    {
        Collection<GrantedAuthority> grantedAuthorityCollection = new ArrayList<>();

        String userSql = "SELECT * FROM USERS WHERE USERNAME=?";

        List<UserEntity> list = jdbcTemplate.query(userSql, new String[] { username }, (ResultSet rs, int rowNum) ->{
            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setPassword(rs.getString("PASSWORD"));
            return user;
        });

        if(list.size() > 0)
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthorityCollection.add(grantedAuthority);

            list.get(0).setGrantedAuthorityCollection(grantedAuthorityCollection);
            return list.get(0);
        }

        return null;
    }
}
