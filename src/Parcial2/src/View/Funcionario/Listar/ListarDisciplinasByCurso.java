package View.Funcionario.Listar;

import Domain.Curso;
import Domain.Disciplina;
import Domain.Service.CursoService;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class ListarDisciplinasByCurso extends javax.swing.JPanel {

    public ListarDisciplinasByCurso() {
        initComponents();
        cursosList.removeAll();
        
        ArrayList<Curso> cursos = CursoService.getAll();
        
        cursosList.removeAll();
        String[] ele = new String[cursos.size()];
        for (int a = 0; a < ele.length; a++) {
            ele[a] = cursos.get(a).getNome();
        }
        cursosList.setModel(new AbstractListModel<String>() {
            String[] strings =  ele ;
            public int getSize() { return cursos.size(); }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        
        disciplinasList.setModel(new DefaultTableModel(Disciplina.NOME_COLUNA, 0));
        
        cursosList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int id = cursosList.getSelectedIndex();
                Curso curso = cursos.get(id);
                
                ArrayList<Disciplina> disciplinas = CursoService.getDisciplinas(curso);
                
                Object[][] data = getData(disciplinas);
                
                disciplinasList.setModel(new DefaultTableModel(data, Disciplina.NOME_COLUNA));
            }
        });
        
    }
    
    private Object[][] getData(ArrayList<Disciplina> disciplinas) {
        Object[][] rowData = new Object[disciplinas.size()][Disciplina.NOME_COLUNA.length];
        
        if (disciplinas.size() == 0) {
            rowData[0][0] = "vazio";
            rowData[0][1] = "vazio";
            return rowData;
        }
        int row = 0;
        for (Disciplina a : disciplinas) {
            rowData[row][0] = a.getId();
            rowData[row][1] = a.getNome();
            row = 0;
        }
        return rowData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        disciplinasList = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        cursosList = new javax.swing.JList<>();

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

        cursosList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cursosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        cursosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(cursosList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> cursosList;
    private javax.swing.JTable disciplinasList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
