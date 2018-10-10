<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ sessionScope.name }" var="username"/>

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

<body>

  <jsp:include page="format/header.jsp"/>

  <main class="main">
    <div class="mainImg-cover">
      <div class="contentWrapper">
        <div class="contentItem">
          <div class="card-list" onclick="goContentPage(${ no })">
            <div class="card-item-left">
              <span class="card-list-title">아카데미 노상공영(구)</span>
              <div class="card-list-content">
                <span>강북구 수유동 535-76</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><i class="material-icons">stars</i></div>
            </div>
          </div>
          <div class="card-list" onclick="goContentPage(${ no })">
            <div class="card-item-left">
              <span class="card-list-title">아카데미 노상공영(구)</span>
              <div class="card-list-content">
                <span>강북구 수유동 535-76</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><i class="material-icons">stars</i></div>
            </div>
          </div>
          <div class="card-list" onclick="goContentPage(${ no })">
            <div class="card-item-left">
              <span class="card-list-title">아카데미 노상공영(구)</span>
              <div class="card-list-content">
                <span>강북구 수유동 535-76</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><i class="material-icons">stars</i></div>
            </div>
          </div>
          <div class="card-list" onclick="goContentPage(${ no })">
            <div class="card-item-left">
              <span class="card-list-title">아카데미 노상공영(구)</span>
              <div class="card-list-content">
                <span>강북구 수유동 535-76</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><i class="material-icons">stars</i></div>
            </div>
          </div>
          <div class="card-list" onclick="goContentPage(${ no })">
            <div class="card-item-left">
              <span class="card-list-title">아카데미 노상공영(구)</span>
              <div class="card-list-content">
                <span>강북구 수유동 535-76</span>
              </div>
            </div>
            <div class="card-item-right">
              <div class="card-list-writer"><i class="material-icons">stars</i></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>

  <jsp:include page="format/footer.jsp"/>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/home.js"></script>

  <script>

    /* autocomplete with JQuery */
    $(function () {
      $.getJSON('${pageContext.request.contextPath}/resources/json/addr.json', function (items) {
        var tags_name = [];
        var tags_addr = [];
        var tags_all = [];
        $.each(items, function (i, item) {
          tags_name[i] = item.PARKING_NAME;
          tags_addr[i] = item.ADDR;
        });

        tags_all = tags_name.concat(tags_addr);
        /*console.log(tags_name);
        console.log(tags_addr);
        console.log(tags_all);*/

        $("#tags").autocomplete({
          source: tags_all
        });
      });
    });

    clickMobileBtn('#navMenu-mobile-btn', '.navMenu-mobile');

    clickSearchbar('#tags', '#hide-items', '#contentItem-title');

    chkSearching('#search-btn', '#tags', 'searchVal-comment');

  </script>

</body>
</html>
