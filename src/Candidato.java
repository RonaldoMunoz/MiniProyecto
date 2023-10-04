import java.util.List;

public class Candidato extends Ciudadano {

    private Partido_p partido_politico;
    private List<String> promesas;
    private String inclinacion;
    private int n_votos;

    public Candidato(String nombre, String cedula, C_origen c_origen, Partido_p partido_politico,
            List<String> promesas, String inclinacion, int n_votos) {
        super(nombre, cedula, c_origen);
        this.partido_politico = partido_politico;
        this.promesas = promesas;
        this.inclinacion = inclinacion;
        this.n_votos = n_votos;
    }

    public Partido_p getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(Partido_p partido_politico) {
        this.partido_politico = partido_politico;
    }

    public List<String> getPromesas() {
        return promesas;
    }

    public void setPromesas(List<String> promesas) {
        this.promesas = promesas;
    }

    public String getInclinacion() {
        return inclinacion;
    }

    public void setInclinacion(String inclinacion) {
        this.inclinacion = inclinacion;
    }

    public int getN_votos() {
        return n_votos;
    }

    public void setN_votos(int n_votos) {
        this.n_votos = n_votos;
    }
    @Override
    //Se sobre-escribe el método toString() por defecto de la clase
    public String toString()
    {  
      return "Nombre"+ getNombre() + "Identificacion:" + getCedula() +
       "Partido Politico:" + getPartido_politico() +"Promesas:" +
       getPromesas() + "Inclinación Politica :"+ getInclinacion()+"\n";
     }  
    
    public void listarDatos(){
        System.out.println("Nombre"+ getNombre() + "Identificacion:" + getCedula() + "Partido Politico:" + getPartido_politico() +"Promesas:" + getPromesas() + "Inclinación Politica :"+ getInclinacion()+"\n");

    }

}
