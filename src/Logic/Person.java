package Logic;

/**
 * @author Nicolas Santiago Caceres
 * clase person
 */
public class Person {

    /**
     *
     * atributo nombre
     */
    private String name;
    /**
     *
     * atributo cedula
     */

    private String cedula;
    /**
     *
     * atributo direccion
     */
    private String direccion;
    /**
     *
     * atributo telefono
     */
    private String telefono;

    /**
     *
     * constructor de la clase person
     */
    public Person(String name, String cedula, String direccion, String telefono) {
        this.name = name;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    /**
     *
     * metodo getnombre
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     *
     * metodo set nombre
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * metodo getcedula
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }
    /**
     *
     * metodo set setcedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     *
     * metodo getdireccion
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     *
     * metodo setdireccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     *
     * metodo gettelefono
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     *
     * metodo set telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
