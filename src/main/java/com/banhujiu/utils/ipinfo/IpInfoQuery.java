package com.banhujiu.utils.ipinfo;

/**
 * @author banhujiu
 * @date 2018/7/20 0020 14:07
 */
public interface IpInfoQuery {
	String getCountryId(String ip);

	IpInfoResult getIpInfo(String ip);
}
