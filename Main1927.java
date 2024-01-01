import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1927 {
    
    private static class Heap{
        private List<Integer> heap;
        
        public Heap() {
            heap=new ArrayList<>();
            heap.add(0);
        }
        
        public void push(int x){
            heap.add(x);
            int index=heap.size()-1;
            while (index>1&&heap.get(index/2)>heap.get(index)){//부모보다 자식이 큰 경우
                //부모값과ㅏ 자식값을 스왑
                Integer parent = heap.get(index / 2);
                heap.set(index/2,x);
                heap.set(index,parent);
                //새로 들어온 값이 자리를 찾을때 까지 반복
                index/=2;
            }
        }
        
        private int pop(){
            if (heap.size()==1)
                return 0;
            
            Integer popElement = heap.get(1);//root에 있는 값이 가장 작다
            
            heap.set(1, heap.get(heap.size()-1));//맨뒤에 있는놈을 root로 올려버림
            heap.remove(heap.size()-1);
            
            int index=1;
            
            while (index*2<heap.size()){
                int minIndex = index * 2;
                int min=heap.get(minIndex);//왼쪽 자식이 더 작은경우
                if(index*2+1< heap.size()&&min> heap.get(index*2+1)){//오른쪽 자식이 더 작은 경우
                    min=heap.get(index*2+1);
                    minIndex=index*2+1;
                }
                
                if(min>heap.get(index))//현재값이 최솟값보다 작은 경우
                    break;
                swap(index,minIndex);
                
                index=minIndex;
            }
            return popElement;
        }
        
        private void swap(int index1, int index2) {
            int temp= heap.get(index1);
            heap.set(index1,heap.get(index2));
            heap.set(index2,temp);
        }
    }
    private static Heap heap=new Heap();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x>0){
                heap.push(x);
            }else if (x==0){
                int pop = heap.pop();
                System.out.println(pop);
            }
        }
    }
}
