import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class SudipTicTacToe extends JFrame implements  ActionListener{

    int i,j,ii,jj,x,y,yesnull; 

    // boundary for button
    int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
     int a1[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
				
      boolean state,type,set;

      //store image
      Icon pic1,pic2,icon,pic11,pic22;
      Checkbox c1,c2;
      JLabel l1,l2;
      //clickable buttons
      JButton b[]=new JButton[9];
      //Replay button
      JButton Replay;

      
public void showButton(){

  x=10; 
  y=10;j=0;

  for(i=0;i<=8;i++,x+=100,j++){
     b[i]=new JButton();

     if(j==3){
      j=0; y+=100; x=10;
    }
    b[i].setBounds(x,y,100,100);
    add(b[i]);
    // add listener to every button
    b[i].addActionListener(this);
}

  Replay=new JButton("Replay");
  Replay.setBounds(100,350,100,50);
  add(Replay);
  //add event listener for Replay button
  Replay.addActionListener(this);

}
public  void check(int num1){
for(ii=0;ii<=7;ii++){
   for(jj=1;jj<=3;jj++){
        if(a[ii][jj]==num1){ a[ii][4]=11;  
        }
      }
    }
}

//main constructor
SudipTicTacToe(){
    super("tic tac toe by Sudip");
    state=true;type=true;set=true;
    pic1=new ImageIcon("pic1.jpg");
    pic2=new ImageIcon("pic2.jpg");
    pic11=new ImageIcon("pic11.jpg");
    pic22=new ImageIcon("pic22.jpg");

    setLayout(null);
    setSize(330,450);
    setVisible(true);
    showButton();
    // cross click vayo vane exit
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}


// button click huda k garne vanera define gareko
public void actionPerformed(ActionEvent e){

if(type==true){
  //Replay button thicda sabai image remove garne
if(e.getSource()==Replay){
 for(i=0;i<=8;i++){
   b[i].setIcon(null);
  } 
}
else{ 
  for(i=0;i<=8;i++){
      if(e.getSource()==b[i]){
       
           if(b[i].getIcon()==null){
              if(state==true){ icon=pic2;         
               state=false;} else{ icon=pic1; state=true; }
            b[i].setIcon(icon);
            }
          } 
      }
    }
}
else if(type==false){                                    
      if(e.getSource()==Replay){
          for(i=0;i<=8;i++){
            b[i].setIcon(null);
          }
       for(i=0;i<=7;i++)
         for(j=0;j<=4;j++)
		        a[i][j]=a1[i][j];
        }
    }

    // checking for winner
for(i=0;i<=7;i++){
  
  Icon icon1=b[(a[i][1]-1)].getIcon();
  Icon icon2=b[(a[i][2]-1)].getIcon();
  Icon icon3=b[(a[i][3]-1)].getIcon();
     if((icon1==icon2)&&(icon2==icon3)&&(icon1!=null)){
               if(icon1==pic1){ 
                 b[(a[i][1]-1)].setIcon(pic11);
                 b[(a[i][2]-1)].setIcon(pic11); 
                 b[(a[i][3]-1)].setIcon(pic11);
                 //display winner name
	              JOptionPane.showMessageDialog(SudipTicTacToe.this,"!!!Player2 won!!! click Replay");	
  		           break;
           }
             else if(icon1==pic2){ 
             b[(a[i][1]-1)].setIcon(pic22);
             b[(a[i][2]-1)].setIcon(pic22);
             b[(a[i][3]-1)].setIcon(pic22); 
             // display winner name
               JOptionPane.showMessageDialog(SudipTicTacToe.this,"!!!Player1 won!!! click Replay");
                break;			 
               }
         }
    }  
}
public static void main(String []args){
  // call constructor
    new SudipTicTacToe();
   }
}