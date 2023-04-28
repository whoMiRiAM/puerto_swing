/*
    MIRIAM GONZÁLEZ PÉREZ
 */

public class Hub {
    private Contenedores[][] c;
    private static int nContenedor = 1;  //asignaremos este ID a cada contenedor antes de apila

    public Hub(){
        this.c=new Contenedores[10][12];
    }

    public void setContenedor(Contenedores[][] c){
        if(c!=null) this.c=c;
    }
    public Contenedores[][] getHub(){
        return c;
    }
    public static int getNContenedor(){return Hub.nContenedor;}


    public String toString() {

        StringBuffer s = new StringBuffer(); //Utilizaremos un StringBuffer para comodidad. Para agregar al final de la cadena
        //Así podremos saber más facil si está Ocupado o Libre.

        for (int i = 0; i < this.c.length; i++) {
            for (int j = 0; j < this.c[i].length; j++) {
                if (this.c[i][j] != null) {
                    s.append("   O   ");

                } else {
                    s.append("   L   ");

                }

            }

            s.append("\n");
        }

        return s.toString();
    }

    /*
    Buscamos con un id pasado el contenedor deseado.
    */
    public String mostrarDatos(int id) {
        Contenedores encontrado = null;

        for (int i = 0; i < this.c.length; i++) {
            for (int j = 0; j < this.c[0].length; j++) {
                if (this.c[i][j].getId() == id) {
                    encontrado = c[i][j];
                }
            }
        }

        if (encontrado != null) {
            return encontrado.toString();
        } else {
            return "El contenedor deseado no se encuentra en el almacén";
        }

    }


    public boolean apilarContenedor(Contenedores contenedor) {
        if (contenedor != null) {
            contenedor.setId();
            Hub.nContenedor++;

            switch (contenedor.getPrioridad()) {
                case 1:    //no se hará nada.
                case 2:
                    int columna = contenedor.getPrioridad() - 1;

                    for (int i = this.c.length - 1; i >= 0; i--) {
                        if (this.c[i][columna] == null) {
                            this.c[i][columna] = contenedor;
                            return true;
                        }
                    }

                    break;

                case 3:
                    for (int j = 2; j < this.c[0].length; j++) {
                        for (int i = this.c.length - 1; i >= 0; i--) {
                            if (this.c[i][j] == null) {
                                this.c[i][j] = contenedor;
                                return true;
                            }
                        }
                    }

                    break;
            }
        }

        return false;
    }

	/*
	Desapilamos el primer contenedor y
	en nada que lo encontremos lo igualaremos a null (se borrará)
	*/

    public boolean desapilarContenedor(int columna) {
        boolean desapilado = false; //estará por defecto en que no hemos desapilado

        if (columna >= 0 && columna < this.c[0].length) {
            for (int i = 0; i < this.c.length && !desapilado; i++) {
                if (this.c[i][columna] != null) {
                    this.c[i][columna] = null; //limpiaremos
                    desapilado = true;
                }
            }
        }

        return desapilado;
    }

    public int contenedorPorPais(String pais) {
        int q = 0;

        for (int i = 0; i < this.c.length; i++) {
            for (int j = 0; j < this.c[i].length; j++) {
                if (this.c[i][j] != null && pais.equals(this.c[i][j].getPais())) {
                    q++;
                }
            }
        }
        return q;

    }

    /////////////////////////////////////////////////////////
    public float pesoTotal(int peso){

        float sumaPeso = 0;

        for (int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                sumaPeso += c[i][j].getPesoC();
            }
        }
        return sumaPeso;
    }

}





