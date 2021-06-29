package Rubic;

class Ido extends Utility {

	public static String log = "";

	public static void showLog() {
		System.out.println(log);
	}

	public char[][] nineIdo(char[][] rubiu,int idom,int ido,int sayuu) {
		char tmp[] = new char[9];
		int idomen = LINE[idom][ido];
		for(int i = 0; i < 9; i++) {
			tmp[i] = rubiu[idomen][i];
		}


		for(int i = 0; i < 9; i++) {
			rubiu[idomen][MENNAI[sayuu][i]] = tmp[i];
		}
		return rubiu;
	}

	public char[][] threeIdo(char[][] rubiu,int[] tate,int[] yoko) {
		//tateは4つ。面。 tate[0] →　tate[1] →　tate[2] →　tate[3] →　tate[0]の順に移動
		//yokoは３つ。位置。移動元、移動先ともに同じ番号
		char[] tmp = new char[4];
		for(int i = 0; i < yoko.length; i++) {
			tmp[i] = rubiu[tate[3]][yoko[i]];
		}

		for(int j = 3; j > 0; j--) {
			for(int i = 0; i < yoko.length; i++) {
				rubiu[tate[j]][yoko[i]] = rubiu[tate[j - 1]][yoko[i]];
			}
		}

		for(int i = 0; i < yoko.length; i++) {
			rubiu[tate[0]][yoko[i]] = tmp[i];
		}

		return rubiu;
	}

	public char[][] Turn(char[][] rubi,int idomen,int idoLine) {
		log += "\n" + idomen + "-" + idoLine;
		int[] ta,yo;
		switch(idoLine) {
		case 11:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 1, 5, 2);
			yo = yokoIn(0, 3, 6);//末尾1の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,3,0);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　


			break;
		case 12:
			System.out.println("90°回転：無し");
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 1, 5, 2);
			yo = yokoIn(1, 4, 7);//末尾2の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			break;

		case 13:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 1, 5, 2);
			yo = yokoIn(2, 5, 8);//末尾3の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,4,1);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　
			break;

		case 21:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 2, 5, 1);
			yo = yokoIn(0, 3, 6);//末尾1の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,3,1);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　


			break;
		case 22:
			System.out.println("90°回転：無し");
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 2, 5, 1);
			yo = yokoIn(1, 4, 7);//末尾2の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			break;

		case 23:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 2, 5, 1);
			yo = yokoIn(2, 5, 8);//末尾3の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,4,0);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　
			break;

		case 31:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 3, 5, 4);
			yo = yokoIn(0, 1, 2);//末尾1の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,1,0);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　


			break;
		case 32:
			System.out.println("90°回転：無し");
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 3, 5, 4);
			yo = yokoIn(3, 4, 5);//末尾2の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			break;

		case 33:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 3, 5, 4);
			yo = yokoIn(6, 7, 8);//末尾3の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,1,1);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　
			break;
		//
		case 41:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 4, 5, 3);
			yo = yokoIn(0, 1, 2);//末尾1の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,1,1);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　


			break;
		case 42:
			System.out.println("90°回転：無し");
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 4, 5, 3);
			yo = yokoIn(3, 4, 5);//末尾2の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			break;

		case 43:
			System.out.println("90°回転：" + LINE[idomen][3]);
			System.out.println("3マス移動：" + LINE[idomen][0]);

			ta = tateIn(idomen, 0, 4, 5, 3);
			yo = yokoIn(6, 7, 8);//末尾3の時
			rubi = threeIdo(rubi,ta,yo);//３マスx4面移動
			rubi = nineIdo(rubi,idomen,1,0);//90°回転、2番目：移動指定面、3番目：９０°回転させる面、末尾0：右回転・1：左回転　※X2の時は不要　
			break;

		}
		return rubi;
	}


}
