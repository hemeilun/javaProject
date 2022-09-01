import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class tests {

    @Test
    public void test1() throws SQLException {

        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("springMVC.xml");
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

}
