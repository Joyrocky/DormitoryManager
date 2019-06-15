<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/10/31
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="com.itheima.po.Dormitory" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>

    <style type="text/css">
        .layui-table{
                text-align: center;
            }
        .layui-table th{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/findClassStudent">班级学生</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/findClassStudent" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/findClassStudent" >
            <input class="layui-input" placeholder="请输入班级编号" name="c_classid" id="c_classid">
            <input class="layui-input" placeholder="请输入班级名" name="c_classname" id="c_classname">

            <button class="layui-btn" lay-submit lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>

    <%--表格数据--%>
    <table class="layui-table" id="tb">
        <thead>
        <tr>
            <th>班级编号</th>
            <th>班级名</th>
            <th>辅导员</th>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>电话</th>
            <th>宿舍编号</th>
        </thead>
        <tbody>

        <!--将返回的Model数据的students集合分步提取出来，循环遍历-->
        <!--前一段为Class数据，后面多段为Student数据-->
        <!--返回数据不受刷新影响，原本就包含在页面中-->
        <c:forEach items="${cs}" var="c">

                <c:set value="${c.students}" var="cc" />

                <c:forEach items="${cc}" var="sc">
                    <tr>
                    <td>${c.c_classid}</td>
                    <td>${c.c_classname}</td>
                    <td>${c.c_counsellor}</td>
                    <td>${sc.s_studentid}</td>
                    <td>${sc.s_name}</td>
                    <td>${sc.s_phone}</td>
                    <td>${sc.s_dormitoryid}</td>
                    </tr>
                </c:forEach>

        </c:forEach>
        </tbody>
    </table>

</div>

<script>

    <!--本想采用Ajax来提交表单,实现异步刷新,但是layui的iframe每次会自动刷新还原为页面-->
    // layui.use(['jquery','form','layer','laydate'], function(){
    //     var form = layui.form,
    //         $ = layui.jquery,
    //         laydate = layui.laydate;
    //
    //     form.on('submit(search)', function(data){
    //
    //         var param = data.field;
    //         console.log(JSON.stringify(param));
    //
    //         $.ajax({
    //             url: '/findClassStudentlist',
    //             type: 'post',
    //             data:JSON.stringify(param),
    //             dataType: 'json',
    //             async: false,
    //             contentType: "application/json; charset=utf-8",
    //             success: function (dd) {
    //
                        //将获取的JSON数据分步提取出来，前一段为Class数据，后面多段为Student数据
    //                 var s= '';
    //                 for(var i in dd){
    //                    var c_classid = dd[i].c_classid;
    //                    var c_classname = dd[i].c_classname;
    //                    var c_counsellor = dd[i].c_counsellor;
    //                    var students = dd[i].students;
    //                 }
    //
                        //拼接异步刷新的表格部分，将数据一起拼接成HTML
    //                 for(var j in students){
    //                     var s_studentid = students[j].s_studentid;
    //                     var s_name = students[j].s_name;
    //                     var s_phone = students[j].s_phone;
    //                     var s_dormitoryid = students[j].s_dormitoryid;
    //                     s += '<tr><td>'+c_classid+'</td><td>'+c_classname+'</td><td>'+c_counsellor+'</td><td>'+
    //                         s_studentid+'</td><td>'+s_name+'</td><td>'+s_phone+'</td><td>'+s_dormitoryid+'</td></tr>';
    //                     //console.log(s_studentid);
    //                 }
    //
    //                 setTimeout(function () {window.location.href='/findClassStudent';},2000);
    //                 console.log(s);

                        //将刷新部分拼接到表格需要刷新的地方
    //                 $('#tbb').append(s);
    //
    //             },
    //             error: function () {
    //                 setTimeout(function () {window.location.href='/findClassStudent';},2000);
    //             }
    //         });
    //     });
    //
    // });
</script>

</body>


</html>
