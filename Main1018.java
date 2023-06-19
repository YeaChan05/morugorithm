import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * package :  PACKAGE_NAME
 * fileName : Main1018
 * author :  ShinYeaChan
 * date : 2023-06-12
 */
public class Main1018 {
    static String evenString;
    static String oddString;
    static List<String> evenBoard;
    static List<String> oddBoard;
    static Integer M;
    static Integer N;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
       /*
           입력받은 체스판과 생성된 체스판 두종류를 비교
           비교해봤을때 작은값을 출력
         */
        createStaticBoard();
        List<String>inputBoard=inputBoard(N);
//        inputBoard.forEach(System.out::println);
        printSmaller(inputBoard);
    }
    
    private static void printSmaller(List<String> inputBoard) {
        int oddVal = compareBoard(inputBoard, oddBoard);
        int evenVal = compareBoard(inputBoard, evenBoard);
        System.out.println(Math.min(oddVal, evenVal));
    }
    
    private static int compareBoard(List<String> inputBoard, List<String> staticBoard) {
        int value=64;
        for(int i = 0 ; i < N - 7 ; i++) {
            for(int j = 0 ; j < M - 7 ; j++) {
                value = Math.min(value, cal(i, j, inputBoard));
            }
        }
        return value;
    }
    
    private static int cal(int x, int y, List<String> inputBoard) {
        int count = 0;
    
        char color = 'W';
    
        for(int i = x ; i < x + 8 ; i++) {
            for(int j = y ; j < y + 8 ; j++) {
                if(inputBoard.get(i).charAt(j)!=color) count++;
                if(color=='W') color = 'B';
                else color = 'W';
            }
            if(color=='W') color = 'B';
            else color = 'W';
        }
        count = Math.min(count, 64 - count);
    
        return count;
    }
    
    /**
     * 보드 입력받기
     */
    private static List<String> inputBoard(Integer n) {
        List<String>board=new ArrayList<>();
        for (int i = 0; i < n; i++)
            board.add(scanner.next());
        return board;
    }
    
    private static void createStaticBoard() {
        N= scanner.nextInt();
        M= scanner.nextInt();
        
        evenString=createEvenString();
        oddString=createOddString();
        
        evenBoard=createStaticBoard(evenString,oddString);
        oddBoard=createStaticBoard(oddString,evenString);
    }
    
    private static List<String> createStaticBoard(String str1, String str2) {
        List<String> board=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if(i%2==0)
                board.add(str1);
            else
                board.add(str2);
        }
        return board;
    }
    
    /**
     * 맨 윗쪽이 검은색으로 시작
     */
    private static String createEvenString() {
        StringBuilder str= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if(i%2==0)
                str.append("B");
            else
                str.append("W");
        }
        return String.valueOf(str);
    }
    private static String createOddString() {
        StringBuilder str= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if(i%2==0)
                str.append("W");
            else
                str.append("B");
        }
        return String.valueOf(str);
    }
}
