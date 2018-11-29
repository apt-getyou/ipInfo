package com.banhujiu.utils.ipinfo.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author banhujiu
 * @date 2018/11/27 14:54
 */
public class IpInfoHttpUtils {
	private static Log logger = LogFactory.getLog(IpInfoHttpUtils.class);

	public static String httpGetData(String url, Map<String, String> header) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		if (header != null && !header.isEmpty()) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				httpGet.addHeader(entry.getKey(), entry.getValue());
			}
		}
		CloseableHttpResponse response;
		String result = null;
		try {
			response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "utf-8");
					EntityUtils.consume(entity);
				}
			} else {
				Header[] headers = response.getHeaders("X-Ca-Error-Message");
				if (headers.length > 0) {
					Header errorMessage = headers[0];
					logger.error(errorMessage.getValue());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		logger.debug("请求结果为：" + result);
		return result;
	}
}
