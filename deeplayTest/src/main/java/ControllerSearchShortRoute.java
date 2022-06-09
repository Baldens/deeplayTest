public class ControllerSearchShortRoute {
    /**
     * Данный класс я представляю как контроллер, здесь выполняется правило игры т.е найти
     * крайчайший путь из верхнего левого угла в нижний правый угол.
     * Вариант решения оказался таким, что есть x и y, далее нахожу вариант ответа путем перегрузки метода.
     * И когда нахрдится ответ, то записывается в приватную переменную bestSum.
     * Если надо достать результат работы метода operationLogicGame(), то используется геттер getBestSum()
     * */

    private Integer bestSum;
    private boolean isFirstOrNo = true;

    public ControllerSearchShortRoute(int[][] arrayField){
        if(arrayField.length == 4 && (arrayField[arrayField.length-1].length == 4)){
            operationLogicGame(1,0,0,arrayField);
        }else{
            throw new IllegalArgumentException("Error length array");
        }
    }

    private void operationLogicGame(int x, int y, Integer sum, int[][] arrayField) {
        if (isFirstOrNo) {
            bestSum = -1;
            isFirstOrNo = false;
        }

        if (x == 3 && y == 3) {
            if (bestSum < 0 || sum <= bestSum) {
                bestSum = sum + arrayField[x][y];
                isFirstOrNo = true;
            }
        } else if (sum < bestSum || bestSum != 0) {
            if (x < 3) {
                operationLogicGame(x + 1, y, sum + arrayField[x + 1][y], arrayField);
            }
            if (y < 3) {
                operationLogicGame(x, y + 1, sum + arrayField[x][y + 1], arrayField);
            }
        }
    }

    public Integer getBestSum() {
        return bestSum;
    }
}
