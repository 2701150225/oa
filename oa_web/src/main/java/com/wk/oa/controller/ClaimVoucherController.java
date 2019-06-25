package com.wk.oa.controller;

import com.wk.oa.dto.ClaimVoucherInfo;
import com.wk.oa.entity.Employee;
import com.wk.oa.global.Contant;
import com.wk.oa.service.ClaimVoucherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Resource
    private ClaimVoucherService claimVoucherService;

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("items", Contant.getItems());
        map.put("info", new ClaimVoucherInfo());
        return "claim_voucher_add";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, ClaimVoucherInfo info) {
        Employee employee = (Employee) session.getAttribute("employee");
       info.getClaimVoucher().setStatus(employee.getSn());
        claimVoucherService.save(info.getClaimVoucher(), info.getItems());
        return "redirect:detail?id=" +info.getClaimVoucher().getId();
    }

    @RequestMapping("/detail")
    public String detail(int id, Map<String, Object> map) {
        map.put("claimVoucher", claimVoucherService.get(id));
        map.put("items", claimVoucherService.getItems(id));
        map.put("records", claimVoucherService.getRecords(id));
        return "claim_voucher_detail";
    }

  @RequestMapping("/self")
    public String self(HttpSession session,Map<String,Object> map){
        Employee employee =(Employee)session.getAttribute("employee");
       map.put("list",claimVoucherService.getForSelf(employee.getSn()));
      return "claim_voucher_self";

    }
}
