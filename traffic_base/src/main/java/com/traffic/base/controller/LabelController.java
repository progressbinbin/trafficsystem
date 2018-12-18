package com.traffic.base.controller;

import com.traffic.base.pojo.Label;
import com.traffic.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Method;
import java.util.List;
import entity.PageResult;
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
    @RequestMapping(value="/search",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list= labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }
@RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findByPage(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageData=labelService.findByPage(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult(pageData.getTotalElements(),pageData.getContent()));
    }
}
