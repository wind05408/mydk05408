package vm;

import java.util.HashMap;

/**
 * Created by dk05408 on 2016-12-03.
 */
public class GCDemo2 {
    public static class PrintThread extends Thread{
        public static final long starttime=System.currentTimeMillis();
        @Override
        public void run(){
            try{
                while(true){
                    long t=System.currentTimeMillis()-starttime;
                    System.out.println("time:"+t);
                    Thread.sleep(100);
                }
            }catch(Exception e){

            }
        }
    }
    public static class MyThread extends Thread{
        HashMap<Long,byte[]> map=new HashMap<Long,byte[]>();
        @Override
        public void run(){
            try{
                while(true){
                    if(map.size()*512/1024/1024>=450){
                        System.out.println("=====准备清理=====:"+map.size());
                        map.clear();
                    }

                    for(int i=0;i<1024;i++){
                        map.put(System.nanoTime(), new byte[512]);
                    }
                    Thread.sleep(1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        new MyThread().start();
    }

}
