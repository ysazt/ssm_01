package com.ambow.dao;

import com.ambow.entity.CityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {

    //add
    public void addCity(CityEntity cityEntity);

    //update
    public void updateCity(CityEntity cityEntity);

    //del
    public void delCity(int id);

    //byid
    public CityEntity byidCity(int id);

    // by cname and proid  返回 cid
    public int bynameAndPidCityDao(@Param("pid") int proid, @Param("name") String cname);

    //all
    public List<CityEntity> allCity();



}
