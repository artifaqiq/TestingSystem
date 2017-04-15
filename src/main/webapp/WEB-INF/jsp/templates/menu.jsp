<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %><%--
  Created by Artur Lomako
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section id="sidebar">
    <div class="white-label">
    </div>
    <div id="sidebar-nav">
        <ul>
            <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
            <li><a href="#"><i class="fa fa-search"></i> Find test</a></li>
            <li><a href="<%= CommandPath.MY_TESTS %>"><i class="fa fa-inbox"></i> My tests</a></li>
            <li><a href="#"><i class="fa fa-newspaper-o"></i> Solved tests</a></li>
            <li><a href="<%= CommandPath.EDIT_TEST %>"><i class="fa fa-plus"></i> Create test</a></li>

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
                    <%--<li class="nav-profile">--%>
                        <%--<div class="nav-profile-name">--%>
                            <%--<a href="<%= CommandPath.LOGOUT %>">--%>
                                <%--${tr.translate("logout")}--%>
                            <%--</a>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </div>
    </div>
