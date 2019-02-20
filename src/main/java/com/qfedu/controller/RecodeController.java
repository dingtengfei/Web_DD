package com.qfedu.controller;

import com.qfedu.domain.Recode;
import com.qfedu.service.RecodeService;
import com.qfedu.vo.PageVo;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 作用等于: @Controller + @ResponseBody
public class RecodeController {
    @Autowired
    private RecodeService recodeService;

    @PostMapping("recodeSave.do")
    public ResultVo save(Recode recode) {
        return recodeService.save(recode);
    }

    @GetMapping("recodeDetail.do")
    public ResultVo queryById(int id) {
        return recodeService.queryById(id);
    }

    @GetMapping("recodeLike.do")
    public ResultVo queryByLike(String msg) {
        return recodeService.queryLike(msg);
    }

    @GetMapping("recodePage.do")
    public PageVo<Recode> page(int page, int size) {
        return recodeService.queryPage(page, size);
    }
}
