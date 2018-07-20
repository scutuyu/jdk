package com.tuyu.jdbc;

import com.tuyu.resource.ResourceUtil;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * jdbc测试
 *
 * @author tuyu
 * @date 7/20/18
 * Stay Hungry, Stay Foolish.
 */
public class JdbcTest {

    /**
     * <pre>
     *      数据库驱动使用的是SPI的方式，具体的Driver在静态代码中将自己的一个实例注册到DriverManager，
     *      在DriverManager中通过ServiceLoader加载所有的实现了java.long.Driver接口的类，
     *      当com.mysql.jdbc.Driver被加载后执行了前面提到的静态代码块，将自己的一个实例注册到了DriverManager中，
     *      当调用DriverManager的getConnection方法后，DriverManager将遍历保存所有具体Driver的列表，
     *      直到合适的驱动连接上数据库为止
     *      得到数据库连接后，就可以通过连接创建PreparedStatement对象或者Statement对象
     *      进而通过PreparedStatement对象或者Statement对象执行查询语句，并得到查询结果
     *      通过调用ResultSet的next方法遍历查询的结果，
     * </pre>
     * @throws SQLException
     */
    @Test
    public void testJdbcBasic() throws SQLException {
        Properties properties = ResourceUtil.getProperties("jdbc.properties");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from city");
//        ResultSet resultSet = preparedStatement.executeQuery();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from city");
        while (resultSet.next()) {
            CityName cityName = new CityName();
            cityName.setId(resultSet.getLong("id"));
            cityName.setName(resultSet.getString("name"));
            cityName.setState(resultSet.getString("state"));
            System.out.println(cityName);
        }
        resultSet.close();
//        preparedStatement.close();
        statement.close();
        connection.close();
    }
}
