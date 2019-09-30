package com.wz.emptyframe.util.file;

import com.jcraft.jsch.*;
import com.wz.emptyframe.entity.system.FileInfo;
import com.wz.emptyframe.util.common.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * 类说明 sftp工具类
 */

public class SftpUtils {

    private static final Logger logger = LoggerFactory.getLogger(SftpUtils.class);

    /**
     * SFTP上传文件
     * @param multipartFile
     * @param uploadFilePath
     * @return
     */
    public static List<FileInfo> uploadMultipart(MultipartFile[] multipartFile, String uploadFilePath) {
        if (multipartFile.length > 5) {
            throw new RuntimeException("一次最多只能上传5个文件！");
        }
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (MultipartFile file : multipartFile) {
            FileInfo fileInfo = uploadMultipart(file,uploadFilePath);
            fileInfoList.add(fileInfo);
        }
        return fileInfoList;
    }

    /**
     * SFTP上传文件
     *
     * @param multipartFile
     * @param uploadFilePath 保存路径由用户指定，不指定为null
     */
    public static FileInfo uploadMultipart(MultipartFile multipartFile, String uploadFilePath) {
        FileInfo fileInfo = new FileInfo();
        File file = new File(multipartFile.getOriginalFilename());
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            String fileUpload = uploadToServer(file, uploadFilePath);
            //构造文件信息
            fileInfo.setId(UUIDUtils.uuid());
            fileInfo.setFileName(multipartFile.getOriginalFilename());
            fileInfo.setFileSize(multipartFile.getSize()/1024);
            fileInfo.setFileUrl(fileUpload);
            fileInfo.setFileType(getFileType(multipartFile.getOriginalFilename()));
            fileInfo.setCreateTime(new Date());
            fos.close();
            //删除临时文件
            file.delete();
            return fileInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从SFTP服务器下载文件
     * @param url
     * @param fileName
     * @param response
     */
    public static void downloadFile(String url, String fileName, HttpServletResponse response) {
        try {
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/octet-stream");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            SftpUtils.setOutputStream(url, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            response.reset();
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * 上传文件至FTP服务器
     * @param file 文件
     * @param uploadFilePath 保存路径（配置文件根路径之后的路径）
     */
    public static String uploadToServer(File file, String uploadFilePath) {
        OutputStream outstream = null;
        InputStream instream = null;
        try {
            ChannelSftp sftp = SftpUtils.connect();
            logger.info("开始上传文件：" + file.getName());
            //进入保存目录
            String directory = cdDirectory(sftp, uploadFilePath);
            //重命名文件
            String newFileName = UUIDUtils.uuid() + file.getName().substring(file.getName().lastIndexOf("."));
            outstream = sftp.put(newFileName);
            instream = new FileInputStream(file);
            byte b[] = new byte[1024];
            int n;
            while ((n = instream.read(b)) != -1) {
                outstream.write(b, 0, n);
            }
            outstream.flush();
            outstream.close();
            instream.close();
            sftp.getSession().disconnect();
            logger.info(newFileName + "上传服务器成功！");
            return directory + "/" + newFileName;
        } catch (Exception e) {
            try {
                if (outstream != null) {
                    outstream.close();
                }
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e1) {
                logger.info("上传失败" + e.getMessage());
            }
            return null;
        }
    }

    /**
     * 上传附件，返回保存路径
     *
     * @param request
     * @return
     */
    public static List<String> uploadFile(HttpServletRequest request, String filePath) throws IOException {
        List<String> savePaths = new ArrayList<String>();
        MultipartHttpServletRequest mul = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = mul.getFileMap();
        for (MultipartFile multipartFile : files.values()) {
            FileInfo fileInfo = uploadMultipart(multipartFile, filePath);
            savePaths.add(fileInfo.getFileUrl());
        }
        return savePaths;
    }

    /**
     * 删除文件
     *
     * @param path 文件路径
     */
    public static void delete(String path) throws Exception {
        if (path != null && !"".equals(path)) {
            ChannelSftp sftp = SftpUtils.connect();
            logger.info("开始删除文件：" + path);
            //截取相对路径
            //String directory = path.substring(SfptEnum.getName("HTTP").length(), path.lastIndexOf("/"));
            //sftp.cd(SfptEnum.getName("PATH") + directory);
            //拼接绝对路径
            String s = SfptEnum.getName("PATH") + path;
            sftp.cd(s.substring(0, s.lastIndexOf("/")));
            sftp.rm(path.substring(path.lastIndexOf("/") + 1));
        }
    }

    /**
     * 从SFTP下载文件
     *
     * @param saveFile
     * @throws UnsupportedEncodingException void
     * @throws SftpException
     * @throws JSchException
     */
    public static void download(String filePath, String saveFile) throws UnsupportedEncodingException,
            SftpException, JSchException {
        // 避免通道关闭,每次新开一个连接
        ChannelSftp sftp = SftpUtils.connect();
        Vector<?> vector = sftp.ls(filePath);
        if (vector.size() > 0) {
            Iterator<?> iterator = vector.iterator();
            while (iterator.hasNext()) {
                ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) iterator.next();
                downLoadFile(filePath, entry.getFilename(), saveFile);
            }
        }
        sftp.getSession().disconnect();
    }

    /**
     * downLoadFile:下载数据. <br/>
     *
     * @param @param file
     * @param @param saveFile
     * @param @param sftp 参数
     * @return void 返回类型
     * @throws
     * @author ta0316 Wyd
     * @Title: downLoadFile
     */
    public static void downLoadFile(String filePath, String fileName, String saveFile) {
        if (!fileName.equals(".") && !fileName.equals("..")) {
            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(saveFile + "/" + fileName);
                ChannelSftp sftp = SftpUtils.connect();
                //
                sftp.cd(filePath);
                sftp.get(fileName, outputStream);
                // 下载后删除文件
                //sftp.rm(fileName);
                logger.info(fileName + "从服务器下载成功！");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (SftpException e) {
                System.out.println(e.getMessage());
            } catch (JSchException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("此次无文件需要被下载！");
        }
    }

    /**
     * @Description: 设置outputStream
     * @Param: [url 文件url, outputStream 输出流]
     * @return: void
     * @Author: wt1186
     * @Date: 2018/7/19
     */
    public static void setOutputStream(String url, OutputStream outputStream) throws JSchException, SftpException {
        String absolutePath = SfptEnum.getName("PATH") + url;//绝对路径
        String filePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));//文件路径
        String fileName = url.substring(url.lastIndexOf("/") + 1);//文件名字
        ChannelSftp sftp = SftpUtils.connect();
        sftp.cd(filePath);
        sftp.get(fileName, outputStream);
    }

    /**
     * 进入保存目录，不存在创建
     *
     * @param sftp
     * @param uploadFilePath
     * @return
     */
    public static String cdDirectory(ChannelSftp sftp, String uploadFilePath) {
        //创建保存路径
        Calendar now = Calendar.getInstance();
        //获取年
        int year = now.get(Calendar.YEAR);
        //获取月
        int month = now.get(Calendar.MONTH) + 1;
        //获取日
        int day = now.get(Calendar.DAY_OF_MONTH);
        if (uploadFilePath != null && !"".equals(uploadFilePath)) {
            uploadFilePath = "/" + uploadFilePath + "/" + year + "/" + month + "/" + day;
        }
        else {
            uploadFilePath = "/" + year + "/" + month + "/" + day;
        }
        String savePath = SfptEnum.getName("PATH") + uploadFilePath;
        try {
            sftp.cd(savePath);
        } catch (Exception e) {
            logger.info("文件夹不存在，开始创建文件夹。");
            //目录不存在，则创建文件夹
            String[] dirs = savePath.split("/");
            String tempPath = "";
            for (String dir : dirs) {
                if (null == dir || "".equals(dir)) {
                    continue;
                }
                tempPath += "/" + dir;
                try {
                    sftp.cd(tempPath);
                } catch (SftpException ex) {
                    try {
                        sftp.mkdir(tempPath);
                        sftp.cd(tempPath);
                    } catch (SftpException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return uploadFilePath;
    }

    /**
     * 连接服务器
     *
     * @return
     * @throws JSchException
     */
    private static ChannelSftp connect() throws JSchException {
        Session session = null;
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            String host = SfptEnum.getName("HOST");
            String port = SfptEnum.getName("PORT");
            String password = SfptEnum.getName("PASSWORD");
            session = jsch.getSession(SfptEnum.getName("LOGINNAME"),host,
                    Integer.valueOf(port));
            session.setPassword(password);
            // 设置第一次登陆的时候提示，可选值:(ask | yes | no)
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            // 1分钟连接超时
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            e.printStackTrace();
            logger.info("SFTPUitl 获取连接发生错误");
            throw e;
        }
        return sftp;
    }


    /**
     * 根据名称获取文件类型
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName) {
        String fileType = "";
        String[] splitName = fileName.split(FileConstant.SYMBLA_POINT);
        String filenameExtension = splitName[splitName.length - 1];
        if(FileConstant.FILENAME_EXTENSION_FILE.indexOf(filenameExtension) != -1) {
            fileType = FileConstant.VALUE_ADJUNCT_FILE;
        } else if(FileConstant.FILENAME_EXTENSION_PICTURE.indexOf(filenameExtension) != -1){
            fileType = FileConstant.VALUE_ADJUNCT_PICTURE;
        } else if(FileConstant.FILENAME_EXTENSION_MV.indexOf(filenameExtension) != -1){
            fileType = FileConstant.VALUE_ADJUNCT_MV;
        } else	if(FileConstant.FILENAME_EXTENSION_AUDIO.indexOf(filenameExtension) != -1){
            fileType = FileConstant.VALUE_ADJUNCT_AUDIO;
        }else if(FileConstant.FILENAME_EXTENSION_APK.indexOf(filenameExtension) != -1) {
            fileType=FileConstant.VALUE_ADJUNCT_APK;
        }
        return fileType;
    }
}

