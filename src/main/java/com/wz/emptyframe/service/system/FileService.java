package com.wz.emptyframe.service.system;

import com.wz.emptyframe.entity.system.FileInfo;
import com.wz.emptyframe.service.base.IBaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
public interface FileService extends IBaseService<FileInfo> {

    List<FileInfo> saveFile(MultipartFile[] files);
}
