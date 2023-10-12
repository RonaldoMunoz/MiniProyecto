
import java.util.ArrayList;
import java.util.List;

public class Candidato extends Ciudadano {

    private Partido_p partido_politico;
    private ArrayList<String> promesas;
    private Inclinacion inclinacion;
    private int n_votos;
    public int length;

    public Candidato(String nombre, String cedula, C_origen c_origen, Partido_p partido_politico,
            ArrayList<String> promesas, Inclinacion inclinacion, int n_votos) {
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

    public void setPromesas(ArrayList<String> promesas) {
        this.promesas = promesas;
    }

    public Inclinacion getInclinacion() {
        return inclinacion;
    }

    public void setInclinacion(Inclinacion inclinacion) {
        this.inclinacion = inclinacion;
    }

    public int getN_votos() {
        return n_votos;
    }

    public void setN_votos(int n_votos) {
        this.n_votos = n_votos;
    }

    @Override
    // Se sobre-escribe el método toString() por defecto de la clase
    public String toString() {
        return "Nombre" + getNombre() + "Identificacion:" + getCedula() + getC_origen().displayNameEnum() +
                "Partido Politico:" + getPartido_politico().displayNameEnum() + "Promesas:" +
                getPromesas() + "Inclinación Politica :" + getInclinacion() + getN_votos() + "\n";
    }

    public void listarDatos() {
        System.out.println(String.format(
                "Nombre: %s\nIdentificacion: %s\nCiudad de origen: %s\nPartido Politico: %s\nPromesas: %s\nInclinación Politica: %s\n",
                getNombre(),
                getCedula(),
                getC_origen().displayNameEnum(),
                getPartido_politico().displayNameEnum(),
                getPromesas(),
                getInclinacion()));
    }
    public void listarDatosVotos(){
                System.out.println(String.format(
                "Nombre: %s\nIdentificacion: %s\nCiudad de origen: %s\nPartido Politico: %s\nPromesas: %s\nInclinación Politica: %s\nTotal de Votos: %s",
                getNombre(),
                getCedula(),
                getC_origen().displayNameEnum(),
                getPartido_politico().displayNameEnum(),
                getPromesas(),
                getInclinacion(),
                getN_votos()));

                

    }

}
