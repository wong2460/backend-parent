package com.wong.backend_test.quartz.dao.mapper;

import com.wong.backend_test.quartz.dao.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wong
 * @since 2020-06-05
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
