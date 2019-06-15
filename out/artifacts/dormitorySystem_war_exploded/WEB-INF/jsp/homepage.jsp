<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/10/15
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
    <script src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <script src="/layui_exts/excel.js"></script>

    <style>
        .o_div{
            background: url("/images/01.jpg") no-repeat;
        }
        .o_span{
            display: block;
            text-align: center;
            font-size: 20px;
            letter-spacing:8px
        }
    </style>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="">宿舍管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <%--<ul class="layui-nav left fast-add" lay-filter="">--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a href="javascript:;">+新增</a>--%>
            <%--<dl class="layui-nav-child"> <!-- 二级菜单 -->--%>
                <%--<dd><a onclick=""><i class="iconfont">&#xe6a2;</i>资讯</a></dd>--%>
                <%--<dd><a onclick=""><i class="iconfont">&#xe6a8;</i>图片</a></dd>--%>
                <%--<dd><a onclick=""><i class="iconfont">&#xe6b8;</i>用户</a></dd>--%>
            <%--</dl>--%>
        <%--</li>--%>
    <%--</ul>--%>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img">${sessionScope.ad.a_username}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('切换帐号','loginOut')">切换帐号</a></dd>
                <dd><a href="/loginOut">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/loginOut">前台首页</a></li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>学生管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/findStudent">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生信息</cite>

                        </a>
                    </li >

                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>班级管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/findClass">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>班级列表</cite>
                        </a>
                    </li >

                    <li>
                        <a _href="/findClassStudent">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>班级学生</cite>
                        </a>
                    </li >
                </ul>
            </li>


            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#59095;</i>
                    <cite>宿舍管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/findDormitory">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>宿舍列表</cite>
                        </a>
                    </li >
                </ul>

                <ul class="sub-menu">
                    <li>
                        <a _href="/findDormitoryStudent">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>人员信息</cite>
                        </a>
                    </li >
                </ul>

                <ul class="sub-menu">
                    <li>
                        <a _href="/findDormRepair">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>维修登记</cite>
                        </a>
                    </li >
                </ul>

            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#59042;</i>
                    <cite>卫生管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>

                <ul class="sub-menu">
                    <li>
                        <a _href="/findDormClean">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>宿舍卫生</cite>
                        </a>
                    </li >
                </ul>

                <ul class="sub-menu">
                    <li>
                        <a _href="/findStudentClean">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>学生卫生</cite>
                        </a>
                    </li >
                </ul>

            </li>

            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe613;</i>
                    <cite>访客管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/findVisitor">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>访客列表</cite>
                        </a>
                    </li >
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/findAdmin">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员列表</cite>
                        </a>
                    </li >


                </ul>
            </li>


        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show o_div" >
                <span class="o_span">${sessionScope.ad.a_username}管理员，欢迎来到宿舍管理系统！</span>
                <div class="layui-col-md6" style="padding: 30px;left: 60px;background-color: #F2F2F2;">
                <div class="layui-card">
                <div class="layui-card-header">个人信息
                        </div>
                        <div class="layui-card-body">
                            <%--<div class="layui-form-label" style="text-align: left">你好</div>--%>
                           用户名：${sessionScope.ad.a_username}
                        </div>
                        <div class="layui-card-body">
                            姓名：${sessionScope.ad.a_name}
                        </div>
                        <div class="layui-card-body">
                            电话：${sessionScope.ad.a_phone}
                        </div>
                        <div class="layui-card-body">
                            级别描述：${sessionScope.ad.a_describe}
                        </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2019-2020 版权所有</div>
</div>
<!-- 底部结束 -->

<script>

    layui.config({
        base: 'layui_exts/',
    }).extend({
        excel: 'excel',
    });

</script>
</body>
</html>
