package com.wk.oa.service.impl;

import com.wk.oa.dao.ClaimVoucherDao;
import com.wk.oa.dao.ClaimVoucherItemDao;
import com.wk.oa.dao.DealRecordDao;
import com.wk.oa.entity.ClaimVoucher;
import com.wk.oa.entity.ClaimVoucherItem;
import com.wk.oa.entity.DealRecord;
import com.wk.oa.global.Contant;
import com.wk.oa.service.ClaimVoucherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("claimVoucherService")
public class ClaimVoucherServiceImpl implements ClaimVoucherService {

    @Resource
    private ClaimVoucherDao claimVoucherDao;
    @Resource
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Resource
    private DealRecordDao dealRecordDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
         claimVoucher.setCreateTime(new Date());
         claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
         claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
         claimVoucherDao.insert(claimVoucher);

         for (ClaimVoucherItem item:items){
             item.setClaimVoucherId(claimVoucher.getId());
             claimVoucherItemDao.insert(item);
         }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

}
