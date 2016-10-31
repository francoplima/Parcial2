package View.Funcionario.Listar;

import Domain.Curso;
import Domain.Disciplina;
import Domain.Service.CursoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class ListarDisciplinasByCurso extends javax.swing.JPanel {

    public ListarDisciplinasByCurso() {
        initComponents();
        cursosList.removeAll();
        
        ArrayList<Curso> cursos = CursoService.getAll();
        for (Curso a : cursos) {
            cursosList.addItem(a.getNome());
        }
        
        cursosList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = e.getID();
                Curso curso = CursoService.findCursoById(id);
                if (curso != null){
                    ArrayList<Disciplina> disciplinas = CursoService.getDisciplinas(curso);
                    
                }
            }
        });
    }
    
    private Object[][] getData(ArrayList<Disciplina> disciplinas) {
        Object[][] rowData = new Object[disciplinas.size()][Disciplina.NOME_COLUNA.length];
        
        if (disciplinas.size() == 0) {
            rowData[0][0] = "vazio";
            rowData[0][1] = "vazio";
            rowData[0][2] = "vazio";
            return rowData;
        }
        int row = 0;
        for (Disciplina a : disciplinas) {
            rowData[row][0] = a.getId();
            rowData[row][1] = a.getNome();
            rowData[row][2] = a.getProfessor().getNome();
            row = 0;
        }
        return rowData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursosList = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        disciplinasList = new javax.swing.JTable();

        cursosList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cursosList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosListActionPerformed(evt);
            }
        });

        disciplinasList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        disciplinasList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(disciplinasList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cursosList, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cursosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cursosListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursosListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cursosList;
    private javax.swing.JTable disciplinasList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
