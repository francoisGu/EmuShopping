<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<div class="container" style="position:absolute; bottom:0;">--%>
  <%--<footer>--%>
    <%--<hr>--%>
    <%--<div>--%>
      <%--<p>&copy; 2015 EmuShop.org. All rights reserved.</p>--%>
    <%--</div>--%>
  <%--</footer>--%>
<%--</div>--%>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
  <a href="/product/new"
     class="btn-floating btn-large waves-effect waves-light red">
    <i class="large material-icons">add</i>
  </a>
  <%--<ul>--%>
  <%--<li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>--%>
  <%--<li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>--%>
  <%--<li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>--%>
  <%--<li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>--%>
  <%--</ul>--%>
</div>

<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/react_frame/vendor/js/bootstrap.min.js"
            var="bootstrapJs"/>
<spring:url value="/resources/react_frame/dist/nav.js" var="navJs"/>
<spring:url
    value="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"
    var="materializeJs"/>

<spring:url value="https://code.jquery.com/jquery-2.1.1.min.js" var="jqueryJs"/>
<script src="${bootstrapJs}"></script>
<script src="${navJs}"></script>
<script src="${materializeJs}"></script>
<script src="${jqueryJs}"></script>


