package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wz.emptyframe.constant.MsgConstant;
import com.wz.emptyframe.dao.system.SysNavigationDao;
import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.entity.system.SysNavigation;
import com.wz.emptyframe.entity.system.SysNavigationGroup;
import com.wz.emptyframe.dao.system.SysNavigationGroupDao;
import com.wz.emptyframe.service.system.SysNavigationGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
@Service
public class SysNavigationGroupServiceImpl extends ServiceImpl<SysNavigationGroupDao, SysNavigationGroup> implements SysNavigationGroupService {

    @Resource
    private SysNavigationGroupDao sysNavigationGroupDao;

    @Override
    public Object insert(SysNavigationGroup sysNavigationGroup) {
        //查看名称是否重复
        boolean repeat = checkRepeat(sysNavigationGroup);
        if (repeat) {
            return WebDTO.faliure(MsgConstant.NAME_REPEAT, null);
        }
        sysNavigationGroupDao.insert(sysNavigationGroup);
        return WebDTO.success();
    }

    @Override
    public Object update(SysNavigationGroup sysNavigationGroup) {
        sysNavigationGroupDao.updateById(sysNavigationGroup);
        return WebDTO.success();
    }

    /**
     * 检查字段是否重复
     * @param sysNavigationGroup
     * @return
     */
    private boolean checkRepeat(SysNavigationGroup sysNavigationGroup) {
        QueryWrapper<SysNavigationGroup> qw = new QueryWrapper<SysNavigationGroup>();
        qw.eq("name",sysNavigationGroup.getName());
        List<SysNavigationGroup> list = sysNavigationGroupDao.selectList(qw);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
