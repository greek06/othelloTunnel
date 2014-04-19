package com.example.othello1;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton start=(ImageButton)findViewById(R.id.start);
		ImageButton settings=(ImageButton)findViewById(R.id.settings);
		ImageButton exit=(ImageButton)findViewById(R.id.exit);
		start.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	startActivity(new Intent("com.example.othello1.GIRIS"));

	        }});	
		settings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent("com.example.othello1.OPTIONS"));
			}
		});
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				 finish();
				
			}
		});
	}
	public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Do you exit?");
        alertDialog
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                finish();

                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

        AlertDialog alert = alertDialog.create();
        alert.show();

    }
}