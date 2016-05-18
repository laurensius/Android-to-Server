package com.laurens.androidarduino;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
//import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

public class myActivity extends Activity implements OnItemSelectedListener{

	Spinner mySpinner;
	Button myButton;
	
	String nilaiSpinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        
        mySpinner = (Spinner)findViewById(R.id.mySpinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerValue, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    mySpinner.setAdapter(adapter);   
	    mySpinner.setOnItemSelectedListener(this);    
	    myButton = (Button)findViewById(R.id.btnConnect);
	    myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntentNext = new Intent(getApplicationContext(), Activity2.class);
				myIntentNext.putExtra("server", nilaiSpinner);
   			 	startActivity(myIntentNext);
			}
		});
    }
    
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    	nilaiSpinner = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // buat kondisi lain
    }
}
