package com.lx.minimall.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.lx.minimall.mmall.common.ServerResponse;
import com.lx.minimall.mmall.service.IProductManageService;
import com.lx.minimall.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lx
 * @Date 2017/11/25 14:29
 */
@Controller()
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductManageService iProductManageService;

    /**
     * 获取用户详情
     * @param productId
     * @return
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(int productId) {
        return iProductManageService.getProductDetail(productId);
    }

    /**
     * 列表查询
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false)String keyword,
                                         @RequestParam(value = "categoryId" , required = false)Integer categoryId,
                                         @RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                         @RequestParam(value = "pageSize" , defaultValue = "10")int pageSize,
                                         @RequestParam(value = "orderBy" , defaultValue = "")String orderBy) {
        return iProductManageService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }
}
