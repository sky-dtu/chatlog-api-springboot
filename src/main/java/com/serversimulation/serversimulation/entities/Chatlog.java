package com.serversimulation.serversimulation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "chatlogs")
@Entity(name = "chatlogs")
public class Chatlog {

	@Id
	@Column(name = "messageid", columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long messageid;
	
	@Column(name = "message", nullable = false, columnDefinition = "LONGTEXT")
	private String message;
	
	@Column(name = "timestamp", nullable = false, columnDefinition = "BIGINT")
	private Long timestamp;
	
	@Column(name = "issent", nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean issent;
	
	@Column(name = "userid", nullable = false, columnDefinition = "VARCHAR(16)")
	private String userid;

	public Long getMessageid() {
		return messageid;
	}

	public void setMessageid(Long messageid) {
		this.messageid = messageid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getIssent() {
		return issent;
	}

	public void setIssent(Boolean issent) {
		this.issent = issent;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Chatlog [messageid=" + messageid + ", message=" + message + ", timestamp=" + timestamp + ", issent="
				+ issent + ", userid=" + userid + "]";
	}

	public Chatlog(Long messageid, String message, Long timestamp, Boolean issent, String userid) {
		super();
		this.messageid = messageid;
		this.message = message;
		this.timestamp = timestamp;
		this.issent = issent;
		this.userid = userid;
	}

	public Chatlog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
