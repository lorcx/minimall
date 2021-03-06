package com.lx.minimall.mmall.service;

import com.github.pagehelper.PageInfo;
import com.lx.minimall.mmall.common.ServerResponse;
import com.lx.minimall.mmall.pojo.Product;
import com.lx.minimall.mmall.vo.ProductDetailVo;

/**
 * @Author lx
 * @Date 2017/11/19 13:43
 */
public interface IProductManageService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> productSearch(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId,
                                                         int pageNum, int pageSize, String orderBy);
}
