package Domain.DAO;

import Domain.Aluno;
import static Domain.DAO.Banco.resultSet;
import Domain.Disciplina;
import Domain.Professor;
import Domain.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guilh
 */
public abstract class DisciplinaDAO extends Banco {
    
    public static Disciplina findById(int idDisciplina) {
        final String sql = "select d.id, d.nome d.idProfessor fom Disciplina d "+
                           "where d.id = " + idDisciplina;
        
        resultSet = exec(sql);
        try {
            while(resultSet.next()) {
                int id = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                String sql2 = "select p.id, p. nome, p.dataNascimento, p.endereco, p.cpf "
                            + "from DisciplinaProfessor df join Professor p on p.id=df.idProfessor  "
                            + "where df.idDisciplina = " + resultSet.getString(1);
                ResultSet resultSetP = exec(sql);
                int idP = Integer.parseInt(resultSetP.getString(1).toString());
                String nomeP = resultSetP.getString(2).toString();
                Date dataP = new Date(resultSetP.getObject(3).toString());
                String enderecoP = resultSetP.getObject(4).toString();
                String cpf = resultSetP.getObject(5).toString();
                Professor professor =  new Professor(id, nomeP, dataP, enderecoP, cpf);
                return new Disciplina(id, nome, professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Turma> findAllTurmaByDisciplina(int idDisciplina) {
        final String sql = "select t.id, t.idDisciplina from Turma t join DisciplinaTurma dt on t.id = dt.idTurma "
                         + "where t.id = " + idDisciplina;
        Disciplina disciplina = findById(idDisciplina);
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        resultSet = exec(sql);
        
        while (resultSet.next()) {
            try {
                int idTurma = Integer.parseInt(resultSet.getObject(1).toString());
                final String sql2 =  "select ";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static boolean addTurma() {
        return false;
    }
    
    public static boolean remTurma() {
        
    }
}
