/*
    MIRIAM GONZÁLEZ PÉREZ
 */

public class Puerto { //implements Serializable
    //////////////////////////////////////////////////////////////////////////////////
    private Hub[] hubs;


    /**
     * Aqui tendremos todos los metodos de Puerto
     */
    public Puerto() {
        this.hubs = new Hub[3];
        for (int i = 0; i < this.hubs.length; i++) {
            this.hubs[i] = new Hub();
        }
    }


    /**
     *
     */
    public Hub getHub(int n) {
        return this.hubs[n];
    }


    public int buscarPorPais(String pais) {
        int total = 0;

        for (int i = 0; i < this.hubs.length; i++) {
            total += this.hubs[i].contenedorPorPais(pais);
        }

        return total;
    }

    /**
     * Intentamos apilar el contenedor en el primer Hub que encuentre con espacio disponible.
     */
    public int insertaEnHub(Contenedores contenedor) {
        int nHub = -1;

        for (int i = 0; i < this.hubs.length && nHub == -1; i++) {
            if (this.hubs[i].apilarContenedor(contenedor)) {
                nHub = i;
            }
        }

        return nHub;
    }


    /**
     * Comprobaremos si el HUB está entre 1 o 3 si no devolveremos False.
     **/
     public boolean desapila(int columna, int hub) {
        if (hub >= 1 && hub <= 3) {
            return this.hubs[hub-1].desapilarContenedor(columna-1);
        }

        return false;
    }

    /////////////////////////////////////////////////////////////////

    public float peso(int nhub, int peso){
         return hubs[nhub].pesoTotal(peso);
    }


}

