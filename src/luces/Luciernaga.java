package luces;

public class Luciernaga {
	
	private String nombre;
    private boolean encendido;
    private int energia;
    private static int milis = 1000; // Duración en milisegundos de una unidad de energía

    public Luciernaga(String nombre, int energia) {
        if (energia < 1 || energia > 50) {
            throw new IllegalArgumentException("La energía debe estar entre 1 y 50.");
        }
        this.nombre = nombre;
        this.energia = energia;
        this.encendido = false;
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
		Luciernaga l1 = new Luciernaga("Luci1", 10);
		Luciernaga l2 = new Luciernaga("Luci2", 20);
		Luciernaga l3 = new Luciernaga("Luci3", 30);
		
		l1.enciende();
		l2.enciende();
		l3.enciende();
		
	}

}
