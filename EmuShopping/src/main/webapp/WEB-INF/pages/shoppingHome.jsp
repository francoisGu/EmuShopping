<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: litaoshen
  Date: 10/09/2015
  Time: 1:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="text-align:center;">

  <h3> Hello World, Welcome to EmuHealth</h3>
  <%--<a href="/product/list" style="color: crimson; font-size: large">Product List</a>--%>

  <c:if test="${not logined}">
    <div id="login" align="center">
      <form action="/login" method="post">
        <fieldset>
          <legend>Please Login</legend>
          <label for="username">Username</label>
          <input type="text" id="username" name="username"/>
          <label for="password">Password</label>
          <input type="password" id="password" name="password"/>

          <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
          </div>
        </fieldset>
      </form>
    </div>
  </c:if>
  <c:if test="${logined}">
    <a href="/logout">Log out</a>
  </c:if>

  <c:if test="${userType.equals('seller')}">
    <a href="/product/orders">All orders</a>
  </c:if>
</div>
<br>

