<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ boarddata }" var="data" />

<html>
<head>
  
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1, maximum-scale=1"/>
  
  <title>Spark</title>
  
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/format/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/format/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detail.css">
  
  <style>
  </style>
  
</head>

<body>

<jsp:include page="format/header.jsp"/>

<main class="detailmain">
  <div class="detailWrapper">
    <div class="leftSide">
      <div class="mapWrapper">
        <div class="map"></div>
      </div>
    </div>
    <div class="rightSide">
      <div class="infoWrapper">
        <div class="row">
          <div class="col-md-12 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
              <div class="text-white-50">상세 보기</span>

            </h4>
            <ul class="list-group mb-3">
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">주차장명</h6>
                </div>
                <span class="text-muted">홍길동</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">위치</h6>
                  <!-- <small class="text-muted">Brief description</small> -->
                </div>
                <span class="text-muted">경기도 고양시 일산서구 주엽동</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">종류</h6>
                  <!-- <small class="text-muted">Brief description</small> -->
                </div>
                <span class="text-muted">공영주차장</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">전화번호</h6>
                  <!-- <small class="text-muted">Brief description</small> -->
                </div>
                <span class="text-muted">010-3479-2106</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">크기</h6>
                  <!-- <small class="text-muted">Brief description</small> -->
                </div>
                <span class="text-muted">대형주차장</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">유/무료</h6>
                  <!-- <small class="text-muted">Brief description</small> -->
                </div>
                <span class="text-muted">유료</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">주차 가능시간</h6>
                
                </div>
                <span class="text-muted">08:00~24:00</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">요금</h6>
                  <small class="text-muted">시간당</small>
                </div>
                <span class="text-muted">2,000원</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">요금</h6>
                  <small class="text-muted">1일</small>
                </div>
                <span class="text-muted">30,000원</span>
              </li>
              <li
                  class="list-group-item d-flex justify-content-between lh-condensed">
                <div>
                  <h6 class="my-0">요금</h6>
                  <small class="text-muted">30일</small>
                </div>
                <span class="text-muted">80,000원</span>
            </ul>
            <div class="favorite">
              <button type="button" class="btn btn-1g btn-block btn-primary">자주 가는 주차장에 등록</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>

<jsp:include page="format/footer.jsp"/>


<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="WebContent/resources/bs/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="../resources/js/home.js"></script>

<script>

</script>

</body>
</html>