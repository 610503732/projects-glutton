package cn.com.git.common.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultMsg implements Serializable {

	private static final long serialVersionUID = -4022829647326354195L;

	private boolean success;
	private String msg;
	private Map<String, Object> params;

	public ResultMsg() {

	}

	public ResultMsg(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Object getParam(String key) {
		if (this.params == null)
			return null;
		return this.params.get(key);
	}

	public void addParam(String key, Object value) {
		if (this.params == null)
			this.params = new HashMap<String, Object>();
		this.params.put(key, value);
	}
}
