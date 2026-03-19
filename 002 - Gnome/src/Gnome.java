
/**
 *
 * @author Trecho de código 1.3	A classe Gnome.
 */
public class Gnome {

    // Variáveis de instância:
    public String name;
    public int age;
    public Gnome gnomeBuddy;
    private boolean magical = false;
    protected double height = 2.6;
    public static final int MAX_HEIGHT = 3; // Altura maxima
    // [final] Constante - [static] Altera um, todos sao alterados

    // Atributos de Instancia:
    Gnome(String name, int age, Gnome buddy, double height) {
        this.name = name;
        this.age = age;
        this.gnomeBuddy = buddy;
        this.height = height;
    }

    // Construtor default
    Gnome() {
        name = "Name";
        age = 00;
        gnomeBuddy = null;
        height = 00;
    }

    // Métodos: 
    public static void makeKing(Gnome h) {
        h.name = "King" + h.getRealName();
        h.magical = true; // Apenas a classe Gnome pode referenciar este campo.
    }

    public void makeMeKing() {
        name = "King" + getRealName();
        magical = true;
    }

    public boolean isMagical() {
        return magical;
    }

    public void setHeight(int newHeight) {
        height = newHeight;
    }

    public String getName() {
        return "I won’t tell!";
    }

    public String getRealName() {
        return name;
    }

    public void renameGnome(String s) {
        name = s;
    }
    
    public void MostrarInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GnomeBuddy: " + gnomeBuddy);
        System.out.println("Height: " + height);

    }
}
