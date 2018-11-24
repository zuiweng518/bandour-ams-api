package com.ams.api.service;

import com.ams.api.entity.RoleOrgs;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleOrgsRow implements RowMapper<RoleOrgs> {
    public RoleOrgs mapRow(ResultSet resultSet,int i)throws SQLException {
        String account=resultSet.getString("account");
        String role_id=resultSet.getString("role_id");
        String role_name=resultSet.getString("role_name");
        String duty_id=resultSet.getString("duty_id");
        String duty_name=resultSet.getString("duty_name");
        RoleOrgs roleOrgs=new RoleOrgs();
        roleOrgs.setAccount("account");
        roleOrgs.setRole_id("role_id");
        roleOrgs.setRole_name("role_name");
        roleOrgs.setOrg_name("org_name");
        roleOrgs.setOrg_id("org_id");
        return roleOrgs;
    }
}
