/**
 * Created by hadoop on 16-8-31.
 */
//$.ready(function(){
//    $("#a1").css("background","black");
//});
$(document).ready(function(){
        $("#sjl1Box").hide();
        $("#content").hide();
        $("#sjl1 li").click(function(){
            $("#content").show();
            $("#sjl1Box").show();
            $("#full").hide();
        })


})

function changeColor(name,id,count){
    for(i=1;i<=count;i++){
        document.getElementById(name+i).style.background="#ececec";
    }
    document.getElementById(id).style.background="#41BABE";
}