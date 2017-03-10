<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <title>在线客服</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <meta content="telephone=no" name="format-detection">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="<%=basePath%>wx/send_files/base.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>wx/send_files/index.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>wx/send_files/kfmain.css">
   
</head>
<body >
 Welcome<br/>
    <input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button>
    <div id="message">
    </div>
  </body>
   
  <script type="text/javascript">
      var websocket = null;
       
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("ws://localhost:8080/tal/websocket");
      }
      else{
          alert('Not support websocket')
      }
       
      //连接发生错误的回调方法
      websocket.onerror = function(){
          setMessageInnerHTML("error");
      };
       
      //连接成功建立的回调方法
      websocket.onopen = function(event){
          setMessageInnerHTML("open");
      }
       
      //接收到消息的回调方法
      websocket.onmessage = function(event){
          setMessageInnerHTML(event.data);
      }
       
      //连接关闭的回调方法
      websocket.onclose = function(){
          setMessageInnerHTML("close");
      }
       
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function(){
          websocket.close();
      }
       
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
          document.getElementById('message').innerHTML += innerHTML + '<br/>';
      }
       
      //关闭连接
      function closeWebSocket(){
          websocket.close();
      }
       
      //发送消息
      function send(){
          var message = document.getElementById('text').value;
          websocket.send(message);
      }
  </script>
</html>