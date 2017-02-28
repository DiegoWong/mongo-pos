package com.app.dwong.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dwong on 2/28/17.
 */
@Document(collection = "Sequence")
public class Sequence {
    @Id
    private String id;
    private String name;
    private int seq;

    public Sequence(String name, int seq) {
        this.name = name;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
