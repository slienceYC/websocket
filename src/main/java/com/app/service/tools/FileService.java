package com.app.service.tools;

import com.app.model.FileInfo;

public interface FileService {
    FileInfo insert(FileInfo fileInfo);

    byte[] getFile(String id);
}
