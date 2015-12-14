package com.badmagicbacon.paste;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pasteRecords")
public class UserRecord {
	
	@Id
	private String username;
	
	private List<PasteContent> contents = new ArrayList<PasteContent>();
	
	public UserRecord() { }
	
	public UserRecord(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<PasteContent> getContents() {
		return contents;
	}
	
	public void setContents(List<PasteContent> contents) {
		this.contents = contents;
	}

}
