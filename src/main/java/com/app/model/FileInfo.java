package com.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author fyc
 * 文件信息实体类
 */
@Data
@Entity
public class FileInfo {
    @Id
    private String id;
    private String fileName;
    private String fileExt;
    private String filePath;
    private Date createTime;
}
