package basic.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class CraneGameTest {

    /**
     * 2차원 배열 x Stack 을 이용한 인형뽑기 문제
     * 움직이는 위치에 따라 2차원 배열에 숫자를 뽑고 0 으로 만들어줌
     * 인형이 없을 경우 0 이기 때문에 보드의 수만 큼 for 문을 돌려줘야
     * 0 이 아니라면 Stack 에 넣어주는데
     * 만약, Stack 에 같은 숫자가 겹치면 값을 넣어주지 않고 Stack 맨위숫자를 빼줌
     * 같은 숫자가 겹치는 경우, count 증가
     * 반복문을 빠져나오고 moves 차례대로 진행
     * 최종 사라진 인형의 개수는 count * 2
     */

    @Test
    void draw() {
        int N = 5;
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int M = 8;
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        assertThat(executeCraneGame(N, board, moves)).isEqualTo(4);
    }

    private int executeCraneGame(int N, int[][] board, int[] moves) {
        Stack<Integer> dolls = new Stack<>();
        int count = 0;
        for (int move : moves) {
            for (int i = 0; i < N; i++) {
                int doll = board[i][move - 1];
                board[i][move - 1] = 0;
                if (doll != 0) {
                    count = getCountOfDisappearedDoll(dolls, count, doll);
                    break;
                }
            }
        }
        return count * 2;
    }

    private int getCountOfDisappearedDoll(Stack<Integer> dolls, int count, int doll) {
        if (!dolls.isEmpty() && doll == dolls.peek()) {
            dolls.pop();
            count++;
        } else {
            dolls.push(doll);
        }
        return count;
    }

}