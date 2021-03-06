package com.mybatis.ds;

import org.apache.log4j.Logger;

public class CustomerContextHolder {

    public static final String DATA_SOURCE_MASTER = "masterDataSource";
    public static final String DATA_SOURCE_SLAVE = "slaveDataSource";
    private static final Logger logger = Logger.getLogger(CustomerContextHolder.class);
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
        logger.info("Switch DataSource -> " + dataSource);
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
