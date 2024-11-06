package luces;

public class LuciernagaT extends Thread{
	
	private String nombre;
    private boolean encendido;
    private int energia;
    private static int milis = 1000;

    public LuciernagaT(String nombre, int energia) {
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
		LuciernagaT l1 = new LuciernagaT("Lucit1", 10);
		LuciernagaT l2 = new LuciernagaT("Lucit2", 12);
		LuciernagaT l3 = new LuciernagaT("Lucit3", 15);
		
		l1.start();
		l2.start();
		l3.start();
	}

}
