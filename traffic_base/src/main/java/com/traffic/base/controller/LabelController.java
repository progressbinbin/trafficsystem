package com.traffic.base.controller;

import com.traffic.base.pojo.Label;
import com.traffic.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * Created by yuantousanfen on 2018/12/11.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }
    @RequestMapping(value="/{labelId}",method=RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(labelId));
    }
    @RequestMapping(method=RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String id,@RequestBody Label label){
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"更新成功");
    }
    @RequestMapping(value="/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String id){
        labelService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
