package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenDataDao;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.generator.GenDataService;
import org.springframework.stereotype.Service;

@Service
public class GenDataServiceImpl extends ServiceImpl<GenDataDao, GenData> implements GenDataService {
}
