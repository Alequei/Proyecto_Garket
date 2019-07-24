package App.Garket.Login.Clases;

public  class almacen {

    private String partes;
    private String conjunto;
    private String clave_equipo;
    private String equipo;
    private String proceso;
    private String area;
    private String ubicacion;
    private int id;

    public String getPartes() {
        return partes;
    }

    public void setPartes(String partes) {
        this.partes = partes;
    }

    public String getConjunto() {
        return conjunto;
    }

    public void setConjunto(String conjunto) {
        this.conjunto = conjunto;
    }

    public String getClave_equipo() {
        return clave_equipo;
    }

    public void setClave_equipo(String clave_equipo) {
        this.clave_equipo = clave_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "almacen{" +
                "partes='" + partes + '\'' +
                ", conjunto='" + conjunto + '\'' +
                ", clave_equipo='" + clave_equipo + '\'' +
                ", equipo='" + equipo + '\'' +
                ", proceso='" + proceso + '\'' +
                ", area='" + area + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", id=" + id +
                '}';
    }
}
