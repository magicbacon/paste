package com.badmagicbacon.paste.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.badmagicbacon.paste.PasteContent;
import com.badmagicbacon.paste.UserRecord;
import com.badmagicbacon.paste.PasteUser;
import com.badmagicbacon.paste.dao.PasteDao;
import com.badmagicbacon.paste.service.PasteService;

@Service("pasteService")
public class PasteServiceImpl implements PasteService {
	
	@Resource(name = "pasteDao")
	private PasteDao pasteDao;
	
	@Override
	public void createUser(PasteUser user) {
		pasteDao.createUser(new UserRecord(user.getUsername()));
	}

	@Override
	public void copy(PasteContent content, String username) {
		pasteDao.copy(content, username);
	}

	@Override
	public PasteContent paste(String username) {
		return pasteDao.paste(username);
	}

}
