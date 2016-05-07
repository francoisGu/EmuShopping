<%--suppress XmlDuplicatedId --%>
<%--
  Created by IntelliJ IDEA.
  User: litaoshen
  Date: 10/09/2015
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="text-align:center; color: teal; font-size: 30px">Emu Shopping |
    Product Creation
</div>

<div id="product_creation" style="">
    <form:form method="POST" action="/product/create">
        <table align="center">
            <tr>
                <td><form:label path="productName">Product Name</form:label></td>
                <td><form:input path="productName"/></td>
            </tr>
            <tr>
                <td><form:label path="description">Product Description</form:label></td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td><form:label path="productPrice">Price</form:label></td>
                <td><form:input path="productPrice"/></td>
            </tr>
            <tr>
                <td><form:label path="quantity">Quantity</form:label></td>
                <td><form:input path="quantity"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>

