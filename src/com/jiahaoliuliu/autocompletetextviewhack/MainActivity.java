package com.jiahaoliuliu.autocompletetextviewhack;

import java.util.ArrayList;
import java.util.List;

import com.jiahaoliuliu.autocompletetextviewhack.model.Cinema;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	// Layout
	private AutoCompleteTextView simpleAutoCompleteTextView;
	private TextView detailsTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		simpleAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.simpleAutoCompleteTextView);
		detailsTextView = (TextView) findViewById(R.id.detailsTextView);

		// Creates simple list
		final List<Cinema> cinemas = new ArrayList<Cinema>();
		Cinema cinema = new Cinema();
		cinema.setCinemaID(1);
		cinema.setCinemaName("CineBox2 La Gavia 3D");
		cinema.setCinemaCompleteAddress("Calle Adolfo Bioy Casares 2, Madrid, Spain");
		cinemas.add(cinema);

		cinema = new Cinema();
		cinema.setCinemaID(2);
		cinema.setCinemaName("CineBox2 Proyecciones 3D");
		cinema.setCinemaCompleteAddress("Calle Fuencarral 136, Madrid, Spain");
		cinemas.add(cinema);

		cinema = new Cinema();
		cinema.setCinemaID(3);
		cinema.setCinemaName("CineBox2 Capitol");
		cinema.setCinemaCompleteAddress("Calle Gran vía 41, Madrid, Spain");
		cinemas.add(cinema);

        ArrayAdapter<Cinema> adapter = new ArrayAdapter<Cinema>(this,
                R.layout.simple_dropdown_item_1line_mod, cinemas);
        simpleAutoCompleteTextView.setAdapter(adapter);
        simpleAutoCompleteTextView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(
					AdapterView<?> adapterView, View view,
					int position, long id) {
				if (position < 0 || position > cinemas.size() - 1) {
					return;
				}
				
				Cinema cinemaSelected = cinemas.get(position);
				
				StringBuffer stringBuffer = new StringBuffer();
				// ID
				stringBuffer.append("Id: " + cinemaSelected.getCinemaID() + " \n");
				// Name
				stringBuffer.append("Name: " + cinemaSelected.getCinemaName() + " \n");
				// Complete Address
				stringBuffer.append("Address: " + cinemaSelected.getCinemaCompleteAddress() + " \n");

				detailsTextView.setText(stringBuffer.toString());
			}
        });
	}
}
