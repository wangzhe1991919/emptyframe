package com.wz.emptyframe.service.generator.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenTypeDao;
import com.wz.emptyframe.entity.generator.GenType;
import com.wz.emptyframe.service.generator.GenTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenTypeServiceImpl  extends ServiceImpl<GenTypeDao, GenType> implements GenTypeService {
}
