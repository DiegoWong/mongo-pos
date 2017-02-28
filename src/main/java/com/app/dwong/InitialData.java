package com.app.dwong;

import com.app.dwong.model.Sequence;
import com.app.dwong.repositories.SequenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(value = "initial.data", havingValue = "true")
@Component
public class InitialData implements ApplicationListener<ContextRefreshedEvent> {
    private final static Logger LOG = LoggerFactory.getLogger(InitialData.class);


    private SequenceRepository sequenceRepository;

    @Autowired
    public InitialData(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("Loading sample data");


        if (sequenceRepository.count() == 0 ) {

            Sequence sequence = sequenceRepository.save(new Sequence("invoice", 0));

            LOG.info("Added {} Sequence", sequence.getName());
        } else {
            LOG.info("Database is not empty. No sample data will be loaded.");
        }

    }


}