package com.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserCollection {

    @Id
    private String id;
    private String userId;
    private String title;
    private String imageUrl;
    private String author;
    private String link;
    private String memo;
}
