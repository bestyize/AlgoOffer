package thewind.note;

public class Test {
    @org.junit.Test
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        }).start();
    }
}
