package com.lx.minimall.mmall.service;

import com.github.pagehelper.PageInfo;
import com.lx.minimall.mmall.common.ServerResponse;
import com.lx.minimall.mmall.pojo.Shipping;

/**
 * @Author lx
 * @Date 2017/11/26 12:32
 */
public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse del(Integer userId, Integer shippingId);

    ServerResponse select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer id, int pageNum, int pageSize);
}
