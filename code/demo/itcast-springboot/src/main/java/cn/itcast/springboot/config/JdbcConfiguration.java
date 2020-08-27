package cn.itcast.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//声明一个类是一个java配置类，相当于一个xml文件
public class JdbcConfiguration {

    @Bean //将方法的返回值注入到spring容器
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){
        DruidDataSource dataSource =   new DruidDataSource();
        return dataSource;
    }
}
