package com.ambow.service;

import com.ambow.dao.CityDao;
import com.ambow.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServcie {

    @Autowired
    CityDao cityDao ;

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public void addCity(CityEntity city){
        cityDao.addCity(city);
    }
}
