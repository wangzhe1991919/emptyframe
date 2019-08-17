package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import com.wz.emptyframe.dao.generator.GenDataDao;
import com.wz.emptyframe.dto.generator.GeneratorDataQuery;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.generator.GenDataService;
import com.wz.emptyframe.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenDataServiceImpl extends ServiceImpl<GenDataDao, GenData> implements GenDataService {

    @Autowired
    private GenDataDao genDataDao;

    @Override
    public void saveMoreContents(GenData genData) {
        if (genData.getContent().contains(genData.getSplit())) {
            String[] s = genData.getContent().split(genData.getSplit());
            for (String content : s) {
                if (StringUtil.isNotEmpty(content)) {
                    GenData o = new GenData(StringUtil.getUUID(),genData.getGenTypeId(),content);
                    genDataDao.insert(o);
                }
            }
        } else {
            genData.setId(StringUtil.getUUID());
            genDataDao.insert(genData);
        }
    }

    @Override
    public List<GenData> listByParam(GeneratorDataQuery param) {
        QueryWrapper qw = param.getCondition();
        return genDataDao.selectList(qw);
    }


}
