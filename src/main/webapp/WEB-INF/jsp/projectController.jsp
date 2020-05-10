<%--
  Created by IntelliJ IDEA.
  User: KV
  --%>
<!DOCTYPE html >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Employee Management</title>
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
</head>

<body style="cursor: pointer" class="nav-md">

<div class="pos-f-t">
    <div class="collapse" id="navbarToggleExternalContent">
        <div class="bg-dark p-4">
            <nav class="navbar navbar-expand-lg navbar-light bg-dark">
                <a style="cursor: pointer" class="navbar-brand" href="Dashboard">Employee Management</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a style="cursor: pointer !important;" class="nav-link" href="Dashboard">Home <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/login">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Log Out</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <nav class="navbar navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent"
                aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>

<c:choose>

    <%--</c:when>--%>
    <c:when test="${mode=='MODE_REG' }">
        <!-- page content -->

        <div class="">
            <div class="">

                <div class="x_panel">
                    <div class="x_title">
                        <h2>Back >>
                            <small><a style="color: #007bff;cursor:hand"
                                      onMouseOver="this.style.color='red'; this.style.fontWeight='bold'"
                                      onMouseOut="this.style.color='#00F'; this.style.fontWeight='normal'"
                                      href="/projects">click here</a></small>
                        </h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <form class="form-horizontal" method="POST" action="/projectSave">
                             <span class="section">+New Projects

                            </span>

                                <%--Project Name--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Project Name <span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" data-validate-length-range="6"
                                           data-validate-words="2" name="projectName"
                                           placeholder="ex. Employee Management" required="required"
                                           value="${project.projectName }"/>
                                </div>
                            </div>



                                <%--Registered Date--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Registered
                                    Date<span
                                            class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="date" name="date"
                                           required='required' value="${project.date }"></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Closing Date<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="date"
                                           name="duration"
                                           required='required' value="${project.duration }"></div>
                            </div>


                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Progress<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="number" name="progress"
                                           data-validate-length="6,8"
                                           required='required' value="${project.progress }"/></div>
                            </div>

                                <%--Salary--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Budget<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="number" class='tel' name="estBudget"
                                           required='required'
                                           data-validate-length-range="1,15" value="${project.estBudget }"/></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Spent Budgett<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="number" name="spentBudget"
                                           required='required' value="${project.spentBudget }"></div>
                            </div>

                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Client Name<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="client"
                                           required='required'
                                           data-validate-length-range="1,10" value="${project.client }"/></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Client Mobile<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="clientMobile"
                                           required='required'
                                           data-validate-length-range="1,10" value="${project.clientMobile }"/></div>
                            </div>

                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Project Description<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input style="height: 60px" class="form-control" type="text" name="teamMembers"
                                           required='required'
                                           data-validate-length-range="1,10" value="${project.teamMembers }">
                                    </input>
                                </div>
                            </div>

                            <div class="ln_solid">
                                <div class="form-group">
                                    <div class="col-md-6 offset-md-3">
                                        <button type='submit' class="btn btn-primary" value="Register">Add New</button>
                                        <button type='reset' class="btn btn-success">Back To Projects</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </c:when>
    <c:when test="${mode=='MODE_UP' }">
        <!-- page content -->

        <div class="">
            <div class="">

                <div class="x_panel">
                    <div class="x_title">
                        <h2>Back >>
                            <small><a style="color: #007bff;cursor:hand"
                                      onMouseOver="this.style.color='red'; this.style.fontWeight='bold'"
                                      onMouseOut="this.style.color='#00F'; this.style.fontWeight='normal'"
                                      href="/projects">click here</a></small>
                        </h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <form class="form-horizontal" method="POST" action="/projectUpdate">
                             <span class="section">Manage Projects

                            </span>

                                <%--Project Name--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Project Name <span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" data-validate-length-range="6"
                                           data-validate-words="2" name="projectName"
                                           placeholder="ex. Employee Management" required="required"
                                           value="${project.projectName }"/>
                                </div>
                            </div>

                                <%--Project No--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Project ID<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input readonly="readonly" class="form-control" class='optional'
                                           name="projectId"
                                           data-validate-words="1"required="required"
                                           value="${project.projectId }"/></div>
                            </div>

                                <%--Registered Date--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Registered
                                    Date<span
                                            class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="date" name="date"
                                           required='required' value="${project.date }"></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Closing Date<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="date"
                                           name="duration"
                                           required='required' value="${project.duration }"></div>
                            </div>


                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Progress<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="number" name="progress"
                                           data-validate-length="6,8"
                                           required='required' value="${project.progress }"/></div>
                            </div>

                                <%--Salary--%>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Budget<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="number" class='tel' name="estBudget"
                                           required='required'
                                           data-validate-length-range="1,15" value="${project.estBudget }"/></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Spent Budgett<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" class='date' type="number" name="spentBudget"
                                           required='required' value="${project.spentBudget }"></div>
                            </div>

                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Client Name<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="client"
                                           required='required'
                                           data-validate-length-range="1,10" value="${project.client }"/></div>
                            </div>
                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Client Mobile<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="clientMobile"
                                           required='required'
                                           data-validate-length-range="1,10" value="${project.clientMobile }"/></div>
                            </div>

                            <div class="field item form-group">
                                <label class="col-form-label col-md-3 col-sm-3  label-align">Project Description<span
                                        class="required">*</span></label>
                                <div class="col-md-6 col-sm-6">
                                    <input style="height: 60px" class="form-control" type="text" name="teamMembers"
                                           required='required'
                                              data-validate-length-range="1,10" value="${project.teamMembers }">
                                    </input>
                                </div>
                            </div>

                            <div class="ln_solid">
                                <div class="form-group">
                                    <div class="col-md-6 offset-md-3">
                                        <button type='submit' class="btn btn-primary" value="Register">Update</button>
                                        <button type='reset' class="btn btn-success">Reset</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </c:when>
</c:choose>

<%--<!-- footer content -->--%>


<div class="pull-right" style="color: white">
    Copyright © Employee Management 2020. Created by Kavindra  Ariyaratne   &nbsp;    &nbsp;
</div>
<div class="clearfix"></div>

<!-- /footer content -->
</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="../../vendors/validator/multifield.js"></script>
<script src="../../vendors/validator/validator.js"></script>

<script>
    // initialize a validator instance from the "FormValidator" constructor.
    // A "<form>" element is optionally passed as an argument, but is not a must
    var validator = new FormValidator({"events": ['blur', 'input', 'change']}, document.forms[0]);
    // on form "submit" event
    document.forms[0].onsubmit = function (e) {
        var submit = true,
            validatorResult = validator.checkAll(this);
        console.log(validatorResult);
        return !!validatorResult.valid;
    };
    // on form "reset" event
    document.forms[0].onreset = function (e) {
        validator.reset();
    };
    // stuff related ONLY for this demo page:
    $('.toggleValidationTooltips').change(function () {
        validator.settings.alerts = !this.checked;
        if (this.checked)
            $('form .alert').remove();
    }).prop('checked', false);
</script>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- validator -->
<script src="../../vendors/validator/validator.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>

</html>