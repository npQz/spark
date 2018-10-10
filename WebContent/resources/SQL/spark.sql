create Table member(
EMAIL 		varchar2(20) primary key,
PASSWORD	varchar2(20) not null,
NAME		varchar2(20),
AGE			varchar2(20),
GENDER		varchar2(20)
);

create Table BOOKMARK(
BOOKMARK_EMAIL	varchar2(20),
BOOKMARK_NAME 	varchar2(50),
BOOKMARK_ADDR		varchar2(50),
BOOKMARK_TEL		varchar2(20)
);

create table SPark(
	PARKING_CODE	 	char(50),
	PARKING_NAME	 	char(50),
	ADDR		 	char(50),
	PARKING_TYPE	 	char(50),
	PARKING_TYPE_NM 	char(50),
	OPERATION_RULE	 	char(50),
	OPERATION_RULE_NM 	char(50),
	TEL		 	char(50),
	CAPACITY	 	char(50),
	CUR_PARKING	 	char(50),
	PAY_YN	 		char(50),
	PAY_NM	 		char(50),
	NIGHT_FREE_OPEN	 	char(50),
	NIGHT_FREE_OPEN_NM 	char(50),
	WEEKDAY_BEGIN_TIME 	char(50),
	WEEKDAY_END_TIME 	char(50),
	WEEKEND_BEGIN_TIME 	char(50),
	WEEKEND_END_TIME 	char(50),
	HOLIDAY_BEGIN_TIME 	char(50),
	HOLIDAY_END_TIME 	char(50),
	SATURDAY_PAY_YN 	char(50),
	SATURDAY_PAY_NM 	char(50),
	HOLIDAY_PAY_YN	 	char(50),
	HOLIDAY_PAY_NM	 	char(50),
	FULLTIME_MONTHLY 	char(50),
	RATES		 	char(50),
	TIME_RATE	 	char(50),
	ADD_RATES	 	char(50),
	ADD_TIME_RATE	 	char(50),
	DAY_MAXIMUM	 	char(50),
	LAT		 	char(50),
	LNG		 	char(50)
);


select *from member;

select * from bookmark;

select count(*) from member;

insert into MEMBER values('asdf@asdf.com', 'asdf', 'username', '18','none');

insert into BOOKMARK values('asdf@asdf.com', '아카데미 노상공영(구)', '강북구 수유동 535-76', '02-111-1111');
insert into BOOKMARK values('asdf@asdf.com', '가오천 노상공영(구)', '강북구 수유동 181-40', '02-111-1111');
insert into BOOKMARK values('asdf@asdf.com', '훈련원공원주차장(시)', '중구 을지로5가 40-3', '02-111-1111');

commit;

delete from BOOKMARK where BOOKMARK_NAME='asdf@asdf.com';

drop table BOOKMARK;