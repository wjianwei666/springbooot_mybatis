package com.sean.config.mybatis;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * Mapper  自动扫描加载类
 * 
 * ClassName: MybatisConfiguration
 * @Description: MybatisConfiguration
 * @author  Wang Jianwei
 * @date 2016-1-22
 */

@Configuration
@ConditionalOnClass({ EnableTransactionManagement.class, EntityManager.class })
@AutoConfigureAfter({ DataBaseConfiguration.class })
@MapperScan(basePackages={"com.sean.api.**.mapper"})
public class MybatisConfiguration implements EnvironmentAware {

	private final static Log logger = LogFactory.getLog(MybatisConfiguration.class);

	private RelaxedPropertyResolver propertyResolver;

	@Inject
	private DataSource dataSource;

	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
	}

    /**
	 * @Description: sqlSessionFactory
	 * @param @return   
	 * @return SqlSessionFactory  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactory sqlSessionFactory() {
		try {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			sessionFactory.setTypeAliasesPackage(propertyResolver
					.getProperty("typeAliasesPackage"));
			sessionFactory
					.setMapperLocations(new PathMatchingResourcePatternResolver()
							.getResources(propertyResolver
									.getProperty("mapperLocations")));
			sessionFactory
					.setConfigLocation(new DefaultResourceLoader()
							.getResource(propertyResolver
									.getProperty("configLocation")));

			return sessionFactory.getObject();
		} catch (Exception e) {
			logger.warn("Could not confiure mybatis session factory");
			return null;
		}
	}

    /**
	 * @Description: transactionManager
	 * @param @return   
	 * @return DataSourceTransactionManager  
	 * @throws
	 * @author Wang Jianwei
	 * @date 2016-1-22
	 */
	@Bean
	@ConditionalOnMissingBean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
