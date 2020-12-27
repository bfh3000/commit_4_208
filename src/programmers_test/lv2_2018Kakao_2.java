package programmers_test;

import java.util.ArrayList;

public class lv2_2018Kakao_2 {

	public static void main(String[] args) {
		int a = 4;
		int b = 5;
		String[] aa = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};  // 14  ���;� ��. a, b 4 5
		//String[] aa = new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}; // 15 ���;� ��. a b 6 6
		System.out.println(solution(a, b, aa));
		System.out.println(solution(a, b, aa));
	}
	//�ι�°
	  static char[][] map;
		static boolean[][] visited;
		static int a, b;
		static ArrayList<Character>[] line;
	  public static int solution(int m, int n, String[] board) {
	      		int answer = 0;
			a = m;
			b = n;
			map = new char[a][b];

			for (int i = 0; i < board.length; i++) {
				char[] ch = board[i].toCharArray();
				for (int j = 0; j < b; j++) {
					map[i][j] = ch[j];
				}
			}
			
			while(true) {
			
				visited = new boolean[a][b];
				line = new ArrayList[b];
				boolean flag = false;

				for (int i = 0; i < b; i++) {
					line[i] = new ArrayList<Character>();
				}

				// �������� 4��ϵ� ǥ���ϱ�.
				// ����
				
				for (int i = 0; i < a - 1; i++) {
					for (int j = 0; j < b - 1; j++) {
						if (map[i][j] == 0)
							continue;
						check(i, j);
					}
				}

				Outter: for (int i = 0; i < a; i++) {
					for (int j = 0; j < b; j++) {
						if (visited[i][j] == true) {
							flag = true;
							break Outter;
						}
					}
				}

				if (!flag) {
					break;
				}

				// �������� 4��ϵ� �����, �������� ���� �ؿ��� ���� �������� �� ������ line�� ����.
				for (int i = 0; i < b; i++) {
					for (int j = a - 1; j >= 0; j--) {
						if (visited[j][i] == false) {
							line[i].add(map[j][i]);
						} else {
							answer++;
						}
					}
				}

				map = new char[a][b];

				// ������ �迭���� �ٽ� char �迭�� ����.
				for (int i = 0; i < b; i++) {
					for (int j = a - 1; j >= 0; j--) {
						if (line[i].size() <= a - 1 - j)
							break;
						map[j][i] = line[i].get((a - 1) - j);
					}
				}
			}
			
			

			return answer;
	  }
	    public static void check(int x, int y) {
			if (isInside(x, y)) {
				if (map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1]) {
					visited[x][y] = true;
					visited[x + 1][y] = true;
					visited[x][y + 1] = true;
					visited[x + 1][y + 1] = true;
				}
			}
		}

		public static boolean isInside(int x, int y) {
			if (x >= 0 && y >= 0 && x < a && y < b)
				return true;
			else
				return false;
		}
}