<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/11/14
  Time: 16:35
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
    <form class="layui-form" action="/updateStudent" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.s_id}" name="s_id" id="s_id"/>
        <div class="layui-form-item">
            <label for="s_studentid" class="layui-form-label">
                <span class="f_sp">学号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_studentid" name="s_studentid"
                       autocomplete="off" value="${sessionScope.s.s_studentid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_name" class="layui-form-label">
                <span class="f_sp">姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_name" name="s_name"
                       autocomplete="off" value="${sessionScope.s.s_name}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_sex" class="layui-form-label">
                <span class="f_sp">性别</span>
            </label>
            <div class="layui-input-inline" id="s_sex">
                <input type="radio" name="s_sex" id="s_male" value="男" title="男" checked="">
                <input type="radio" name="s_sex" id="s_female" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_age" class="layui-form-label">
                <span class="f_sp">年龄</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_age" name="s_age"
                       autocomplete="off" value="${sessionScope.s.s_age}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_phone" class="layui-form-label">
                <span class="f_sp">电话</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_phone" name="s_phone"
                       autocomplete="off" value="${sessionScope.s.s_phone}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">*</span>班级编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classid" name="s_classid"
                       autocomplete="off" value="${sessionScope.s.s_classid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">*</span>班级名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classname" name="s_classname"
                       autocomplete="off" value="${sessionScope.s.s_classname}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="s_dormitoryid" class="layui-form-label">
                <span class="">*</span>寝室编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_dormitoryid" name="s_dormitoryid"
                       autocomplete="off" value="${sessionScope.s.s_dormitoryid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>

<script>
    // layui.use(['form','layer','laydate'], function(){
    //     var form = layui.form,
    //         $ = layui.jquery,
    //         laydate = layui.laydate;
    //     form.on('submit(updateForm)', function(obj,s_id) {
    //
    //         $.ajax({
    //             url: '/updateStudent',
    //             type: "post",
    //             data:{"s_id":s_id},
    //             success:function(data){
    //                 layer.msg('修改成功', {icon: 1, time: 3000});
    //                 setTimeout(function () {window.location.href='/findStudent';},2000);
    //
    //             },
    //             error:function(){
    //                 console.log($("#s_id").val());
    //                 layer.msg('修改失败',{icon:0,time:3000});
    //                 setTimeout(function () {window.location.href='/findStudent';},2000);
    //             }
    //         });
    //     })
    //
    // });

</script>
</body>
</html>
