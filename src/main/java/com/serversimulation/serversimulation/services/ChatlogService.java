package com.serversimulation.serversimulation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.serversimulation.serversimulation.entities.Chatlog;

@Service
public interface ChatlogService {
	public List<Chatlog> getChatlogsByUser(String user_id, Integer limit, Long start);
	public Long addChatlogsByUser(Chatlog chatlog);
	public Integer deleteChatlogsByUser(String user_id);
	public Integer deleteChatlogsByMsgid(String user_id, Long msgid);
}
