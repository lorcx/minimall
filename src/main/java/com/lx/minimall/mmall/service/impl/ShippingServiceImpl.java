package com.lx.minimall.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.lx.minimall.mmall.common.ServerResponse;
import com.lx.minimall.mmall.dao.ShippingMapper;
import com.lx.minimall.mmall.pojo.Shipping;
import com.lx.minimall.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 收货地址管理
 * @Author lx
 * @Date 2017/11/26 12:32
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    /**
     * 新增收货地址
     * @param shipping
     * @return
     */
    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
        // 防止横向越权
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0) {
            Map result = Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess(result);
        }
        return ServerResponse.createByErrorMessage("新增收货地址失败");
    }

    /**
     * 更新收货地址
     * @param userId
     * @param shipping
     * @return
     */
    @Override
    public ServerResponse update(Integer userId, Shipping shipping) {
        // 防止横向越权
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByShipping(shipping);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("更新收货地址成功");
        }
        return ServerResponse.createByErrorMessage("更新收货地址失败");
    }

    /**
     * 删除收货地址
     * @param userId
     * @param shippingId
     * @return
     */
    @Override
    public ServerResponse del(Integer userId, Integer shippingId) {
        // 防止横向越权
        int rowCount = shippingMapper.deleteByUserIdShippingId(userId, shippingId);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("删除货地址成功");
        }
        return ServerResponse.createByErrorMessage("删除收货地址失败");
    }

    /**
     * 查询收货地址
     * @param userId
     * @param shippingId
     * @return
     */
    @Override
    public ServerResponse select(Integer userId, Integer shippingId) {
        // 防止横向越权
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if (shipping == null) {
            return ServerResponse.createByErrorMessage("无法查询到该收货地址");
        }
        return ServerResponse.createBySuccess("查询成功", shipping);
    }

    /**
     * 查询收货地址列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
