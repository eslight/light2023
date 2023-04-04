function jQuery(selector){
    if (typeof selector== "string") {
       if (selector.charAt(0)=="#"){
           //selector是一个id选择器
           dmObj = document.getElementById(selector.substring(1));
           return new jQuery();
       }
    }
    if (typeof selector=="function"){
        window.onload=selector
    }
    this.html=function (htmlText){
        dmObj.innerHTML=htmlText;
    }
    this.click=function (fun){
        dmObj.onclick=fun
    }
    this.blur=function (fun){
        dmObj.onblur=fun
    }
    this.change=function (fun){
        dmObj.onchange=fun
    }
    this.focus=function (fun){
        dmObj.onfocus=fun
    }
    this.val=function (valContent){
        if (valContent==undefined){
            return dmObj.value;
        }else {
            dmObj.value=valContent;
        }

    }
    //静态方法发送AJAX请求
    jQuery.ajax=function (jsonArgs){
        //创建ajax核心对象
        var xml = new XMLHttpRequest();
        //注册回调函数
                xml.onreadystatechange=function (){
                    if (this.readyState == 4) {
                        if (this.status == 200) {
                            var jsonObj = JSON.parse(this.responseText);
                            jsonArgs.success(jsonObj)
                        }else {
                            alert(this.status)
                        }
                    }
                }

        //开启通道
        //toUpperCase()转为大写
        if (jsonArgs.type.toUpperCase() == "POST") {
            xml.open("POST",jsonArgs.url,jsonArgs.async)
            xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xml.send(jsonArgs.data)
        }if (jsonArgs.type.toUpperCase()=="GET"){
            xml.open("GET",jsonArgs.url+"?"+jsonArgs.data,jsonArgs.async)
            xml.send()
        }


    }
}
$=jQuery
new jQuery()
