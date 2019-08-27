package threadPool.thread;

/**
 * Created by JinMiao
 * 2019/8/27.
 */
public class Statistics {

    public static ThreadLocal<Statistics> threadLocal = ThreadLocal.withInitial(Statistics::new);

    public int recieve;

    public int send;

    public int schedule;

    public int notifyWriteEvent;

    public int notifySchedule;


    @Override
    public String toString() {
        return "Statistics{" +
                "recieve=" + recieve +
                ", send=" + send +
                ", schedule=" + schedule +
                ", notifyWriteEvent=" + notifyWriteEvent +
                ", notifySchedule=" + notifySchedule +
                '}';
    }

    public void clear(){
        this.recieve=0;
        this.send=0;
        this.schedule=0;
        this.notifySchedule=0;
        this.notifyWriteEvent=0;
    }
}
