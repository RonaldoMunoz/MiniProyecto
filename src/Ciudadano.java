public class Ciudadano {
    private String nombre, cedula;
    private C_origen c_origen;

    public Ciudadano(String nombre, String cedula, C_origen c_origen) {
        
        this.nombre = nombre;
        this.cedula = cedula;
        this.c_origen = c_origen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public C_origen getC_origen() {
        return c_origen;
    }

    public void setC_origen(C_origen c_origen) {
        this.c_origen = c_origen;
    }

    
}
