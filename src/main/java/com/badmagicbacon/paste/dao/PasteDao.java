package com.badmagicbacon.paste.dao;

import com.badmagicbacon.paste.PasteContent;
import com.badmagicbacon.paste.UserRecord;

public interface PasteDao {

	void createUser(UserRecord record);

	void copy(PasteContent content, String username);

	PasteContent paste(String username);

}
