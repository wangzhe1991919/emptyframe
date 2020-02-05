package com.wz.emptyframe.dao.system;

import com.wz.emptyframe.dto.system.SysNavigationVO;
import com.wz.emptyframe.entity.system.SysNavigation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
@Mapper
public interface SysNavigationDao extends BaseMapper<SysNavigation> {

    List<SysNavigationVO> selectListDetail();

}
