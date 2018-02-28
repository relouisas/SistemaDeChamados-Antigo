package Sistema.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Sistema.daos.ConnectionFactory;
import Sistema.models.Usuario;


public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Usuario usuario) {

		String sql = "insert into contatos (nome, email, endereco, dataNascimento) " + "values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getDepartamento());

			// stmt.setDate(4, new
			// java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean alterar(Usuario usuario) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getDepartamento());
			stmt.setLong(4, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean remover(Usuario usuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	public Usuario getById(Long id) {
		Usuario result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				result = new Usuario();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEmail(rs.getString("email"));
				result.setEndereco(rs.getString("Departamento"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}



