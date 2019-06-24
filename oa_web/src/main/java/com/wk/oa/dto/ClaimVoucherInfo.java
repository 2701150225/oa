package com.wk.oa.dto;

import com.wk.oa.entity.ClaimVoucher;
import com.wk.oa.entity.ClaimVoucherItem;

import java.util.List;

public class ClaimVoucherInfo {
     private ClaimVoucher claimVoucher;
     private List<ClaimVoucherItem> items;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
