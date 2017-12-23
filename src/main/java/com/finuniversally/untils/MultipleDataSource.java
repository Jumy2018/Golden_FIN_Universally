package com.finuniversally.untils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切换数据源
 * @author riseSun
 *
 * 2017年12月18日下午11:10:42
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    /**
     * 指定数据源
     * @param dataSource
     * @author riseSun
    
     * 2017年12月18日下午11:10:34
     */
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
    /**
     * 移除当前使用的数据源，切换到系统默认的数据源
     * 
     * @author riseSun
    
     * 2017年12月23日下午4:00:15
     */
    public static void removeDataSourceKey() {
    	dataSourceKey.remove();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}