package com.app.dwong.api.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.app.dwong.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

    @Autowired
    private MongoOperations mongo;

    public int getNextSequence(String seqName)
    {
        Sequence counter = mongo.findAndModify(
                query(where("name").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSeq();
    }

}
