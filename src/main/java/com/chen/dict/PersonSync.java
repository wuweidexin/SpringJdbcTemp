package com.chen.dict;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PersonSync {
	String host = "http://xttest.msbu.kingdee.com";
	public static void main(String[] args) {
		PersonSync ps = new PersonSync();
		ps.getPersonByTime();
	}
	
	private void getPersonByTime(){
		//返回某个时间段的人员信息
		String  url = host  + "/openaccess/input/person/getAtTime";
		//json形式的参数
		JSONObject data = new JSONObject();
		data.accumulate("eid","172");
		data.accumulate("time","2015-05-26 01:40:38");
		data.accumulate("begin",0);
		data.accumulate("count",10);
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>(); 
		nvps.add(new BasicNameValuePair("eid","172"));
		nvps.add(new BasicNameValuePair("data", Utils.enyte(data.toString())));
		//form 提交的方式
		String reponse = Utils.sendPost(url,nvps, Utils.form);
		System.out.println(reponse);
	}
	private void addPerson(){
		String  url = host  + "/openaccess/input/person/add";
		
		//json形式的参数
		JSONObject data = new JSONObject();
		data.accumulate("eid","172");
		data.accumulate("time","2015-05-26 01:40:38");
		data.accumulate("begin",0);
		data.accumulate("count",10);
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>(); 
		nvps.add(new BasicNameValuePair("eid","172"));
		nvps.add(new BasicNameValuePair("data", Utils.enyte(data.toString())));
		//form 提交的方式
		String reponse = Utils.sendPost(url,nvps, Utils.form);
		System.out.println(reponse);
	}
	
}
