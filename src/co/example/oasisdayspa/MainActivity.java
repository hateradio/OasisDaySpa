package co.example.oasisdayspa;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {
	private int currentYear;
	private int currentMonth;
	private int currentDay;
	static final int DATE_DIALOG_ID = 0;
	private Button btnDate;
	private TextView reservation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDate = (Button) findViewById(R.id.btnDate);
		reservation = (TextView) findViewById(R.id.txtReservation);

		btnDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		final Calendar c = Calendar.getInstance();
		currentYear = c.get(Calendar.YEAR);
		currentMonth = c.get(Calendar.MONTH);
		currentDay = c.get(Calendar.DAY_OF_MONTH);

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, reservationDate, currentYear,
					currentMonth, currentDay);
		default: return null;
		}
	}
	
	private DatePickerDialog.OnDateSetListener reservationDate =
			new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					GregorianCalendar d = new GregorianCalendar(year, monthOfYear, dayOfMonth);
					final DateFormat df = DateFormat.getDateInstance();
					reservation.setText("Your reservation is set for " + df.format(d.getTime()));
				}
			};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
