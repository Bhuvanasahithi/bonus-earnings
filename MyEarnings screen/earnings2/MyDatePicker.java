package pram.techvedika.com.earnings2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
import java.time.Month;
import java.util.Calendar;
public class MyDatePicker  extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        /*return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this, year, month, day);*/
        DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(),R.style.AlertDialog_Theme, this, year, month, day);
        // return the DatePickerDialog
        return mDatePicker;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        TextView textView=(TextView)getActivity().findViewById(R.id.txt_today_date);
        String month_name=Month.of(month+1).name();
        month_name = month_name.substring(0,1).toUpperCase() + month_name.substring(1).toLowerCase();
        textView.setText(month_name+" "+dayOfMonth+", "+year);
    }
}


