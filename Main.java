/*
    MIRIAM GONZÁLEZ PÉREZ
 */

public class Main {
    public static void main(String[] args) {

        new MainWindow();
        new VentanaContenedor();

        Contenedores c1 = new Contenedores(2, 30, 1, "Italia", "Madera", "Fedex", "Tipsa", true);
        Contenedores c2 = new Contenedores(7, 50, 2, "Francia", "Azúcar", "MRW", "Fedex", true);
        Contenedores c3 = new Contenedores(5, 80, 3, "España", "Metal", "Tipsa", "Correos", true);

        Hub h1 = new Hub();
        Puerto p1 = new Puerto();

        h1.apilarContenedor(c1);
        h1.apilarContenedor(c2);
        h1.apilarContenedor(c3);

        p1.insertaEnHub(c1);
        p1.insertaEnHub(c2);
        p1.insertaEnHub(c3);


    }
}
