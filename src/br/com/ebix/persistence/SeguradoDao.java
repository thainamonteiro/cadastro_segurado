package br.com.ebix.persistence;

import br.com.ebix.model.Segurado;

public class SeguradoDao extends Dao {

	public void create(Segurado s) throws Exception {
		open();

		stmt = con.prepareStatement("insert into segurado values (null, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, s.getNome());
		stmt.setString(2, s.getCpf());
		stmt.setString(3, s.getRg());
		stmt.setString(4, s.getSexo());
		StringBuffer buffer = new StringBuffer();
		for (String seguro : s.getSeguros()) {
			buffer.append(seguro);
			buffer.append(",");
		}
		stmt.setString(5, buffer.toString());
		stmt.setString(6, s.getCorrentista());
		StringBuffer buffer2 = new StringBuffer();
		for (String diasVisita : s.getDiasVisita()) {
			buffer2.append(diasVisita);
			buffer2.append(",");
		}
		stmt.setString(7, buffer2.toString());
		stmt.execute();

		close();
	}

//	public static void main(String[] args) throws Exception {
//		Segurado s = new Segurado("thaina", "1234569", "123456", "F", "ESTAMOS", "NAO", "todos");
//		SeguradoDao dao = new SeguradoDao();
//		dao.create(s);
//	}
}
