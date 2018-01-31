/**
 * Created by andilyliao on 17-11-16.
 */
var xmlHttp=new XMLHttpRequest();
function fun() {
    var uname=document.getElementById("un").value;
    var upass=document.getElementById("up").value;
    xmlHttp.onreadystatechange =resready;
    xmlHttp.open("POST","/testapp/regist?timeStamp="+new Date().getTime(),true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send("uname="+uname+"&upass="+upass);
}

function fun1() {
    var uname=document.getElementById("un").value;
    var upass=document.getElementById("up").value;
    xmlHttp.onreadystatechange =resready1;
    xmlHttp.open("GET","/testapp/regist?uname="+uname+"&upass="+upass+"&timeStamp="+new Date().getTime(),true);
    xmlHttp.send();
}
function resready() {
    if(xmlHttp.readyState==4){
        if(xmlHttp.status==200||xmlHttp.status==304){
            var data = xmlHttp.responseText;
            var res=eval(data);
            var resstr="<table>" +
                "<tr>" +
                "<td>uid</td><td>username</td><td>password</td><td>regtime</td>" +
                "</tr>";

            for(i=0;i<res.length;i++){
                resstr+="<tr>";
                var uid=res[i].uid;
                resstr+="<td>"+uid+"</td>";
                var unm=res[i].unm;
                resstr+="<td>"+unm+"</td>";
                var pws=res[i].pws;
                resstr+="<td>"+pws+"</td>";
                var dtime=res[i].dtime;
                resstr+="<td>"+dtime+"</td>";
                resstr+="</tr>";
            }
            resstr+="</table>";
            document.getElementById("xxx").innerHTML=resstr;
        }
    }
}
function resready1() {
    if(xmlHttp.readyState==4) {
        if (xmlHttp.status == 200 || xmlHttp.status == 304) {
            var data = xmlHttp.responseText;
            document.getElementById("xxx").innerHTML=data;
        }
    }
}
