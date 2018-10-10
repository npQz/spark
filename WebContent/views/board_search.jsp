<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>스마트 주차장</title>
  <style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 15px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;  font-size: 15px;}
    /* .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;} */
    .info .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .info .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
  </style>

</head>
<body>
<div id="map" style="width:100%;height:1000px;"></div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65ef4303482c34481a1e7944b80a4dc0&libraries=clusterer"></script>
<script>
  <%
    request.setCharacterEncoding("UTF-8");
    String parking_name = request.getParameter("PARKING_NAME");
  %>
  var login = false; //session or 자바에서 가져오기 <- 로그인 여부 확인 (null)
  var loginAddr = ' ';
  if(login){
    loginAddr = 'http://www.naver.com/';	// 로그인창으로
  }else{
    loginAddr = 'http://www.kakaocorp.com/main'; // 즐겨찾기로
  }

  var SearchAdd ='<%=parking_name%>';
  var Search1 = false;
  var Search2 = 0;

  $(document).ready(function(){

    $.get("/resources/json/data2.json", function(data) {

      if(SearchAdd==null){
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
              center: new daum.maps.LatLng(37.566828, 126.97864), // 지도의 중심좌표
              level: 8 // 지도의 확대 레벨
            };
      } else {
        for(var i=0; i<data.positions.length; i++){
          if(SearchAdd==data.positions[i].ADDR){  //스트링으로 검색으로 바꿔서
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                  center: new daum.maps.LatLng(data.positions[i].LAT, data.positions[i].LNG), // 지도의 중심좌표
                  level: 3 // 지도의 확대 레벨
                };
            Search2 = i;
          }else{
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                  center: new daum.maps.LatLng(37.566828, 126.97864), // 지도의 중심좌표
                  level: 8 // 지도의 확대 레벨
                };
          }
        }
        Search1 = true;
      }



      var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      // 마커 클러스터러를 생성합니다
      var clusterer = new daum.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 6 // 클러스터 할 최소 지도 레벨
      });

      var positions = [];
      for(var i =0; i<data.positions.length; i++){

        positions[i] = {
          code :  data.positions[i].PARKING_CODE,
          name : data.positions[i].PARKING_NAME,
          addr : data.positions[i].ADDR,
          latlng : new daum.maps.LatLng(data.positions[i].LAT, data.positions[i].LNG)
        }
      }

      // 마커와 커스텀 오버레이 배열 변수 선언
      var marker = [];
      var i =0;

      positions.forEach(function(pos) {
        // 마커를 생성합니다
        marker[i] = new daum.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커의 위치
          clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
        });

        var customOverlay = new daum.maps.CustomOverlay({
          position: marker[i].getPosition()
        });



        /*
        var content =
        '<div class="wrap">' +
            '    <div class="info">' +
            '        <div class="title">' +
            '            카카오 스페이스닷원' +
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
            '        </div>' +
            '        <div class="body">' +
            '            <div class="desc">' +
            '                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
            '                <div><a href="http://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>' +
            '            </div>' +
            '        </div>' +
            '    </div>' +
            '</div>';
         */

        var content = document.createElement('div');
        content.classList.add("wrap");
        var info = document.createElement('div');
        info.classList.add("info");
        var title = document.createElement('div');
        title.classList.add('title');
        title.innerHTML=  positions[i].name;
        var close = document.createElement('div');
        close.classList.add("close");
        close.onclick = function() { customOverlay.setMap(null); };

        var body = document.createElement('div');
        body.classList.add("body");
        /*
            var desc = document.createElement('div');
            desc.classList.add("desc");
             */
        var ellipsis = document.createElement('div');
        ellipsis.classList.add("ellipsis");
        ellipsis.innerHTML= '주차장 주소 : ' + positions[i].addr;

        var linkdiv = document.createElement('div');

        var box1 = document.createElement('b');
        var link = document.createElement('a');
        var infoText = document.createTextNode('  상세 보기  ');
        link.classList.add('link');
        link.setAttribute('href','./BoardSearchAction.bo?BOARD_NAME='+positions[i].code);

        var box2 = document.createElement('b');
        var link2 = document.createElement('a');
        var infoText2 = document.createTextNode('  즐겨찾기  ');
        link2.classList.add('link');

        link2.setAttribute('href',loginAddr);



        //밑으로 넣기
        content.appendChild(info);
        info.appendChild(title);
        title.appendChild(close);
        info.appendChild(body);

        body.appendChild(ellipsis);
        body.appendChild(linkdiv);

        linkdiv.appendChild(box1);
        box1.appendChild(link);
        link.appendChild(infoText);

        linkdiv.appendChild(box2);
        box2.appendChild(link2);
        link2.appendChild(infoText2);




        customOverlay.setContent(content);
        if(Search1){
          if(Search2==i){
            customOverlay.setMap(map);
          }
        }else{
          customOverlay.setMap(null);
        }

        // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
        daum.maps.event.addListener(marker[i], 'click', function() {
          customOverlay.setMap(map);
        });

        // 클러스터러 생성
        clusterer.addMarkers(marker);
        i++;
      });

    });
  });



</script>
</body>
</html>