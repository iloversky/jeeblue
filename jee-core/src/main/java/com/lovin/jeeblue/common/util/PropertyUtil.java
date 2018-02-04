package com.lovin.jeeblue.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 属性文件读取工具类
 * Created by Lovin on 2018/1/14.
 */
public class PropertyUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    private static DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

    private static Map<String, Properties> propertiesMap = new HashMap<>();

    private final static String PROPERTY_NAME = "application.properties";

    public static synchronized String getValue(String key) {
        Properties props = getInstance(PROPERTY_NAME);
        return props.getProperty(key);
    }

    public static synchronized String getValue(String key, String defaultValue) {
        Properties props = getInstance(PROPERTY_NAME);
        return props.getProperty(key, defaultValue);
    }

    public static synchronized String getValueByConfig(String config, String key) {
        Properties props = getInstance(config);
        return props.getProperty(key);
    }

    public static synchronized String getValueByConfig(String config, String key, String defaultValue) {
        Properties props = getInstance(config);
        return props.getProperty(key, defaultValue);
    }

    private static Properties getInstance(String config) {
        Properties props = propertiesMap.get(config);
        if(props == null) {
            props = new Properties();
            InputStream in = null;
            try {
                Resource resource = resourceLoader.getResource(config);
                in = resource.getInputStream();

                logger.info("load file {}", resource.getURL().toString());
                props.load(in);

                propertiesMap.put(config, props);
            } catch (FileNotFoundException e) {
                logger.error("{} 文件未找到", config);
            } catch (IOException e) {
                logger.error("出现 IOException");
            } finally {
                try {
                    if(null != in) {
                        in.close();
                    }
                } catch (IOException e) {
                    logger.error("{} 文件流关闭出现异常", config);
                }
            }
        }
        return props;
    }
}
