package xin.fallen.usedveh.PoliceDBVehImg.druid.VehImage;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = VehImageDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "vehImageSqlSessionFactory")
public class VehImageDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "xin.fallen.usedveh.PoliceDBVehImg.mapper.VehImage";
//    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Value("${druid.veh-image.url}")
    private String url;

    @Value("${druid.veh-image.username}")
    private String user;

    @Value("${druid.veh-image.password}")
    private String password;

    @Value("${druid.veh-image.driverClassName}")
    private String driverClass;

    @Bean(name = "vehImageDataSource")
    @Primary
    public DataSource vehImageDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "vehImageTransactionManager")
    @Primary
    public DataSourceTransactionManager vehImageTransactionManager() {
        return new DataSourceTransactionManager(vehImageDataSource());
    }

    @Bean(name = "vehImageSqlSessionFactory")
    @Primary
    public SqlSessionFactory vehImageSqlSessionFactory(@Qualifier("vehImageDataSource") DataSource vehImageDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(vehImageDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver();
//                .getResources(VehImageDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}