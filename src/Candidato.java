import java.util.List;
public class Candidato extends Ciudadano {

        private Partido_p partido_politico;
        private List<String> promesas;
        private String inclinacion;
        public Candidato(String nombre, String cedula, C_origen c_origen, Partido_p partido_politico,
                List<String> promesas,String inclinacion) {
            super(nombre, cedula, c_origen);
            this.partido_politico = partido_politico;
            this.promesas = promesas;
            this.inclinacion = inclinacion;
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
}
