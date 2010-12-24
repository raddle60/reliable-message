package com.raddle.message.api;

import java.util.Map;

import com.raddle.message.exception.AlreadyExistsException;
import com.raddle.message.exception.ExistsMessageException;
import com.raddle.message.exception.NotExistException;

public interface MessageQueueService {
	/**
	 * 注册持久的队列
	 * @param queueId 队列id，必须唯一
	 * @param desc 队列的描述
	 * @throws AlreadyExistsException 如果队列已经存在
	 */
	public void registerQueue(String queueId, String desc) throws AlreadyExistsException;

	/**
	 * 注册持久的队列，带超时时间
	 * @param queueId queueId 队列id，必须唯一
	 * @param desc 队列的描述
	 * @param expireSecondsIfNoMessage 队列中无消息，过expireSeconds就删除
	 * @throws AlreadyExistsException 如果队列已经存在
	 */
	public void registerTemporaryQueue(String queueId, String desc, int expireSecondsIfNoMessage) throws AlreadyExistsException;

	/**
	 * 删除队列
	 * @param queueId 队列id
	 * @param force true不管队列中是否存在未发送的消息
	 * @throws ExistsMessageException 如果force为false队列中有消息存在
	 * @throws NotExistException 队列不存在
	 */
	public void unregisterQueue(String queueId, boolean force) throws ExistsMessageException, NotExistException;

	/**
	 * 向队列发送消息
	 * @param queueId 队列id
	 * @param headers 消息头
	 * @param body 消息体
	 * @param expireSeconds 过期时间，-1表示永不过期
	 * @throws NotExistException 队列不存在
	 */
	public void sendMessageToQueue(String queueId, Map<String, String> headers, byte[] body, int expireSeconds) throws NotExistException;

	/**
	 * 连接到队列接收消息，多个客户端连接，每个消息只发给其中一个客户端
	 * @param queueId 队列id
	 * @param receiver 接收回调
	 * @throws NotExistException 队列不存在
	 */
	public void connectQueue(String queueId, MessageReceiver receiver) throws NotExistException;
}
