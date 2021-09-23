package com.ambow.service;



import com.ambow.dao.ProvinceDao;
import com.ambow.entity.ProvinceEntity;

import java.util.List;

public class ProvinceService {

    ProvinceDao provinceDao;

    public void setProvinceDao(ProvinceDao provinceDao) {
        this.provinceDao = provinceDao;
    }

    public List<ProvinceEntity> findallProvince(){
        return  provinceDao.allProvince();
    }


    public void addProvinceService(String name){
        provinceDao.addProvince(name);
    }

    public void delProvinceService(int id){
        provinceDao.delProvince(id);
    }

    public void updateProvinceService(String id, String name){
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setPid(Integer.parseInt(id));
        provinceEntity.setPname(name);
        provinceDao.updateProvince(provinceEntity);
    }

    public ProvinceEntity findbyidProvinceService(int id){

        return null ;
    }


}
