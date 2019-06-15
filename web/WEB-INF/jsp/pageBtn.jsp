<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/11/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>后台登录</title>
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
   <div class="page-bar" id="pg_div">
       <ul class="page-num-ul">
           <li class="pg-li">共${param.totalCount}条记录&nbsp;&nbsp;${param.currentPageNo}/${param.totalPageCount}页
           <c:if test="${param.currentPageNo>1}">
                <a class="pg_a" href="javascript:page_nav(document.forms[0],1);">首页</a>
                <a class="pg_a" href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a>
           </c:if>
           <c:if test="${param.currentPageNo<param.totalPageCount}">
                <a class="pg_a" href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});">下一页</a>
                <a class="pg_a" href="javascript:page_nav(document.forms[0],${param.totalPageCount});">最后一页</a>
           </c:if>
           </li>
       </ul>
       <ul class="page-go-form"><label>跳转至</label>
           <input type="text" name="inputPage" id="inputPage" class="page-key" />页
           <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
       </ul>
   </div>
</body>
<script>
    function page_nav(frm,num) {
        frm.pageIndex.value = num;
        frm.submit();
    }

    function  jump_to(frm,num) {
        var  regexp=/^[1-9]\d*$/;
        var  totalPageCount = document.getElementById("totalPageCount").value;
        if (!regexp.test(num)){
            alert("请输入大于0的正整数！")
            return false;
        }else if((num-totalPageCount)>0){
            alert("请输入小于总页数的页码");
            return false;
        }else{
            page_nav(frm,num);
        }

    }
</script>
</html>
