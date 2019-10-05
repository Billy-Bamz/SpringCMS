package com.codebamz.startcms.StartCMS.component;

import com.codebamz.startcms.StartCMS.repository.CategoriaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//configuration solo se va a cargar para configuraciones
@Configuration
public class TestDatabaseConfiguration {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("codebamz");
        dataSource.setPassword("root1234");

        return dataSource;
    }

    @Bean
    public CategoriaRepository categoriaRepository(){
        return new CategoriaRepository();
    }
}
