package com.wz.emptyframe.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 文件信息实体类
 * @author ta0546 wz
 * @time 2019/9/6
 */
@TableName("sys_file")
public class FileInfo {

    private String id;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String fileUrl;
    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
