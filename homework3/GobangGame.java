package com.nicholas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				// int[] computerPosArr = computerDo();
				int[] computerPosArr = computerDo(posX, posY, chessman);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {

		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}

	// 在黑色棋子（玩家）连子最多的一侧放棋子
	// 稍后改进：对方向设置优先级，由高到低尝试
	public int[] computerDo(int posX, int posY, String ico) {

		int X;
		int Y;
		//四个方向
		int ud = upToDown(posX, posY, ico);
		int lr = leftToRight(posX, posY, ico);
		int lu = leftUpToRightDown(posX, posY, ico);
		int ld = leftDownToRightUp(posX, posY, ico);
		int maxIndex = 0;
		int[] nums = { ud, lr, lu, ld };
		//在四个方向中，选出连子数目最多的一个方向
		// 返回最大的数的数组下标
		for (int i = 0; i <= 3; i++) {
			if (nums[maxIndex] >= nums[i]) {
				continue;
			} else {
				maxIndex = i;
			}
		}
		//最坏的情况下也就循环一次 即有ld->ud
		int a = 1;
		while (a > 0) {
			// upToDown方向
			if (nums[maxIndex] == ud) {
				String[][] board = chessboard.getBoard();
				Y = posY;
				if((board[posX+1][posY]!="十")||(posX+1>Chessboard.BOARD_SIZE-1)){
					//若此方向已有棋子，继续向前走，直到可以放置棋子或是跳出循环
					//循环的次数是在这个方向上连子的最大值
					for(int i=0;i<ud;i++){
						X = posX - i;
						if(board[X][Y] != "十"){
							continue;
						}else{
							int[] res = {X,Y};
							return res;
						}
					}
				}else{
					X = posX+1;
					Y = posY;
					int[] res = {X,Y};
					return res;
				}
				//此方向行不通，则换另一个方向
				//现在是固定顺序，下一个版本考虑按优先级选择方向现在只有最高
				nums[maxIndex] = lr;
//				if (posY + 1 > Chessboard.BOARD_SIZE) {
//					Y = posY - 1;
//					X = posX;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 换相反的方向
//						Y = posY + 1;
//						X = posX;
//						String[][] board1 = chessboard.getBoard();
//						if (board1[X][Y] != "十") {
//							// 相反的方向仍旧有棋子，则换其他的方向
//							nums[maxIndex] = lr;
//							continue;
//						}
//					}
//				} else {
//					Y = posY + 1;
//					X = posX;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 只能换其他的方向
//						nums[maxIndex] = lr;
//						continue;
//					}
//				}
//				int[] res = { X, Y };
//				return res;

			}
			if (nums[maxIndex] == lr) {
				// leftToRight
				String[][] board = chessboard.getBoard();
				X = posX;
				if((board[posX][posY+1]!="十")||(posY+1>Chessboard.BOARD_SIZE-1)){
					for(int i=0;i<lr;i++){
						Y = posY - i;
						if(board[X][Y] != "十"){
							continue;
						}else{
							int[] res = {X,Y};
							return res;
						}
					}
				}else{
					X = posX;
					Y = posY+1;
					int[] res = {X,Y};
					return res;
				}
				nums[maxIndex] = lu;
//				if (posX + 1 > Chessboard.BOARD_SIZE) {
//					X = posX - 1;
//					Y = posY;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 换相反的方向
//						X = posX + 1;
//						Y = posY;
//						String[][] board1 = chessboard.getBoard();
//						if (board1[X][Y] != "十") {
//							// 相反的方向仍旧有棋子，则换其他的方向
//							nums[maxIndex] = lu;
//							continue;
//						}
//					}
//				} else {
//					X = posX + 1;
//					Y = posY;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 只能换其他的方向
//						nums[maxIndex] = lu;
//						continue;
//					}
//				}
//				int[] res = { X, Y };
//				return res;
			}
			if (nums[maxIndex] == lu) {
				// leftUpToRightDown
				String[][] board = chessboard.getBoard();
				
				if((board[posX+1][posY+1]!="十")||(posY+1>Chessboard.BOARD_SIZE-1)||(posX+1>Chessboard.BOARD_SIZE-1)){
					for(int i=0;i<lu;i++){
						Y = posY - i;
						X = posX - i;
						if(board[X][Y] != "十"){
							continue;
						}else{
							int[] res = {X,Y};
							return res;
						}
					}
				}else{
					X = posX+1;
					Y = posY+1;
					int[] res = {X,Y};
					return res;
				}
				nums[maxIndex] = ld;
//				if ((posX + 1 > Chessboard.BOARD_SIZE)
//						|| (posY + 1 > Chessboard.BOARD_SIZE)) {
//					X = posX - 1;
//					Y = posY - 1;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 换相反的方向
//						X = posX + 1;
//						Y = posY + 1;
//						String[][] board1 = chessboard.getBoard();
//						if (board1[X][Y] != "十") {
//							// 相反的方向仍旧有棋子，则换其他的方向
//							nums[maxIndex] = ld;
//							continue;
//						}
//					}
//				} else {
//					X = posX + 1;
//					Y = posY + 1;
//					String[][] board = chessboard.getBoard();
//					if (board[X][Y] != "十") {
//						// 只能换其他的方向
//						nums[maxIndex] = ld;
//						continue;
//
//					}
//				}
//				int[] res = { X, Y };
//				return res;
			} 
			if(nums[maxIndex] == ld){
				// leftDownToRightUp
				String[][] board = chessboard.getBoard();
				if((board[posX-1][posY+1]!="十")||(posY+1>Chessboard.BOARD_SIZE-1)||(posX-1<0)){
					for(int i=0;i<ld;i++){
						Y = posY - i;
						X = posX + i;
						if(board[X][Y] != "十"){
							continue;
						}else{
							int[] res = {X,Y};
							return res;
						}
					}
				}else{
					X = posX+1;
					Y = posY-1;
					int[] res = {X,Y};
					return res;
				}
				nums[maxIndex] = ud;
			}
			a--;
		}
		//如果四个方向都行不通，则调用随机方法，以后可以改进
		return computerDo();

	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//四个方向中有一个方向满足条件，就返回true
		if (upToDown(posX, posY, ico) == WIN_COUNT
				|| leftToRight(posX, posY, ico) == WIN_COUNT
				|| leftDownToRightUp(posX, posY, ico) == WIN_COUNT
				|| leftUpToRightDown(posX, posY, ico) == WIN_COUNT) {
			return true;
		}

		return false;
	}
	//左右方向
	public int leftToRight(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		// 由于算了本身，所以count从-1开始
		int count = -1;
		for (int i = 0; posY - i >= 0; i++) {
			if (board[posX][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; posY + i <= Chessboard.BOARD_SIZE; i++) {
			if (board[posX][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//上下方向
	public int upToDown(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; posX - i >= 0; i++) {
			if (board[posX - i][posY].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; posX + i <= Chessboard.BOARD_SIZE; i++) {
			if (board[posX + i][posY].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//左上到右下
	public int leftUpToRightDown(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; (posX - i >= 0) && (posY - i >= 0); i++) {
			if (board[posX - i][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; (posX + i <= Chessboard.BOARD_SIZE)
				&& (posY + i <= Chessboard.BOARD_SIZE); i++) {
			if (board[posX + i][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}
	//左下到右上
	public int leftDownToRightUp(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		int count = -1;
		for (int i = 0; (posY - i >= 0) && (posX + i <= Chessboard.BOARD_SIZE); i++) {
			if (board[posX + i][posY - i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		for (int i = 0; (posY + i <= Chessboard.BOARD_SIZE) && (posX - i >= 0); i++) {
			if (board[posX - i][posY + i].equals(ico)) {
				count++;
				continue;
			} else {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
