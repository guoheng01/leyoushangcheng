package cn.itcast.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//声明一个类是一个java配置类，相当于一个xml文件
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfiguration {

//    @Autowired
//    private JdbcProperties jdbcProperties;

    @Bean //将方法的返回值注入到spring容器
    public DataSource dataSource(JdbcProperties jdbcProperties){//bean方法的形参注入
        DruidDataSource dataSource =   new DruidDataSource();
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        dataSource.setUsername(jdbcProperties.getUserName());
        dataSource.setPassword(jdbcProperties.getPassWord());
        return dataSource;
    }
}
