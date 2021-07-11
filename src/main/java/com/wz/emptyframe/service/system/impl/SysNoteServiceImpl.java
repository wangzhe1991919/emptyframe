package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.constant.MsgConstant;
import com.wz.emptyframe.dao.system.SysNoteDao;
import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.entity.system.SysNote;
import com.wz.emptyframe.entity.system.User;
import com.wz.emptyframe.service.system.SysNoteService;
import com.wz.emptyframe.util.common.UUIDUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class SysNoteServiceImpl extends ServiceImpl<SysNoteDao, SysNote> implements SysNoteService {

    @Resource
    private SysNoteDao sysNoteDao;

    @Override
    public Object listNewCurrUser() {
        //当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            return WebDTO.faliure(MsgConstant.PLEASE_LOGIN);
        }
        QueryWrapper<SysNote> qw = new QueryWrapper();
        qw.eq("create_user", user.getId());
        qw.orderByDesc("create_time");
        List<SysNote> list = sysNoteDao.selectList(qw);

        SysNote result = null;
        if (list.size() > 0) {
            result = list.get(0);
        }
        return WebDTO.success(result);
    }

    @Override
    public SysNote saveAndCreateNote(SysNote sysNote) {
        //首先存储旧的笔记
        saveOrUpdate(sysNote);
        //创建一条新的笔记,将时间设置为当前时间，ID设置为新的
        sysNote.setId(UUIDUtils.uuid());
        sysNote.setCreateTime(new Date());
        sysNoteDao.insert(sysNote);
        return sysNote;
    }
}
