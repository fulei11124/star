package com.dream.star.service.sys;

import com.dream.star.model.sys.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> findAll();

    SysUser findById(String id);

    int add(SysUser user);
}
