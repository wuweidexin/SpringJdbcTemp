package com.chen.dict;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
@Controller
@RequestMapping(value="dict")
public class DictController {
	
	@RequestMapping(value="/translate.action",method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	public @ResponseBody String generateResult(String text){
		JSONObject reJson = null;
		if(null != text && text.trim().length() > 0) {
			String url = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=https://www.baidu.com";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("type","AUTO"));
			params.add(new BasicNameValuePair("i",text));
			params.add(new BasicNameValuePair("doctype","json"));
			params.add(new BasicNameValuePair("xmlVersion","1.8"));
			params.add(new BasicNameValuePair("keyfrom","fanyi.web"));
			params.add(new BasicNameValuePair("ue","UTF-8"));
			params.add(new BasicNameValuePair("action","FY_BY_CLICKBUTTON"));
			params.add(new BasicNameValuePair("typoResult","true"));
			String str = Utils.sendPost(url, params, Utils.form);
			if(null != str && str.trim().length() >0) {
				reJson = JSONObject.fromObject(str.trim());
				JSONObject smr = reJson.getJSONObject("smartResult");
				if(smr != null && smr.containsKey("entries")) {
					String re = smr.optString("entries");
					if(re.trim().length() > 4) {
						re = re.substring(4, re.length()-1); 
						JSONObject json = new JSONObject();
						json.accumulate("success", true);
						json.accumulate("data", re);
						return json.toString();
					}
				}
			}
		}
		return null;
	}
}
