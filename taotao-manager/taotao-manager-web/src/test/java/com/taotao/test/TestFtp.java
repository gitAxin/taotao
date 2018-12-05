/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  TestFtp.java   
 * @Package com.taotao.test   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月5日 下午11:35:45   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/**   
 * @ClassName:  TestFtp   
 * @Description:测试ftp上传文件  
 * @author:  Axin 
 * @date:   2018年12月5日 下午11:35:45   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class TestFtp {
	
	@Test
	public void testFtpClient() throws Exception{
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建Ftp连接
		ftpClient.connect("47.104.228.117",21);
		//登录
		ftpClient.login("ftpuser", "123456");
		//上传文件
		//第一个参数:服务器端文件名
		//上传文档的inputStream
		FileInputStream fis = new FileInputStream(new File("E:\\Pictures\\Saved Pictures\\002.jpg"));
		//默认格式为文档格式，图片上传后会出现花屏，设置文件格式为二进制格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//改变文件路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/files");
		ftpClient.storeFile("hello2.jpg", fis);
		//退出
		ftpClient.logout();
	}

}
