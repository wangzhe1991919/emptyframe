package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenTypeDao;
import com.wz.emptyframe.entity.generator.GenType;
import com.wz.emptyframe.serivce.generator.GenTypeService;
import org.springframework.stereotype.Service;

@Service
public class GenTypeServiceImpl  extends ServiceImpl<GenTypeDao, GenType> implements GenTypeService {
}
