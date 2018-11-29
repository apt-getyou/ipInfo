package com.banhujiu.utils.ipinfo.info;

import com.banhujiu.utils.ipinfo.IpInfoResult;
import com.banhujiu.utils.ipinfo.IpInfoResultAbles;

/**
 * @author banhujiu
 * @date 2018/7/20 0020 11:31
 */
public class AliyunResult implements IpInfoResultAbles {

	/**
	 * code : 0
	 * data : {"code":0,"data":{"area":"华南","area_id":"800000","city":"深圳市","city_id":"440300","country":"中国","country_id":"CN","county":"","county_id":"","ip":"112.95.183.163","isp":"联通","isp_id":"100026","region":"广东省","region_id":"440000"}}
	 */

	private Integer code;
	private AliyunIpData data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public AliyunIpData getData() {
		return data;
	}

	public void setData(AliyunIpData data) {
		this.data = data;
	}

	@Override
	public IpInfoResult toIpInfoResult() {
		if (data == null) {
			return null;
		}
		IpInfoResult result = new IpInfoResult();
		result.setArea(data.getArea());
		result.setAreaId(data.getArea_id());
		result.setRegion(data.getRegion());
		result.setRegionId(data.getRegion_id());
		result.setCity(data.getCity());
		result.setCityId(data.getCity_id());
		result.setCountry(data.getCountry());
		result.setCountryId(data.getCountry_id());
		return result;
	}
}
