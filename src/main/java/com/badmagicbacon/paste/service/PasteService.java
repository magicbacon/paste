package com.badmagicbacon.paste.service;

import com.badmagicbacon.paste.PasteContent;
import com.badmagicbacon.paste.PasteUser;

public interface PasteService {
	
	void createUser(PasteUser user);

	void copy(PasteContent content, String username);

	PasteContent paste(String username);

}
