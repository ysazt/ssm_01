package com.ambow.dao;

import com.ambow.entity.ProvinceEntity;

import java.util.List;

public interface ProvinceDao {

   // 查询所有省份
    public List<ProvinceEntity> allProvince();

    //添加
    public void addProvince(String name);

    //修改
    public void updateProvince(ProvinceEntity provinceEntity);

    //删除
   public void delProvince(int id );


}
