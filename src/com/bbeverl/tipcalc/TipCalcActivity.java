package com.bbeverl.tipcalc;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalcActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    }
    
    public void onResume() {
    	super.onResume();
    	Button btnCalculate = (Button) this.findViewById(R.id.btnCalc);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calculate();			
			}
		});
    }
    
    public void calculate() {
    	EditText edtSubtotal = (EditText) this.findViewById(R.id.editSubtotal);
    	EditText edtSplit = (EditText) this.findViewById(R.id.editSplit);
    	EditText edtPercent = (EditText) this.findViewById(R.id.editPercent);    	
    	
    	TextView txtTotal = (TextView) this.findViewById(R.id.txtTotal);
    	TextView txtTip = (TextView) this.findViewById(R.id.txtTip);
    	try {
    	double subTotal = Double.parseDouble(edtSubtotal.getText().toString());
    	int split = Integer.parseInt(edtSplit.getText().toString());
    	double percent = Double.parseDouble(edtPercent.getText().toString());
		
    	double tip = (subTotal / split) * (percent / 100);
    	
    	DecimalFormat moneyFormat = new DecimalFormat("#.##");
    	
    	txtTip.setText('$' + moneyFormat.format(tip));
    	txtTotal.setText('$' + moneyFormat.format(tip + subTotal));    	
    	} catch (Exception e) {
    		txtTip.setText("Error");
        	txtTotal.setText("Error");  
		}
    }
}