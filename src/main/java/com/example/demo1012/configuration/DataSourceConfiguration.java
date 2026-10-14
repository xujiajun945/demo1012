package com.example.demo1012.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.example.demo1012.dal.dao", sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DataSourceConfiguration {

    private static final String MAPPER_LOCATION = "classpath*:com/example/demo1012/dal/mapper/*.xml";

    @ConfigurationProperties(prefix = "demo.data-source")
    @Bean("dataSource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean("demoSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        log.warn("druid data source: " + druidDataSource.getDriverClassName() + " " + druidDataSource.getUsername());
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources(MAPPER_LOCATION);
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("demoSqlSessionTemplate")
    public SqlSessionTemplate demoSqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
