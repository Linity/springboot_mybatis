package com.ljw.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
@Configuration
@EnableTransactionManagement
//@MapperScan(basePackages = "com.ljw.web.dao")
public class MyBatisConfig implements TransactionManagementConfigurer {

    //单个DataSource配置
    @Bean
    @ConfigurationProperties(prefix="test.datasource")
    public DataSource dataSource() {
        Properties properties = new Properties();
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
/*    每个基于 Spring-MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的
    1.从 XML 文件中构建 SqlSessionFactory 的实例非常简单，建议使用类路径下的资源文件进行配置
    String resource = "classpath:mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    在基本的Mybatis中，利用SqlSessionFactoryBuilder来创建工厂
    或者利用下面的
    sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
    2.从 Java 程序中创建 configuration
*/
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        //设置需要映射的实体类和对应的sql语句xml文件(当语句比较简单时，可以结合java注解的形式)
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ljw.web.entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    /*SqlSessionTemplate是
    *mybatis.spring提供的持久层访问模板化的工具，线程安全，可通过构造参数或依赖注入SqlSessionFactory实例
    SqlSessionTemplate是MyBatis-spring的核心。
    这个类负责管理MyBatis的SqlSession,调用MyBatis的SQL方法，翻译异常。
    SqlSessionTemplate是线程安全的，可以被多个DAO所共享使用。
    当调用SQL方法时，包含从映射器getMapper()方法返回的方法，
    SqlSessionTemplate将会保证使用的SqlSession是和当前Spring的事务相关的。
    此外，它管理session的生命周期，包含必要的关闭，提交或回滚操作。
    SqlSessionTemplate实现了SqlSession，这就是说要对MyBatis的SqlSession进行简易替换。
    SqlSessionTemplate通常是被用来替代默认的MyBatis实现的DefaultSqlSession，
    因为它不能参与到Spring的事务中也不能被注入，因为它是线程不安全的。
    相同应用程序中两个类之间的转换可能会引起数据一致性的问题。
    * */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    /* 把事物托给spring来管理
     为事务管理器指定的DataSource必须
     和用来创建SqlSessionFactoryBean的是同一个数据源,否则事务管理器就无法工作了。
    一旦 Spring 的 PlatformTransactionManager 配置好了,你可以在 Spring 中以你通常的做 法来配置事务。
    @Transactional 注解和 AOP(Aspect-Oriented Program,面向切面编程,译 者注)样式的配置都是支持的*/
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
