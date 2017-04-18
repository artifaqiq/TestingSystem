<%--
  Created by Artur Lomako
--%>
<%@ page import="com.netcracker.dev3.lomako.constants.CommandPath" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(document).ready(function(){
        document.getElementById("en_link").href = '<%= CommandPath.SET_LOCALE %>'
            + "&locale=en&callback="
            + encodeURIComponent(window.location.toString());

        document.getElementById("ru_link").href = '<%= CommandPath.SET_LOCALE %>'
            + "&locale=ru&callback="
            + encodeURIComponent(window.location.toString());
    });
</script>

<section id="sidebar">
    <div class="white-label">
    </div>
    <div id="sidebar-nav">
        <ul>
            <li><a href="<%= CommandPath.TAG_CLOUD %>"><i class="fa fa-cloud"></i> Tag cloud</a></li>
            <li><a href="<%= CommandPath.MY_TESTS %>&id=<%= request.getSession().getAttribute("id")%>"><i
                    class="fa fa-inbox"></i> My tests</a></li>
            <li><a href="<%= CommandPath.ALL_TESTS %>"><i class="fa fa-search"></i> All tests</a></li>
            <li><a href="<%= CommandPath.ALL_USERS %>"><i class="fa fa-user-o"></i> All users</a></li>
            <li><a href="<%=CommandPath.TEST_RESULTS_BY_USER%>&id=<%= request.getSession().getAttribute("id")%>">
                <i class="fa fa-newspaper-o"></i> Solved tests</a>
            </li>

        </ul>
    </div>
</section>

<section id="content">
    <div id="header">
        <div class="header-nav">
            <div class="menu-button">
            </div>
            <div class="nav">
                <ul>
                    <li class="nav-profile">
                        <div class="nav-profile-image">
                            <a href="#" id="en_link">
                                <img src="/static/img/en.png" alt="English language">
                            </a>
                        </div>
                    </li>
                    <li class="nav-profile">
                        <div class="nav-profile-image">
                            <div class="nav-profile-image">
                                <a href="#" id="ru_link">
                                    <img src="/static/img/ru.png" alt="Russian language">
                                </a>
                            </div>
                        </div>
                    </li>
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
