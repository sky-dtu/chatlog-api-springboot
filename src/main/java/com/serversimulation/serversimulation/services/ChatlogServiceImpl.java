package com.serversimulation.serversimulation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serversimulation.serversimulation.dao.ChatlogDao;
import com.serversimulation.serversimulation.entities.Chatlog;

@Service
public class ChatlogServiceImpl implements ChatlogService {
	
	@Autowired
	private ChatlogDao chatlogDao;
	
	private ChatlogServiceImpl() {
	}
	
//	@Override
//	public List<Chatlog> getChatlogsByUser(String user_id) {
//		return chatlogDao.getAllChatlogsByUser(user_id);
//	}

	@Override
	public List<Chatlog> getChatlogsByUser(String user_id, Integer limit, Long start) {
		return chatlogDao.getAllChatlogsByUser(user_id, limit, start);
	}

	@Override
	public Long addChatlogsByUser(Chatlog chatlog) {		
		Long msgid = chatlogDao.save(chatlog).getMessageid();
		return msgid;
	}

	@Override
	public Integer deleteChatlogsByUser(String user_id) {
		return chatlogDao.deleteChatlogsByUser(user_id);
	}

	@Override
	public Integer deleteChatlogsByMsgid(String user_id, Long msgid) {
		return chatlogDao.deleteChatlogsByMsgid(user_id, msgid);
	}

}
