package com.dream.star.service.sys.impl;

import com.dream.star.model.sys.SysUser;
import com.dream.star.model.sys.SysUserExample;
import com.dream.star.mapper.sys.SysUserMapper;
import com.dream.star.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Override
    public List<SysUser> findAll() {
        return mapper.selectByExample(new SysUserExample());
    }

    @Override
    public SysUser findById(String id) {
        return mapper.selectByPrimaryKey(Long.decode(id));
    }

    @Override
    public int add(SysUser user) {
        return mapper.insert(user);
    }
}
