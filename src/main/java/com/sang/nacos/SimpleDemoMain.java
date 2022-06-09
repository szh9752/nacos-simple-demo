package com.sang.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class SimpleDemoMain {

    public static void main(String[] args) throws NacosException {
        //    使用NacosClient来远程获取 nacos服务上的配置信息

        //    获取命名空间
        String namespace = "1c69c8b9-912d-40ec-8442-bba55eb2e849";
        //    nacos 地址
        String serverAddr = "127.0.0.1:8848";
        //   date id
        String dataId = "nacos-simple-demo.yaml";
        //    group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();   
        properties.put("serverAddr", serverAddr);
        properties.put("namespace", namespace);
//    获取配置
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, group, 50000);
        System.out.println(config);
    }

}
