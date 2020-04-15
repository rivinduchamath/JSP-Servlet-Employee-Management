<%--
  Created by IntelliJ IDEA.
  User: Rivindu Chamath
  Date: 03-Mar-20
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Employee Management </title>
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
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
                    <div class="profile_pic">
                        <img src="../../images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>Rivindu Chamath</h2>
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
                            <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="form.jsp">General Form</a></li>
                                    <li><a href="form_advanced.jsp">Advanced Components</a></li>
                                    <li><a href="form_validation">Form Validation</a></li>
                                    <li><a href="form_wizards.jsp">Form Wizard</a></li>
                                    <li><a href="form_upload.jsp">Form Upload</a></li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> UI Elements <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="general_elements.jsp">General Elements</a></li>
                                    <li><a href="media_gallery.jsp">Media Gallery</a></li>

                                    <li><a href="index.jsp">Icons</a></li>
                                    <li><a href="glyphicons.jsp">Glyphicons</a></li>

                                    <li><a href="invoice.jsp">Invoice</a></li>

                                    <li><a href="calendar">Calendar</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="tables">Tables</a></li>
                                    <li><a href="tables_dynamic">Table Dynamic</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="chartjs.jsp">Chart JS</a></li>

                                    <li><a href="morisjs.jsp">Moris JS</a></li>
                                    <li><a href="echarts.jsp">ECharts</a></li>

                                </ul>
                            </li>

                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-bug"></i> Additional Pages <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="e_commerce.jsp">E-commerce</a></li>
                                    <li><a href="projects">Projects</a></li>
                                    <li><a href="project_detail.jsp">Project Detail</a></li>
                                    <li><a href="contacts">Contacts</a></li>
                                    <li><a href="profile">Profile</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="page_403.jsp">403 Error</a></li>
                                    <li><a href="page_404.jsp">404 Error</a></li>
                                    <li><a href="page_500.jsp">500 Error</a></li>
                                    <li><a href="plain_page.jsp">Plain Page</a></li>
                                    <li><a href="login">Login Page</a></li>
                                    <li><a href="pricing_tables.jsp">Pricing Tables</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
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
                                <img src="../../images/img.jpg" alt="">Rivindu Chamath
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;"> Profile</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Help</a>
                                <a class="dropdown-item" href="login"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                        <li role="presentation" class="nav-item dropdown open">
                            <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1"
                               data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul class="dropdown-menu list-unstyled msg_list" role="menu"
                                aria-labelledby="navbarDropdown1">
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="../../images/img.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="../../images/img.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="../../images/img.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="../../images/img.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <div class="text-center">
                                        <a class="dropdown-item">
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
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
                        <h3>Projects
                            <small>Listing design</small>
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
                <form  method="POST" action="/projectController" name="projectController">
                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Projects</h2>
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

                                <p style="font-weight: bold; font-size: 14px">Click Here To Add New Project >> &emsp;
                                    <button class="btn-outline-info" style="width: 9%;font-weight: bolder;color: black;
                          height:36px; " href="/"
                                            onMouseOver="this.style.color='white'; this.style.fontWeight='bold'"
                                            onMouseOut="this.style.color='black'; "
                                    >+New
                                    </button>
                                </p>

                                <!-- start project list -->
                                <table id="datatable-buttons" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="width: 1%">#</th>
                                        <th style="width: 20%">Project Name</th>
                                        <th>Closing date</th>
                                        <th>Project Progress</th>
                                        <th>Status</th>
                                        <th style="width: 20%">#Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lias}" var="a">
                                        <tr>
                                            <td>${a.projectId}</td>
                                            <td>
                                                <a>${a.projectName}</a>
                                                <br/>
                                                <small>Created ${a.date}</small>
                                            </td>
                                            <td>
                                                <ul class="list-inline">
                                                    <small>Expected ${a.duration}</small>
                                                </ul>
                                            </td>
                                            <td class="project_progress">
                                                <div class="progress progress_sm">
                                                    <div class="progress-bar bg-green" role="progressbar"
                                                         data-transitiongoal="${a.progress}"></div>
                                                </div>
                                                <small>${a.progress}% Complete</small>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-success btn-xs">Success</button>
                                            </td>
                                            <td>
                                                <a href="/project_detail" class="btn btn-primary btn-xs"><i
                                                        class="fa fa-folder"></i> View </a>
                                                <a href="/projectController" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>
                                                    Edit </a>
                                                <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
                                                    Delete </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!-- end project list -->

                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Copyright © Employee Management 2018.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu
                Wijayarathna</a>
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
<!-- bootstrap-progressbar -->
<script src="../../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>