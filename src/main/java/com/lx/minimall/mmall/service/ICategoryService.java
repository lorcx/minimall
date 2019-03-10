package com.lx.minimall.mmall.service;


import com.lx.minimall.mmall.common.ServerResponse;
import com.lx.minimall.mmall.pojo.Category;

import java.util.List;

/**
 * @Author lx
 * @Date 2017/11/18 22:26
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, int parentId);

    ServerResponse updateCategoryName(int categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(int categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(int categoryId);
}
