<!--
document.write("<div id=meizzCalendarLayer style='position: absolute; z-index: 9999; width: 144; height: 193; display: none'>");
document.write("<iframe name=meizzCalendarIframe scrolling=no frameborder=0 width=100% height=100%></iframe></div>");
function writeIframe()
{
    var strIframe = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><style>"+
    "*{font-size: 12px; font-family: \u5b8b\u4f53}"+
    ".bg{  color: "+ WebCalendar.todayColor +"; cursor: default; background-color: "+ WebCalendar.amendColor +";}"+
    "table#tableMain{ width: 142; height: 180;}"+
    "table#tableWeek td{ color: "+ WebCalendar.wordlColor +";}"+
    "table#tableDay  td{ font-weight: bold;}"+
    "td#meizzYearHead, td#meizzYearMonth{color: "+ WebCalendar.wordColor +"}"+
    ".out { text-align: center; border-top: 1px solid "+ WebCalendar.DarkBorder +"; border-left: 1px solid "+ WebCalendar.DarkBorder +";"+
    "border-right: 1px solid "+ WebCalendar.lightColor +"; border-bottom: 1px solid "+ WebCalendar.lightColor +";}"+
    ".over{ text-align: center; border-top: 1px solid #FFFFFF; border-left: 1px solid #FFFFFF;"+
    "border-bottom: 1px solid "+ WebCalendar.DarkBorder +"; border-right: 1px solid "+ WebCalendar.DarkBorder +"}"+
    "input{ border: 1px solid "+ WebCalendar.lightColor +"; padding-top: 1px; height: 18; cursor: hand;"+
    "       color:"+ WebCalendar.todayColor +"; background-color: "+ WebCalendar.btnBgColor +"}"+
    "</style></head><body onselectstart='return false' style='margin: 0px' oncontextmenu='return false'><form name=meizz>";

    if (WebCalendar.drag){ strIframe += "<scr"+"ipt language=javascript>"+
    "var drag=false, cx=0, cy=0, o = parent.WebCalendar.calendar; function document.onmousemove(){"+
    "if(parent.WebCalendar.drag && drag){if(o.style.left=='')o.style.left=0; if(o.style.top=='')o.style.top=0;"+
    "o.style.left = parseInt(o.style.left) + window.event.clientX-cx;"+
    "o.style.top  = parseInt(o.style.top)  + window.event.clientY-cy;}}"+
    "function document.onkeydown(){ switch(window.event.keyCode){  case 27 : parent.hiddenCalendar(); break;"+
    "case 37 : parent.prevM(); break; case 38 : parent.prevY(); break; case 39 : parent.nextM(); break; case 40 : parent.nextY(); break;"+
    "case 84 : document.forms[0].today.click(); break;} window.event.keyCode = 0; window.event.returnValue= false;}"+
    "function dragStart(){cx=window.event.clientX; cy=window.event.clientY; drag=true;}</scr"+"ipt>"}

    strIframe += "<select name=tmpYearSelect  onblur='parent.hiddenSelect(this)' style='z-index:1;position:absolute;top:3;left:18;display:none'"+
    " onchange='parent.WebCalendar.thisYear =this.value; parent.hiddenSelect(this); parent.writeCalendar();'></select>"+
    "<select name=tmpMonthSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:3;left:74;display:none'"+
    " onchange='parent.WebCalendar.thisMonth=this.value; parent.hiddenSelect(this); parent.writeCalendar();'></select>"+

    "<table id=tableMain class=bg border=0 cellspacing=2 cellpadding=0>"+
    "<tr><td width=140 height=19 bgcolor='"+ WebCalendar.lightColor +"'>"+
    "    <table width=140 id=tableHead border=0 cellspacing=1 cellpadding=0><tr align=center>"+
    "    <td width=15 height=19 class=bg title='\u5411\u524d\u7ffb 1 \u6708&#13;\u5feb\u6377\u952e\uff1a\u2190' style='cursor: hand' onclick='parent.prevM()'><b>&lt;</b></td>"+
    "    <td width=60 id=meizzYearHead  title='\u70b9\u51fb\u6b64\u5904\u9009\u62e9\u5e74\u4efd' onclick='parent.funYearSelect(parseInt(this.innerText, 10))'"+
    "        onmouseover='this.bgColor=parent.WebCalendar.amendColor; this.style.color=parent.WebCalendar.lightColor'"+
    "        onmouseout='this.bgColor=parent.WebCalendar.lightColor; this.style.color=parent.WebCalendar.wordColor'></td>"+
    "    <td width=50 id=meizzYearMonth title='\u70b9\u51fb\u6b64\u5904\u9009\u62e9\u6708\u4efd' onclick='parent.funMonthSelect(parseInt(this.innerText, 10))'"+
    "        onmouseover='this.bgColor=parent.WebCalendar.amendColor; this.style.color=parent.WebCalendar.lightColor'"+
    "        onmouseout='this.bgColor=parent.WebCalendar.lightColor; this.style.color=parent.WebCalendar.wordColor'></td>"+
    "    <td width=15 class=bg title='\u5411\u540e\u7ffb 1 \u6708&#13;\u5feb\u6377\u952e\uff1a\u2192' onclick='parent.nextM()' style='cursor: hand'><b>&gt;</b></td></tr></table>"+
    "</td></tr><tr><td height=20><table id=tableWeek border=1 width=140 cellpadding=0 cellspacing=0 ";
    if(WebCalendar.drag){strIframe += "onmousedown='dragStart()' onmouseup='drag=false' onmouseout='drag=false'";}
    strIframe += " borderColorLight='"+ WebCalendar.darkColor +"' borderColorDark='"+ WebCalendar.lightColor +"'>"+
    "    <tr align=center><td height=20>\u65e5</td><td>\u4e00</td><td>\u4e8c</td><td>\u4e09</td><td>\u56db</td><td>\u4e94</td><td>\u516d</td></tr></table>"+
    "</td></tr><tr><td valign=top width=140 bgcolor='"+ WebCalendar.lightColor +"'>"+
    "    <table id=tableDay height=120 width=140 border=0 cellspacing=1 cellpadding=0>";
         for(var x=0; x<5; x++){ strIframe += "<tr>";
         for(var y=0; y<7; y++)  strIframe += "<td class=out id='meizzDay"+ (x*7+y) +"'></td>"; strIframe += "</tr>";}
         strIframe += "<tr>";
         for(var x=35; x<39; x++) strIframe += "<td class=out id='meizzDay"+ x +"'></td>";
         strIframe +="<td colspan=3 class=out title='"+ WebCalendar.regInfo +"'><input style=' background-color: "+
         WebCalendar.btnBgColor +";cursor: hand; padding-top: 4px; width: 100%; height: 100%; border: 0' onfocus='this.blur()'"+
         " type=button value='&nbsp; &nbsp; \u5173\u95ed' onclick='parent.hiddenCalendar()'></td></tr></table>"+
    "</td></tr><tr><td height=20 width=140 bgcolor='"+ WebCalendar.lightColor +"'>"+
    "    <table border=0 cellpadding=1 cellspacing=0 width=140>"+
    "    <tr><td><input name=prevYear title='\u5411\u524d\u7ffb 1 \u5e74&#13;\u5feb\u6377\u952e\uff1a\u2191' onclick='parent.prevY()' type=button value='&lt;&lt;'"+
    "    onfocus='this.blur()' style='meizz:expression(this.disabled=parent.WebCalendar.thisYear==1000)'><input"+
    "    onfocus='this.blur()' name=prevMonth title='\u5411\u524d\u7ffb 1 \u6708&#13;\u5feb\u6377\u952e\uff1a\u2190' onclick='parent.prevM()' type=button value='&lt;&nbsp;'>"+
    "    </td><td align=center><input name=today type=button value='\u4eca\u5929' onfocus='this.blur()' style='width: 50' title='\u5f53\u524d\u65e5\u671f&#13;\u5feb\u6377\u952e\uff1aT'"+
    "    onclick=\"parent.returnDate(new Date().getDate() +'/'+ (new Date().getMonth() +1) +'/'+ new Date().getFullYear())\">"+
    "    </td><td align=right><input title='\u5411\u540e\u7ffb 1 \u6708&#13;\u5feb\u6377\u952e\uff1a\u2192' name=nextMonth onclick='parent.nextM()' type=button value='&nbsp;&gt;'"+
    "    onfocus='this.blur()'><input name=nextYear title='\u5411\u540e\u7ffb 1 \u5e74&#13;\u5feb\u6377\u952e\uff1a\u2193' onclick='parent.nextY()' type=button value='&gt;&gt;'"+
    "    onfocus='this.blur()' style='meizz:expression(this.disabled=parent.WebCalendar.thisYear==9999)'></td></tr></table>"+
    "</td></tr><table></form></body></html>";
    with(WebCalendar.iframe)
    {
        document.writeln(strIframe); document.close();
        for(var i=0; i<39; i++)
        {
            WebCalendar.dayObj[i] = eval("meizzDay"+ i);
            WebCalendar.dayObj[i].onmouseover = dayMouseOver;
            WebCalendar.dayObj[i].onmouseout  = dayMouseOut;
            WebCalendar.dayObj[i].onclick     = returnDate;
        }
    }
}
function TWebCalendar() //\u521d\u59cb\u5316\u65e5\u5386\u7684\u8bbe\u7f6e
{
    this.regInfo    = "";
    this.regInfo   += "";
    this.daysMonth  = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    this.day        = new Array(39);            //\u5b9a\u4e49\u65e5\u5386\u5c55\u793a\u7528\u7684\u6570\u7ec4
    this.dayObj     = new Array(39);            //\u5b9a\u4e49\u65e5\u671f\u5c55\u793a\u63a7\u4ef6\u6570\u7ec4
    this.dateStyle  = null;                     //\u4fdd\u5b58\u683c\u5f0f\u5316\u540e\u65e5\u671f\u6570\u7ec4
    this.objExport  = null;                     //\u65e5\u5386\u56de\u4f20\u7684\u663e\u793a\u63a7\u4ef6
    this.eventSrc   = null;                     //\u65e5\u5386\u663e\u793a\u7684\u89e6\u53d1\u63a7\u4ef6
    this.inputDate  = null;                     //\u8f6c\u5316\u5916\u7684\u8f93\u5165\u7684\u65e5\u671f(d/m/yyyy)
    this.thisYear   = new Date().getFullYear(); //\u5b9a\u4e49\u5e74\u7684\u53d8\u91cf\u7684\u521d\u59cb\u503c
    this.thisMonth  = new Date().getMonth()+ 1; //\u5b9a\u4e49\u6708\u7684\u53d8\u91cf\u7684\u521d\u59cb\u503c
    this.thisDay    = new Date().getDate();     //\u5b9a\u4e49\u65e5\u7684\u53d8\u91cf\u7684\u521d\u59cb\u503c
    this.today      = this.thisDay +"/"+ this.thisMonth +"/"+ this.thisYear;   //\u4eca\u5929(d/m/yyyy)
    this.iframe     = window.frames("meizzCalendarIframe"); //\u65e5\u5386\u7684 iframe \u8f7d\u4f53
    this.calendar   = getObjectById("meizzCalendarLayer");  //\u65e5\u5386\u7684\u5c42
    this.dateReg    = "";           //\u65e5\u5386\u683c\u5f0f\u9a8c\u8bc1\u7684\u6b63\u5219\u5f0f

    this.yearFall   = 50;           //\u5b9a\u4e49\u5e74\u4e0b\u62c9\u6846\u7684\u5e74\u5dee\u503c
    this.format     = "yyyy-mm-dd"; //\u56de\u4f20\u65e5\u671f\u7684\u683c\u5f0f
    this.timeShow   = false;        //\u662f\u5426\u8fd4\u56de\u65f6\u95f4
    this.drag       = true;         //\u662f\u5426\u5141\u8bb8\u62d6\u52a8
    this.amendColor = "#D0D0C6";
	this.darkColor  = "#92908C";    //\u63a7\u4ef6\u7684\u6697\u8272
    this.lightColor = "#ffffff";    //\u63a7\u4ef6\u7684\u4eae\u8272
    this.btnBgColor = "#D0D0C6";    //\u63a7\u4ef6\u7684\u6309\u94ae\u80cc\u666f\u8272
    this.wordColor  = "#000000";    //\u63a7\u4ef6\u7684\u6587\u5b57\u989c\u8272
    this.wordDark   = "#ffffff";    //\u63a7\u4ef6\u7684\u6697\u6587\u5b57\u989c\u8272
    this.dayBgColor = "#E0DFDE";    //\u65e5\u671f\u6570\u5b57\u80cc\u666f\u8272
    this.todayColor = "#FF0000";    //\u4eca\u5929\u5728\u65e5\u5386\u4e0a\u7684\u6807\u793a\u80cc\u666f\u8272
    this.DarkBorder = "#ffffff";    //\u65e5\u671f\u663e\u793a\u7684\u7acb\u4f53\u8868\u8fbe\u8272
}   var WebCalendar = new TWebCalendar();

function calendar() //\u4e3b\u8c03\u51fd\u6570
{
    var e = window.event.srcElement;   writeIframe();
    var o = WebCalendar.calendar.style; WebCalendar.eventSrc = e;
	if (arguments.length == 0) WebCalendar.objExport = e;
    else WebCalendar.objExport = eval(arguments[0]);

    WebCalendar.iframe.tableWeek.style.cursor = WebCalendar.drag ? "move" : "default";
	var t = e.offsetTop,  h = e.clientHeight, l = e.offsetLeft, p = e.type;
	while (e = e.offsetParent){t += e.offsetTop; l += e.offsetLeft;}
    o.display = ""; WebCalendar.iframe.document.body.focus();
    var cw = WebCalendar.calendar.clientWidth, ch = WebCalendar.calendar.clientHeight;
    var dw = document.body.clientWidth, dl = document.body.scrollLeft, dt = document.body.scrollTop;
    
    if (document.body.clientHeight + dt - t - h >= ch) o.top = (p=="image")? t + h : t + h + 6;
    else o.top  = (t - dt < ch) ? ((p=="image")? t + h : t + h + 6) : t - ch;
    if (dw + dl - l >= cw) o.left = l; else o.left = (dw >= cw) ? dw - cw + dl : dl;

    if  (!WebCalendar.timeShow) WebCalendar.dateReg = /^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/;
    else WebCalendar.dateReg = /^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;

    try{
        if (WebCalendar.objExport.value.trim() != ""){
            WebCalendar.dateStyle = WebCalendar.objExport.value.trim().match(WebCalendar.dateReg);
            if (WebCalendar.dateStyle == null)
            {
                WebCalendar.thisYear   = new Date().getFullYear();
                WebCalendar.thisMonth  = new Date().getMonth()+ 1;
                WebCalendar.thisDay    = new Date().getDate();
                alert("\u539f\u6587\u672c\u6846\u91cc\u7684\u65e5\u671f\u6709\u9519\u8bef\uff01\n\u53ef\u80fd\u4e0e\u4f60\u5b9a\u4e49\u7684\u663e\u793a\u65f6\u5206\u79d2\u6709\u51b2\u7a81\uff01");
                writeCalendar(); return false;
            }
            else
            {
                WebCalendar.thisYear   = parseInt(WebCalendar.dateStyle[1], 10);
                WebCalendar.thisMonth  = parseInt(WebCalendar.dateStyle[3], 10);
                WebCalendar.thisDay    = parseInt(WebCalendar.dateStyle[4], 10);
                WebCalendar.inputDate  = parseInt(WebCalendar.thisDay, 10) +"/"+ parseInt(WebCalendar.thisMonth, 10) +"/"+ 
                parseInt(WebCalendar.thisYear, 10); writeCalendar();
            }
        }  else writeCalendar();
    }  catch(e){writeCalendar();}
}
function funMonthSelect() //\u6708\u4efd\u7684\u4e0b\u62c9\u6846
{
    var m = isNaN(parseInt(WebCalendar.thisMonth, 10)) ? new Date().getMonth() + 1 : parseInt(WebCalendar.thisMonth);
    var e = WebCalendar.iframe.document.forms[0].tmpMonthSelect;
    for (var i=1; i<13; i++) e.options.add(new Option(i +"\u6708", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function funYearSelect() //\u5e74\u4efd\u7684\u4e0b\u62c9\u6846
{
    var n = WebCalendar.yearFall;
    var e = WebCalendar.iframe.document.forms[0].tmpYearSelect;
    var y = isNaN(parseInt(WebCalendar.thisYear, 10)) ? new Date().getFullYear() : parseInt(WebCalendar.thisYear);
        y = (y <= 1000)? 1000 : ((y >= 9999)? 9999 : y);
    var min = (y - n >= 1000) ? y - n : 1000;
    var max = (y + n <= 9999) ? y + n : 9999;
        min = (max == 9999) ? max-n*2 : min;
        max = (min == 1000) ? min+n*2 : max;
    for (var i=min; i<=max; i++)
    {
      //alert(e.options.length);
      e.options[e.options.length] = new Option(i +"\u5e74", i+"", true, true);//e.options.add(new Option(i +"\u5e74", i));
    }
    e.style.display = "";
    e.value = y; e.focus();
}
function prevM()  //\u5f80\u524d\u7ffb\u6708\u4efd
{
    WebCalendar.thisDay = 1;
    if (WebCalendar.thisMonth==1)
    {
        WebCalendar.thisYear--;
        WebCalendar.thisMonth=13;
    }
    WebCalendar.thisMonth--; writeCalendar();
}
function nextM()  //\u5f80\u540e\u7ffb\u6708\u4efd
{
    WebCalendar.thisDay = 1;
    if (WebCalendar.thisMonth==12)
    {
        WebCalendar.thisYear++;
        WebCalendar.thisMonth=0;
    }
    WebCalendar.thisMonth++; writeCalendar();
}
function prevY(){WebCalendar.thisDay = 1; WebCalendar.thisYear--; writeCalendar();}//\u5f80\u524d\u7ffb Year
function nextY(){WebCalendar.thisDay = 1; WebCalendar.thisYear++; writeCalendar();}//\u5f80\u540e\u7ffb Year
function hiddenSelect(e){for(var i=e.options.length; i>-1; i--)e.options.remove(i); e.style.display="none";}
function getObjectById(id){ if(document.all) return(eval("document.all."+ id)); return(eval(id)); }
function hiddenCalendar(){getObjectById("meizzCalendarLayer").style.display = "none";};
function appendZero(n){return(("00"+ n).substr(("00"+ n).length-2));}//\u65e5\u671f\u81ea\u52a8\u8865\u96f6\u7a0b\u5e8f

String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}


function dayMouseOver()
{
    this.className = "over";
    this.style.backgroundColor = WebCalendar.darkColor;
    if(WebCalendar.day[this.id.substr(8)].split("/")[1] == WebCalendar.thisMonth)
    this.style.color = WebCalendar.lightColor;
}
function dayMouseOut()
{
    this.className = "out"; var d = WebCalendar.day[this.id.substr(8)], a = d.split("/");
    this.style.removeAttribute('backgroundColor');
    if(a[1] == WebCalendar.thisMonth && d != WebCalendar.today)
    {
        if(WebCalendar.dateStyle && a[0] == parseInt(WebCalendar.dateStyle[4], 10))
        this.style.color = WebCalendar.lightColor;
        this.style.color = WebCalendar.wordColor;
    }
}
function writeCalendar() //\u5bf9\u65e5\u5386\u663e\u793a\u7684\u6570\u636e\u7684\u5904\u7406\u7a0b\u5e8f
{
    var y = WebCalendar.thisYear;
    var m = WebCalendar.thisMonth; 
    var d = WebCalendar.thisDay;
    WebCalendar.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28;
    if (!(y<=9999 && y >= 1000 && parseInt(m, 10)>0 && parseInt(m, 10)<13 && parseInt(d, 10)>0)){
        alert("\u5bf9\u4e0d\u8d77\uff0c\u4f60\u8f93\u5165\u4e86\u9519\u8bef\u7684\u65e5\u671f\uff01");
        WebCalendar.thisYear   = new Date().getFullYear();
        WebCalendar.thisMonth  = new Date().getMonth()+ 1;
        WebCalendar.thisDay    = new Date().getDate(); }
    y = WebCalendar.thisYear;
    m = WebCalendar.thisMonth;
    d = WebCalendar.thisDay;
    WebCalendar.iframe.meizzYearHead.innerText  = y +" \u5e74";
    WebCalendar.iframe.meizzYearMonth.innerText = parseInt(m, 10) +" \u6708";
    WebCalendar.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28; //\u95f0\u5e74\u4e8c\u6708\u4e3a29\u5929
    var w = new Date(y, m-1, 1).getDay();
    var prevDays = m==1  ? WebCalendar.daysMonth[11] : WebCalendar.daysMonth[m-2];
    for(var i=(w-1); i>=0; i--) //\u8fd9\u4e09\u4e2a for \u5faa\u73af\u4e3a\u65e5\u5386\u8d4b\u6570\u636e\u6e90\uff08\u6570\u7ec4 WebCalendar.day\uff09\u683c\u5f0f\u662f d/m/yyyy
    {
        WebCalendar.day[i] = prevDays +"/"+ (parseInt(m, 10)-1) +"/"+ y;
        if(m==1) WebCalendar.day[i] = prevDays +"/"+ 12 +"/"+ (parseInt(y, 10)-1);
        prevDays--;
    }
    for(var i=1; i<=WebCalendar.daysMonth[m-1]; i++) WebCalendar.day[i+w-1] = i +"/"+ m +"/"+ y;
    for(var i=1; i<39-w-WebCalendar.daysMonth[m-1]+1; i++)
    {
        WebCalendar.day[WebCalendar.daysMonth[m-1]+w-1+i] = i +"/"+ (parseInt(m, 10)+1) +"/"+ y;
        if(m==12) WebCalendar.day[WebCalendar.daysMonth[m-1]+w-1+i] = i +"/"+ 1 +"/"+ (parseInt(y, 10)+1);
    }
    for(var i=0; i<39; i++)    //\u8fd9\u4e2a\u5faa\u73af\u662f\u6839\u636e\u6e90\u6570\u7ec4\u5199\u5230\u65e5\u5386\u91cc\u663e\u793a
    {
        var a = WebCalendar.day[i].split("/");
        WebCalendar.dayObj[i].innerText    = a[0];
        WebCalendar.dayObj[i].title        = a[2] +"-"+ appendZero(a[1]) +"-"+ appendZero(a[0]);
        WebCalendar.dayObj[i].bgColor      = WebCalendar.dayBgColor;
        WebCalendar.dayObj[i].style.color  = WebCalendar.wordColor;
        if ((i<10 && parseInt(WebCalendar.day[i], 10)>20) || (i>27 && parseInt(WebCalendar.day[i], 10)<12))
            WebCalendar.dayObj[i].style.color = WebCalendar.wordDark;
        if (WebCalendar.inputDate==WebCalendar.day[i])    //\u8bbe\u7f6e\u8f93\u5165\u6846\u91cc\u7684\u65e5\u671f\u5728\u65e5\u5386\u4e0a\u7684\u989c\u8272
        {WebCalendar.dayObj[i].bgColor = WebCalendar.darkColor; WebCalendar.dayObj[i].style.color = WebCalendar.lightColor;}
        if (WebCalendar.day[i] == WebCalendar.today)      //\u8bbe\u7f6e\u4eca\u5929\u5728\u65e5\u5386\u4e0a\u53cd\u5e94\u51fa\u6765\u7684\u989c\u8272
        {WebCalendar.dayObj[i].bgColor = WebCalendar.todayColor; WebCalendar.dayObj[i].style.color = WebCalendar.lightColor;}
    }
}
function returnDate() //\u6839\u636e\u65e5\u671f\u683c\u5f0f\u7b49\u8fd4\u56de\u7528\u6237\u9009\u5b9a\u7684\u65e5\u671f
{
    if(WebCalendar.objExport)
    {
        var returnValue;
        var a = (arguments.length==0) ? WebCalendar.day[this.id.substr(8)].split("/") : arguments[0].split("/");
        var d = WebCalendar.format.match(/^(\w{4})(-|\/|.|)(\w{1,2})\2(\w{1,2})$/);
        if(d==null){alert("\u4f60\u8bbe\u5b9a\u7684\u65e5\u671f\u8f93\u51fa\u683c\u5f0f\u4e0d\u5bf9\uff01\r\n\r\n\u8bf7\u91cd\u65b0\u5b9a\u4e49 WebCalendar.format \uff01"); return false;}
        var flag = d[3].length==2 || d[4].length==2; //\u5224\u65ad\u8fd4\u56de\u7684\u65e5\u671f\u683c\u5f0f\u662f\u5426\u8981\u8865\u96f6
        returnValue = flag ? a[2] +d[2]+ appendZero(a[1]) +d[2]+ appendZero(a[0]) : a[2] +d[2]+ a[1] +d[2]+ a[0];
        if(WebCalendar.timeShow)
        {
            var h = new Date().getHours(), m = new Date().getMinutes(), s = new Date().getSeconds();
            returnValue += flag ? " "+ appendZero(h) +":"+ appendZero(m) +":"+ appendZero(s) : " "+  h  +":"+ m +":"+ s;
        }
        WebCalendar.objExport.value = returnValue;
        hiddenCalendar();
    }
}
document.onclick = function(){
 if(WebCalendar.eventSrc != window.event.srcElement) hiddenCalendar();
}