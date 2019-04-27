package com.app.jpa;

import com.app.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fyc
 * jpa 文件保存接口
 */
public interface FileInfoRespository extends JpaRepository<FileInfo,String> {

}
