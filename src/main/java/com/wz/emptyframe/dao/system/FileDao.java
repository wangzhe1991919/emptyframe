package com.wz.emptyframe.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.emptyframe.entity.system.FileInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends BaseMapper<FileInfo> {

}
