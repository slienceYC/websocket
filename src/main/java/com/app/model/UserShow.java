package com.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author fyc
 * 用户分享实体
 */

@Data
@Entity
public class UserShow {
    @Id
    private String id;
    private String userId;
    private String title;
    private String content;
    private String imagePath;
    private int likeNum;
    private String userImage;
    private Date createTime;
}
