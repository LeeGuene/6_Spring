package com.example.c_mybatis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 스프링에서의 설정 클래스
// 메소드들에 @Bean 어노테이션을 붙여서 등록해준다.
@Configuration
@RequiredArgsConstructor
public class MybatisConfig {

    // xml 설정 파일 등등 리소스 파일들을 읽어오기 위해 주입을 받는다.
    private final ApplicationContext applicationContext;

    // application.properties 에서 spring.datasource.hikari 로 시작하는 설정을 읽어와서 바인딩해라!!
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    // Datasource 는 인터페이스
    // 데이터베이스를 연결하기 위한 설정들을 전달 받아 DataSource를 반환한다.
    // Datasource 는 데이터베이스 커넥션 풀(CP)를 관리한다.
    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{

        // SqlSessionFactoryBean 은 SqlSessionFactory 를 설정하고 생성하는 역할을 함.
        // SqlSessionFactory 는 실제 SQL 세션을 관리하고 실행하는 역할.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 데이터 소스를 저장한다.
        sqlSessionFactoryBean.setDataSource(dataSource());

        // Mybatis maaper 파일의 위치를 설정
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));

        // Mybatis 설정 파일의 위치를 설정
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/config.xml"));

        // 객체 생성
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        // 언더바(_)와 카멜 케이스이 자동으로 매핑되도록 설정
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;

    }




}



































