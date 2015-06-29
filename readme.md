# Android Date  

### Calendar物件  

##### 1. 建立物件  

> Calendar myCal = Calendar.getInstance();  

##### 2. 取得年  

> myCal.get(Calendar.YEAR)  

##### 3. 取得月份，月份是從0開始  

> myCal.get(Calendar.MONTH)  

##### 4. 取得日期  

> myCal.get(Calendar.DAY_OF_MONTH)

##### 5. 設定日期

> myCal.set(Calendar.DAY_OF_MONTH,1)  

##### 6. 設定到前2個月

> myCal.add(Calendar.MONTH, -2)  

##### 7. 設定到前3日

> myCal.add(Calendar.DATE, -3)

##### 8. 設定年份

> myCal.set(Calendar.YEAR, 1980)

##### 9. 設定每週首日為星期日

> myCal.setFirstDayOfWeek(Calendar.SUNDAY)

##### 10. 本週是今年第幾週

> myCal.get(Calendar.WEEK_OF_YEAR)

##### 11. 本日是今年第幾天

> myCal.get(Calendar.DAY_OF_YEAR)