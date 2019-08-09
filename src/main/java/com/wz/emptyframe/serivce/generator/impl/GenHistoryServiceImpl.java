package com.wz.emptyframe.serivce.generator.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.generator.GenHistoryDao;
import com.wz.emptyframe.entity.generator.GenHistory;
import com.wz.emptyframe.serivce.generator.GenHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenHistoryServiceImpl extends ServiceImpl<GenHistoryDao, GenHistory> implements GenHistoryService {
}
