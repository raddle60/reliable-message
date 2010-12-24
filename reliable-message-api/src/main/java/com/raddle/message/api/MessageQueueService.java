package com.raddle.message.api;

import java.util.Map;

import com.raddle.message.exception.AlreadyExistsException;
import com.raddle.message.exception.MessageExistsException;
import com.raddle.message.exception.NotExistsException;

public interface MessageQueueService {
	/**
	 * 注册持久的队列
	 * 
	 * @param queueId 队列id，必须唯一
	 * @param desc 队列的描述
	 * @throws AlreadyExistsException 如果队列已经存在
	 */
	public void registerQueue(String queueId, String desc) throws AlreadyExistsException;

	/**
	 * 注册持久的队列，带超时时间
	 * 
	 * @param queueId queueId 队列id，必须唯一
	 * @param desc 队列的描述
	 * @param expireSecondsIfNoMessage 队列中无消息，过expireSeconds就删除
	 * @throws AlreadyExistsException 如果队列已经存在
	 */
	public void registerTemporaryQueue(String queueId, String desc, int expireSecondsIfNoMessage) throws AlreadyExistsException;

	/**
	 * 队列是否存在
	 * 
	 * @param topicId 队列id
	 * @return true存在，false 不存在
	 */
	public boolean isQueueExists(String topicId);

	/**
	 * 删除队列
	 * 
	 * @param queueId 队列id
	 * @param force true不管队列中是否存在未发送的消息
	 * @throws MessageExistsException 如果force为false队列中有消息存在
	 * @throws NotExistsException 队列不存在
	 */
	public void unregisterQueue(String queueId, boolean force) throws MessageExistsException, NotExistsException;

	/**
	 * 向队列发送消息
	 * 
	 * @param queueId 队列id
	 * @param headers 消息头
	 * @param body 消息体
	 * @param expireSeconds 过期时间，-1表示永不过期
	 * @throws NotExistsException 队列不存在
	 */
	public void sendMessageToQueue(String queueId, Map<String, String> headers, byte[] body, int expireSeconds) throws NotExistsException;

	/**
	 * 连接到队列接收消息，多个客户端连接，每个消息只发给其中一个客户端
	 * 
	 * @param queueId 队列id
	 * @param receiver 接收回调
	 * @throws NotExistsException 队列不存在
	 */
	public void connectQueue(String queueId, MessageReceiver receiver) throws NotExistsException;
}
