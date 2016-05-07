<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: litaoshen
  Date: 31/08/2015
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div id="container">

  <%-- load header --%>
  <div id="header">
    <jsp:include page="fragments/header.jsp"/>
  </div>

  <%-- include content page --%>
  <div id="body">
    <body>
    <jsp:include page="${content}"/>
    </body>
  </div>

  <%-- load footer --%>
  <div id="footer">
    <jsp:include page="fragments/footer.jsp"/>
  </div>

</div>
<style>
  html,
  body {
    margin: 0;
    padding: 0;
    height: 100%;
  }

  #container {
    min-height: 100%;
    position: relative;
  }

  #header {
    padding: 10px;
  }

  #body {
    padding: 10px 10px 60px;
  }

  #footer {
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 60px; /* Height of the footer */
  }
</style>
</html>
