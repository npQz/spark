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
  <title>modify password</title>

  <style>

    .pwContent {
      width: 100%;
      height: 100%;
    }

    input {
      width: 100%;
    }

    .pwTitle {
      margin-bottom: 10px;
    }

    input[type=button] {
      color: #bdbdbd;
      font-size: 18px;
      background: #5C9C7B;
      border: 0;
      width: 100%;
      height: 40px;
      border-radius: 3px;
      text-align: center;
    }

    input[type=button]:hover {
      color: #fff;
      cursor: pointer;
    }

    .inputCmt {
      padding: 5px 0 0 10px;
      margin-bottom: 30px;
      color: #f00;
      font-size: 15px;
    }

  </style>

</head>
<body>

  <div class="pwContent">
    <div class="pwCon-old">
      <form name="modifyPWForm" action="#" method="post">
        <div class="pwTitle old-title"><label for="old_pw">현재 비밀번호</label></div>
        <input type="password" name="old_pw" class="old_pw" id="old_pw">
        <div class="inputCmt" id="oldPw-Cmt"></div>
        <div class="pwTitle new-title"><label for="new_pw">새 비밀번호</label></div>
        <input type="password" name="new_pw" class="new_pw" id="new_pw">
        <div class="inputCmt" id="newPw-Cmt"></div>
        <div class="pwTitle newRe-title"><label for="new_pw_re">새 비밀번호 확인</label></div>
        <input type="password" name="new_pw_re" class="new_pw_re" id="new_pw_re">
        <div class="inputCmt" id="newPw_re-Cmt"></div>
        <input type="button" value="비밀번호 변경" onclick="modifyPW()">
      </form>
    </div>
  </div>

  <script src="../resources/js/modifyPW.js"></script>

</body>
</html>
