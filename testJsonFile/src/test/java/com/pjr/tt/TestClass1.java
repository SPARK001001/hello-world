package com.pjr.tt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.google.gson.Gson;
import com.pjr.mapper.T_MALL_CLASS_1_mapper;

class TestClass1 {

	@Test
	void test() throws Exception {
		//获取sqlsessionfactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		//获取mapper
		T_MALL_CLASS_1_mapper class_1_mapper = session.getMapper(T_MALL_CLASS_1_mapper.class);
		//操作获取数据
		List<T_MALL_CLASS_1> class1_list = class_1_mapper.getList();
		System.out.println(class1_list.size());
		//创建gson 对象
		Gson gson = new Gson();
		//转json
		String class1str = gson.toJson(class1_list);
		//生成静态文件
		FileOutputStream out = new FileOutputStream("j:/class_1.js");
		out.write(class1str.getBytes());
		out.close();
	}

}
