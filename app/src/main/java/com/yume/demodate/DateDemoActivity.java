package com.yume.demodate;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * onCreate的部分有Calendar物件的操作
 * button實作DatePickerDialog & TimePickerDialog
 * */
public class DateDemoActivity extends Activity {
    private String dateStr="";
    private TextView dateText,timeText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dateText=(TextView) findViewById(R.id.dateText);
        timeText=(TextView) findViewById(R.id.timeText);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int x=5;
        Calendar myCal = Calendar.getInstance();
        int y=myCal.get(Calendar.YEAR);
        int m=myCal.get(Calendar.MONTH);
        int d=myCal.get(Calendar.DAY_OF_MONTH);
        // 本月第一天
        myCal.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("first day of this month>>"+sdf.format(myCal.getTime()));
        // 本月最後一天
        myCal.set(Calendar.DAY_OF_MONTH, myCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("last day of this month>>"+sdf.format(myCal.getTime()));

        myCal.set(y,m,d);//設定為本日
        // 到前 x 個月
        myCal.add(Calendar.MONTH, -x);
        System.out.println(x+" months ago>>"+sdf.format(myCal.getTime()));

        myCal.set(y,m,d);//設定為本日
        // 到後 x 個月
        myCal.add(Calendar.MONTH, x);
        System.out.println(x+" months later>>"+sdf.format(myCal.getTime()));

        myCal.set(y,m,d);//設定為本日
        // 到前 x 天
        myCal.add(Calendar.DATE, -x);
        System.out.println(x+" days ago>>"+sdf.format(myCal.getTime()));

        myCal.set(y,m,d);//設定為本日
        // 到後 x 天
        myCal.add(Calendar.DATE, x);
        System.out.println(x+" days later>>"+sdf.format(myCal.getTime()));

        myCal.set(y,m,d);//設定為本日
        // 當月天數
        myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("days of this month>>"+myCal.getActualMaximum(Calendar.DAY_OF_MONTH));

        // 直接設定年份為 1980 年
        myCal.set(Calendar.YEAR, 1980);
        System.out.println("set the year to 1967>>"+sdf.format(myCal.getTime()));

        // 直接設定月份為 2 月，注意月份是從 0 起頭
        myCal.set(Calendar.MONTH, 1);
        System.out.println("set the month to feb>>"+sdf.format(myCal.getTime()));

        // 直接設定時間的時欄位為下午 1 點，24時制
        myCal.set(Calendar.HOUR, 13);
        System.out.println("set the hour to 13 pm>>"+sdf2.format(myCal.getTime()));
        // 直接設定時間的分欄位為 30 分
        myCal.set(Calendar.MINUTE, 30);
        System.out.println("set the minute to 30>>"+sdf2.format(myCal.getTime()));
        // 直接設定時間的秒欄位為 55 秒
        myCal.set(Calendar.SECOND, 55);
        System.out.println("set the second to 55>>"+sdf2.format(myCal.getTime()));
        // 判斷現在為 AM 或 PM, 0: AM, 1: PM
        myCal.get(Calendar.AM_PM);
        System.out.println("get AM or PM>>"+myCal.get(Calendar.AM_PM));

        myCal.set(y,m,d);//設定為本日

        // 判斷是否為閏年, 先將月份移至 2 月
        // 再看 2 月有幾天, 29 天為閏年, 其他則為平年
        myCal.set(Calendar.MONTH, 1);
        if(myCal.getActualMaximum(Calendar.DAY_OF_MONTH)==29){
            setTitle("今年為閏年");
        }else{
            setTitle("今年不是閏年,是平年");
        }
        // 今天是星期幾
        myCal.get(Calendar.DAY_OF_WEEK);
        System.out.println("get weekend>>"+myCal.get(Calendar.DAY_OF_WEEK));
        // 查日曆日, 即今天是今年的第幾天
        myCal.get(Calendar.DAY_OF_YEAR);
        System.out.println("get the day of year>>"+myCal.get(Calendar.DAY_OF_YEAR));
        // 本週是今年第幾週
        System.out.println("get the number of week>>"+myCal.get(Calendar.WEEK_OF_YEAR));
        myCal.setFirstDayOfWeek(Calendar.SUNDAY);// 設定每週首日為星期日
        myCal.setFirstDayOfWeek(Calendar.MONDAY);// 設定每週首日為星期一
        System.out.println("get the first day of every week>>"+myCal.getFirstDayOfWeek());// 查每週首日, 1: 星期日, 2: 星期一
    }
    public void btnOnClick(View v){
        Calendar now = Calendar.getInstance();
        switch (v.getId()){
            case R.id.datepickerbutton: //日期
                DatePickerDialog dateStartPicDlg = new DatePickerDialog(this,myDateSetListener, now.get(Calendar.YEAR), now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));
                dateStartPicDlg.setTitle(getResources().getString(R.string.labelDate)); //設定標題
                dateStartPicDlg.setMessage(getResources().getString(R.string.msgChoosedate)); //設定內容訊息
                dateStartPicDlg.setIcon(android.R.drawable.ic_dialog_info);
                dateStartPicDlg.setCancelable(true);
                dateStartPicDlg.show();
                break;
            case R.id.timepickerbutton: //時間
                TimePickerDialog takeDateTPicDlg = new TimePickerDialog(this, myTimeSetListener, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                        true);
                takeDateTPicDlg.setTitle(getResources().getString(R.string.labelTime));
                takeDateTPicDlg.setMessage(getResources().getString(R.string.msgChoosetime));
                takeDateTPicDlg.setIcon(android.R.drawable.ic_dialog_info);
                takeDateTPicDlg.setCancelable(true);
                takeDateTPicDlg.show();
                break;
        }
    }
    private DatePickerDialog.OnDateSetListener myDateSetListener
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year,
                              int monthOfYear, int dayOfMonth) {
            String m=((monthOfYear+1)<10)?"0"+String.valueOf(monthOfYear+1):String.valueOf(monthOfYear+1);
            String d=(dayOfMonth<10)?"0"+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
            dateStr=String.valueOf(year)+"-"+m+"-"+d;
            dateText.setText(dateStr);
        }
    };
    private TimePickerDialog.OnTimeSetListener myTimeSetListener
            = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String h=(hourOfDay<10)?"0"+String.valueOf(hourOfDay):String.valueOf(hourOfDay);
            String m=(minute<10)?"0"+String.valueOf(minute):String.valueOf(minute);
            dateStr=h+":"+m;
            timeText.setText(dateStr);
        }
    };
}
