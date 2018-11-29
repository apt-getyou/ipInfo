package com.banhujiu.utils.ipinfo.info;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.banhujiu.utils.ipinfo.IpInfoQuery;
import com.banhujiu.utils.ipinfo.IpInfoResult;
import com.banhujiu.utils.ipinfo.utils.IpInfoHttpUtils;
import com.google.gson.Gson;

/**
 * @author banhujiu
 * @date 2018/7/20 0020 14:07
 */
public class AliyunIpInfoQuery implements IpInfoQuery {
	private Log logger = LogFactory.getLog(AliyunIpInfoQuery.class);

	private String url = "https://dm-81.data.aliyun.com/rest/160601/ip/getIpInfo.json";
	private String appCode = "";
	private boolean debug = false;


	@Override
	public String getCountryId(String ip) {
		AliyunResult info = getInfo(ip);
		if (info == null) {
			return "";
		}
		if (info.getCode() == null || info.getCode() != 0) {
			return "";
		}
		if (info.getData() == null) {
			return "";
		}
		return info.getData().getCountry_id();
	}

	@Override
	public IpInfoResult getIpInfo(String ip) {
		AliyunResult ipInfo = getInfo(ip);
		if (ipInfo == null) {
			return null;
		}
		return ipInfo.toIpInfoResult();
	}

	private AliyunResult getInfo(String ip) {
		if (debug) {
			logger.info("开始获取ip信息，ip为" + ip);
		}
		if (appCode == null || appCode.equals("")) {
			logger.error("appCode is NULL");
			return null;
		}
		HashMap<String, String> header = new HashMap<>();
		header.put("Authorization", "APPCODE " + appCode);
		String url = this.url + "?ip=" + ip;
		if (debug) {
			logger.info("请求url为" + url);
		}
		String result = IpInfoHttpUtils.httpGetData(url, header);
		if (debug) {
			logger.info("获取ip资源返回为" + result);
		}
		Gson gson = new Gson();
		return gson.fromJson(result, AliyunResult.class);
	}

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
