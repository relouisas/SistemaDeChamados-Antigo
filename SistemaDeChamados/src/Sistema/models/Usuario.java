package Sistema.models;
import java.util.Calendar;

//import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	
	private Long id;
	private String nome;
	private String email;
	private String Departamento;
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	//private Calendar dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setEndereco(String departamento) {
		this.Departamento = departamento;
	}

}
