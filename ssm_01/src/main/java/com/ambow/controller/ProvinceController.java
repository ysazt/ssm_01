package com.ambow.controller;

import com.ambow.entity.CityEntity;
import com.ambow.entity.ProvinceEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProvinceController {

    @RequestMapping("addProvince")
    public String addprovinceCon(int id , String name ){
        System.out.println(id+"第一次请求...."+name);
        return "redirect:index.jsp";
    }

    @RequestMapping("updateProvince")
    public String updateProvince(ProvinceEntity provinceEntity){
        System.out.println(provinceEntity.getPid()+"第一次请求...."+provinceEntity.getPname());
        return "redirect:index.jsp";
    }

    @RequestMapping("updateProvince1")
    public String updateProvince1(CityEntity cityEntity, HttpServletRequest request, Model model){
        System.out.println("第一次请求 city...."+cityEntity);
        request.setAttribute("requet_value","zhang");
        model.addAttribute("model_vale","ceshi");

        return "hello";
    }


    @RequestMapping("toother")
    public String other(Model model,HttpServletRequest request ){
        model.addAttribute("aa","wang");
        request.setAttribute("cc","ddd");
        return "forward:bb";
    }

    @RequestMapping("bb")
    public String bb(Model model ,HttpServletRequest request){
        String str = (String)model.getAttribute("aa");
        String ss = (String) request.getAttribute("cc");
        System.out.println(str);
        System.out.println("cc.."+ss);
        return "hello";
    }

    @RequestMapping("toother1")
    public String other1(Model model,HttpServletRequest request ){
        model.addAttribute("aa","wang");
        request.setAttribute("cc","ddd");
        //return "forward:bb";
        return "redirect:bb1";
    }

    @RequestMapping("bb1")
    public String bb1(Model model ,String aa,HttpServletRequest request){
        String str = (String)model.getAttribute("aa");
        String ss = (String) request.getAttribute("cc");
        System.out.println(str);
        System.out.println("cc.."+ss);
        System.out.println("aa.."+aa);
        return "hello";
    }
}
