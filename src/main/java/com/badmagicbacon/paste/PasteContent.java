package com.badmagicbacon.paste;

import org.joda.time.DateTime;

public class PasteContent {
	
	private String content;
	private DateTime timestamp;
	
	public PasteContent() {
		timestamp = new DateTime();
	}
	
	public PasteContent(String content, DateTime timestamp) {
		this.content = content;
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public DateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "PasteContent [content=" + content + ", timestamp=" + timestamp + "]";
	}
	
}
