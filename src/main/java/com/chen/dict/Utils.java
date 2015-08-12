package com.chen.dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	static int HTTP_OK = 200;
	public static String form = ContentType.APPLICATION_FORM_URLENCODED.toString();
	public static String json = ContentType.APPLICATION_JSON.toString();
	//params.add(new BasicNameValuePair("pwd","2544"));
	
	
	public static String sendPost(String url, List<NameValuePair> params, String type){
		HttpUriRequest httpPost = null;
		try {
			httpPost = RequestBuilder
					.post()
					.addHeader("Content-Type",type)
					.setEntity(new UrlEncodedFormEntity(params,"UTF-8"))
					.setUri(url).build();
		} catch (UnsupportedEncodingException e) {
			logger.error("send http requset faile",e.getMessage());
		}
		return sendHttpRequest(httpPost);
		
	}
	
	
	public static String sendHttpRequest(HttpUriRequest httpRequest) {
		HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			if (isRequestSuccessful(httpResponse)) {
				HttpEntity httpEntity = httpResponse.getEntity();
				String response = EntityUtils.toString(httpEntity, "utf-8");
				logger.info("http response", response); 
				return response;
			}
		} catch (ClientProtocolException e) {
			logger.error("send http requset faile,uri={}, exception={}",
					httpRequest.getURI(), e);
		} catch (IOException e) {
			logger.error("send http requset faile,uri={}, exception={}",
					httpRequest.getURI(), e);
		}
		return null;
	}

	private static boolean isRequestSuccessful(HttpResponse httpResponse) {
		logger.info("response code：{}", httpResponse.getStatusLine().getStatusCode());
		return httpResponse.getStatusLine().getStatusCode() == HTTP_OK;
	}
	
	
	public static String enyte(String data){
		try {
			String path = Utils.class.getResource("172.key").getPath();
			byte[] b = FileUtils.readFileToByteArray(new File(path));
			PrivateKey restorePublicKey = RSAUtils.restorePrivateKey(b);
			byte[] bytes =  Base64.encodeBase64(RSAUtils.encryptLarger(data.getBytes(), restorePublicKey));
			return new String(bytes,"UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
