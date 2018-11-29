package com.banhujiu.utils.ipinfo.test;

import java.security.SecureRandom;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.banhujiu.utils.ipinfo.IpInfoQuery;
import com.banhujiu.utils.ipinfo.info.AliyunProperties;
import com.google.gson.Gson;

/**
 * @author banhujiu
 * @date 2018/11/27 15:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestApplication.class)
@EnableConfigurationProperties(AliyunProperties.class)
public class IpInfoTest {
	@Resource
	private IpInfoQuery ipInfoQuery;
	@Autowired
	private AliyunProperties aliyunProperties;

	@Test
	public void ipinfoTest() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(aliyunProperties));
		SecureRandom random = new SecureRandom();
		StringBuilder ipSb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			ipSb.append(random.nextInt(255)).append(".");
		}
		ipSb.deleteCharAt(ipSb.length() - 1);
		String ip = ipSb.toString();
		System.out.println(ip);
		System.out.println(ipInfoQuery.getCountryId(ip));
		System.out.println(ipInfoQuery.getIpInfo(ip));
	}
}
