package com.example.othello1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class options extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		
		CheckBox sound=(CheckBox)findViewById(R.id.checkBox1);
		sound.setOnCheckedChangeListener(new OnCheckedChangeListener() {
 
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            	//G�nderilecek verimizi tan�ml�yoruz.
            	boolean  ses = true;
            	//�ntentimizi tan�ml�yoruz
            	 Intent i= new Intent("com.example.othello1.GIRIS");
            	//Verimizi yerle�tirmek i�in Bundle'�m�z� olu�turuyoruz.
            	 Bundle bundle = new Bundle();
            	//Bundle'�m�za int de�erimizi yerle�tiriyoruz. �lk arguman�m�z anahtar, ikinci arguman�m�z de�er.
            	 bundle.putBoolean("ses", ses);
            	//intentimize bundle'�m�z� ekledik.
            	 i.putExtras(bundle);
            	//intentimizi �al��t�rd�k.
            	 startActivity(i);

              
 
            }
        });

	}
	
}