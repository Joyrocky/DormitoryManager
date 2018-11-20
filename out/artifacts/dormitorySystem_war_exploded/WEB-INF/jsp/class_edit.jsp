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
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/pg_btn.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body>

<div class="x-body">
    <form class="layui-form"  id="f_auto" action="/updateClass" method="post" >
        <input type="hidden" value="${sessionScope.c.c_id}" name="c_id" id="c_id"/>
        <div class="layui-form-item">
            <label for="s_classid" class="layui-form-label">
                <span class="">班级编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="s_classid" name="s_classid"
                       autocomplete="off" value="${sessionScope.c.s_classid}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="c_classname" class="layui-form-label">
                <span class="">班级名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="c_classname" name="c_classname"
                       autocomplete="off" value="${sessionScope.c.c_classname}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="c_counsellor" class="layui-form-label">
                <span class="">辅导员姓名</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="c_counsellor" name="c_counsellor"
                       autocomplete="off" value="${sessionScope.c.c_counsellor}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateClass">
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
    //     form.on('submit(updateClass)', function(obj,c_id) {
    //
    //         $.ajax({
    //             url: '/updateClass',
    //             type: "post",
    //             data:{"c_id":c_id},
    //             success:function(data){
    //                 layer.msg('修改成功', {icon: 1, time: 3000});
    //                 setTimeout(function () {window.location.href='/findClass';},2000);
    //
    //             },
    //             error:function(){
    //                 console.log($("#c_id").val());
    //                 layer.msg('修改失败',{icon:0,time:3000});
    //                 setTimeout(function () {window.location.href='/findClass';},2000);
    //             }
    //         });
    //     })
    //
    // });

    // function editClass(){
    //            $.ajax({
    //                     url: '/updateClass',
    //                     type: "post",
    //                      dateType:'json',
    //                     data:{"c_id":c_id,"s_classid":s_classid,"c_classname":c_classname,"c_counsellor":c_counsellor},
    //                     success:function(data){
    //                         console.log(data);
    //                         layer.msg('修改成功', {icon: 1, time: 3000});
    //                         setTimeout(function () {window.location.href='/findClass';},2000);
    //
    //                     },
    //                     error:function(){
    //                         console.log($("#c_id").val());
    //                         layer.msg('修改失败',{icon:0,time:3000});
    //                         setTimeout(function () {window.location.href='/findClass';},2000);
    //                     }
    //                 });
    //         }
</script>
</body>
</html>
