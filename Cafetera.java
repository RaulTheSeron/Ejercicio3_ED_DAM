package ed_trimestral_3ev;

/**
 * Esta clase representa una cafetera. Consta de dos propiedades: 
 * capacidadMaxima, que representa la cantidad máxima de café que puede almacenar la cafetera. 
 * cantidadActual, que representa la cantidad actual de café que se encuentra en la
 * cafetera.
 * @author raul
 * @version 24/05/2021
 */
public class Cafetera implements InterfaceCafetera {

    private int capacidadMaxima;
    private int cantidadActual;

    /**
     * Constructor parametrizado 1: cuenta con parametros para modificar todas
     * las propiedades de clase.
     *
     * @param capacidadMaxima entero que representa la cantidad máxima de café
     * que puede contener la cafetera.
     * @param cantidadActual entero que representea la cantidad actual de café
     * que contiene la cafetera
     */
    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.cantidadActual = cantidadActual;
        this.capacidadMaxima = Math.max(capacidadMaxima, cantidadActual);
    }

    /**
     * Contructor parametrizado 2: modifica la capacidad maxima de la cafetera,
     * estableciendo por defecto la cantidad actual a 1 (llamando al contructor
     * parametrizado 1)
     *
     * @param capacidadMaxima entero que representa la cantidad máxima de cafe
     * que puede contener la cafetera.
     */
    public Cafetera(int capacidadMaxima) {
        this(capacidadMaxima, 0);
    }

    /**
     * Contructor por defecto: establece la cantidad máxima de la cafetera a
     * 1000 y la cantidad actual a 0.
     */
    public Cafetera() {
        this(1000, 0);
    }

    /**
     * Metodo simula el llenado de la cafetera, estableciendo su capacidad
     * actual igual a su capacidad máxima.
     */
    @Override
    public void llenarCafetera() {
        setCantidadActual(getCapacidadMaxima());
    }

    /**
     * Metodo que simula la extraccion de una taza de café de la cafetra. Si realizar
     * esta operacion da como resultado que la cantidad actual es menor que 0, esta
     * se establecerá a 0.
     * @param tamanoTaza entero que representa la cantidad de café que se ha
     * extraido de la cafetera.
     * @throws Exception : se lanza cuando se intenta extraer café de la
     * cafetera y esta está vacía, es decir, su cantidad actual es 0.
     */
    @Override
    public void servirTaza(int tamanoTaza) throws Exception {
        setCantidadActual(getCantidadActual() - tamanoTaza);
        if (getCantidadActual() < 0) {
            setCantidadActual(0);
            throw new Exception("No hay café.");
        }
    }

    /**
     * Metodo que simula el vaciado de la cafetera. Establece su cantidad actual
     * a 0.
     */
    @Override
    public void vaciarCafetera() {
        setCantidadActual(0);
    }

    /**
     * Metodo que simula el incremento de la cantidad de cafe de la cafetera. Si
     * dicha cantidad hace que la cantidad actual supere la cantidad máxima, se
     * establecerá que la cantidad actual es igual a la cantidad máxima.
     * @param cantidad entero que representa la cantidad de café que se ha
     * añadido a la cafetera.
     * @throws Exception : se lanza cuando se intenta añadir café y esto produce 
     * que la cantidad actual supere la cantidad máxima permitida.
     */
    @Override
    public void agregarCafe(int cantidad) throws Exception {
        setCantidadActual(getCantidadActual() + cantidad);
        if (getCantidadActual() > getCapacidadMaxima()) {
            setCantidadActual(getCapacidadMaxima());
            throw new Exception("Rebosa");
        }

    }

    //Getters y setters de los campos encapsulados.
    /**
     * Metodo para obtener capacidad máxima del objeto cafetera.
     * @return capacidadMaxima : entero que representa la cantidad máxima de café
     * que puede almacenar la cafetera.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Metodo para establecer la capidad máxima del objeto cafetera.
     * @param capacidadMaxima entero que representa la capacidad máxima que tiene
     * la cafetera.
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Metodo para obtener la cantidad actual de cafe que hay en el objeto cafetera.
     * @return cantidadActual entero que representa la cantidad actual de cafe que 
     * hay en la cafetera.
     */
    public int getCantidadActual() {
        return cantidadActual;
    }

    /**
     * Metodo para establecer al cantidad actual de cafe que hay en el objeto cafetera.
     * @param cantidadActual entero que representa la cantidad actual de cafe que 
     * hay en la cafetera.
     */
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}
