package App.Garket.Login.Clases;

public  class solicitud {

    private String imagen;
    private String codigodetc;
    private String descripcion;
    private String fecha_fin;
    private String hora_fin;
    private String fecha_inicio;
    private String hora_inicio;
    private Almacen almacen;
    private int id;

    public String getCodigodetc() {
        return codigodetc;
    }

    public void setCodigodetc(String codigodetc) {
        this.codigodetc = codigodetc;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Almacen {
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
    }
}
