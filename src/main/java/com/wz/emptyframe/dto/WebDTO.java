package com.wz.emptyframe.dto;


import com.wz.emptyframe.constant.MsgConstant;

/**
 * 统一返回数据传输类
 * @author ta0546 wz
 * @time 2018-09-04
 */
public class WebDTO {
	/**
	 * 返回状态 true成功， false失败
	 */
	private int code;
	/**
	 * 成功或失败内容提示
	 */
	private String message;
	/**
	 * 相关数据
	 */
	private Object data;


    WebDTO(int code,String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
	
	/**
	 * 成功提示
	 * @param message  消息
	 * @param data 数据
	 * @return
	 */
	public static Object success(String message,Object data) {
		return new WebDTO(MsgConstant.RESPONSECODE_200,message,data);
	}
	/**
	 * 失败提示
	 * @param message  消息
	 * @param data 数据
	 * @return
	 */
	public static Object faliure(String message,Object data) {
		return new WebDTO(MsgConstant.RESPONSECODE_500,message,data);
	}
	/**
	 * 成功提示
	 * @param data 数据
	 * @return
	 */
	public static Object success(Object data) {
		return WebDTO.success(MsgConstant.SUCCESS,data);
	}
	/**
	 * 成功提示
	 * @return
	 */
	public static Object success() {
        return WebDTO.success(MsgConstant.SUCCESS);
    }
	/**
	 * 失败提示
	 * @param data 数据
	 * @return
	 */
	public static Object faliure(Object data) {
		return WebDTO.faliure(MsgConstant.FAIL,data);
	};
	
	/**
	 * 返回（状态自定义）
	 * @param code
	 * @param data
	 * @return
	 */
	public static Object response(int code,String message,String data) {
	    return new WebDTO(code,"",data);
	}
	
	/**
     * 返回（状态自定义，重载）
     * @param b
     * @param b
     * @return
     */
    public static Object response(int b) {
        return response(b,"","");
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
