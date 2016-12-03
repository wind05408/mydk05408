package vm;

/**
 * Created by dk05408 on 2016-12-03.
 */
public class GCDemo1 {
    public static GCDemo1 gcDemo1;

    public static void main(String[] args)throws InterruptedException {
        gcDemo1 = new GCDemo1();
        gcDemo1 = null;//可复活
        System.gc();
        Thread.sleep(1000);
        if(gcDemo1 == null){
            System.out.println("obj is null");
        }else{
            System.out.println("obj 可用");
        }

        gcDemo1 = null;//不可复活
        System.gc();
        Thread.sleep(1000);
        if(gcDemo1 == null){
            System.out.println("obj is null");
        }else{
            System.out.println("obj 可用");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize called");
        gcDemo1 = this;
    }
}
