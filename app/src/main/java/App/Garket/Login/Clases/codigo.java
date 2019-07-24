package App.Garket.Login.Clases;

public  class codigo {

    private String clave;
    private int id;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "codigo{" +
                "clave='" + clave + '\'' +
                ", id=" + id +
                '}';
    }
}
