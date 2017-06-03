package xin.fallen.usedveh.PoliceDBVehImg.druid.ExcelExport;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ExcelExportDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "excelExportSqlSessionFactory")
public class ExcelExportDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "xin.fallen.usedveh.PoliceDBVehImg.mapper.ExcelExport";
//    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

    @Value("${druid.excel-export.url}")
    private String url;

    @Value("${druid.excel-export.username}")
    private String user;

    @Value("${druid.excel-export.password}")
    private String password;

    @Value("${druid.excel-export.driverClassName}")
    private String driverClass;

    @Bean(name = "excelExportDataSource")
    public DataSource ExcelExportDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "excelExportTransactionManager")
    public DataSourceTransactionManager excelExportTransactionManager() {
        return new DataSourceTransactionManager(ExcelExportDataSource());
    }

    @Bean(name = "excelExportSqlSessionFactory")
    public SqlSessionFactory excelExportTransactionManagerSqlSessionFactory(@Qualifier("excelExportDataSource") DataSource excelExportDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(excelExportDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver();
//                .getResources(ExcelExportDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}