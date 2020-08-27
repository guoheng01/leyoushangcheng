package cn.itcast.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//声明一个类是一个java配置类，相当于一个xml文件
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfiguration {

    @Autowired
    private JdbcProperties jdbcProperties;

    @Bean //将方法的返回值注入到spring容器
    public DataSource dataSource(){
        DruidDataSource dataSource =   new DruidDataSource();
        dataSource.setUrl(this.jdbcProperties.getUrl());
        dataSource.setDriverClassName(this.jdbcProperties.getDriverClassName());
        dataSource.setUsername(this.jdbcProperties.getUserName());
        dataSource.setPassword(this.jdbcProperties.getPassWord());
        return dataSource;
    }
}
