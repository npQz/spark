<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ sessionScope.name }" var="name"/>
<c:set value="${ sessionScope.email }" var="email"/>

<nav class="nav">
  <div class="navWrapper">
    <div class="navContents">
      <div class="navItem-brand">
        <span><a class="navItem-brand-icon" href="${pageContext.request.contextPath}/">Spark</a></span>
      </div>
      <div class="navItem-account">
        <c:choose>
          <c:when test="${ name eq null }">
            <div class="dropdown" style="float:right;">
              <div class="dropBtn"><i class="material-icons icon-account">account_circle</i></div>
              <div class="dropdown-content">
                <a href="/Signin.Lo">로그인</a>
                <a href="/Signup.Lo">회원 가입</a>
              </div>
            </div>
          </c:when>
          <c:when test="${ name ne null }">
            <div class="dropdown" style="float:right;">
              <div class="dropBtn"><span>${ name }</span><i class="material-icons" id="arrow">arrow_drop_down</i></div>
              <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/views/">즐겨찾기</a>
                <a href="/MemberViewAction.Lo?${ email }">계 정</a>
                <a href="${pageContext.request.contextPath}/views/">로그 아웃</a>
              </div>
            </div>
          </c:when>
        </c:choose>
      </div>
      <div class="navItem-btn"><i class="material-icons" id="navMenu-mobile-btn">view_headline</i></div>
    </div>
  </div>
  <c:choose>
    <c:when test="${ name eq null}">
      <div class="navMenu-mobile-Wrapper">
        <div class="navMenu-mobile" id="navMenu-mobile1">
          <div class="navItem-mobile-li"><a href="/Signin.Lo">로그인</a></div>
          <div class="navItem-mobile-li"><a href="/Signup.Lo">회원 가입</a></div>
        </div>
      </div>
    </c:when>
    <c:when test="${ name ne null}">
      <div class="navMenu-mobile-Wrapper">
        <div class="navMenu-mobile" id="navMenu-mobile2">
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/">즐겨찾기</a></div>
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/">계 정</a></div>
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/">로그 아웃</a></div>
        </div>
      </div>
    </c:when>
  </c:choose>
</nav>