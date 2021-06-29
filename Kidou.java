package Rubic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Kidou extends Hyoji{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Hyoji rubi = new Hyoji();

		Ido ido = new Ido();

		char[][] start_rub = rubi.setColor();

		char[][] rub = rubi.setColor();

		RandomTurn rt = new RandomTurn();

		System.out.println("ランダムで何回転しますか？※0ならそのまま");
		String str0 = br.readLine();
		int rt_n = Integer.parseInt(str0);
		for (int i = 0; i < rt_n; i++) {
			rub = ido.Turn(rub,rt.men(),rt.line());
		}

		do{

			Ido.showLog();
			rubi.hyoji(rub);

			System.out.println("どの面を基準に回転しますか？(0～5)");
			String str1 = br.readLine();
			int idomen = Integer.parseInt(str1);
			//ここで移動面を基準にして表示
			rubi.idohyoji(rub,idomen);

			System.out.println("どのラインを回転しますか？(11～43)");
			String str2 = br.readLine();

			int idoLine = Integer.parseInt(str2);

			rub = ido.Turn(rub,idomen,idoLine);

			if (Arrays.deepEquals(start_rub , rub)) {
				System.out.println("揃いました！終了です。");
				break;
			}
		}while(true);
	}


}
