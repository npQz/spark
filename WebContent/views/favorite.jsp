<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ sessionScope.name }" var="username" />
<c:set value="${ bmkList }" var="list" />

<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1, maximum-scale=1"/>

  <title>Spark</title>

  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/format/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/format/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/favorite.css">

</head>

<style>
  .card-item-right a {
    color: #000;
  }
  
</style>

<body>

  <jsp:include page="format/header.jsp"/>

  <main class="main">
    <div class="mainImg-cover">
      <div class="contentWrapper">
        <div class="contentItem">
          <c:forEach items="${ list }" var="list">
          <div class="card-list"> <%--onclick="goContentPage(${ no })--%>
            <div class="card-item-left">
              <span class="card-list-name">${ list.BOOKMARK_NAME }</span>
              <div class="card-list-addr">
                <span>${ list.BOOKMARK_ADDR }</span>
              </div>
              <div class="card-list-tel">
                <span>${ list.BOOKMARK_TEL }</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><a href="/BmkDelete.me?BOOKMARK_NAME=${ list.BOOKMARK_NAME }"><i class="material-icons">bookmark</i></a></div>
            </div>
          </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </main>

  <jsp:include page="format/footer.jsp"/>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/favorite.js"></script>

  <script>

  </script>

</body>
</html>
