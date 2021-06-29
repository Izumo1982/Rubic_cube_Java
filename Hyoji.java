package Rubic;

import java.nio.charset.Charset;

class Hyoji implements Data {

	public char[][] setColor(){
		char[][] rub = new char[6][9];

		for(int i = 0; i < rub.length;i++) {
			for(int j = 0; j < rub[i].length;j++) {
				rub[i][j] = RUB[i];
			}
		}
		return rub;
	}

	private static String format(String target, int length){
        int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
        return String.format("%-"+(length-byteDiff)+"s", target);
    }

    private static int getByteLength(String string, Charset charset) {
        return string.getBytes(charset).length;
    }


	String[] outp(char[][] rubu,int idomen) {
		String[] list = new String[4];
		//1行目　面目、2～4行目　3X3のデータ
		list[0] = idomen  + "面目";
		list[1] = "";
		list[2] = "";
		list[3] = "";
		for(int j = 0; j < rubu[idomen].length;j++) {
//			System.out.println(j + ":" + (j / 3) + 1);
			list[(j / 3) + 1] = list[(j / 3) + 1] + rubu[idomen][j];
		}
		return list;
	}



	void hyoji(char[][] rubu){
		String[] outPut = {"","","",""};

		for(int i = 0; i < rubu.length;i++) {
			String[] outline = outp(rubu,i);

			for(int j = 0; j < outline.length;j++) {
				outPut[j] = outPut[j] + format(outline[j], 8) + "｜";
			}
		}

		System.out.println(outPut[0] + "\n" + outPut[1] + "\n" + outPut[2] + "\n" + outPut[3] + "\n");

	}

	void idohyoji(char[][] rubu,int idomen) {
		String[] outline = new String[18];
		outline[5] = "";
		outline[13] = "";
		String spe = "                ";
		String[] outlineN = new String[4];

		outline[0] = "          移動面を中心" ;


		outlineN = outp(rubu, LINE[idomen][1]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 1] = spe + outlineN[j] ;
		}

		outlineN = outp(rubu,LINE[idomen][3]);

		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 7] = outlineN[j];
		}

		outlineN = outp(rubu,LINE[idomen][0]);


		outline[6] = "       ※基準面 111213";
		outline[7] = outline[7] + "      " + outlineN[0] + "↑↑↑　　　";
		outline[8] = outline[8] + "      31←" + outlineN[1] + "→41　" ;
		outline[9] = outline[9] + "      32←" + outlineN[2] + "→42　" ;
		outline[10] = outline[10] + "      33←" + outlineN[3] + "→43　" ;
		outline[11] = "                ↓↓↓";
		outline[12] = "                212223";

		outlineN = outp(rubu,LINE[idomen][4]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 7] = outline[j + 7] + outlineN[j];
		}


		outlineN = outp(rubu,LINE[idomen][2]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 14] = spe + outlineN[j];
		}

		//ここで文字調整要
		for(int j = 0;j < outline.length; j ++) {
			outline[j] = format(outline[j], 35) + " | ";

		}


//以下、裏面
		outline[0] = outline[0] + "　　　　　　　裏面を中心" ;

		outlineN = outp(rubu,LINE[idomen][1]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 1] = outline[j + 1] + spe + outlineN[j];
		}

		outlineN = outp(rubu,LINE[idomen][4]);

		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 7] = outline[j + 7] + outlineN[j];
		}

		outlineN = outp(rubu,LINE[idomen][5]);


		outline[6] = outline[6] + "　　　 ※基準面 111213";
		outline[7] = outline[7] + "　　　" + outlineN[0] + "↑↑↑　　　　　";
		outline[8] = outline[8] + "　　　31←" + outlineN[1] + "→41　　　" ;
		outline[9] = outline[9] + "　　　32←" + outlineN[2] + "→42　　　" ;
		outline[10] = outline[10] + "　　　33←" + outlineN[3] + "→43　　　" ;
		outline[11] = outline[11] + "　　　　　　　　↓↓↓";
		outline[12] = outline[12] + "　　　　　　　　212223";

		outlineN = outp(rubu,LINE[idomen][3]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 7] = outline[j + 7] + outlineN[j];
		}


		outlineN = outp(rubu,LINE[idomen][2]);
		for(int j = 0;j < outlineN.length; j ++) {
			outline[j + 14] = outline[j + 14] + spe + outlineN[j];
		}





		for(int j = 0;j < outline.length; j ++) {
			System.out.println(outline[j]);
		}
	}

}
