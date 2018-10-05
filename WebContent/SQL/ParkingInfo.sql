select * from SPark;

select * from SPark where PARKING_CODE =171932;
select parking_name,lat,lng from SPARK where parking_name like '%신길%';

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
