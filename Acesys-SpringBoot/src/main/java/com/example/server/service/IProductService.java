package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Product;
import com.example.server.pojo.RespBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
public interface IProductService extends IService<Product> {

    RespBean addProduct(Product product);
    RespBean addProductImg(MultipartFile file);

    RespBean updateProduct(Product product);

    RespBean deleteProduct(Integer id);


}
