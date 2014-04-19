package com.example.othello1;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class girisEkran extends Activity {// global degiþkenler burada tanýmlanýr
	 MediaPlayer mp,winner,loser;
	 int userCounter=0,CPU=0,Finalx,Finaly,FinalType;
	boolean flag=false,user=false;
	boolean flagCpu=false;
	final Integer[][] tempIntArray = new Integer[2][40];//olasý hamleleri sayýsal olarak anlatabilmek icin
	final Integer[][] intArray = new Integer[8][8];// bilgisayar tarafýna durumu sayýsal anlatabilmek icin
	final ImageButton[] [] viewArray = new ImageButton[8][8];//ekrandaki tüm imageButtonlarýn arrayý
	boolean leftControl=false;
	boolean rightControl=false;
	int biggest=0,tempX,tempY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {//default gelir activity olusturulurken yapýlacaklar yazýlýr
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giris);
		 mp = MediaPlayer.create(this,R.raw.hit);
		 winner = MediaPlayer.create(this,R.raw.taammi);
		 loser = MediaPlayer.create(this,R.raw.ariza);
		 int initial;
			for(initial=0;initial<40;initial++){
				tempIntArray[0][initial]=-1;
				tempIntArray[1][initial]=-1;
			}
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				intArray[i][j]=0;
		
		viewArray[0][0]=(ImageButton)findViewById(R.id.imageButton1);// ekran üzerindeki 64 imageButton
		viewArray[0][1]=(ImageButton)findViewById(R.id.imageButton2);
		viewArray[0][2]=(ImageButton)findViewById(R.id.imageButton3);
		viewArray[0][3]=(ImageButton)findViewById(R.id.imageButton4);
		viewArray[0][4]=(ImageButton)findViewById(R.id.imageButton5);
		viewArray[0][5]=(ImageButton)findViewById(R.id.imageButton6);
		viewArray[0][6]=(ImageButton)findViewById(R.id.imageButton7);
		viewArray[0][7]=(ImageButton)findViewById(R.id.imageButton8);
		viewArray[1][0]=(ImageButton)findViewById(R.id.imageButton9);
		viewArray[1][1]=(ImageButton)findViewById(R.id.imageButton10);
		viewArray[1][2]=(ImageButton)findViewById(R.id.imageButton11);
		viewArray[1][3]=(ImageButton)findViewById(R.id.imageButton12);
		viewArray[1][4]=(ImageButton)findViewById(R.id.imageButton13);
		viewArray[1][5]=(ImageButton)findViewById(R.id.imageButton14);
		viewArray[1][6]=(ImageButton)findViewById(R.id.imageButton15);
		viewArray[1][7]=(ImageButton)findViewById(R.id.imageButton16);
		viewArray[2][0]=(ImageButton)findViewById(R.id.imageButton17);
		viewArray[2][1]=(ImageButton)findViewById(R.id.imageButton18);
		viewArray[2][2]=(ImageButton)findViewById(R.id.imageButton19);
		viewArray[2][3]=(ImageButton)findViewById(R.id.imageButton20);
		viewArray[2][4]=(ImageButton)findViewById(R.id.imageButton21);
		viewArray[2][5]=(ImageButton)findViewById(R.id.imageButton22);
		viewArray[2][6]=(ImageButton)findViewById(R.id.imageButton23);
		viewArray[2][7]=(ImageButton)findViewById(R.id.imageButton24);
		viewArray[3][0]=(ImageButton)findViewById(R.id.imageButton25);
		viewArray[3][1]=(ImageButton)findViewById(R.id.imageButton26);
		viewArray[3][2]=(ImageButton)findViewById(R.id.imageButton27);
		viewArray[3][3]=(ImageButton)findViewById(R.id.imageButton28);
		viewArray[3][4]=(ImageButton)findViewById(R.id.imageButton29);
		viewArray[3][5]=(ImageButton)findViewById(R.id.imageButton30);
		viewArray[3][6]=(ImageButton)findViewById(R.id.imageButton31);
		viewArray[3][7]=(ImageButton)findViewById(R.id.imageButton32);
		viewArray[4][0]=(ImageButton)findViewById(R.id.imageButton33);
		viewArray[4][1]=(ImageButton)findViewById(R.id.imageButton34);
		viewArray[4][2]=(ImageButton)findViewById(R.id.imageButton35);
		viewArray[4][3]=(ImageButton)findViewById(R.id.imageButton36);
		viewArray[4][4]=(ImageButton)findViewById(R.id.imageButton37);
		viewArray[4][5]=(ImageButton)findViewById(R.id.imageButton38);
		viewArray[4][6]=(ImageButton)findViewById(R.id.imageButton39);
		viewArray[4][7]=(ImageButton)findViewById(R.id.imageButton40);
		viewArray[5][0]=(ImageButton)findViewById(R.id.imageButton41);
		viewArray[5][1]=(ImageButton)findViewById(R.id.imageButton42);
		viewArray[5][2]=(ImageButton)findViewById(R.id.imageButton43);
		viewArray[5][3]=(ImageButton)findViewById(R.id.imageButton44);
		viewArray[5][4]=(ImageButton)findViewById(R.id.imageButton45);
		viewArray[5][5]=(ImageButton)findViewById(R.id.imageButton46);
		viewArray[5][6]=(ImageButton)findViewById(R.id.imageButton47);
		viewArray[5][7]=(ImageButton)findViewById(R.id.imageButton48);
		viewArray[6][0]=(ImageButton)findViewById(R.id.imageButton49);
		viewArray[6][1]=(ImageButton)findViewById(R.id.imageButton50);
		viewArray[6][2]=(ImageButton)findViewById(R.id.imageButton51);
		viewArray[6][3]=(ImageButton)findViewById(R.id.imageButton52);
		viewArray[6][4]=(ImageButton)findViewById(R.id.imageButton53);
		viewArray[6][5]=(ImageButton)findViewById(R.id.imageButton54);
		viewArray[6][6]=(ImageButton)findViewById(R.id.imageButton55);
		viewArray[6][7]=(ImageButton)findViewById(R.id.imageButton56);
		viewArray[7][0]=(ImageButton)findViewById(R.id.imageButton57);
		viewArray[7][1]=(ImageButton)findViewById(R.id.imageButton58);
		viewArray[7][2]=(ImageButton)findViewById(R.id.imageButton59);
		viewArray[7][3]=(ImageButton)findViewById(R.id.imageButton60);
		viewArray[7][4]=(ImageButton)findViewById(R.id.imageButton61);
		viewArray[7][5]=(ImageButton)findViewById(R.id.imageButton62);
		viewArray[7][6]=(ImageButton)findViewById(R.id.imageButton63);
		viewArray[7][7]=(ImageButton)findViewById(R.id.imageButton64);		
		//taþlarýn baslangýc pozisyonlarý manuel olrak ayarlanýr
intArray[3][4]=1;	  viewArray[3][4].setImageResource(R.drawable.black);
intArray[4][3]=1;	  viewArray[4][3].setImageResource(R.drawable.black);
intArray[4][4]=-1;	  viewArray[4][4].setImageResource(R.drawable.white);
intArray[3][3]=-1;	  viewArray[3][3].setImageResource(R.drawable.white);

setScorTable();// ekrandaki sayýsal durumu gösterir
viewArray[0][0].setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	control(viewArray,0,0);//her buton týklandýgýnda bu fonksiyon cagýrýlýr
	        }});

viewArray[0][1].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,1);
    }});

viewArray[0][2].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,2);
    }});

viewArray[0][3].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,3);
    }});
viewArray[0][4].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,4);
    }});
viewArray[0][5].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,5);
    }});
viewArray[0][6].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,6);
    }});
viewArray[0][7].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,0,7);
    }});////////////////////////////////////
viewArray[1][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,1,0);
    }});

viewArray[1][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,1);
}});

viewArray[1][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,2);
}});

viewArray[1][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,3);
}});
viewArray[1][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,4);
}});
viewArray[1][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,5);
}});
viewArray[1][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,6);
}});
viewArray[1][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,1,7);
}});////////////////
viewArray[2][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,2,0);
    }});

viewArray[2][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,1);
}});

viewArray[2][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,2);
}});

viewArray[2][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,3);
}});
viewArray[2][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,4);
}});
viewArray[2][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,5);
}});
viewArray[2][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,6);
}});
viewArray[2][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,2,7);
}});////////////////////////////////////////////////////////
viewArray[3][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,3,0);
    }});

viewArray[3][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,1);
}});

viewArray[3][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,2);
}});

viewArray[3][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,3);
}});
viewArray[3][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,4);
}});
viewArray[3][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,5);
}});
viewArray[3][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,6);
}});
viewArray[3][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,3,7);
}});//////////////////////////////////////////////////////////////////////////////////////
viewArray[4][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,4,0);
    }});

viewArray[4][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,1);
}});

viewArray[4][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,2);
}});

viewArray[4][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,3);
}});
viewArray[4][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,4);
}});
viewArray[4][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,5);
}});
viewArray[4][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,6);
}});
viewArray[4][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,4,7);
}});////////////////////////////////////////////////////////

viewArray[5][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,5,0);
    }});
viewArray[5][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,1);
}});

viewArray[5][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,2);
}});

viewArray[5][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,3);
}});
viewArray[5][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,4);
}});
viewArray[5][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,5);
}});
viewArray[5][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,6);
}});
viewArray[5][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,5,7);
}});////////////////////////////////////////

viewArray[6][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,6,0);
    }});

viewArray[6][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,1);
}});

viewArray[6][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,2);
}});

viewArray[6][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,3);
}});
viewArray[6][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,4);
}});
viewArray[6][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,5);
}});
viewArray[6][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,6);
}});
viewArray[6][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,6,7);
}});////////////////////////////////////////////////

viewArray[7][0].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    	control(viewArray,7,0);
    }});

viewArray[7][1].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,1);
}});

viewArray[7][2].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,2);
}});

viewArray[7][3].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,3);
}});
viewArray[7][4].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,4);
}});
viewArray[7][5].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,5);
}});
viewArray[7][6].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,6);
}});
viewArray[7][7].setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
control(viewArray,7,7);
}});
CPU(1);
	}/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
void control(ImageButton[][] viewArray,int x,int y){//oyun akýsýný sýrasýný kontrol eder
	Bundle veriler = getIntent().getExtras();
	
	        // Alýnan string veri bir deðiþkene aktarýlýyor
	    //boolean ses = veriler.getBoolean("ses");
	    //  if(ses)
		mp.start();   
		flag=false;
		if(intArray[x][y]==0)
		controlDirection(x,y,1);
	
		
		 if(flag){
			CPU(-1);
		
		}
		}

void CPU(int type){// bilgisayarýn hamlelerini kontrol eder mantýklý yerlere oynar
	ImageView end=(ImageView)findViewById(R.id.imageView3);//kazandýn
	ImageView end1=(ImageView)findViewById(R.id.imageView4);//kaybettin
	Button play=(Button)findViewById(R.id.button1);
	Button menu=(Button)findViewById(R.id.button2);
	leftControl=true;
	rightControl=true;
	int i,j;
	boolean left=true,right=true,down=true,up=true;
	boolean upLeft=true,upRight=true,downLeft=true,downRight=true;
	biggest=0;
	if(type==-1){
	 tempX=-1; tempY=-1;
	}
	for(i=0;i<8;i++){
		for(j=0;j<8;j++){
	if(intArray[i][j]==type){// tüm yönleri kontrol eder nereler müsait diye
		left=true; right=true; down=true; up=true;
		upLeft=true; upRight=true; downLeft=true; downRight=true;
			if(j==0 || intArray[i][j-1]==0 || intArray[i][j-1]==type)
					left=false;
			if(j==7 || intArray[i][j+1]==0 || intArray[i][j+1]==type)
					right=false;

			if(i==0 || intArray[i-1][j]==0 || intArray[i-1][j]==type)
					up=false;
			if(i==7 || intArray[i+1][j]==0 || intArray[i+1][j]==type)
				
			if(j==0  || i==0 || intArray[i-1][j-1]==0 || intArray[i-1][j-1]==type)
					upLeft=false;
			if(j==7  || i==0|| intArray[i-1][j+1]==0 || intArray[i-1][j+1]==type)
					upRight=false;
			
			if(j==0  || i==7 || intArray[i+1][j-1]==0 || intArray[i+1][j-1]==type)
					downLeft=false;
			if(j==7  || i==7 || intArray[i+1][j+1]==0 || intArray[i+1][j+1]==type)
					downRight=false;
			
		if(left)
			CPULeftControl(i,j,type);
	
		if(right)
			CPURightControl(i,j,type);
		
		if(down)
			CPUDownControl(i,j,type);
		if(up)
			CPUUpControl(i,j,type);
		
		if(upLeft)
			CPUUpLeftControl(i,j,type);
	
		if(upRight)
			CPUUpRightControl(i,j,type);
		
		if(downLeft)
			CPUDownLeftControl(i,j,type);
		if(downRight)
			CPUDownRightControl(i,j,type);
		
	}
		}
		
}//2. for dan cýkýs
	setScorTable();  
	if(tempX != -1 && type == -1)//olasý tüm hamleler oynanmýs ve kontrol aedilmiþse
	controlDirection(tempX,tempY,-1);
	if(type==-1){
		
	 user=false;
	   CPU(1);
	   if(!user && tempX!=-1)
		   CPU(-1);
	}
	
	if(!user && tempX==-1 && type==-1){
		if(userCounter > CPU){// oyun bittiginde bilgisayar kazandýysa
		end.setVisibility(View.VISIBLE);
		winner.start();
		}
		else{// oyuncu kazandýysa
			loser.start();
			end1.setVisibility(View.VISIBLE);
			}
	play.setVisibility(View.VISIBLE);
	menu.setVisibility(View.VISIBLE);
	}
	play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        	startActivity(new Intent("com.example.othello1.GIRIS"));// tekrar oyunu oynayabilmek icin PlayAgain
        }});
	menu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        	//startActivity(new Intent("com.example.othello1"));
        }});
}

void controlDirection(int x,int y,int type){//ekran üzerindeki tüm deðiþiklikler burada olur
	int i=1;
	int counter=0;
	boolean left=false,right=false,up=false,down=false;
	boolean upLeft=false,upRight=false,downLeft=false,downRight=false;		
	while(y-i>0 && intArray[x][y-i]==-type) {    //sol
		left=true;
		counter++;
		
		if((y-i)==0){
			left=false;
			break;
		}
		i++;
	}
	if((y-i<0 || intArray[x][y-i]==type) && left){
		for(int j=0;j<=counter;j++){
			if(type==-1){
			viewArray[x][y-j].setImageResource(R.drawable.white);
			intArray[x][y-j]=type;
			}
			else{
				viewArray[x][y-j].setImageResource(R.drawable.black);
				intArray[x][y-j]=type;
				flag=true;
			}
		}
		
	}
	i=1;
	counter=0;
	while( y+i<7 && intArray[x][y+i]==-type) {//sag
		right=true;
		counter++;
		
		if((y+i)==7){
			right=false;
			break;
		}
		i++;
	}
	
	if((y+i>7 || intArray[x][y+i]==type) && right){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x][y+j].setImageResource(R.drawable.white);
				intArray[x][y+j]=type;
				}
				else{
					viewArray[x][y+j].setImageResource(R.drawable.black);
					intArray[x][y+j]=type;
					flag=true;
				}
			
		}
		
	}
	i=1;
	counter=0;
	while(x-i>0 && intArray[x-i][y]==-type) {//yukarý
		up=true;
		counter++;
		
		if((x-i)==0){
			up=false;
			break;
		}
		i++;
	}
	if((x-i<0 || intArray[x-i][y]==type) && up){
		for(int j=0;j<=counter;j++){
			if(type==-1){
			viewArray[x-j][y].setImageResource(R.drawable.white);
			intArray[x-j][y]=type;
			}
			else{
				viewArray[x-j][y].setImageResource(R.drawable.black);
				intArray[x-j][y]=type;
				flag=true;
			}
		}
		
	}
	i=1;
	counter=0;
	while( x+i<7 && intArray[x+i][y]==-type) {//asagý
		down=true;
		counter++;
		
		if((x+i)==7){
			down=false;
			break;
		}
		i++;
	}
	
	if((x+i>7 || intArray[x+i][y]==type) && down){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x+j][y].setImageResource(R.drawable.white);
				intArray[x+j][y]=type;
				}
				else{
					viewArray[x+j][y].setImageResource(R.drawable.black);
					intArray[x+j][y]=type;
					flag=true;
				}
			
		}
		
	}
	i=1;
	counter=0;
	while( x-i>0 && y-i>0 && intArray[x-i][y-i]==-type) {//asagý
		upLeft=true;
		counter++;
		
		if((x-i)==0 || (y-i)==0){
			upLeft=false;
			break;
		}
		i++;
	}
	
	if((x-i<0 || y-i<0 || intArray[x-i][y-i]==type) && upLeft){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x-j][y-j].setImageResource(R.drawable.white);
				intArray[x-j][y-j]=type;
				}
				else{
					viewArray[x-j][y-j].setImageResource(R.drawable.black);
					intArray[x-j][y-j]=type;
					flag=true;
				}
			
		}
		
	}
	i=1;
	counter=0;
	while( x-i>0 && y+i<7 && intArray[x-i][y+i]==-type) {//asagý
		upRight=true;
		counter++;
		
		if((x-i)==0 || (y+i)==7){
			upRight=false;
			break;
		}
		i++;
	}
	
	if((x-i<0 || y+i>7 || intArray[x-i][y+i]==type) && upRight){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x-j][y+j].setImageResource(R.drawable.white);
				intArray[x-j][y+j]=type;
				}
				else{
					viewArray[x-j][y+j].setImageResource(R.drawable.black);
					intArray[x-j][y+j]=type;
					flag=true;
				}
			
		}
		
	}
	i=1;
	counter=0;
	while( x+i<7 && y-i>0 && intArray[x+i][y-i]==-type) {//asagý
		downLeft=true;
		counter++;
		
		if((x+i)==7 || (y-i)==0){
			downLeft=false;
			break;
		}
		i++;
	}
	
	if((x+i>7 || y-i<0 || intArray[x+i][y-i]==type) && downLeft){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x+j][y-j].setImageResource(R.drawable.white);
				intArray[x+j][y-j]=type;
				}
				else{
					viewArray[x+j][y-j].setImageResource(R.drawable.black);
					intArray[x+j][y-j]=type;
					flag=true;
				}
			
		}
		
	}
	i=1;
	counter=0;
	while( x+i<7 && y+i<7 && intArray[x+i][y+i]==-type) {//asagý
		downRight=true;
		counter++;
		
		if((x+i)==7 || (y+i)==7){
			downRight=false;
			break;
		}
		i++;
	}
	
	if((x+i>7 || y+i>7 || intArray[x+i][y+i]==type) && downRight){
		for(int j=0;j<=counter;j++){
			if(type==-1){
				viewArray[x+j][y+j].setImageResource(R.drawable.white);
				intArray[x+j][y+j]=type;
				}
				else{
					viewArray[x+j][y+j].setImageResource(R.drawable.black);
					intArray[x+j][y+j]=type;
					flag=true;
				}
		}
		
	}
	if(type==1 && tempIntArray[0][0]!=-1 && flag){
		int initial;
		for(initial=0;initial<40 && tempIntArray[0][initial]!=-1;initial++){
			if(x==tempIntArray[0][initial] && y==tempIntArray[1][initial]){
				tempIntArray[0][initial]=-1;
				tempIntArray[1][initial]=-1;
				continue;
			}
			viewArray[tempIntArray[0][initial]][tempIntArray[1][initial]].setImageResource(R.drawable.yesil);
			tempIntArray[0][initial]=-1;
			tempIntArray[1][initial]=-1;
		}
	}
}
void CPULeftControl(int x,int y,int type){//bilgisayarýn sol hamlersini kontrol eder

	int counter=0;
	int i;
for( i=1;0<y-i;i++){
	if(intArray[x][y-i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x][y-i]==0) || (y>0 && type==1 && intArray[x][y-i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x;  tempY=y-i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x][y-i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x;
			tempIntArray[1][j]=y-i;
		}
}
}
void CPURightControl(int x,int y,int type){//bilgisayarýn sag hamlesini kontrol eder
	int counter=0;
	int i;
	
for( i=1;i<(7-y);i++){
	if(intArray[x][y+i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x][y+i]==0)  || (y<7 && type==1 && intArray[x][y+i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x;  tempY=y+i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x][y+i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x;
			tempIntArray[1][j]=y+i;
		}
}
}
void CPUUpControl(int x,int y,int type){//bilgisayarýn üst hamlesini kontrol eder
	int counter=0;
	int i;
for( i=1;0<x-i;i++){
	if(intArray[x-i][y]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x-i][y]==0)  || (x>0 && type==1 && intArray[x-i][y]==0 && counter >= 1)){
	if(type==-1){
		tempX=x-i;  tempY=y;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x-i][y].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x-i;
			tempIntArray[1][j]=y;
		}
}
}
void CPUDownControl(int x,int y,int type){//bilgisayarýn alt hamlesini kontrol eder
	int counter=0;
	int i;
	
for( i=1;i<(7-x);i++){
	if(intArray[x+i][y]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x+i][y]==0)  || (x<7 && type==1 && intArray[x+i][y]==0 && counter >= 1)){
	if(type==-1){
	tempX=x+i;  tempY=y;
	biggest=counter;
	}
	else {
		user=true;
		viewArray[x+i][y].setImageResource(R.drawable.yesil1);
		int j;
		for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
		tempIntArray[0][j]=x+i;
		tempIntArray[1][j]=y;
	}
}
}
void CPUUpLeftControl(int x,int y,int type){//bilgisayarýn sol Ust hamlesini kontrol eder
	int counter=0;
	int i;
for( i=1;0<y-i && 0<x-i;i++){
	if(intArray[x-i][y-i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x-i][y-i]==0) || (x>0 && y>0 && type==1 && intArray[x-i][y-i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x-i;  tempY=y-i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x-i][y-i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x-i;
			tempIntArray[1][j]=y-i;
		}
}
}
void CPUUpRightControl(int x,int y,int type){//bilgisayarýn sag USt hamlesini kontrol eder
	int counter=0;
	int i;
for( i=1;7>y+i && x-i>0;i++){
	if(intArray[x-i][y+i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x-i][y+i]==0 ) || (type==1 && intArray[x-i][y+i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x-i;  tempY=y+i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x-i][y+i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x-i;
			tempIntArray[1][j]=y+i;
		}
}
}
void CPUDownLeftControl(int x,int y,int type){//bilgisayarýn asagý sol hamlesini kontrol eder
	int counter=0;
	int i;
for( i=1;0<y-i && x+i<7;i++){
	if(intArray[x+i][y-i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x+i][y-i]==0 ) || (type==1 && intArray[x+i][y-i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x+i;  tempY=y-i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x+i][y-i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x+i;
			tempIntArray[1][j]=y-i;
		}
}
}
void CPUDownRightControl(int x,int y,int type){//bilgisayarýn asagý sag hamlesini kontrol eder
	int counter=0;
	int i;
for( i=1;7>y+i && x+i<7;i++){
	if(intArray[x+i][y+i]==-type)
		counter++;
	else break;
}
if((counter > biggest && intArray[x+i][y+i]==0) || (type==1 && intArray[x+i][y+i]==0 && counter >= 1)){
	if(type==-1){
		tempX=x+i;  tempY=y+i;
		biggest=counter;
		}
		else {
			user=true;
			viewArray[x+i][y+i].setImageResource(R.drawable.yesil1);
			int j;
			for(j=0;tempIntArray[0][j]!=-1 && j<40;j++);
			tempIntArray[0][j]=x+i;
			tempIntArray[1][j]=y+i;
		}
}
}
void setScorTable(){ // ekran üzerindeki skoru göstermeye  calýsýyor
	userCounter=0; CPU=0;
	TextView text=(TextView)findViewById(R.id.textView1);
	Typeface myTypeface=Typeface.createFromAsset(getAssets(), "fonts/Outwrite.ttf");
	 text.setTypeface(myTypeface);
	
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			if(intArray[i][j]==1)
				userCounter++;
			else if(intArray[i][j]==-1)
				CPU++;
	}
	}
	text.setText(userCounter+" - "+CPU);
	
}
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		CPU(1);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
