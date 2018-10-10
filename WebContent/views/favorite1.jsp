<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ sessionScope.name }" var="username"/>
<c:set value="${ bmkList }" var="list"/>

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
  .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0, 0, 0); /* Fallback color */
    background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
  }
  
  /* Modal Content */
  .modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
  }
  
  /* The Close Button */
  .close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }
  
  .close:hover,
  .close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
  }
</style>

<body>

<jsp:include page="format/header.jsp"/>

<main class="main">
  <div class="mainImg-cover">
    <div class="contentWrapper">
      <div class="contentItem">
        <h2>Modal Example</h2>
        
        <!-- Trigger/Open The Modal -->
        <button id="myBtn">Open Modal</button>
        
        <!-- The Modal -->
        <div id="myModal" class="modal">
  
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
  </div>
</main>

<jsp:include page="format/footer.jsp"/>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/favorite.js"></script>

<script>
  // Get the modal
  var modal = document.getElementById('myModal');

  // Get the button that opens the modal
  var btn = document.getElementById("myBtn");

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks the button, open the modal
  btn.onclick = function () {
    modal.style.display = "block";
  }

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
</script>

</body>
</html>
