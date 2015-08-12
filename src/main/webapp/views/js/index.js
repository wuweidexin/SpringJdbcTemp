$(document).ready(function(){
	$("#translate").click(function(){
		var txt = $("#srctext").val();
		if(txt.trim().length > 0) {
			$.post("dict/translate.action",
				  {
				    text:txt
				  },
				  function(result){
					  var d = result.data;
					  if(d && d.trim().length > 0) {
						  d = d.replace(/"/g, '');
						  $("#show").text(d);
					  } else{
						  $("#show").text('');
					  }
				  }
			 );
		
			
		} else {
			$("#show").text('请输入值');
		}
	});
	
	$("#hideRightBtn").click(function(){
		XuntongJSBridge.call('hideOptionMenu');//隐藏右上角按钮
	});
	
	$("#showRightBtn").click(function(){
		XuntongJSBridge.call('showOptionMenu');//显示右上角按钮
	});
	
	$("#hideWebViewTitle").click(function(){
		XuntongJSBridge.call('hideWebViewTitle');//隐藏页面标题
	});
	$("#setWebViewTitle").click(function(){
		XuntongJSBridge.call('setWebViewTitle',{'title':'申请加入群聊'});//设置页面标题并显示
	});
	$("#getPersonInfo").click(function(){
		XuntongJSBridge.call('getPersonInfo',{}, function(result){
			
			alert("用户数据："+JSON.stringify(result));
	    });
	});
	$("#getNetworkType").click(function(){
		XuntongJSBridge.call('getNetworkType',
                {},
                function(result){
	       alert("用户网络状态："+JSON.stringify(result));
            }); 

	});
	$("#gotoApp").click(function(){
		XuntongJSBridge.call('gotoApp',
	            {"data":'kdweibo://p?url=https://itunes.apple.com/cn/app/id595672427'},
	        function(result){
	              alert("结果："+JSON.stringify(result));
	    }); 

	});
	
	$("#sinin").click(function(){
		XuntongJSBridge.call('localFunction',{'name':'signin'},function(result){
			alert(JSON.stringify(result));
		});

	});
	$("#createChat").click(function(){
		XuntongJSBridge.call('localFunction',{'name':'createChat'},function(result){
			alert(JSON.stringify(result));
		});
	});
	
	$("#invite").click(function(){
		XuntongJSBridge.call('localFunction',{'name':'invite'},function(result){
			alert(JSON.stringify(result));
		});
	});
	
	$("#selectFile").click(function(){
		XuntongJSBridge.call('selectFile',{},function(result){
			alert(JSON.stringify(result));
		});
	});
	$("#showFile").click(function(){
		
		XuntongJSBridge.call('showFile',{'fileId':'556d5ddc84ae9a5d5689b159',
			'fileName':'perfect.plist','fileExt':'plist',
			'fileTime':'2015-06-02 15:40','fileSize':'1196'},function(result){
			alert(JSON.stringify(result));
		});
		
	});
	$("#selectPic").click(function(){
		XuntongJSBridge.call('selectPic',{},function(result){});
	});
	
	$("#scanQRCode").click(function(){
		XuntongJSBridge.call('scanQRCode',
	            {'needResult':0,'scanType':['qrCode']},
	            function(result){}
	            );
	});
	
	$("#selectOrg").click(function(){
		XuntongJSBridge.call('selectOrg',{},function(result){
			alert(JSON.stringify(result));
		});
	});
	
	$("#selectDepts").click(function(){
		XuntongJSBridge.call('selectDepts',{},function(result){
			alert(JSON.stringify(result));
		});
	});
	$("#selectPersons").click(function(){
		XuntongJSBridge.call('selectPersons',{ 'isMulti':'true'},function(result){
			alert(JSON.stringify(result));
		});

	});
	$("#selectPerson").click(function(){
		XuntongJSBridge.call('selectPerson',{},function(result){
			alert(JSON.stringify(result));
		});
	});
	
	//获取url中的参数
	function getUrlParam(name) {
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	  var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	  if (r != null) return unescape(r[2]); return null; //返回参数值
	}
	//tiketVerification.jsp 
	$("#ticketByJs").click(function(){
		var ticket=getUrlParam('ticket');
//        var reg = new RegExp("(^|&)" + 'ticket' + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
//        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
//        if (r != null) 
//        	ticket = unescape(r[2]); 
        
        alert('ticket:  ' + ticket);
	});
   
	
	$("#accessToken").click(function(){
		var appid= '10121';
		var appSecret= '201508102005';
		var xturl = "http://xttest.msbu.kingdee.com";
		var url =xturl + "/openauth2/api/token?grant_type=client_credential&" +
				"appid="+appid+"&secret="+appSecret;
		 $.get(url,function(data,status){
			    alert(JSON.stringify(data));
			    $("#accesstoken").val(data.access_token);
		 });
	});
	
	$("#validAccessToken").click(function(){
		var accesstoken= $("#accesstoken").val();
		var xturl = "http://xttest.msbu.kingdee.com";
		var url =xturl + "/openauth2/api/token?grant_type=valid&" +
				"token="+accesstoken;
		 $.get(url, function(data,status){
			    alert("验证成功，APPId是: " + data.appid);
		 });
	});

	$("#getcontext").click(function(){
		var ticket= $("#ticket").val();
//		var ticket = 'fc7b27c2bc5cf6d8847f895d3e5f0eae';
		var accesstoken= $("#accesstoken").val();
		var xturl = "http://xttest.msbu.kingdee.com";
		
		//如果没access_token,只传入了ticket,返回对应用户的企业:
		//如果没ticket,只传入了access_token,返回对应的应用:
		
		var url = null;
		if(ticket){
			xturl = xturl + "/openauth2/api/getcontext?ticket="+ticket;
		}
		if(accesstoken){
			xturl = xturl + "&accessToken="+accesstoken;
		}
				
		 $.get(xturl, function(data,status){
			 if(data){
				 alert("当前登录用户数据是 :" + JSON.stringify(data));
			 }else {
				 alert("数据有误");
			 }
			    
		 });
	});
})