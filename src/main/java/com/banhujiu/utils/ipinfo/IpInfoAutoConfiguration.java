package com.banhujiu.utils.ipinfo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.banhujiu.utils.ipinfo.info.AliyunIpInfoQuery;
import com.banhujiu.utils.ipinfo.info.AliyunProperties;


/**
 * @author banhujiu
 * @date 2018/7/20 0020 14:03
 */
@Configuration
@EnableConfigurationProperties(AliyunProperties.class)
public class IpInfoAutoConfiguration {
	private AliyunProperties properties;

	public IpInfoAutoConfiguration(AliyunProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean(IpInfoQuery.class)
	public IpInfoQuery ipInfoQuery() {
		AliyunIpInfoQuery aliyunIpInfoQuery = new AliyunIpInfoQuery();
		aliyunIpInfoQuery.setUrl(properties.getUrl());
		aliyunIpInfoQuery.setAppCode(properties.getAppCode());
		aliyunIpInfoQuery.setDebug(properties.isDebug());
		return aliyunIpInfoQuery;
	}
}
