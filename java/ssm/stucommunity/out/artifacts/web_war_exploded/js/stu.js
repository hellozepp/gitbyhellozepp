/**
 * Created by hadoop on 2017/1/7.ucdtmse
 */
function ref(){
    var a=document.getElementById("code");
    a.src="/val"+"?randomNum="+Math.random()*1000;
}
function checkCodeRes(){
    var xmlhttp=null;
    var val="";
    if (window.XMLHttpRequest)
    {// code for all new browsers
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {// code for IE5 and IE6
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        //回调函数 编写逻辑操作客户端页面或responseText获取服务端数据
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            val =xmlhttp.responseText;
            if(val=="1"){
                // alert("OK");
//					window.location.replace ( "index.html" );
//                 window.location="index.html";
            }
            else alert("验证码输入错误");
        }
    };
    xmlhttp.open("post","/check");//页面内容： 请求方式 地址
    xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");//设置请求头
    var checkCode=document.getElementById("checkCode").value;
    xmlhttp.send("checkCode="+checkCode);

}
