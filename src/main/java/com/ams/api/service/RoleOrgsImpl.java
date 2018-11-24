package com.ams.api.service;

import com.ams.api.entity.RoleOrgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleOrgsImpl implements RoleOrgsService {
    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public List<RoleOrgs> findRoleOrgsByAccount(String account) {
        String sql="select x.account,y.`name` as duty_name,w.`name` as role_name,o.`name` as org_name,y.id as duty_id,z.role_id,y.org_id  from ams_user_duty x,ams_duty y,ams_role_duty z,ams_role w,ams_org o";
        sql+=" where x.duty_id=z.duty_id and y.id=z.duty_id and w.id=z.role_id and o.id=y.org_id and x.account=?";
        RowMapper<RoleOrgs> rowMapper = new BeanPropertyRowMapper<RoleOrgs>(RoleOrgs.class);
        List<RoleOrgs> list=jdbc.query(sql,rowMapper,account);
        return list;
    }
}
