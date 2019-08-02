package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenDataDao;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.generator.GenDataService;
import com.wz.emptyframe.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenDataServiceImpl extends ServiceImpl<GenDataDao, GenData> implements GenDataService {

    @Autowired
    private GenDataDao genDataDao;

    //content切割符
    private static final String SPLIT_SYMBOL = "%";

    @Override
    public void saveMoreContents(GenData genData) {
        if (genData.getContent().contains(SPLIT_SYMBOL)) {
            String[] s = genData.getContent().split(SPLIT_SYMBOL);
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


}
