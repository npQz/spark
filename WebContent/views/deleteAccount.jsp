<%--
  Created by IntelliJ IDEA.
  User: H
  Date: 2018-10-08
  Time: 오전 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>delete account</title>

  <style>

    .pwContent {
      width: 100%;
    }

    input {
      width: 100%;
    }
    
    .deleteTitle {
      margin-top: 50px;
      margin-bottom: 20px;
    }

    input[type=submit] {
      color: #bdbdbd;
      font-size: 18px;
      background: #D32F2F;
      border: 0;
      width: 100%;
      height: 40px;
      border-radius: 3px;
      text-align: center;
    }

    input[type=submit]:hover {
      color: #fff;
      cursor: pointer;
    }

  </style>

</head>
<body>

  <div class="pwContent">
    <div class="pwCon-old">
      <form name="deleteForm" action="/MemberDeleteAction.Lo" method="post">
        <div class="deleteTitle">정말로 계정을 삭제하시겠습니까?</div>
        <input type="submit" value="계정 삭제">
      </form>
    </div>
  </div>

  <script src="../resources/js/modifyPW.js"></script>

</body>
</html>
