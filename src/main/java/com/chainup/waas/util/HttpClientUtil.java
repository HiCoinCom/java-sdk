package com.chainup.waas.util;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpClientUtil {

	private final int DEFAULT_TIMEOUT = 30000;

	private static HttpClientUtil ins;

	private HttpClient client;
	private int timeout = DEFAULT_TIMEOUT;

	private static int maxConnTotal = 200;   //最大不要超过1000
	private static int maxConnPerRoute = 100;//实际的单个连接池大小，

	private HttpClientUtil() {
		if (client == null) {
			client = HttpClients.createDefault();
		}
	}

	public static HttpClientUtil getInstance() {
		if (ins == null) {
			synchronized (HttpClientUtil.class) {
				if (ins == null) {
					ins = new HttpClientUtil();
				}
			}
		}
		return ins;
	}

	public String doGetWithJsonResult(String uri) {
		String json = null;
		HttpResponse response = null;
		try {
			HttpGet request = new HttpGet(uri);
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
					.setConnectTimeout(timeout).setSocketTimeout(timeout).build();
			request.setConfig(config);
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(response != null) {
					EntityUtils.consume(response.getEntity());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}

	public String doPostWithJsonResult(String uri, Map<String, String> paramMap) {
		String json = null;
		HttpResponse response = null;
		try {
			HttpPost request = new HttpPost(uri);
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
					.setConnectTimeout(timeout).setSocketTimeout(timeout).build();
			request.setConfig(config);
			List<NameValuePair> params = new ArrayList<NameValuePair>(0);
			if (paramMap != null && !paramMap.isEmpty()) {
				for (String key : paramMap.keySet()) {
					params.add(new BasicNameValuePair(key, paramMap.get(key)));
				}
				request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			}
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
			}
			request.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(response != null) {
					EntityUtils.consume(response.getEntity());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
