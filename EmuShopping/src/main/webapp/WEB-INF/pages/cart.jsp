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

  <c:if test="${!empty productList}">

    <table align="center" border="1" bgcolor="black" width="600px">
      <tr style="background-color: teal; color: white; text-align: center;"
          height="40px">

        <td>Product ID</td>
        <td>Product Name</td>
        <td>Product Description</td>
        <td>Price</td>
        <td>Read</td>
        <td>Delete</td>
      </tr>
      <c:forEach items="${productList}" var="product">
        <tr
            style="background-color: white; color: black; text-align: center;"
            height="30px">

          <td><c:out value="${product.productId}"/>
          </td>
          <td><c:out value="${product.productName}"/>
          </td>
          <td><c:out value="${product.description}"/>
          </td>
          <td><c:out value="${product.productPrice}"/>
          </td>
          <td><a href="${product.productId}/read">Read</a></td>
          <td><a href="${product.productId}/cart/delete">Delete</a></td>
        </tr>
      </c:forEach>
    </table>

    <%--<div class="product_list">--%>
    <%--<c:forEach items="${productList}" var="product">--%>
    <%--<div class="col-sm-6 col-md-4">--%>
    <%--<div class="card small">--%>
    <%--<div class="card-image waves-effect waves-block waves-light">--%>
    <%--<img class="activator"--%>
    <%--src="/resources/react_frame/img/health_juice.jpg">--%>
    <%--</div>--%>
    <%--<div class="card-content">--%>
    <%--<span--%>
    <%--class="card-title activator grey-text text-darken-4">${product.productName}<i--%>
    <%--class="material-icons right">more_vert</i></span>--%>

    <%--<p><a href="#">${product.description}</a></p>--%>
    <%--</div>--%>
    <%--<div class="card-reveal">--%>
    <%--<span--%>
    <%--class="card-title grey-text text-darken-4">${product.productName}<i--%>
    <%--class="material-icons right">close</i></span>--%>

    <%--<div class="row">--%>
    <%--<label class="col-sm-2">ID</label>--%>

    <%--<div class="col-sm-10">${product.productId}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<label class="col-sm-2">Description</label>--%>

    <%--<div class="col-sm-10">${product.description}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<label class="col-sm-2">Price</label>--%>

    <%--<div class="col-sm-10">${product.productPrice}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
    <%--<label class="col-sm-2">Quantity</label>--%>

    <%--<div class="col-sm-10">${product.quantity}</div>--%>
    <%--</div>--%>

    <%--<div class="btn-group btn-group-sm" role="group"--%>
    <%--style="position:absolute; bottom:0;">--%>
    <%--<a type="button" href="${product.productId}/read"--%>
    <%--class="btn btn-default">Read</a>--%>
    <%--</div>--%>
    <%--<style>.btn {--%>
    <%--margin: 5px--%>
    <%--}</style>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</c:forEach>--%>
    <%--</div>--%>
  </c:if>

  <a type="button" href="/product/pay" class="btn btn-default">Pay</a>

  <%--<a href="/product/new">Click Here to add new Product</a>--%>
</div>


