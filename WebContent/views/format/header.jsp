<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${ sessionScope.name }" var="name"/>

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
                <a href="/Signin.Lo">Sign In</a>
                <a href="/Signup.Lo">Sign Up</a>
              </div>
            </div>
          </c:when>
          <c:when test="${ name ne null }">
            <div class="dropdown" style="float:right;">
              <div class="dropBtn"><span>${ name }</span><i class="material-icons" id="arrow">arrow_drop_down</i></div>
              <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/views/">Account</a>
                <a href="${pageContext.request.contextPath}/views/">Log out</a>
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
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/signIn.jsp">Sign In</a></div>
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/signUp.jsp">Sign Up</a></div>
        </div>
      </div>
    </c:when>
    <c:when test="${ name ne null}">
      <div class="navMenu-mobile-Wrapper">
        <div class="navMenu-mobile" id="navMenu-mobile2">
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/">Account</a></div>
          <div class="navItem-mobile-li"><a href="${pageContext.request.contextPath}/views/">Log out</a></div>
        </div>
      </div>
    </c:when>
  </c:choose>
</nav>