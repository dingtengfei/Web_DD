package com.qfedu.util;

import com.qfedu.content.SystemCon;
import com.qfedu.vo.PageVo;
import com.qfedu.vo.ResultVo;

import java.util.List;


public class ResultUtil {
    public static ResultVo exec(boolean isTrue, String msg, Object data) {
        ResultVo resultVo = new ResultVo();
        if (isTrue) {
            resultVo.setCode(SystemCon.OK);
        } else {
            resultVo.setCode(SystemCon.ERROR);
        }
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> PageVo<T> exec(int page, int size, long count, List<T> data) {
        PageVo pageVo = new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
        pageVo.setCount(count);
        pageVo.setTotalPage((int) (count % size == 0 ? count / size : (count / size + 1)));
        pageVo.setData(data);

        return pageVo;
    }
}
