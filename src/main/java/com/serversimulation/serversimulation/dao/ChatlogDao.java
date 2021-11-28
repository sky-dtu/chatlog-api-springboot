package com.serversimulation.serversimulation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.serversimulation.serversimulation.entities.Chatlog;


public interface ChatlogDao extends CrudRepository<Chatlog, Long>{

	@Query(value = "SELECT * FROM chatlogs cl WHERE cl.userid= :user AND cl.messageid >= :startval ORDER BY cl.timestamp DESC LIMIT :limitval", nativeQuery = true)
	public List<Chatlog> getAllChatlogsByUser(@Param("user") String user_id, @Param("limitval") Integer limit, @Param("startval") Long start);

	@Query("SELECT cl FROM chatlogs cl WHERE cl.messageid= :msgid")
	public List<Chatlog> getAllChatlogsByMessageId(@Param("msgid") String msg_id);

	@Modifying
	@Query("DELETE FROM chatlogs cl WHERE cl.userid= :user")
	@Transactional
	public Integer deleteChatlogsByUser(@Param("user") String user_id);

	@Modifying
	@Query("DELETE FROM chatlogs cl WHERE cl.userid=:user AND cl.messageid=:msgid")
	@Transactional
	public Integer deleteChatlogsByMsgid(@Param("user") String user_id, @Param("msgid") Long msgid);
	
	
	
}
