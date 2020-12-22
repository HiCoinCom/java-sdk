package com.chainup.waas.response;

import java.io.Serializable;


/**
 * @author chainup waas
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 7917345507074842804L;
    /**
     * 0成功 非0具体错误原因
     */
	private String code = "";
    /**
     * 具体错误描述or成功描述
     */
	private String msg = "";
    /**
     * 存放业务数据
     */
    private T data;


    public static class Builder {
        public static <T> CommonResult<T> SUCC() {
            CommonResult<T> vo = new CommonResult<T>();
            vo.setCode("0");
            return vo;
        }

        public static <T> CommonResult<T> FAIL() {
            CommonResult<T> vo = new CommonResult<T>();
            return vo;
        }
    }

    public static <T> CommonResult<T> SUCC() {
        return Builder.SUCC();
    }

    public static <T> CommonResult<T> SUCC(T data) {
    	CommonResult<T> result = new CommonResult<T>();
    	result.setCode("0");
    	result.setData(data);
        return result;
    }

    public static <T> CommonResult<T> FAIL() {
        return Builder.FAIL();
    }

    public static <T> CommonResult<T> FAIL(T data) {
    	CommonResult<T> result = new CommonResult<T>();
    	result.setData(data);
        return result;
    }


    public CommonResult<T> initSuccCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }


    public CommonResult<T> initSuccData(T data) {
        this.data = data;
        return this;
    }
    public CommonResult<T> initSuccData(T data , String code) {
        this.data = data;
        this.code = code;
        return this;
    }
    public static <T> CommonResult<T> FAIL(String code, String msg) {
        return CommonResult.FAIL(code, msg, null);
    }
    public static <T> CommonResult<T> PARAM_FAIL(String msg) {
        return CommonResult.FAIL("100004", msg, null);
    }

    public static <T> CommonResult<T> FAIL(String code, String msg, T data) {
        CommonResult<T> result = CommonResult.Builder.FAIL();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> CommonResult<T> SUCC(String code, String msg) {
        return CommonResult.SUCC(code, msg, null);
    }

    public static <T> CommonResult<T> SUCC(String code, String msg, T data) {
        CommonResult<T> result = CommonResult.Builder.SUCC();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
