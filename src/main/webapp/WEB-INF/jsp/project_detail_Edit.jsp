<%--
  Created by IntelliJ IDEA.
  User: KV
  --%>
<!DOCTYPE html >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Employee Management </title>
    <link rel="icon" type="image/png" href="../../images/icons/title.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

</head>

<body class="nav-md">


<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="Dashboard" class="site_title"> <img style="margin-top: -0px; width: 40px;height: 40px"
                                                                 src="../../images/favicon.ico"><span
                            style="margin-top: 20px;">&nbsp;Four Seasons!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic" style=" width: 80px;height: 80px">
                        <img src="../../images/icons/${loggerName.pic}" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2> ${loggerName.name}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="Dashboard">Dashboard</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> Employee <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="tables_dynamic">Employee Manage</a></li>
                                    <li><a href="attendance">Attendance</a></li>
                                    <li><a href="salary">Salary Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i>Project<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="projects">Projects</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> Notice <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="notice">View All</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-user"></i> Employee Data <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="contacts">Contacts</a></li>
                                    <li><a href="profile">Profile</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="media_gallery">View Images</a></li>
                                    <li><a href="calendar">Calendar</a></li>
                                    <li><a href="e_commerce">E-commerce</a></li>
                                    <li><a href="pricing_tables">Pricing Tables</a></li>
                                    <li><a href="login">Login Page</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                               id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="../../images/icons/${loggerName.pic}" alt="">${loggerName.name}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;"> Profile</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Help</a>
                                <a class="dropdown-item" href="/"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Project Detail
                            <small> design</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                      <button class="btn btn-secondary" type="button">Go!</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>New Partner Contracts Consultancy</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="#">Settings 1</a>
                                            <a class="dropdown-item" href="#">Settings 2</a>
                                        </div>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">

                                <div class="col-md-9 col-sm-9  ">

                                    <ul class="stats-overview">
                                        <li>
                                            <span class="name"> Estimated budget </span>
                                            <span class="value text-success">${projectData.estBudget} </span>
                                        </li>
                                        <li>
                                            <span class="name"> Total amount spent </span>
                                            <span class="value text-success"> ${projectData.spentBudget} </span>
                                        </li>
                                        <li class="hidden-phone">
                                            <span class="name"> Estimated project duration </span>
                                            <span class="value text-success"> ${projectData.duration} </span>
                                        </li>
                                    </ul>
                                    <br/>

                                    <form  method="POST" action="saveActivities" name="saveActivities">
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">
                                                Activity Name<span
                                                        class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" data-validate-length-range="6"
                                                       placeholder="ex. Project Manage"
                                                      name="activity"
                                                        required="required">

                                            </div>
                                        </div>
                                        <br>
                                        <br>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Description<span
                                                    class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input style="height: 60px" class="form-control" data-validate-length-range="6"
                                                       data-validate-words="2" type="text" name="description"
                                                      required="required"
                                                />
                                            </div>
                                        </div>
                                        <br>
                                        <br>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Date<span
                                                    class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" data-validate-length-range="6"
                                                       data-validate-words="2" name="date"
                                                       required="required" type="date"
                                                />
                                            </div>
                                        </div>
                                        <br>
                                        <br>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Project Id<span
                                                    class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                                <input class="form-control" data-validate-length-range="6"
                                                       data-validate-words="2" name="projectId"
                                                       required="required" readonly="true" type="text" value="${projectData.projectId}"
                                                />
                                            </div>
                                        </div>
                                        <div class="text-center mtop20">

                                            <button type='submit' class="btn btn-primary" style="width: 30%" value="Register">Submit</button>
                                            <%--<a href="#" class="btn btn-sm btn-primary">Save Activity</a>--%>
                                            <br>
                                            <a href="/project_detail?projectId=${projectData.projectId}"
                                               class="btn btn-sm btn-warning"><< Back</a>
                                        </div>
                                    </form>


                                    <h4>Recent Activity Month<p id="output"></p></h4>

                                    <!-- end of user messages -->
                                    <ul class="messages">
                                        <c:forEach items="${loadActivity}" var="e">

                                            <li style="background-color: hsla(34,23%,94%,0.36)">


                                                <div style="margin-right: 11px" class="message_date">
                                                    <script language="javascript">
                                                        window.addEventListener("load", function (e) {
                                                            t1 = ${e.date.month} +1;
                                                            document.getElementById('output').innerHTML = t1;
                                                        })
                                                    </script>
                                                    <h4 class="date text-info">Modified Date : ${e.date}</h4>

                                                </div>
                                                <div class="message_wrapper">
                                                    <h4 class="heading">Activity Name :- ${e.activity} <br>
                                                    Activity Id :- ${e.activityId}
                                                    </h4>
                                                    <blockquote style="width: 60%" class="message">Description :- ${e.description}
                                                    </blockquote>
                                                    <br/>
                                                    <p class="url">
                                                        <span class="fs1 text-info" aria-hidden="true"
                                                              data-icon=""></span>
                                                        <a href="#"><i class="fa fa-paperclip"></i>Link :- Click Here</a>
                                                    </p>
                                                </div>

                                            </li>
                                            <br>
                                        </c:forEach>
                                    </ul>

                                    <!-- end of user messages -->


                                </div>

                                <!-- start project-detail sidebar -->
                                <div class="col-md-3 col-sm-3  ">

                                    <section class="panel">

                                        <div class="x_title">
                                            <h2>Project Description</h2>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="panel-body">
                                            <h3 class="green"><i
                                                    class="fa fa-paint-brush"></i>${projectData.projectName}
                                            </h3>

                                            <p>${projectData.teamMembers}</p>
                                            <br/>

                                            <div class="project_detail">

                                                <p class="title">Client Name</p>
                                                <p>${projectData.client}</p>
                                                <p class="title">Client Mobile</p>
                                                <p>${projectData.clientMobile}</p>
                                            </div>

                                            <br/>
                                            <h5>Project files</h5>
                                            <ul class="list-unstyled project_files">
                                                <li><a href=""><i class="fa fa-file-word-o"></i>
                                                    Functional-requirements.docx</a>
                                                </li>
                                                <li><a href=""><i class="fa fa-file-pdf-o"></i> UAT.pdf</a>
                                                </li>
                                                <li><a href=""><i class="fa fa-mail-forward"></i>
                                                    Email-from-flatbal.mln</a>
                                                </li>
                                                <li><a href=""><i class="fa fa-picture-o"></i> Logo.png</a>
                                                </li>
                                                <li><a href=""><i class="fa fa-file-word-o"></i>
                                                    Contract-10_12_2014.docx</a>
                                                </li>
                                            </ul>
                                            <br/>


                                        </div>

                                    </section>

                                </div>
                                <!-- end project-detail sidebar -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->

            <footer>
                <div class="pull-right">
                    Copyright © Employee Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Kavindra  Ariyaratne</a>
                </div>
                <div class="clearfix"></div>
            </footer>
        <!-- /footer content -->
    </div>
</div>


<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- ECharts -->
<script src="../../vendors/echarts/dist/echarts.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>