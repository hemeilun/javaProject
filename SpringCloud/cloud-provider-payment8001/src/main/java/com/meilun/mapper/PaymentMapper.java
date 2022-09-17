package com.meilun.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.meilun.entities.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.meilun.entities.Payment
 */

@Repository
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}




