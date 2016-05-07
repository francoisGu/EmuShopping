<%--
  Created by IntelliJ IDEA.
  User: litaoshen
  Date: 10/09/2015
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="text-align:center; color: teal; font-size: 30px">EmuShopping |
  Product Details
</div>

<div align="center">

  <c:if test="${!empty orderList}">

    <table align="center" border="1" bgcolor="black" width="600px">
      <tr style="background-color: teal; color: white; text-align: center;"
          height="40px">

        <td>Order ID</td>
        <c:if test="${currentUser.type.equals('seller')}">
          <td>Buyer ID</td>
          <%--<td>Buyer Name</td>--%>
        </c:if>
        <td>Order Status</td>
        <td>Action</td>
      </tr>
      <c:forEach items="${orderList}" var="order">
        <tr
            style="background-color: white; color: black; text-align: center;"
            height="30px">

          <td><c:out value="${order.orderId}"/>
          </td>

          <c:if test="${currentUser.type.equals('seller')}">
            <td><c:out value="${order.buyer.userId}"/>
            </td>
            <%--<td><c:out value="${order.buyer.type}"/>--%>
            <%--</td>--%>
          </c:if>
          <td><c:out value="${order.status}"/>
          </td>

          <c:if test="${currentUser.type.equals('buyer')
            and order.status.equals('paid')}">
            <td><a href="${order.orderId}/order/cancel">Cancel</a></td>
          </c:if>
          <c:if test="${currentUser.type.equals('seller')
            and order.status.equals('wait_to_cancel')}">
            <td><a href="${order.orderId}/order/approve">Approve</a></td>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</div>


