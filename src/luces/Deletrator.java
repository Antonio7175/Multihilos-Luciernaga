package luces;

public class Deletrator implements Runnable {
    private String palabra;
    private static int milis = 1000;

    public Deletrator(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        int length = palabra.length();
        for (int i = 0; i < length; i++) {
            StringBuilder output = new StringBuilder("[" + "-".repeat(length) + "]");
            output.setCharAt(i + 1, palabra.charAt(i));
            System.out.println("Deletreando \"" + palabra + "\": " + output);
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Deletrator("hola"));
        t.start();
    }
}  


