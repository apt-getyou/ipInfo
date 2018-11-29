package com.banhujiu.utils.ipinfo.info;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.banhujiu.utils.ipinfo.IpInfoAutoConfiguration;

/**
 * @author banhujiu
 * @date 2018/11/27 15:47
 */
@AutoConfigureBefore(IpInfoAutoConfiguration.class)
@ConfigurationProperties(prefix = "ip.info.aliyun")
public class AliyunProperties {
	private String url = "https://dm-81.data.aliyun.com/rest/160601/ip/getIpInfo.json";
	private String appCode;
	private boolean debug = false;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
