package mvc.dao.impl;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userdaoimpl")
public class userdaoimpl {

    @Autowired
    @Qualifier("template")
    private JdbcTemplate template;

    public List<User> querry() {
        String sql = "select * from user";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        //System.out.println(query);
        return query;
    }

/*    public void querry() {
        String sql = "select * from user";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(query);
    }*/
}
