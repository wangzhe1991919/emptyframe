package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wz.emptyframe.constant.MsgConstant;
import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.entity.system.SysNavigation;
import com.wz.emptyframe.dao.system.SysNavigationDao;
import com.wz.emptyframe.service.system.SysNavigationService;
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
public class SysNavigationServiceImpl extends ServiceImpl<SysNavigationDao, SysNavigation> implements SysNavigationService {


    @Resource
    private SysNavigationDao sysNavigationDao;

    @Override
    public Object insert(SysNavigation sysNavigation) {
        //查看名称是否重复
        boolean repeat = checkRepeat(sysNavigation);
        if (repeat) {
            return WebDTO.faliure(MsgConstant.NAME_REPEAT, null);
        }
        sysNavigationDao.insert(sysNavigation);
        return WebDTO.success();
    }

    @Override
    public Object listDetail() {

        QueryWrapper queryWrapper = new QueryWrapper();

        List<SysNavigation> list = sysNavigationDao.selectList(null);



        return list;
    }

    /**
     * 检查字段是否重复
     * @param sysNavigation
     * @return
     */
    private boolean checkRepeat(SysNavigation sysNavigation) {
        //查看名称是否重复
        QueryWrapper<SysNavigation> qw = new QueryWrapper<SysNavigation>();
        qw.eq("name",sysNavigation.getName());
        List<SysNavigation> list = sysNavigationDao.selectList(qw);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
