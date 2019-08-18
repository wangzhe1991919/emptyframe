package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenDataDao;
import com.wz.emptyframe.dto.generator.GeneratorDataQuery;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.generator.GenDataService;
import com.wz.emptyframe.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GenDataServiceImpl extends ServiceImpl<GenDataDao, GenData> implements GenDataService {

    @Autowired
    private GenDataDao genDataDao;

    @Override
    public void saveMoreContents(int genTypeId,String contents,String split) {
        if (contents.contains(split)) {
            String[] s = contents.split(split);
            for (String content : s) {
                if (StringUtil.isNotEmpty(content)) {
                    GenData o = new GenData(StringUtil.getUUID(),genTypeId,content);
                    genDataDao.insert(o);
                }
            }
        } else {
            GenData genData = new GenData(StringUtil.getUUID(),genTypeId,contents);
            genDataDao.insert(genData);
        }
    }

    @Override
    public List<GenData> listByParam(GeneratorDataQuery param) {
        QueryWrapper qw = param.getCondition();
        return genDataDao.selectList(qw);
    }


}
