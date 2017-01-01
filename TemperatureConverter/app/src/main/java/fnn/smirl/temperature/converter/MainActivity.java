package fnn.smirl.temperature.converter;

import android.view.*;
import android.widget.*;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements
OnEditorActionListener, OnItemSelectedListener
{

 @Override
 public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
 {
	// TODO: Implement this method
	try{
	 if (p1.getId() == R.id.spinner1){
		t1 = (Temperature) p1.getSelectedItem();
	 }else if (p1.getId() == R.id.spinner2){
		t2 = (Temperature) p1.getSelectedItem();
	 } 

	 if (et1.getText().toString() != null){
		convert(swap);
	 }
	}catch (Exception ee){}

 }

 @Override
 public void onNothingSelected(AdapterView<?> p1)
 {
	// TODO: Implement this method
 }


 @Override
 public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
 {
	// TODO: Implement this method
	try{
	 if (p1.getId() == R.id.et1){
		swap = true;
		convert(swap);
		tv1.setText("From:");
		tv2.setText("To:");
	 }else
	 if (p1.getId() == R.id.et2){
		swap = false;
		convert(swap);
		tv2.setText("From:");
		tv1.setText("To:");
	 }
	}catch (Exception ee){}
	return true;
 }

 boolean swap = true;

 Spinner spinner1, spinner2;
 EditText et1, et2;
 TextView tv1, tv2;

 Temperature temps[];
 Temperature t1 = Temperature.CELCIUS;
 Temperature t2 = Temperature.CELCIUS;

 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);

	temps = Temperature.values();

	tv1 = (TextView)findViewById(R.id.tv1);
	tv2 = (TextView)findViewById(R.id.tv2);

	et1 = (EditText)findViewById(R.id.et1);
	et1.setOnEditorActionListener(this);

	et2 = (EditText)findViewById(R.id.et2);
	et2.setOnEditorActionListener(this);

	spinner1 = (Spinner)findViewById(R.id.spinner1);
	spinner2 = (Spinner)findViewById(R.id.spinner2);

	ArrayAdapter<Temperature> adapter = 
	 new ArrayAdapter<Temperature>(this, android.R.layout.simple_dropdown_item_1line , temps);

	spinner1.setAdapter(adapter);
	spinner2.setAdapter(adapter);

	spinner1.setOnItemSelectedListener(this);
	spinner2.setOnItemSelectedListener(this);

 }

 private void convert(boolean sw){
	if (sw){
	 double d = Double.parseDouble(et1.getText().toString());
	 double ans = TemperatureConversion.convert(t1, t2, d);
	 et2.setText("" + ans);
	}else{
	 double d = Double.parseDouble(et2.getText().toString());
	 double ans = TemperatureConversion.convert(t2, t1, d);
	 et1.setText("" + ans);
	}
 }
}
