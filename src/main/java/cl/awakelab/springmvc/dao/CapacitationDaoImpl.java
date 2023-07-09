package cl.awakelab.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awakelab.springmvc.models.Capacitation;

public class CapacitationDaoImpl implements ICapacitationDao {

	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Capacitation> GetAllCapacitations() {
		String sql = "SELECT id, rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes FROM capacitaciones";
		return template.query(sql, new CapacitationRowMapper());
	}

	@Override
	public boolean createCapacitation(Capacitation capacitation) {
		System.out.println("Datos de la capacitación:");
		System.out.println("ID: " + capacitation.getId());
		System.out.println("Rut Cliente: " + capacitation.getRutCliente());
		System.out.println("Día: " + capacitation.getDia());
		System.out.println("Hora: " + capacitation.getHora());
		System.out.println("Lugar: " + capacitation.getLugar());
		System.out.println("Duración: " + capacitation.getDuracion());
		System.out.println("Cantidad de Asistentes: " + capacitation.getCantidadAsistentes());

		return true;
	}

	private static class CapacitationRowMapper implements RowMapper<Capacitation> {

		public Capacitation mapRow(ResultSet rs, int rowNum) throws SQLException {
			Capacitation capacitation = new Capacitation();
			capacitation.setId(rs.getInt("id"));
			capacitation.setRutCliente(rs.getString("rut_cliente"));
			capacitation.setDia(rs.getString("dia"));
			capacitation.setHora(rs.getString("hora"));
			capacitation.setLugar(rs.getString("lugar"));
			capacitation.setDuracion(rs.getInt("duracion"));
			capacitation.setCantidadAsistentes(rs.getInt("cantidad_asistentes"));
			return capacitation;
		}
	}
}
