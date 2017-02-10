function $(id){
    return typeof id==='string'?document.getElementById(id):id;
}

window.onload=function(){
    // 标签的索引
    var index=0;
    var timer=null;

    var lis=$('notice-tit').getElementsByTagName('li'),
        divs=$('notice-con').getElementsByTagName('div');
//标题的个数和内容的个数必须相同才运行!
    if(lis.length!=divs.length) return;
    // 遍历所有的页签
    for(var i=0;i<lis.length;i++){
        //为每一个标题设置id值!
        lis[i].id=i;
        lis[i].onmouseover=function(){
            // 用that这个变量来引用当前滑过的li
            var that=this;
            // 如果存在准备执行的定时器，立刻清除，只有当前停留时间大于500ms时才开始执行
            //因为只要划过，那么我就会添加一个500ms执行的定时器!这时候如果鼠标离开到了另外一个选项卡
            //另外的选项卡执行了onmouseover事件,那么执行之前必须把全局指定的其它的timer全部清除掉，看清楚timer是全局的!
            if(timer){
                clearTimeout(timer);
                timer=null;
            }
            // 延迟半秒执行
            timer=window.setTimeout(function(){
                //影藏所有的其它没有划过的元素
                for(var j=0;j<lis.length;j++){
                    //隐藏其它title和选项卡内容!
                    lis[j].className='';
                    divs[j].style.display='none';
                }
                //显示特定的title和选项卡内容!
                lis[that.id].className='select';
                divs[that.id].style.display='block';
            },0);
        }
    }
}