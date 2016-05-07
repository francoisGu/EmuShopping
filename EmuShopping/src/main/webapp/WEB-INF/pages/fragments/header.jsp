<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>EmuShop</title>

    <spring:url value="/resources/react_frame/vendor/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <spring:url value="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"
                var="materializeCss"/>
<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons"
                var="materialIconsCss"/>
    <spring:url value="/resources/react_frame/vendor/react/react-with-addons.js" var="reactJs"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${materializeCss}" rel="stylesheet" />
    <link href="${materialIconsCss}" rel="stylesheet" />
    <script src="${reactJs}"></script>


</head>

<spring:url value="/" var="urlHome"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header navbar-left">
            <a class="navbar-brand" href="${urlHome}">EmuShop</a>
        </div>
        <div id="navbar">
            <div id="navbar_content" content="${content}">
            </div>
            <div id="navbar_right">
                <%--<ul class="nav navbar-nav navbar-right">--%>

                    <%--<li class="active"><a href="${urlAddProduct}">Add Product</a></li>--%>
                <%--</ul>--%>
            </div>
        </div>
    </div>
</nav>
