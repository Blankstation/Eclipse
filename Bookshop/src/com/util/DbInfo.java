package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
*********************************************
*@����   DbInfo
*@ʱ��   2017��6��1�� ����10:57:37
*@����   guyan
*@����        ��ȡdb.properties�ļ�������
*********************************************
*/
public class DbInfo {
	private static DbInfo dbInfo;
	private ConfigInfo configInfo;
	
	private DbInfo(){
		configInfo=new ConfigInfo();
		getProperties();
		
	}
	public static DbInfo newInstance(){
		if(dbInfo==null){
			dbInfo=new DbInfo();
		}
		return dbInfo;
	}
	public String getDriver(){
		String driver=null;
		if(configInfo!=null){
			driver=configInfo.getDriver();
		}
		return driver;
	}
	public String getUrl(){
		String url=null;
		if(configInfo!=null){
			url=configInfo.getUrl();
		}
		return url;
	}
	public String getName(){
		String name=null;
		if(configInfo!=null){
			name=configInfo.getName();
		}
		return name;
	}
	public String getPwd(){
		String pwd=null;
		if(configInfo!=null){
			pwd=configInfo.getPwd();
		}
		return pwd;
	}
	//��ȡ�����ļ�
	private void getProperties(){
		FileInputStream fis=null;
		try{
			String str=DbInfo.class.getResource("/").toURI().getPath()+"db.properties";
			File file=new File(str);
			Properties properties=new Properties();
			fis=new FileInputStream(file);
			properties.load(fis);
			configInfo.setDriver(properties.getProperty("driver"));
			configInfo.setName(properties.getProperty("name"));
			configInfo.setUrl(properties.getProperty("url"));
			configInfo.setPwd(properties.getProperty("pwd"));
			fis.close();
		}catch (FileNotFoundException e) {
			Log.logger.error(e.getMessage());
		} catch (IOException e) {
			Log.logger.error(e.getMessage());
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}finally{
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					Log.logger.error(e.getMessage());
				}
		}
	}
	}
}


