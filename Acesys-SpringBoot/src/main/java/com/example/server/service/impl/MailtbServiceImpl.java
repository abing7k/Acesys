package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.MailtbMapper;
import com.example.server.pojo.Mailtb;
import com.example.server.service.IMailtbService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Service
public class MailtbServiceImpl extends ServiceImpl<MailtbMapper, Mailtb> implements IMailtbService {

}
