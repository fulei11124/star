package com.dream.star.web.sys;

import com.dream.star.model.common.RespEntity;
import com.dream.star.model.sys.SysUser;
import com.dream.star.service.sys.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("用户接口API")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("findAll")
    @ApiOperation("查询所有用户信息")
    public RespEntity<List<SysUser>> findAll(){
        RespEntity<List<SysUser>> res = new RespEntity<>();
        List<SysUser> users =sysUserService.findAll();
        res.ok(users);
        return res;
    }

    @GetMapping("findById")
    @ApiOperation("根据id查询用户信息")
    public RespEntity<SysUser> findById(String id){
        RespEntity<SysUser> res = new RespEntity<>();
        SysUser user =sysUserService.findById(id);
        res.ok(user);
        return res;
    }
}
