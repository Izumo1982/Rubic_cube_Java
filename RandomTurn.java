package Rubic;

class RandomTurn {

	//回転基準面のランダム　0～5
	public int men() {
		return 	 (int)(Math.random() * 5);

	}

	public int line(){
		//移動方向のランダム　1～4 に　*10
		//移動列のランダム　1～3
		return (int)((Math.random() * 4) + 1) * 10 + ((int)(Math.random() * 3) + 1);
	}

}
