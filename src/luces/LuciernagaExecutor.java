package luces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuciernagaExecutor {
	
	public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.execute(new LuciernagaR("Luciérnaga 1", 5));
        executor.execute(new LuciernagaR("Luciérnaga 2", 7));
        executor.execute(new LuciernagaR("Luciérnaga 3", 10));

        executor.shutdown();
    }

}
