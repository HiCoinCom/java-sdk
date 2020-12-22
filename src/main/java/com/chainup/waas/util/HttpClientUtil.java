package com.chainup.waas.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
				json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
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

	public Boolean doGetCode(String uri) {
		String json = null;
		HttpResponse response = null;
		try {
			HttpGet request = new HttpGet(uri);
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
					.setConnectTimeout(timeout).setSocketTimeout(timeout).build();
			request.setConfig(config);
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(response != null) {
					EntityUtils.consume(response.getEntity());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String doGetCustomByToken(String uri,String token) {
		String json = null;
		HttpResponse response = null;
		try {
			HttpGet request = new HttpGet(uri);
			request.addHeader("token",token);
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
					.setConnectTimeout(timeout).setSocketTimeout(timeout).build();

			request.setConfig(config);
			client = HttpClients.custom().setDefaultRequestConfig(config)
					.setMaxConnTotal(maxConnTotal)
					.setMaxConnPerRoute(maxConnPerRoute).build();
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
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

	public String doGetCustom(String uri) {
		String json = null;
		HttpResponse response = null;
		try {
			HttpGet request = new HttpGet(uri);
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
					.setConnectTimeout(timeout).setSocketTimeout(timeout).build();

			request.setConfig(config);
			client = HttpClients.custom().setDefaultRequestConfig(config)
					.setMaxConnTotal(maxConnTotal)
					.setMaxConnPerRoute(maxConnPerRoute).build();
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
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
				json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
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

	public String doPostWithJsonResult(String uri, String jsonParameters) {
		HttpPost request = new HttpPost(uri);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(timeout)
				.setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		request.setConfig(config);
		request.setEntity(new StringEntity(jsonParameters, ContentType.APPLICATION_JSON));
		HttpResponse response = null;
		String responseStr = null;
		try {
			response = client.execute(request);
			responseStr = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseStr;

	}

	public String doPost(String url, Map<String, String> params) {
		ArrayList<BasicNameValuePair> data = new ArrayList<>();
		for(String key : params.keySet()){
			data.add(new BasicNameValuePair(key, params.get(key)));
		}
		return this.doPost(url,data);
	}


    public String doPost(String url, ArrayList<BasicNameValuePair> data) {
		try {
			//UrlEncodedFormEntity这个类是用来把输入数据编码成合适的内容
			//两个键值对，被UrlEncodedFormEntity实例编码后变为如下内容：param1=value1¶m2=value2
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(data,
					HTTP.UTF_8);//首先将参数设置为utf-8的形式，
			String result = "";//向服务器请求之后返回的数据结果
			//HttpClient httpClient = new DefaultHttpClient();//申明一个网络访问客户端
			HttpPost post = new HttpPost(url);//post方式
			post.setEntity(entity);//带上参数
			HttpResponse httpResponse = client.execute(post);//响应结果
			if (httpResponse.getStatusLine().getStatusCode() == 200) {//如果是200  表示成功
				result = EntityUtils.toString(httpResponse.getEntity());//把结果取出来  是一个STRING类型的
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String doPost(String url, ArrayList<BasicNameValuePair> data, Map<String, String> headers) {
		try {
			//UrlEncodedFormEntity这个类是用来把输入数据编码成合适的内容
			//两个键值对，被UrlEncodedFormEntity实例编码后变为如下内容：param1=value1¶m2=value2
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(data, 
					HTTP.UTF_8);//首先将参数设置为utf-8的形式，
			String result = "";//向服务器请求之后返回的数据结果
			//HttpClient httpClient = new DefaultHttpClient();//申明一个网络访问客户端
			HttpPost post = new HttpPost(url);//post方式
			for (Map.Entry<String, String> header : headers.entrySet()) {
				post.addHeader(header.getKey(), header.getValue());
			}
			post.setEntity(entity);//带上参数
			HttpResponse httpResponse = client.execute(post);//响应结果
			if (httpResponse.getStatusLine().getStatusCode() == 200) {//如果是200  表示成功
				result = EntityUtils.toString(httpResponse.getEntity());//把结果取出来  是一个STRING类型的
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * post body 方式请求
	 */
	public String doPost(String url, JSONObject jsonObject, Map<String, String> header){
		try {
			// 创建指定内容和编码的字符串实体类
			StringEntity entity=new StringEntity(jsonObject.toString(), Consts.UTF_8);
			//entity.setContentEncoding("UTF-8");
			//entity.setContentType("application/json");
			// 创建post请求
			HttpPost httpPost = new HttpPost(url);
			// 设置超时时间
			RequestConfig config = RequestConfig.custom()
					.setConnectionRequestTimeout(6000)
					.setConnectTimeout(6000)
					.setSocketTimeout(6000)
					.build();
			httpPost.setConfig(config);
			// 设置请求头
			for (Map.Entry<String, String> entry : header.entrySet()) {
				httpPost.setHeader(entry.getKey(), entry.getValue());
			}
			// 设置请求参数
			httpPost.setEntity(entity);

			String result = "";
			// 发送HttpPost请求，获取返回值
			HttpResponse response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {//如果是200  表示成功
				result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String doPostWithToken(String url, ArrayList<BasicNameValuePair> data, String token) {
		try {
			//UrlEncodedFormEntity这个类是用来把输入数据编码成合适的内容
			//两个键值对，被UrlEncodedFormEntity实例编码后变为如下内容：param1=value1¶m2=value2
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(data,"UTF-8");
			String result = "";
			HttpPost post = new HttpPost(url);
			post.addHeader("token",token);
			post.setEntity(entity);
			//这个地方先写死超时时间，避免单例中timeout被篡改
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(30000).setConnectionRequestTimeout(30000)
					.setSocketTimeout(30000).build();
			post.setConfig(requestConfig);
			HttpResponse httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(httpResponse.getEntity());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String doPost(String url, String jsonStr) {
		URL u = null;
		HttpURLConnection con = null;

		try {
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setConnectTimeout(timeout);
			con.setReadTimeout(timeout);
			if(jsonStr != null && !"".equals(jsonStr)){
				OutputStreamWriter osw = new OutputStreamWriter(
						con.getOutputStream(), "UTF-8");
				osw.write(jsonStr);
				osw.flush();
				osw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		// 读取返回内容
		StringBuffer buffer = new StringBuffer();
        BufferedReader br = null;
		try {
			 br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		    if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String result = buffer.toString();
		return result;
	}
	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String doPost(String url, String jsonStr,int timeout) {
		setTimeout(timeout);
		return doPost(url,jsonStr);
	}

	public String doGetCustom(String url, int timeout) {
		setTimeout(timeout);
		return doGetCustom(url);
	}
	
	
	
	
	
}
