package com.ams.api.service;

import com.ams.api.entity.App;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppRow  implements  RowMapper<App> {

    public App mapRow(ResultSet resultSet,int i)throws SQLException {
        String app_code=resultSet.getString("app_code");
        String app_secret=resultSet.getString("app_secret");
        String domains=resultSet.getString("domains");
        App app=new App();
        app.setApp_code(app_code);
        app.setApp_secret(app_secret);
        app.setDomains(domains);
        return app;
    }

}
