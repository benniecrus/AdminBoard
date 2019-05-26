<!DOCTYPE html>
<html>
<head>
	<title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Admin Board</title>
</head>
<body>
    <div class="sidebar">
        <ul class="widget widget-menu unstyled">
            <li class="active"><a href="home"><i class="menu-icon icon-dashboard"></i>Admin Board
            </a></li>
        </ul>
        <!--/.widget-nav-->
        
        
        <ul class="widget widget-menu unstyled">

            <li><a href="initBatchList"><i class="menu-icon icon-list"></i>Batch </a></li>
            <li><a href="initCourseList"><i class="menu-icon icon-book"></i>Course </a></li>
            <li><a href="initFresherList"><i class="menu-icon icon-user"></i>Fresher </a></li>
        </ul>
        <!--/.widget-nav-->
        <ul class="widget widget-menu unstyled">
            <li><a class="collapsed" data-toggle="collapse" href="#togglePages"><i class="menu-icon icon-cog">
            </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
            </i>More Pages </a>
                <ul id="togglePages" class="collapse unstyled">

                    <li><a href="initUserList"><i class="icon-inbox"></i>All Users </a></li>
                </ul>
            </li>

            <li><a href="logout"><i class="menu-icon icon-signout"></i>Logout </a></li>
        </ul>
    </div>
</body>
</html>