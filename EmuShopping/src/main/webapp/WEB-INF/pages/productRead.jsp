<%--
  Created by IntelliJ IDEA.
  User: litaoshen
  Date: 12/09/2015
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div style="text-align:center; color: teal; font-size: 30px">Emu Shopping |
    Product Read
</div>

<div id="product_creation" style="">
    <form:form modelAttribute="productForm">

        <table align="center">
            <tr>
                <td><form:label path="productId">Product ID</form:label></td>
                <td ><form:input path="productId" readonly="true" cssStyle="color: darkgray"/>${product.productId}</td>
            </tr>
            <tr>
                <td><form:label path="productName">Product Name</form:label></td>
                <td><form:input path="productName" readonly="true" cssStyle="color: darkgray"/>${product.productName}</td>
            </tr>
            <tr>
                <td><form:label path="description">Product Description</form:label></td>
                <td><form:input path="description" readonly="true" cssStyle="color: darkgray"/>${product.description}</td>
            </tr>
            <tr>
                <td><form:label path="productPrice">Price</form:label></td>
                <td><form:input path="productPrice" readonly="true" cssStyle="color: darkgray"/>${product.productPrice}</td>
            </tr>
            <tr>
                <td><form:label path="quantity">Quantity</form:label></td>
                <td><form:input path="quantity" readonly="true" cssStyle="color: darkgray"/>${product.quantity}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/product/list" type="button" style="color: brown">Back</a>
                </td>
            </tr>
        </table>
    </form:form>
</div>

