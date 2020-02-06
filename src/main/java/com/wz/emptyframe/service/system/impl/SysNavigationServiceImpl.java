package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wz.emptyframe.constant.MsgConstant;
import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.dto.system.SysNavigationIndexVO;
import com.wz.emptyframe.dto.system.SysNavigationVO;
import com.wz.emptyframe.entity.system.SysNavigation;
import com.wz.emptyframe.dao.system.SysNavigationDao;
import com.wz.emptyframe.service.system.SysNavigationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<SysNavigationVO> list = sysNavigationDao.selectListDetail();
        return list;
    }

    @Override
    public Object listDetailIndex() {
        List<SysNavigationVO> list = sysNavigationDao.selectListDetail();
        return group(list);
    }

    /**
     * 分组返回
     * @param list
     * @return
     */
    private List<SysNavigationIndexVO> group(List<SysNavigationVO> list) {
        List<SysNavigationIndexVO> indexVOList = new ArrayList<>();

        list.forEach(o -> {
            List<SysNavigationVO> tmp = getByGroupId(indexVOList,o.getGroupId());
            //未添加过分组的
            if (tmp == null) {
                SysNavigationIndexVO sysNavigationIndexVO = new SysNavigationIndexVO();
                sysNavigationIndexVO.setGroupId(o.getGroupId());
                sysNavigationIndexVO.setGroupName(o.getGroupName());
                List<SysNavigationVO> tmpList = new ArrayList<SysNavigationVO>();
                tmpList.add(o);
                sysNavigationIndexVO.setNavigationVOList(tmpList);
                indexVOList.add(sysNavigationIndexVO);
            } else {
                tmp.add(o);
            }
        });
        return indexVOList;
    }

    /**
     * 查询列表是是否已经有该分组数据了
     * @param list
     * @param groupId
     * @return
     */
    private List<SysNavigationVO> getByGroupId(List<SysNavigationIndexVO> list,String groupId) {
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getGroupId().equals(groupId)) {
                return list.get(i).getNavigationVOList();
            }
        }
        return null;
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
