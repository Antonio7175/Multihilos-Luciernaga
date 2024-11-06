package luces;

public class LuciernagaR implements Runnable{
	
	 private String nombre;
	    private boolean encendido;
	    private int energia;
	    private static int milis = 1000;

	    public LuciernagaR(String nombre, int energia) {
	        if (energia < 1 || energia > 50) {
	            throw new IllegalArgumentException("La energía debe estar entre 1 y 50.");
	        }
	        this.nombre = nombre;
	        this.energia = energia;
	        this.encendido = false;
	    }

	    @Override
	    public void run() {
	        enciende();
	    }

	    public void enciende() {
	        if (!encendido && energia > 0) {
	            encendido = true;
	            while (energia > 0) {
	                System.out.println(nombre + " tiene " + energia + " unidades de energía.");
	                energia--;
	                try {
	                    Thread.sleep(milis);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	            encendido = false;
	            System.out.println(nombre + " se ha apagado.");
	        }
	    }
	    
	    public static void main(String[] args) {
	    
	    LuciernagaR l1 = new LuciernagaR("LuciR1", 5);
	    LuciernagaR l2 = new LuciernagaR("LuciR2", 5);
	    LuciernagaR l3 = new LuciernagaR("LuciR3", 60);
	    
	    l1.run();
	    l2.run();
	    l3.run();
	    
	    }
	    

}
