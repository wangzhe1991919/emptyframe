package com.wz.emptyframe.util.file;

/**
 * @author ta0546 wz
 * @time 2019/9/6
 */
public class FileConstant {

    public static final String SYMBLA_POINT="\\.";

    /** 附件类型值-文档 **/
    public static final String VALUE_ADJUNCT_FILE = "file";

    /** 附件类型值-图片 **/
    public static final String VALUE_ADJUNCT_PICTURE = "picture";

    /** 附件类型值-视频 **/
    public static final String VALUE_ADJUNCT_MV = "mv";

    /** 附件类型值-音频 **/
    public static final String VALUE_ADJUNCT_AUDIO = "audio";

    /** 附件类型值-音频 **/
    public static final String VALUE_ADJUNCT_APK = "apk";

    /** 文件扩展名-文档 **/
    public static  final String FILENAME_EXTENSION_FILE = "txt,doc,xls,xlsx,docx,zip";

    /** 文件扩展名-图片 **/
    public static  final String FILENAME_EXTENSION_PICTURE = "bmp,gif,jpg,pic,png,tif,JPG,PNG";

    /** 文件扩展名-视频 **/
    public static  final String FILENAME_EXTENSION_MV = "avi,mpg,mov,swf,wmv,3gp,mp4,rm,rmvb,flv";

    /** 文件扩展名-音频 **/
    public static  final String FILENAME_EXTENSION_AUDIO = "mp3,wav,aiff,mpeg,wma,vqf,flac,aac";

    /** 文件扩展名-apk安装包 **/
    public static  final String FILENAME_EXTENSION_APK = "apk";

    // 重复通讯录操作跳过
    public static final String SKIP="0";
    // 重复通讯录操作替换
    public static final String REPLACE="1";
    // 重复通讯录操作保留两者
    public static final String SAVE_TWO="2";

    // 文件超过限制
    public static final String SIZE_EXCEED_LIMIT="文件大小超出限制,不能超过1M ";
}
