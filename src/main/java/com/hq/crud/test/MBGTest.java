package com.hq.crud.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MBGTest 
{
	public static void main(String[] args) throws Exception
	{
		//以下代码生成对应数据表的bean即dao层操作数据库方法，缺点是不太符合业务逻辑
		/*
		 * List<String> warnings = new ArrayList<String>(); boolean overwrite = true;
		 * File configFile = new File("mbg.xml"); ConfigurationParser cp = new
		 * ConfigurationParser(warnings); Configuration config =
		 * cp.parseConfiguration(configFile); DefaultShellCallback callback = new
		 * DefaultShellCallback(overwrite); MyBatisGenerator myBatisGenerator = new
		 * MyBatisGenerator(config, callback, warnings);
		 * myBatisGenerator.generate(null);
		 */
	}
}
