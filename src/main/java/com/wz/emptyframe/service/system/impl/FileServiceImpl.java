package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.system.FileDao;
import com.wz.emptyframe.entity.system.FileInfo;
import com.wz.emptyframe.service.system.FileService;
import com.wz.emptyframe.util.file.SftpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wangzhe
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileDao, FileInfo> implements FileService{

    private static final String SYSTEM_NAME = "wangzhe";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<FileInfo> saveFile(MultipartFile[] files) {
        List<FileInfo> fileInfoList = SftpUtils.uploadMultipart(files, SYSTEM_NAME);
        saveBatch(fileInfoList);
        return fileInfoList;
    }
}
