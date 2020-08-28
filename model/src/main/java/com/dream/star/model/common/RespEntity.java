package com.dream.star.model.common;


import com.dream.star.model.enums.StatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 接口返回实体
 */
@Data
@ApiModel("RespEntity")
public class RespEntity<T> implements Serializable {
    @ApiModelProperty(value = "接口返回信息", name = "msg", example = "请求成功！！！")
    private String msg;
    @ApiModelProperty(value = "接口返回码", name = "code", example = "200")
    private Integer code;
    @ApiModelProperty(value = "接口数据", name = "data")
    private T data;
    @ApiModelProperty(value = "接口返回错误信息", name = "error", example = "参数错误！！！")
    private String error;

    public RespEntity<T> success(T obj) {
        RespEntity<T> resp = new RespEntity<>();
        resp.setCode(StatusCode.SUCCESS.getCode());
        resp.setMsg(StatusCode.SUCCESS.getMsg());
        resp.setData(obj);
        return resp;
    }
    public RespEntity<T> failed(T obj, Integer code, String msg) {
        RespEntity<T> resp = new RespEntity<>();
        resp.setCode(code);
        resp.setMsg(msg);
        resp.setData(obj);
        return resp;
    }

    public void ok(T obj) {
        this.msg = StatusCode.SUCCESS.getMsg();
        this.code = StatusCode.SUCCESS.getCode();
        this.data = obj;
    }

    public void ok(T obj, String msg) {
        this.msg = msg;
        this.code = StatusCode.SUCCESS.getCode();
        this.data = obj;
    }

    public void null_obj(T obj) {
        this.code = StatusCode.DATA_NULL.getCode();
        this.msg = StatusCode.DATA_NULL.getMsg();
        this.data = obj;
    }

    public void null_obj(T obj, String error) {
        this.code = StatusCode.DATA_NULL.getCode();
        this.msg = StatusCode.DATA_NULL.getMsg();
        this.data = obj;
        this.error = error;
    }

    public void fail(T obj, String msg, Integer code) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(obj);
    }

    public void fail(T obj, String error, Integer code, String msg) {
        this.setCode(code);
        this.setError(error);
        this.setData(obj);
        this.setMsg(msg);
    }

    public void fail(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public void fail(Integer code, String msg, String error) {
        this.msg = msg;
        this.code = code;
        this.error = error;
    }

    public static <T> RespEntity getRespObj(T param) {
        RespEntity<T> obj = new RespEntity<>();
        if (param == null) {
            obj.null_obj(param);
        } else {
            obj.ok(param, StatusCode.SUCCESS.getMsg());
        }
        return obj;
    }

    public static <T> RespEntity<T> getRespList(T param) {
        List<T> list = (List) param;
        RespEntity<T> resp = new RespEntity<>();
        if (list != null && list.size() > 0) {
            resp.ok(param, StatusCode.SUCCESS.getMsg());
        } else {
            resp.null_obj(param);
        }
        return resp;
    }


}
