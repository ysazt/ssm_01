package com.ambow.dao;

import com.ambow.entity.ProvinceEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProvinceDaoTest {
    SqlSession session = null ;
    @Before
    public void testBefore() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession() ;
    }

    @Test
    public void testAll() throws IOException {
        ProvinceDao mapper = session.getMapper(ProvinceDao.class);  // 创建ProvinceDao这个类
        List<ProvinceEntity> list = mapper.allProvince();
        for (ProvinceEntity item : list){
            System.out.println("mybatis..."+item.getPname());
        }
    }

    @Test
    public void testAdd() throws IOException {
        ProvinceDao mapper = session.getMapper(ProvinceDao.class);  // 创建ProvinceDao这个类
        mapper.addProvince("mybatis添加省份");
        session.commit();

    }

    @Test
    public void testUpdate(){
        ProvinceDao provinceDao = session.getMapper(ProvinceDao.class);
        ProvinceEntity entity = new ProvinceEntity(25,"mybatis 修改");
        provinceDao.updateProvince(entity);
        session.commit();
    }

    @Test
    public void testDel(){
        ProvinceDao provinceDao = session.getMapper(ProvinceDao.class);
        provinceDao.delProvince(25);
        session.commit();
    }


}
