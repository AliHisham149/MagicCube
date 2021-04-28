public class challenges {
/*CHALLENGES FROM 1-5
 * 
 * after studying the cases of the challenges i reached that these challenges are called magic squares
 * and i reached some properties of magic squares and they are :
 * A B C 
 * D E F 
 * G H I 
 * we will assume that the square that has the letters from A to I as shown is a magic square
 * 1- the average of the 4 corners equals the middle number (E=(A+C+I+G)/4) 
 * 2- average of each to opposite numbers equals the middle number(E=(A+I)/2=(B+H)/2=(C+G)/2=(D+F)/2) 
 * 3- average of the 4 sides equals the middle number (E=(B+D+F+H)/4)
 * 4-if you are familiar with chess there is something called the knight's move for example:
 *   if the knight is on square A then his available moves are F and H, and from that we go to the fact that
 *   the average of both knights moves of each corner is equal to the number in the corner
 *   (A=(F+H)/2,C=(D+H)/2,G=(B+F)/2,I=(B+D)/2)
 * 5-the middle number is one third of the magic sum(sum of each row, column, diagonal) 
 */
/*
 * CHALLENGE 6 
 * 
 * I tried so many different approaches in coding for challenge 6,after that i reached that for a magic square to have 
 * 7 magic sums (3 rows, 3 columns, 1 diagonal) with a magic sum of a non-square number it has to follow certain formulas 
 * and these formulas are: 
 * A = (p^2+q^2-r^2-s^2)^2
 * B = (2*(qr+ps))^2
 * C = (2*(qs-pr))^2
 * D = (2*(qr-ps))^2
 * E = (p^2-q^2+r^2-s^2)^2
 * F = (2*(rs+pq))^2
 * G = (2*(qs+pr))^2
 * H = (2*(rs-pq))^2
 * I = (p^2-q^2-r^2+s^2)^2
 * Also the magic sum will be = (q^2+p^2+r^2+s^2)^2
 * Moreover I found the smallest numbers for the square to satisfy all the requirements as it was found by an Indian
 * scientist called Ajai Choudhry so i copied it and multiplied it by the 2 minimum square numbers greater than 1 
 * which are 4 and 9, 
 * reference: http://www.multimagie.com/English/SquaresOfSquaresSearch.htm
 * PS: I don't know if it counts as i solved it or no but the solution is in the excel sheet attached 
 * 
*
*/
	
//to check whether all columns, rows and diagonals are equal and if the middle number is 3*the sum or so called
public static boolean checksum(int a[][]) {
	int a1 = a[0][0];
	int a2 = a[0][1];
	int a3 = a[0][2];
	int a4 = a[1][0];
	int a5 = a[1][1];
	int a6 = a[1][2];
	int a7 = a[2][0];
	int a8 = a[2][1];
	int a9 = a[2][2];
	int row1= a1+a2+a3;
	int row2= a4+a5+a6;
	int row3= a7+a8+a9;
	int col1= a1+a4+a7;
	int col2= a2+a5+a8;
	int col3= a3+a6+a9;
	int diag1=a1+a5+a9;
	int diag2= a3+a5+a7;
	if((row1==row2)&&(row2==row3)&&(col1==row3)&&(col2==col1)&&(col2==col3)
			&&(col3==diag1)&&(diag1==diag2)&& (a5==diag2/3)
			&&(a1>0)&&(a2>0)&&(a3>0)&&(a4>0)&&(a5>0)&&(a6>0)&&(a7>0)&&(a8>0)&&(a9>0)) {
		return true;
		
	}else {
		return false;
	}
	
}

//performs the calculations of the knight's move method mentioned above in the comments
public static void knightmove(int a[][]) {
	int a1 = a[0][0];
	int a2 = a[0][1];
	int a3 = a[0][2];
	int a4 = a[1][0];
	int a5 = a[1][1];
	int a6 = a[1][2];
	int a7 = a[2][0];
	int a8 = a[2][1];
	int a9 = a[2][2];
	for(int i=0;i<6;i++) {
	//first knight move combinations
	if(!(a1!=0 && a6!=0 && a8!=0)) {
		if(a1!=0 && a6!=0) {
			a8= a1*2- a6;
		}
		if(a1!=0 && a8!=0) {
			a6= a1*2 - a8 ;
		}
		if(a6!=0 && a8!=0) {
			a1 = (a6 + a8)/2;
	}}
	//second knight move combinations
	if(!(a3!=0 && a4!=0 && a8!=0)) {
		if(a3!=0 && a4!=0) {
			a8= a3*2 - a4;
		}
		if(a3!=0 && a8!=0) {
			a4= a3*2 - a8;
		}
		if(a4!=0 && a8!=0) {
			a3 = (a4 + a8)/2;}}
	//third knight move combinations
	if(!(a7!=0 && a6!=0 && a2!=0)) {
		if(a7!=0 && a6!=0) {
			a6= a7*2-a2;
		}
		if(a7!=0 && a2!=0) {
			a2=a7*2-a6;
		}
		if(a6!=0 && a2!=0) {
			a7 = (a6 + a2)/2;
			}}
	//fourth knight move combinations
	if(!(a9!=0 && a2!=0 && a4!=0)) {
		if(a9!=0 && a2!=0) {
			a4= a9*2-a2;
		}
		if(a9!=0 && a4!=0) {
			a2= a9*2-a4;
		}
		if(a2!=0 && a4!=0) {
			a9 = (a2 + a4) / 2;}}
	}
	a[0][0]=a1;
	a[0][1]=a2;
	a[0][2]=a3;
	a[1][0]=a4;
	a[1][1]=a5;
	a[1][2]=a6;
	a[2][0]=a7;
	a[2][1]=a8;
	a[2][2]=a9;

}
//performs the calculations involving the middle number
public static void middlenumber(int a[][]) {
	int a1 = a[0][0];
	int a2 = a[0][1];
	int a3 = a[0][2];
	int a4 = a[1][0];
	int a5 = a[1][1];
	int a6 = a[1][2];
	int a7 = a[2][0];
	int a8 = a[2][1];
	int a9 = a[2][2];
	//corners solve
	if(a5!=0 && a1!=0 && a3!=0 && a7!=0) {
		a9 = (a5*4)-a1-a3-a7;
	}
	if(a5!=0 && a1!=0 && a3!=0 && a9!=0) {
		a7 = (a5*4)-a1-a3-a9;
	}
	if(a5!=0 && a1!=0 && a9!=0 && a7!=0) {
		a3 = (a5*4)-a1-a9-a7;
	}
	if(a5!=0 && a9!=0 && a3!=0 && a7!=0) {
		a1 = (a5*4)-a9-a3-a7;
	}
	if(a9!=0 && a1!=0 && a3!=0 && a7!=0) {
		a5 = (a9+a1+a3+a7) / 4;
	}
	//middle two opposite values 
	if(a5!=0 && a1!=0) {
		a9 = a5*2 - a1;
	}
	if(a5!=0 && a9!=0) {
		a1 = a5*2 - a9;
	}
	if(a5!=0 && a2!=0) {
		a8 = a5*2 - a2;
	}
	if(a5!=0 && a8!=0) {
		a2 = a5*2 - a8;
	}
	if(a5!=0 && a3!=0) {
		a7 = a5*2 - a3;
	}
	if(a5!=0 && a7!=0) {
		a3 = a5*2 - a7;
	}
	if(a5!=0 && a4!=0) {
		a6 = a5*2 - a4;
	}
	if(a5!=0 && a6!=0) {
		a4 = a5*2 - a6;
	}
	if(a9!=0 && a1!=0) {
		a5 = (a1+a9)/2;
	}
	if(a8!=0 && a2!=0) {
		a5 = (a2+a8)/2;
	}
	if(a7!=0 && a3!=0) {
		a5 = (a3+a7)/2;
	}
	if(a6!=0 && a4!=0) {
		a5 = (a4+a6)/2;
	}
	//sides solve
	if(a5!=0 && a2!=0 && a4!=0 && a6!=0) {
		a8 = (a5*4)-a2-a4-a6;
	}
	if(a5!=0 && a2!=0 && a4!=0 && a8!=0) {
		a6 = (a5*4)-a2-a4-a8;
	}
	if(a5!=0 && a2!=0 && a6!=0 && a8!=0) {
		a4 = (a5*4)-a2-a6-a8;
	}
	if(a5!=0 && a4!=0 && a6!=0 && a8!=0) {
		a2 = (a5*4)-a4-a6-a8;
	}
	if(a2!=0 && a4!=0 && a6!=0 && a8!=0) {
		a5 = (a9+a1+a3+a7) / 4;
	}
	
	a[0][0]=a1;
	a[0][1]=a2;
	a[0][2]=a3;
	a[1][0]=a4;
	a[1][1]=a5;
	a[1][2]=a6;
	a[2][0]=a7;
	a[2][1]=a8;
	a[2][2]=a9;
}
//performs calculations involving magic sum
public static void magicsum(int a[][]) {
	int a1 = a[0][0];
	int a2 = a[0][1];
	int a3 = a[0][2];
	int a4 = a[1][0];
	int a5 = a[1][1];
	int a6 = a[1][2];
	int a7 = a[2][0];
	int a8 = a[2][1];
	int a9 = a[2][2];
	int magicsum=0;
	for(int i=0;i<8;i++) {
	if(a1!=0&&a2!=0&&a3!=0) {
		magicsum = a1 + a2 + a3;
		a5 = magicsum/3;
	}
	if(a4!=0&&a5!=0&&a6!=0) {
		magicsum = a4 + a5 + a6;
		a5 = magicsum/3;
	}
	if(a7!=0&&a8!=0&&a9!=0) {
		magicsum = a7 + a8 + a9;
		a5 = magicsum/3;
	}
	if(a1!=0&&a4!=0&&a7!=0) {
		magicsum = a1 + a4 + a7;
		a5 = magicsum/3;
	}
	if(a2!=0&&a5!=0&&a8!=0) {
		magicsum = a2 + a5 + a8;
		a5 = magicsum/3;
	}
	if(a3!=0&&a6!=0&&a9!=0) {
		magicsum = a3 + a6 + a9;
		a5 = magicsum/3;
	}
	if(a1!=0&&a5!=0&&a9!=0) {
		magicsum = a1 + a5 + a9;
		a5 = magicsum/3;
	}
	if(a3!=0&&a5!=0&&a7!=0) {
		magicsum = a3 + a5 + a7;
		a5 = magicsum/3;
	}
	if(magicsum!=0) {
		if(a1!=0 && a2!=0) {
			a3 = magicsum -a1 -a2;
		}
		if(a3!=0 && a2!=0) {
			a1 = magicsum - a3 -a2;
		}
		if(a1!=0 && a3!=0) {
			a2 = magicsum -a1 -a3;
		}
		if(a4!=0 && a5!=0) {
			a6 = magicsum -a4 -a5;
		}
		if(a4!=0 && a6!=0) {
			a5 = magicsum -a4 -a6;
		}
		if(a5!=0 && a6!=0) {
			a4 = magicsum-a5-a6;
		}
		if(a7!=0 && a8!=0) {
			a9 = magicsum -a7 -a8;
		}
		if(a7!=0 && a9!=0) {
			a8 = magicsum -a7 -a9;
		}
		if(a8!=0 && a9!=0) {
			a7 = magicsum -a8 -a9;
		}
		if(a1!=0 && a4!=0) {
			a7 = magicsum -a1 -a4;
		}
		if(a1!=0 && a7!=0) {
			a4 = magicsum -a1 -a7;
		}
		if(a7!=0 && a4!=0) {
			a1 = magicsum -a4 -a7;
		}
		if(a5!=0 && a2!=0) {
			a8 = magicsum -a5 -a2;
		}
		if(a8!=0 && a2!=0) {
			a5 = magicsum -a8 -a2;
		}
		if(a8!=0 && a5!=0) {
			a2 = magicsum -a5 -a8;
		}
		if(a3!=0 && a6!=0) {
			a9 = magicsum -a3 -a6;
		}
		if(a3!=0 && a9!=0) {
			a6 = magicsum -a3 -a9;
		}
		if(a6!=0 && a9!=0) {
			a3 = magicsum -a6 -a9;
		}
		if(a1!=0 && a5!=0) {
			a9 = magicsum -a1 -a5;
		}
		if(a1!=0 && a9!=0) {
			a5 = magicsum -a1 -a9;
		}
		if(a9!=0 && a5!=0) {
			a1 = magicsum -a5 -a9;
		}
		if(a5!=0 && a7!=0) {
			a3 = magicsum -a5 -a7;
		}
		if(a3!=0 && a7!=0) {
			a5 = magicsum -a3 -a7;
		}
		if(a3!=0 && a5!=0) {
			a7 = magicsum -a3 -a5;
		}
	}}
	a[0][0]=a1;
	a[0][1]=a2;
	a[0][2]=a3;
	a[1][0]=a4;
	a[1][1]=a5;
	a[1][2]=a6;
	a[2][0]=a7;
	a[2][1]=a8;
	a[2][2]=a9;
}
//Challenge1
public static void challenge1() {
	int a[][]= new int[3][3];
	a[0][0]=12;
	a[0][1]=17;
	a[0][2]=10;
	a[1][0]=11;
		while(!checksum(a)) {
		knightmove(a);
		middlenumber(a);
		magicsum(a);
	}
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
	        System.out.print(a[i][j] + " ");
	    }
	    System.out.println();
	}
}
//Challenge2
public static void challenge2() {
	int a[][]= new int[3][3];
	a[1][0]=15;
	a[0][1]=7;
	a[0][2]=16;
	a[2][2]=11;
		while(!checksum(a)) {
		knightmove(a);
		middlenumber(a);
		magicsum(a);
	}
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
	        System.out.print(a[i][j] + " ");
	    }
	    System.out.println();
	}
}
//Challenge3
public static void challenge3() {
	int a[][]= new int[3][3];
	a[1][0]=31;
	a[1][2]=15;
	a[2][1]=41;
		while(!checksum(a)) {
		knightmove(a);
		middlenumber(a);
		magicsum(a);
	}
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
	        System.out.print(a[i][j] + " ");
	    }
	    System.out.println();
	}
}
//Challenge 4
public static void challenge4() {
	int a[][]= new int[3][3];
	a[1][2]=18;
	a[2][1]=28;
		for(int i=0; i<9;i++) {
		middlenumber(a);
		magicsum(a);
		knightmove(a);
	}
		int a1 = a[0][0];
		int a2 = a[0][1];
		int a3 = a[0][2];
		int a4 = a[1][0];
		int a5 = a[1][1];
		int a6 = a[1][2];
		int a7 = a[2][0];
		int a8 = a[2][1];
		int a9 = a[2][2];
		   
		if(!checksum(a)) {
			for (int j=0;!checksum(a);j++)
			{
				a[0][0]=a1;
				a[0][1]=a2;
				a[0][2]=a3;
				a[1][0]=a4;
				a[1][1]=a5;
				a[1][2]=a6;
				a[2][0]=a7;
				a[2][1]=a8;
				a[2][2]=a9;
			a[1][1]=j;
			for(int k=0;k<9;k++)
			{
			knightmove(a);
			middlenumber(a);
			magicsum(a);	
			}

	}
			}
		
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		        System.out.print(a[i][j] + " ");
		    }
		    System.out.println();
		}
}
//Challenge5
public static void challenge5() {
	int a[][]= new int[3][3];
	int j=0;
	a[1][2]=18;
	a[2][1]=28;
	
		for(int i=0; i<9;i++) {
		middlenumber(a);
		magicsum(a);
		knightmove(a);
	}
		int a1 = a[0][0];
		int a2 = a[0][1];
		int a3 = a[0][2];
		int a4 = a[1][0];
		int a5 = a[1][1];
		int a6 = a[1][2];
		int a7 = a[2][0];
		int a8 = a[2][1];
		int a9 = a[2][2];
		for(int count=0;count<3;count++) {   
		if(!checksum(a)|| count<3) {
			for (j=j;!checksum(a);j++)
			{
				a[0][0]=a1;
				a[0][1]=a2;
				a[0][2]=a3;
				a[1][0]=a4;
				a[1][1]=a5;
				a[1][2]=a6;
				a[2][0]=a7;
				a[2][1]=a8;
				a[2][2]=a9;
			a[1][1]=j;
			for(int k=0;k<9;k++)
			{
			knightmove(a);
			middlenumber(a);
			magicsum(a);	
			}
	}
			}
		
		for (int i = 0; i < 3; i++) {
		    for (int x = 0; x < 3; x++) {
		        System.out.print(a[i][x] + " ");
		    }
		    System.out.println();
		}
		System.out.println();
		a[1][1]=j+1;
		}
	}
public static void main(String[]args) {
	System.out.println("Challenge 1");
	challenge1();
	System.out.println();
	System.out.println("Challenge 2");
	challenge2();
	System.out.println();
	System.out.println("Challenge 3");
	challenge3();
	System.out.println();
	System.out.println("Challenge 4");
	challenge4();
	System.out.println();
	System.out.println("Challenge 5");
	challenge5();
	System.out.println();
	System.out.println("For challenge 6 kindly open the excel file attached :)");

}

}

