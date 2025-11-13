package mvc.model.entity;


public class Empleado {

    private String nombre;
    private String dni;
    private char sexo;
    private int categoria;
    private int anyos;

    /**
     * Constructor vacío (default).
     */
    public Empleado() {

    }

    /**
     * Constructor con todos los campos.
     *
     * @param nombre    Nombre del empleado.
     * @param dni       DNI del empleado (clave primaria).
     * @param sexo      Sexo (H/M).
     * @param categoria Categoría profesional.
     * @param anyos     Años de antigüedad.
     */
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.categoria = categoria;
        this.anyos = anyos;
    }

    /**
     * Obtiene el nombre del empleado.
     * @return el nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre el nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del empleado.
     * @return el DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del empleado.
     * @param dni el nuevo DNI del empleado.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el sexo del empleado.
     * @return el sexo (char) del empleado.
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del empleado.
     * @param sexo el nuevo sexo (char) del empleado.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene la categoría profesional del empleado.
     * @return la categoría (int) del empleado.
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría profesional del empleado.
     * @param categoria la nueva categoría (int) del empleado.
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene los años de antigüedad del empleado.
     * @return los años (int) de antigüedad.
     */
    public int getAnyos() {
        return anyos;
    }

    /**
     * Establece los años de antigüedad del empleado.
     * @param anyos los nuevos años (int) de antigüedad.
     */
    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    /**
     * Devuelve una representación en String del objeto, útil para depuración.
     * @return una cadena con los datos del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", categoria=" + categoria +
                ", anyos=" + anyos +
                '}';
    }
}