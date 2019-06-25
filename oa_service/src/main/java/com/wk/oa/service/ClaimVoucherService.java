package com.wk.oa.service;


import com.wk.oa.entity.ClaimVoucher;
import com.wk.oa.entity.ClaimVoucherItem;
import com.wk.oa.entity.DealRecord;

import java.util.List;

public interface ClaimVoucherService {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);

    List<ClaimVoucherItem> getItems(int cvid);

    List<DealRecord> getRecords(int cvid);

     List<ClaimVoucher> getForSelf(String sn);
}


