package com.wk.oa.dao;

import com.wk.oa.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByCreateSn(String csn);  //查询某个创建者的报销单
    List<ClaimVoucher> selectByNextDealSn(String ndsn); //查询某个处理人的报销单

}
