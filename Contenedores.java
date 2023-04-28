import java.util.Arrays;

public class Contenedores {
    private  int id;
    private int pesoC;
    private int prioridad;
    private String pais;
    private String empresaEnvia;
    private String empresaRecibe;
    private String contenido;
    private boolean inspeccionado;

    //G/S

    public Contenedores(int id, int pesoC, int prioridad, String pais, String contenido, String empresaEnvia, String empresaRecibe, boolean inspeccionado){
        this(id);
        this.setPesoC(pesoC);
        this.setPrioridad(prioridad);
        this.setPais(pais);
        this.setContenido(contenido);
        this.setEmpresaEnvia(empresaEnvia);
        this.setEmpresaRecibe(empresaRecibe);
        this.setInspeccionado(inspeccionado);
    }
    public int getId() {
        return id;
    }

    public void setId(){this.id = id;}
    public int getPesoC() {
        return pesoC;
    }

    public void setPesoC(int pesoC) {
        if(pesoC >0) this.pesoC = pesoC;
        else pesoC = 1;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad<=3) this.prioridad = prioridad;
    }


    public boolean isInspeccionado() {
        return inspeccionado;
    }

    public void setInspeccionado(boolean inspeccionado) {
        this.inspeccionado = inspeccionado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        if (contenido.length() > 100) {
            contenido = contenido.substring(0, 100);
        }

        this.contenido = contenido;
    }

    public String getEmpresaEnvia() {
        return empresaEnvia;
    }

    public void setEmpresaEnvia(String empresaEnvia) {
        if (empresaEnvia.length() > 20) {
            empresaEnvia = empresaEnvia.substring(0, 20);
        }

        this.empresaEnvia = empresaEnvia;
    }

    public String getEmpresaRecibe() {
        return empresaRecibe;
    }

    public void setEmpresaRecibe(String empresaRecibe) {
        if (empresaRecibe.length() > 20) {
            empresaRecibe = empresaRecibe.substring(0, 20);
        }

        this.empresaRecibe = empresaRecibe;
    }

    //constructores

    public Contenedores(int id){ //
        if(id<0) id=-id;
        this.id=id;
        this.prioridad=3;
    }

}












