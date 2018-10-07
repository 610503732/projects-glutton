package cn.com.git.common.factory;

import cn.com.git.common.entity.ResultMsg;

public class ResultMsgFactory {

	private static final boolean SUCCESS = true;
	private static final boolean FAIL = false;
	private static final String MSG_CTRL_SUCCESS = "操作成功！";
	private static final String MSG_CTRL_FAIL = "服务器异常或繁忙，操作失败！";

	private ResultMsgFactory() {

	}

	public static ResultMsg success(String msg) {
		return new ResultMsg(SUCCESS, msg);
	}

	public static ResultMsg fail(String msg) {
		return new ResultMsg(FAIL, msg);
	}

	public static ResultMsg successMsg() {
		return new ResultMsg(SUCCESS, MSG_CTRL_SUCCESS);
	}

	public static ResultMsg failMsg() {
		return new ResultMsg(FAIL, MSG_CTRL_FAIL);
	}
}
