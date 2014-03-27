package br.com.erickles.imccalculator.controller;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.erickles.imccalculator.R;
import br.com.erickles.imccalculator.model.Calculator;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity{
	
	private EditText editTextWeight;
	private EditText editTextHeight;
	private Button buttonCalculate;
	private Button buttonClear;
	private TextView textViewResult;
	private TextView textViewIMCResult;
	private boolean isError = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		editTextWeight = (EditText) findViewById(R.id.editTextWeight);
		editTextHeight = (EditText) findViewById(R.id.editTextHeight);
		
		buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
		buttonClear = (Button) findViewById(R.id.buttonClear);
		
		textViewResult = (TextView) findViewById(R.id.textViewResult);
		textViewIMCResult = (TextView) findViewById(R.id.textViewIMCResult);
		
		buttonCalculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(editTextHeight.getText().toString().length() == 0){
					editTextHeight.setError("Informe a altura!");
					isError = true;
				}else{
					if(Double.parseDouble(editTextHeight.getText().toString()) == 0){
						editTextHeight.setError("Informe a altura!");
						isError = true;
					}
				}
				
				if(editTextWeight.getText().toString().length() == 0){
					editTextWeight.setError("Informe o peso!");
					isError = true;
				}else{
					if(Double.parseDouble(editTextWeight.getText().toString()) == 0){
						editTextWeight.setError("Informe o peso!");
						isError = true;
					}
				}
				
				if(!isError){
					textViewIMCResult.setText(String.valueOf(Calculator.calculateIMC(Double.parseDouble(editTextWeight.getText().toString()), Double.parseDouble(editTextHeight.getText().toString()))));
					textViewResult.setText(getString(R.string.InTheMomentYourIMCRepresents) + "\n" + Calculator.getSituationBodyMass(Calculator.calculateIMC(Double.parseDouble(editTextWeight.getText().toString()), Double.parseDouble(editTextHeight.getText().toString())), MainActivity.this));
				}
			}
		});
		
		buttonClear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editTextHeight.setError(null);
				editTextWeight.setError(null);
				
				editTextHeight.setText("");
				editTextWeight.setText("");
				
				isError = false;
				
				textViewIMCResult.setText("");
				textViewResult.setText(getString(R.string.PresentationText));
			}
		});
	}

}
