package com.badmagicbacon.paste.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.badmagicbacon.paste.PasteContent;
import com.badmagicbacon.paste.UserRecord;
import com.badmagicbacon.paste.dao.PasteDao;

@Repository("pasteDao")
public class PasteDaoImpl implements PasteDao {
	
	@Resource(name = "mongoOperations")
	private MongoOperations mongoOperations;
	
	@Override
	public void createUser(UserRecord record) {
		mongoOperations.insert(record);
	}
	
	@Override
	public void copy(PasteContent content, String username) {
		Query findRecordByUsername = new Query(Criteria.where("username").is(username));
		Update insertContent = new Update().push("contents", content);
		mongoOperations.updateFirst(findRecordByUsername, insertContent, UserRecord.class);
	}
	
	@Override
	public PasteContent paste(String username) {
		Query findRecordByUsername = new Query(Criteria.where("username").is(username));
		UserRecord record = mongoOperations.findOne(findRecordByUsername, UserRecord.class);
		return record.getContents().isEmpty() ? null : record.getContents().get(0);
	}

}
