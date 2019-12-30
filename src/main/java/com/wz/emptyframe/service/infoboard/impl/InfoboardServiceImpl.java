package com.wz.emptyframe.service.infoboard.impl;

import com.wz.emptyframe.entity.infoboard.Infoboard;
import com.wz.emptyframe.dao.infoboard.InfoboardDao;
import com.wz.emptyframe.service.infoboard.InfoboardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-30
 */
@Service
public class InfoboardServiceImpl extends ServiceImpl<InfoboardDao, Infoboard> implements InfoboardService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object listConvert() {

        List<Infoboard> list = list();
        list.forEach(o -> {
            Map<String,Object> map = new HashMap<String,Object>();
            //经纬度
            String coords = o.getLng() + "," + o.getLat();
            //详细API阅读http://lbsyun.baidu.com/index.php?title=webapi/guide/changeposition
            map = restTemplate.getForObject("http://api.map.baidu.com/geoconv/v1/?coords="+coords+"&from=1&to=5&ak=IeZTPQkbOK3auYpr9qXFyG8ADG5R0L3Z",Map.class);
            if (map.get("status").toString().equals("0")) {
                List<Map<String,Object>> tmpList = (List)map.get("result");
                if (tmpList.size() > 0) {
                    o.setLng(tmpList.get(0).get("x").toString());
                    o.setLat(tmpList.get(0).get("y").toString());
                }
            }
        });
        return list;
    }
}
