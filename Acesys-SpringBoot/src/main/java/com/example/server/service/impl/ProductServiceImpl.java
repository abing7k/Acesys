package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.ProductMapper;
import com.example.server.pojo.Product;
import com.example.server.pojo.RespBean;
import com.example.server.service.IProductService;
import com.example.server.utils.FdfsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public RespBean addProduct(Product product) {
        if (productMapper.insert(product) > 0) {
            return RespBean.success("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @Override
    public RespBean addProductImg(MultipartFile file) {
        if (file != null) {
            return RespBean.success("上传成功", FdfsUtils.URL + FdfsUtils.upload(file));
        } else {
            return RespBean.error("上传失败");
        }
    }

    @Override
    public RespBean updateProduct(Product product) {
        System.out.println(product);
        if (product.getImage() == null || "".equals(product.getImage())) {
            product.setImage(productMapper.getImageById(product.getId()));
        }
        if (productMapper.updateById(product) > 0) {
            return RespBean.success("修改成功");
        } else {
            return RespBean.error("修改失败");
        }
    }

    @Override
    public RespBean deleteProduct(Integer id) {
        if (productMapper.deleteById(id) >= 1) {
            return RespBean.success("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }
}
