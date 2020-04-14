<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13-Apr-20
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
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
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->

    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

    <script>
        function myFunction() {
            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("datatable-buttons");
            tr = table.getElementsByTagName("tr");
            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="Dashboard" class="site_title"> <img style="margin-top: -0px; width: 40px;height: 40px" src="../../images/favicon.ico"><span style="margin-top: 20px;">&nbsp;Four Seasons!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic"style=" width: 80px;height: 80px">
                        <img src="../../images/icons/${loggerName.pic}"  alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>${loggerName.name}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

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
                            <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
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
                            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
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
                            <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="e_commerce.jsp">E-commerce</a></li>
                                    <li><a href="projects.jsp">Projects</a></li>
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
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
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
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="../../images/icons/${loggerName.pic}" alt=""> ${loggerName.name}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item"  href="javascript:;"> Profile</a>
                                <a class="dropdown-item"  href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item"  href="javascript:;">Help</a>
                                <a class="dropdown-item"  href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                        <li role="presentation" class="nav-item dropdown open">
                            <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul class="dropdown-menu list-unstyled msg_list" role="menu" aria-labelledby="navbarDropdown1">
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
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
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
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
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
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
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
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
                        <h3>Tables <small>Some examples to get you started</small></h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row" style="display: block;">

                    <div class="clearfix"></div>
                    <div class="col-md-8 col-sm-8 ">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Today active users
                                    <small>Update Today
                                        Users</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <button class="btn btn-success" style="position: absolute;display:inline; right: 0;width: 10%;
                                             height: 35px; ">Pay</button>
                                </ul>
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">

                                <div class="row">

                                    <div class="col-sm-12">

                                        <div class="card-box table-responsive">

                                            <table id="datatable-buttons"  class="table table-striped jambo_table bulk_action table-bordered">
                                                <thead class="thead-dark">

                                                <tr>
                                                    <th>EmpId</th>
                                                    <th>Name</th>
                                                    <th>Salary</th>
                                                    <th>OT Hours</th>
                                                    <th>Total Salary</th>
                                                    <th>Delete</th>
                                                    <th><input type="checkbox" id="check-all" class="flat"></th>
                                                </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach items="${listEmployeesTableSalary}" var="e">
                                                    <tr>
                                                        <td>${e.employee}</td>
                                                        <td>${e.employeeName}</td>
                                                        <td>${e.salary}</td>
                                                        <td>${e.totalOtHours}</td>
                                                        <td>${e.fullPayment}</td>
                                                        <td><a href="/delete?pid=${e.salaryId}"><span
                                                                class="glyphicon glyphicon-trash"></span></a></td>
                                                        <td class="a-center ">
                                                            <input type="checkbox" class="flat" name="table_records">
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--///////////////////////////////////////////////////////-->
                    <form  method="POST" action="/salarySave" name="salary">
                    <div class="col-md-4 col-sm-4 " style="float: right">


                        <div class="form-group">
                            <label for="itemCode">Employee Id</label>
                            <input type="text" class="form-control"
                                   required="required" name="employee"
                                   id="itemCode" placeholder="ID" readonly/>
                        </div>

                        <div class="form-group">
                            <label for="itemDesc">Employee Name </label>
                            <input type="text" class="form-control" id="itemDesc" placeholder="Name">
                        </div>

                        <div class="col-md-7 col-sm-7 ">
                            <label for="itemDesc">Salary </label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">

                                    <span class="input-group-text">
                                       Normal
                                </span>
                                </div>
                                <input type="text" class="form-control" name="salary" id="itemTime"
                                       aria-label="Dollar amount (with dot and two decimal places)">

                            </div>
                        </div>
                        <div class="col-md-5 col-sm-5 ">
                            <label for="itemDesc">&nbsp;</label>
                            <div class="input-group mb-3" style="float: right">
                                <div class="input-group-prepend">
                                <span class="input-group-text">
                                       OT
                                </span>
                                </div>
                                <input type="text" class="form-control"
                                       id="itemTime2"  name="totalOtHours"
                                       aria-label="Dollar amount (with dot and two decimal places)"/>

                            </div>
                        </div>

                        <div class="col-md-12 col-sm-12 ">
                            <label for="itemDesc">&nbsp;</label>

                            <div class="input-group mb-3" style="float: right">
                                <div class="input-group-prepend">
                                <span class="input-group-text">
                                       Total
                                </span>
                                </div>
                                <input type="text" id="tot" class="form-control"
                                       name="fullPayment"  value= "0" id="itemTime3"
                                       aria-label="Dollar amount (with dot and two decimal places)">

                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 ">
                            <label for="itemDesc">&nbsp;</label>
                            <div class="input-group mb-5" style="float: right">

                                <button type='submit' class="btn btn-success" style="width: 50%" value="Register">Submit</button>
                                <button type='reset' class="btn btn-outline-success" value="">Reset</button>

                            </div>
                        </div>
                    </div>
                    <!--////////////////////////////////////////////-->
                    </form>
                </div>

            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Copyright © Employee Management 2019.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu
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
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>
<script>
    var selectedRow = null;
    $("#datatable-buttons tbody").on('click', 'tr', function () {
        var date = new Date();
        var date2 = new Date();
        var today = date.getHours() +":" + (date.getMinutes())+":"+date.getSeconds();
        date2.setHours(date.getHours()+8);
        var today2 = date2.getHours() +":" + (date.getMinutes())+":"+date.getSeconds();
        selectedRow = $(this);
        $("#itemCode").val($(this).find("td:first-child").text());
        $("#itemDesc").val($(this).find("td:nth-child(2)").text());
        $("#itemTime").val($(this).find("td:nth-child(3)").text());
        $("#itemTime2").val($(this).find("td:nth-child(4)").text());
        $("#tot").val($(this).find("td:nth-child(5)").text());
        $("#datatable-buttons tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>
<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<script src="../../vendors/iCheck/icheck.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>
