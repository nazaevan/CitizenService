package com.mentoring.project.demo.controller;

import com.mentoring.project.demo.model.FileRequest;
import com.mentoring.project.demo.service.FileRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/ms/mentoring-demo/", produces = {(MediaType.APPLICATION_JSON_VALUE)})
public class UploadFileController {

    @Autowired
    FileRequestService fileRequestService;


    @Autowired
    private Environment env;



    @PostMapping(value = "/uploadFile")
    public FileRequest fileUpload(@RequestParam("File") MultipartFile file, @RequestParam("id_request") Long id_request) throws IOException {
        FTPClient client = new FTPClient();

        String sFTP = env.getProperty("ftp.configuration.host");
        String sUser = env.getProperty("ftp.configuration.user");
        String sPassword = env.getProperty("ftp.configuration.pass");

        FileRequest fileRequest = null;
        try {
            client.connect(sFTP);
            boolean login = client.login(sUser, sPassword);
            if(login) {
                client.makeDirectory("REQUEST"+id_request);
                client.changeWorkingDirectory("REQUEST"+id_request);
                MultipartFile fileToUpload = file;
                String remoteFile = file.getOriginalFilename();
                InputStream inputStream = file.getInputStream();
                boolean isUploaded = client.storeFile(remoteFile, inputStream);
                inputStream.close();
                if (isUploaded) {
                    fileRequest = fileRequestService.createFileRequest(id_request,client.printWorkingDirectory(),remoteFile);
                }
            }
        }catch (IOException ioe) {
            return null;
        }
        return fileRequest;
    }


}
