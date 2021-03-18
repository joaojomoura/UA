public class Contacto {
  private String nome;
  private String telefone;
  private String email;

  public Contacto (String name, String phone) {
    nome = name;
    telefone = phone;
  }

  public Contacto (String name, String phone, String mail) {
    nome = name;
    telefone = phone;
    email = mail;
  }

  public String eMail () {
    return email;
  }

  public String nome () {
    return nome;
  }

  public String telefone () {
    return telefone;
  }
}
