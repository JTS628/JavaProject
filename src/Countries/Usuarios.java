
package Countries;


public class Usuarios {
    
    private String name;
    private String lastname;
    private String usuario;
    private String pass;

    public Usuarios() {
    }

    public Usuarios(String name, String lastname, String usuario, String pass) {
        this.name = name;
        this.lastname = lastname;
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
