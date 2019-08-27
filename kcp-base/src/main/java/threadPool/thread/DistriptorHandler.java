package threadPool.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import threadPool.task.ITask;

public class DistriptorHandler
{

	protected static final Logger logger = LoggerFactory.getLogger(DistriptorHandler.class);
	private ITask task;



	public void execute()
	{
		long start = System.currentTimeMillis();
		try {
			this.task.execute();

			long now = System.currentTimeMillis();
			Statistics statistics = Statistics.threadLocal.get();
			if(now-start>2){
				System.out.println(Thread.currentThread().getName()+" "+task.getClass().getSimpleName()+"  "+(now-start));
				System.out.println(statistics);
			}
			statistics.clear();
			//得主动释放内存
			this.task = null;
		} catch (Throwable throwable) {
			logger.error("error",throwable);
		}
	}


	public void setTask(ITask task) {
		this.task = task;
	}
}
