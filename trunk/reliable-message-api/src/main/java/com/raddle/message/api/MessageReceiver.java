/**
 * 
 */
package com.raddle.message.api;

import java.util.Map;

/**
 * 接收消息
 * 
 * @author xurong
 * 
 */
public interface MessageReceiver {
	/**
	 * 接收成功
	 */
	public static final int RECEIVE_SUCCESS = 1;
	/**
	 * 接收失败
	 */
	public static final int RECEIVE_FAILED = -1;

	/**
	 * 接收消息
	 * 
	 * @param metas 消息的元信息，有消息系统加上
	 * @param headers 消息头信息，由发送者加上
	 * @param body 消息体
	 * @return 接收成功或失败，任何异常都认为是失败，失败或超时，服务器都会重发
	 */
	public int messageReceived(Map<String, String> metas, Map<String, String> headers, byte[] body) throws Throwable;
}
