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
        <a href="/findDormitoryStudent">人员信息</a>

      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/findDormitoryStudent" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/findDormitoryStudent" >
            <input class="layui-input" placeholder="请输入宿舍编号" name="s_dormitoryid" id="s_dormitoryid">

            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>


    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEmployeeForm">
                <div class="layui-form-item">
                    <label class="layui-form-label">宿舍编号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="s_dormitoryid" class="layui-input" placeholder="请输入宿舍编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">床位总数：</label>
                    <div class="layui-input-block">
                        <input type="text" name="d_bedtotal" class="layui-input" placeholder="请输入床位总数">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">已用床位：</label>
                    <div class="layui-input-block">
                        <input type="text" name="d_bed" class="layui-input" placeholder="请输入已用床位">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">管理员：</label>
                    <div class="layui-input-block">
                        <input type="text" name="a_name" class="layui-input" placeholder="请输入管理员姓名">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--表格数据--%>
    <table class="layui-table">
        <thead>
        <tr>
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>宿舍编号</th>
            <th>宿舍楼</th>
            <th>已用床位</th>
            <th>学生姓名</th>
            <th>电话</th>
            <th>班级编号</th>
                <th>班级名</th>

        </thead>
        <tbody>
<c:forEach items="${ds}" var="d">

    <c:set value="${d.students}" var="dd" />

    <c:forEach items="${dd}" var="sd">
        <tr>
            <td>${d.s_dormitoryid}</td>
            <td>${d.d_dormbuilding}</td>
            <td>${d.d_bed}</td>
            <td>${sd.s_name}</td>
            <td>${sd.s_phone}</td>
            <td>${sd.s_classid}</td>
            <td>${sd.s_classname}</td>
        </tr>
    </c:forEach>

</c:forEach>
        </tbody>
    </table>
</div>



</body>


</html>
