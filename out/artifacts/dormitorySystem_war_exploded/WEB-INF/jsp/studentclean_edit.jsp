<%--
  Created by IntelliJ IDEA.
  User: 周训凯
  Date: 2019/4/25
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body>

<div class="x-body">
    <form class="layui-form"  id="f_auto" action="/updateStudentClean" method="post" >

        <input type="hidden" value="${sessionScope.d.g_id}" name="g_id" id="g_id"/>
        <div class="layui-form-item">
            <label for="s_studentid" class="layui-form-label">
                <span class="">学号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_studentid" name="s_studentid"
                       autocomplete="off" value="${sessionScope.d.s_studentid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_name" class="layui-form-label">
                <span class="">姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_name" name="s_name"
                       autocomplete="off" value="${sessionScope.d.s_name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_grade" class="layui-form-label">
                <span class="">卫生打分</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_grade" name="s_grade"
                       autocomplete="off" value="${sessionScope.d.s_grade}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">班级编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classid" name="s_classid"
                       autocomplete="off" value="${sessionScope.d.s_classid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_dormitoryid" class="layui-form-label">
                <span class="">寝室编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_dormitoryid" name="s_dormitoryid"
                       autocomplete="off" value="${sessionScope.d.s_dormitoryid}" class="layui-input">
            </div>
        </div>

        <input type="hidden" value="${sessionScope.d.update_time}" name="update_time" id="update_time"/>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateClass">
                修改
            </button>
        </div>
    </form>
</div>

<script>
</script>
</body>
</html>


