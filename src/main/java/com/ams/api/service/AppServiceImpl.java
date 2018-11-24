package com.ams.api.service;

import com.ams.api.entity.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
;

@Service
public class AppServiceImpl implements AppService {
    private static Logger log= LoggerFactory.getLogger(AppServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbc;
    public App findApp(String app_code,String app_secret,String domains){
        String sql="select  code from ams_app where code=? and secret=? ";
        RowMapper<App> rowMapper = new BeanPropertyRowMapper<App>(App.class);
        App app=null;
        try {
            app= jdbc.queryForObject(sql, rowMapper, app_code, app_secret);
        }catch (Exception e){
             log.error("app_code或者app_secret有误");

        }
        return app;
    }
}
