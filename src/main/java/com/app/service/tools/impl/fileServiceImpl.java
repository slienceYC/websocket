package com.app.service.tools.impl;

import com.app.jpa.FileInfoRespository;
import com.app.model.FileInfo;
import com.app.service.tools.FileService;
import com.app.timing.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;

@Service
public class fileServiceImpl implements FileService {

    @Autowired
    private FileInfoRespository fileInfoRespository;

    @Override
    public FileInfo insert(FileInfo fileInfo) {
        fileInfo.setId(UUIDUtil.generate());
        fileInfo.setCreateTime(new Date());
        fileInfoRespository.save(fileInfo);
        return fileInfo;
    }

    @Override
    public byte[] getFile(String id){
        try {
            FileInfo fileInfo = fileInfoRespository.getOne(id);
            InputStream in = new FileInputStream(fileInfo.getFilePath());
            byte[] data = toByteArray(in);
            return data;
        }catch (Exception e){
            return null;
        }

    }

    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
