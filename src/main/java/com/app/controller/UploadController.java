package com.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.app.model.FileInfo;
import com.app.model.JsonObjectBO;
import com.app.service.tools.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    private static final String UPLOADED_FOLDER = "C:\\fileUpload\\";

    @Autowired
    private FileService fileService;

    @RequestMapping("/fileUpload")
    public JsonObjectBO singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
           return JsonObjectBO.error("请上传文件");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFilePath(UPLOADED_FOLDER + file.getOriginalFilename());
            fileInfo.setFileName(file.getOriginalFilename());
//            String ext = file.getName().split(".")[1];
//            fileInfo.setFileExt(ext);
            FileInfo fileInfo1 = fileService.insert(fileInfo);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("file",fileInfo1);
            return JsonObjectBO.success("上传成功",jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
            return JsonObjectBO.exception("上传失败");
        }
    }

    @RequestMapping("/fileDownload")
    public ResponseEntity<byte[]> fileDownload(@RequestParam String id){
        try {
            byte[] fileData = fileService.getFile(id);
            //请求头
            HttpHeaders headers = new HttpHeaders();
            //application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(fileData, headers, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
