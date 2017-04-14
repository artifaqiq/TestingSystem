<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section id="sidebar">
    <div class="white-label">
    </div>
    <div id="sidebar-nav">
        <ul>
            <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
            <li><a href="#"><i class="fa fa-search"></i> Find test</a></li>
            <li><a href="#"><i class="fa fa-inbox"></i> My tests</a></li>
            <li><a href="#"><i class="fa fa-newspaper-o"></i> Solved tests</a></li>

        </ul>
    </div>
</section>
<section id="content">
    <div id="header">
        <div class="header-nav">
            <div class="menu-button">
                <!--<i class="fa fa-navicon"></i>-->
            </div>
            <div class="nav">
                <ul>
                    <li class="nav-profile">
                        <div class="nav-profile-image">
                            <div class="nav-profile-name">
                                <%= pageContext.getSession().getAttribute("firstName") + " " + pageContext.getSession().getAttribute("lastName")%>
                            </div>
                        </div>
                    </li>
                    <li class="nav-profile">
                        <div class="nav-profile-name">
                            <a href="<%= CommandPath.LOGOUT %>">
                                ${tr.translate("logout")}
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="content-header">
            <h1>Dashboard</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </div>
        <div class="widget-box sample-widget">
            <div class="widget-header">
                <h2>Widget Header</h2>
                <i class="fa fa-cog"></i>
            </div>
            <div class="widget-content">
                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
            </div>
        </div>
        <div class="widget-box sample-widget">
            <div class="widget-header">
                <h2>Widget Header</h2>
                <i class="fa fa-cog"></i>
            </div>
            <div class="widget-content">
                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
            </div>
        </div>
        <div class="widget-box sample-widget">
            <div class="widget-header">
                <h2>Widget Header</h2>
                <i class="fa fa-cog"></i>
            </div>
            <div class="widget-content">
                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
            </div>
        </div>
        <div class="widget-box sample-widget">
            <div class="widget-header">
                <h2>Widget Header</h2>
                <i class="fa fa-cog"></i>
            </div>
            <div class="widget-content">
                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png">
            </div>
        </div>
    </div>
</section>
