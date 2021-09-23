package com.ambow.controller;

import com.ambow.dao.ProvinceDao;
import com.ambow.entity.CityEntity;
import com.ambow.entity.ProvinceEntity;
import com.ambow.service.CityServcie;
import com.ambow.service.ProvinceService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {

    @Test
    public void test01(){
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCname("测试");
        System.out.println("原来的。。。"+cityEntity.getCname());

        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        CityEntity cityEntity1 =(CityEntity) app.getBean("cityEntity");
        //cityEntity1.setCname("测试2");
        System.out.println(cityEntity1);

        ProvinceEntity provinceEntity = (ProvinceEntity) app.getBean("pro");
    }

    @Test
    public void test02(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
       // ProvinceDao provinceDao = (ProvinceDao) app.getBean("provinceDao");
        ProvinceDao provinceDao = app.getBean(ProvinceDao.class);
        List<ProvinceEntity> list = provinceDao.allProvince();
        System.out.println(list.size());
    }

    @Test
    public void test03(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        // ProvinceDao provinceDao = (ProvinceDao) app.getBean("provinceDao");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) app.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        provinceDao.addProvince("spring-mybatis 增加");
        sqlSession.commit();
    }


    @Test
    public void test04(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ProvinceService provinceService = (ProvinceService)applicationContext.getBean("provinceService");
        provinceService.addProvinceService("servcie spring -mybatis 不饿能");
    }

    @Test
    public void test05(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CityServcie cityServcie = (CityServcie)applicationContext.getBean("cityServcie");
        CityEntity city = new CityEntity();
        city.setCname("servcie  spring - mybatis 城市");
        city.setCproid(new ProvinceEntity(1,""));
        cityServcie.addCity(city);
    }
}
