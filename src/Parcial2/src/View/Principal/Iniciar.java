package View.Principal;

import Domain.*;
import Domain.Service.CursoService;
import View.Funcionario.Cadastrar.CadastrarCurso;
import View.Funcionario.Cadastrar.CadastrarDisciplinaEmCurso;
import View.Funcionario.Cadastrar.GestaoTurma_1;
import View.Funcionario.Listar.ListarCurso;
import View.Funcionario.Listar.ListarDisciplinasByCurso;
import java.util.ArrayList;

public class Iniciar extends javax.swing.JFrame {
    private ArrayList<Curso> cursos;
    
    public Iniciar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        verCursos = new javax.swing.JMenuItem();
        CadastrarCursos = new javax.swing.JMenuItem();
        disciplinasPorCurso = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        gestaoDisciplinas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(198, 223, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Sistema Acadêmico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(406, Short.MAX_VALUE))
        );

        jMenu1.setText("Viewers");

        jMenu3.setText("Funcionário");

        jMenu4.setText("Cursos");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        verCursos.setText("Ver Cursos");
        verCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosActionPerformed(evt);
            }
        });
        jMenu4.add(verCursos);

        CadastrarCursos.setText("Cadastrar Cursos");
        CadastrarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarCursosActionPerformed(evt);
            }
        });
        jMenu4.add(CadastrarCursos);

        disciplinasPorCurso.setText("Disciplinas por Curso");
        disciplinasPorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinasPorCursoActionPerformed(evt);
            }
        });
        jMenu4.add(disciplinasPorCurso);

        jMenu3.add(jMenu4);

        jMenu5.setText("Disciplinas");

        gestaoDisciplinas.setText("Gestão de Disciplinas");
        gestaoDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestaoDisciplinasActionPerformed(evt);
            }
        });
        jMenu5.add(gestaoDisciplinas);

        jMenu3.add(jMenu5);

        jMenu6.setText("Turmas");

        jMenuItem1.setText("Gestão de Turmas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenu3.add(jMenu6);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarCursosActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new CadastrarCurso());
    }//GEN-LAST:event_CadastrarCursosActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void verCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new ListarCurso(CursoService.getAll()));
    }//GEN-LAST:event_verCursosActionPerformed

    private void disciplinasPorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinasPorCursoActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new ListarDisciplinasByCurso());
    }//GEN-LAST:event_disciplinasPorCursoActionPerformed

    private void gestaoDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestaoDisciplinasActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new CadastrarDisciplinaEmCurso());
    }//GEN-LAST:event_gestaoDisciplinasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new GestaoTurma_1());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void addCursos(ArrayList<Curso> cursos) {
        if (! cursos.isEmpty()) {
            cursos.addAll(cursos);
        }
    }
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Iniciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastrarCursos;
    private javax.swing.JMenuItem disciplinasPorCurso;
    private javax.swing.JMenuItem gestaoDisciplinas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem verCursos;
    // End of variables declaration//GEN-END:variables
}
