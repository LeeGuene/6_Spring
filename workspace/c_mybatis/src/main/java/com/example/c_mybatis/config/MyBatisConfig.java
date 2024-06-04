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

// @Configuration : 설정 관련 클래스임을 알려주는 어노테이션
// 메소드를 등록하려면 @Bean을 붙여서 등록해야 한다.
@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    // xml 설정 파일 등등 리소스 파일들을 읽어오기 위해 주입을 받는다.
    private final ApplicationContext applicationContext;

    // HikariConfig : 설정 정보를 담은 클래스
    // HikariConfig() 객체를 생성하는 메서드
    // application.properties로 가서 해당 주소(spring.datasource.hikari)로 시작(prefix)하는 
    // 모든 설정들을 읽어와서 바인딩한다는 의미.
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Bean
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    // 커넥션 설정
    // 위에서 가져온 설정정보를 가지고, 커넥션을 생성한다. ( HikariDataSource )

    // DataSource : 인터페이스
    // 데이터베이스를 연결하기 위한 설정들을 전달 받아 DataSource를 반환한다.
    // DataSource는 데이터베이스 커넥션 풀을 관리한다.
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    // 스프링 안에 .xml파일에 있는 SQL 소스코드(텍스트)를 데이터베이스에서 작동하도록 만들어주는 코드

    // SqlSessionFactoryBean    : SqlSessionFactory을 설정하고 생성하는 역할
    // SqlSessionFactory        : 실제 SQL 세션을 관리하고 실행하는 역할
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // xml 파일 위치를 설정
        // mapper는 테이블마다 생성해주는 것이 일반적이다.
        // getResources("classpath:mapper/*.xml") : resources 폴더에 접근하여 mapper폴더 안에 있는 모든 xml 파일을 조회한다.
        
        // MyBatis 메퍼 파일의 위치를 설정
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        
        // MyBatis 설정 파일의 위치를 설정
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/config.xml"));

        // SqlSessionFactory 객체 생성
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        // 언더바(_) 와 카멜 표기법을 자동으로 매핑해준다.
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;
    }




}

































