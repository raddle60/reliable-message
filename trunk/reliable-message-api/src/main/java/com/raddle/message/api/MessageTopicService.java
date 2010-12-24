package com.raddle.message.api;

import java.util.Map;

import com.raddle.message.exception.AlreadyExistsException;
import com.raddle.message.exception.ExistsMessageException;
import com.raddle.message.exception.NotExistException;

public interface MessageTopicService {

	/**
	 * 注册持久主题
	 * 
	 * @param topicId 主题id，必须唯一
	 * @param desc 主题描述
	 * @throws AlreadyExistsException 主题已经存在
	 */
	public void registerTopic(String topicId, String desc) throws AlreadyExistsException;

	/**
	 * 注册持久主题
	 * 
	 * @param topicId 主题id，必须唯一
	 * @param desc 主题描述
	 * @param expireSecondsIfNoMessage 主题中无消息，过expireSeconds就删除
	 * @throws AlreadyExistsException 主题已经存在
	 */
	public void registerTemporaryTopic(String topicId, String desc, int expireSecondsIfNoMessage) throws AlreadyExistsException;

	/**
	 * 主题是否存在
	 * 
	 * @param topicId 主题id
	 * @return true存在，false 不存在
	 */
	public boolean isTopicExists(String topicId);

	/**
	 * 删除主题
	 * 
	 * @param topicId 主题id
	 * @param force true不管主题中是否存在未发送的消息
	 * @throws ExistsMessageException 如果force为false队列中有消息存在
	 * @throws NotExistException 主题不存在
	 */
	public void unregisterTopic(String topicId, boolean force) throws ExistsMessageException, NotExistException;

	/**
	 * 发送消息到主题
	 * 
	 * @param topicId 主题id
	 * @param headers 消息头
	 * @param body 消息体
	 * @param expireSeconds 过期时间，-1表示永不过期
	 * @throws NotExistException 主题不存在
	 */
	public void sendMessageToTopic(String topicId, Map<String, String> headers, byte[] body, int expireSeconds) throws NotExistException;

	/**
	 * 连接到主题，接收消息，同一组的客户端，消息只发送给其中一个
	 * 
	 * @param topicId 主题id
	 * @param receiverId 接收者id，必须唯一
	 * @param groupId 组id，如果存在，就加入，不存在就创建
	 * @param receiver 接收者
	 * @throws NotExistException 主题不存在
	 * @throws AlreadyExistsException 同receiverId的接收者已存在
	 */
	public void connectTopic(String topicId, String receiverId, String groupId, MessageReceiver receiver) throws NotExistException, AlreadyExistsException;
	
	/**
	 * 接收者是否存在
	 * @param topicId 主题id
	 * @param receiverId 接收者id
	 * @return true存在，false不存在
	 * @throws NotExistException 主题不存在
	 */
	public boolean isReceiverExists(String topicId,String receiverId) throws NotExistException;
}
