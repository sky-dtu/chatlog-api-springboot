package com.serversimulation.serversimulation.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.serversimulation.serversimulation.entities.Chatlog;
import com.serversimulation.serversimulation.services.ChatlogService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chatlogs")
public class ChatlogController {
	
	@Autowired
	private ChatlogService chatlogService;

	@GetMapping("/home")
	public String home() {
		return "This is home";
	}
	
	@PostMapping("/{user}")
	public Long addChatlogByUser(@RequestBody Chatlog chatlog, @PathVariable String user) {
		chatlog.setUserid(user);
		return this.chatlogService.addChatlogsByUser(chatlog);
	}
	
	
//	@GetMapping("/{user}")
//	public List<Chatlog> getChatlogByUser(@PathVariable String user) {
//		return this.chatlogService.getChatlogsByUser(user);
//	}
	
	@GetMapping("/{user}")
	public List<Chatlog> getChatlogByUser(@PathVariable String user, @RequestParam("start") Optional<Long> start, @RequestParam("limit") Optional<Integer> limit) {
		
//		limit.orElse(10);
		
//		start.orElse((long) 0);
		
		
		return this.chatlogService.getChatlogsByUser(user, limit.orElse(10), start.orElse((long) 0));
	}
	
	
	
	@DeleteMapping("/{user}")
	public ResponseEntity<HttpStatus> deleteChatlogsByUser(@PathVariable String user) {
		try {
			Integer res = this.chatlogService.deleteChatlogsByUser(user);
			
			// HTTP Response for User ID Not Found
			if(res == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/{user}/{msgid}")
	public ResponseEntity<HttpStatus> deleteChatlogsByMsgid(@PathVariable String user, @PathVariable Long msgid) {
		try {
			Integer res = this.chatlogService.deleteChatlogsByMsgid(user, msgid);
			
			// HTTP Response for Message ID Not Found
			if(res == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
