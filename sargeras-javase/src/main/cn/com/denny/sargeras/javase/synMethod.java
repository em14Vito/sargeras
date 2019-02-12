package cn.com.denny.sargeras.javase;

public class synMethod {
    private int c = 0;

    public synchronized void increment(data a) {
        (a.i)++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }


    public static void main(String[] args) {
        synMethod aa = new synMethod();
        data test = new data(100);
        new Thread(()->aa.increment(test)).start();
        test.setI(test.getI()+122);
        System.out.println(test.getI());
    }


    private static class data{
        Integer i;
        data(Integer i){
            this.i = i;
        }

        public Integer getI(){
            return i;
        }

        public void setI(Integer i){
            this.i = i;
        }
    }
}