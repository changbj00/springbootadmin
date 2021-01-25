package com.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RefreshScope
@Slf4j
public class Testcontroller {
    @Autowired
    DruidConfiguration druidConfiguration;
    @Autowired
    CursorMapper cursorMapper;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @GetMapping("/refresh")
    public String refresh() throws SQLException {
        DruidDataSource master = SpringUtils.getBean("dataSource");
        master.setUrl(druidConfiguration.getDbUrl());
        master.setUsername(druidConfiguration.getUsername());
        master.setPassword(druidConfiguration.getPassword());
        master.setDriverClassName(druidConfiguration.getDriverClassName());
        master.restart();
        return jdbcUrl + "----------" + druidConfiguration.getDbUrl();
    }

    @GetMapping("/scan")
    public String scan() {
        List<BusinessVariables> list = cursorMapper.scan();
        list.forEach(businessVariables -> {
            log.info("businessVariables:{}", businessVariables);
        });
        return "businessVariables";

    }

}
