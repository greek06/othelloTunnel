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
            	//Gönderilecek verimizi tanýmlýyoruz.
            	boolean  ses = true;
            	//Ýntentimizi tanýmlýyoruz
            	 Intent i= new Intent("com.example.othello1.GIRIS");
            	//Verimizi yerleþtirmek için Bundle'ýmýzý oluþturuyoruz.
            	 Bundle bundle = new Bundle();
            	//Bundle'ýmýza int deðerimizi yerleþtiriyoruz. Ýlk argumanýmýz anahtar, ikinci argumanýmýz deðer.
            	 bundle.putBoolean("ses", ses);
            	//intentimize bundle'ýmýzý ekledik.
            	 i.putExtras(bundle);
            	//intentimizi çalýþtýrdýk.
            	 startActivity(i);

              
 
            }
        });

	}
	
}