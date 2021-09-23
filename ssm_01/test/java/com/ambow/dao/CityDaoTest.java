package com.ambow.dao;

import com.ambow.entity.CityEntity;
import com.ambow.entity.ProvinceEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CityDaoTest {
    SqlSession session = null ;
    @Before
    public void testBefore() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession() ;
    }

    @Test
    public void testAdd(){
        CityDao  cityDao = session.getMapper(CityDao.class);
        CityEntity city = new CityEntity();
        city.setCname("mybatis 城市添加");
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setPid(22);
        city.setCproid(provinceEntity);
        cityDao.addCity(city);
        session.commit();
    }

    @Test
    public void testUpdate(){
        CityDao cityDao = session.getMapper(CityDao.class);
        CityEntity city = new CityEntity();
        city.setCid(17);

        city.setCname("mybatis 城市修改");
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setPid(23);
        city.setCproid(provinceEntity);

        cityDao.updateCity(city);

        session.commit();
    }


    @Test
    public void testDel(){
        CityDao cityDao = session.getMapper(CityDao.class);
        cityDao.delCity(17);

        session.commit();
    }

    @Test
    public void testByid(){
        CityDao cityDao = session.getMapper(CityDao.class);
        CityEntity cityEntity = cityDao.byidCity(2);
        System.out.println(cityEntity);
    }


    @Test
    public void testByIdAndName(){
        CityDao cityDao = session.getMapper(CityDao.class);
        int cid = cityDao.bynameAndPidCityDao(1,"乌兰察布");
        System.out.println(cid);
    }
}
