package Rubic;

public class Utility implements Data {

	int[] tateIn(int idomen, int t1,int t2,int t3,int t4) {
		int ta[] = new int[4];

		ta[0] = LINE[idomen][t1];
		ta[1] = LINE[idomen][t2];
		ta[2] = LINE[idomen][t3];
		ta[3] = LINE[idomen][t4];
		return ta;
	}

	int[] yokoIn(int y1,int y2, int y3) {
		int yo[] = new int[3];
		yo[0] = y1;
		yo[1] = y2;
		yo[2] = y3;
		return yo;
	}
}
