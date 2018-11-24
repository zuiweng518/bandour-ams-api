package com.ams.api.service;

import com.ams.api.entity.RoleOrgs;

import java.util.List;

public interface RoleOrgsService {
    public List<RoleOrgs> findRoleOrgsByAccount(String account);
}
