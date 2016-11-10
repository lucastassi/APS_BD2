/*
aulas
https://www.youtube.com/watch?v=O4BdT0q-740
https://www.youtube.com/watch?v=WJ3700ZIxBc
https://www.youtube.com/watch?v=K_1KTYZBt9c
https://www.youtube.com/watch?v=nVZHH0B4t4w
https://www.youtube.com/watch?v=dXr83K4nH94
https://www.youtube.com/watch?v=DjNLLozpmaA
https://www.youtube.com/watch?v=WJ3700ZIxBc
 */
package my.contacteditor.conexao;
import my.contacteditor.PrefeitoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import my.contacteditor.TelaPrefeitoCadastro;
import my.contacteditor.entradaInvalidaException;
/**
 *
 * @author  Lucas Tassi
 *          Lucas Diniz
 *          Lucas Barbosa
 *          Jhordan Garcia
 */
public class conexaoBD {
    Connection conexao;
    private Connection oConn;
    private Statement state;
    
    public conexaoBD(){
    }
    
    /*Realiza a conexão no BD*/
    public Connection conectarBD(){
        try{
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,"postgres","2402");
            System.out.println("Conexão efetuada com sucesso.");
            return conexao;    
        }
        catch(Exception ex){
            System.out.println("Erro ao conectar"+ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    /*Desconecta do BD*/
    public void desconBD(){
        try{
            conexao.close();
            System.out.println("Conexão finalizada com sucesso");
        }
        catch(Exception ex){
            System.out.println("Erro ao desconectar: "+ex.getMessage());
        }
    }
    
    /*Exclui o fornecedor do BD através do CNPJ*/
    public boolean excluirCandidato(String cpf) throws SQLException{
        conectarBD();
        state = conexao.createStatement();
        state.executeUpdate("delete from CANDIDATO where cand_cpf = '"+cpf+"'");
        desconBD(); 
        return true;
    }
    
    
    public void atualizarCandidato(PrefeitoDAO p) throws SQLException, entradaInvalidaException{
        conectarBD();
        state = conexao.createStatement();
 
            state.executeUpdate("update CANDIDATO set cand_nome = '"+p.getNomeReal()+"',"
                    + "cand_cpf = '"+p.getCpf()+"', cand_tit_ele = '"+p.getTituloEleitor()+"', cand_sexo = '"+Integer.parseInt(p.getSexo().substring(0,1))+"',"
                    + "cand_nasc = '"+p.getDataNasc()+"', cand_rg= '"+p.getRg()+"', cand_uf = '"+Integer.parseInt(p.getUfNasc().substring(0,2).trim())+"', cand_org_emissor = '"+Integer.parseInt(p.getOrgaoEmissor().substring(0,2).trim())+"', cand_tel1= '"+p.getTelefone1()+"', cand_tel2 = '"+p.getTelefone2()+"',"
                    + "cand_end_rua = '"+p.getRua()+"',cand_end_nro = '"+p.getNumeroRua()+"',cand_end_bairro = '"+p.getBairro()+"',"
                    + "cand_end_cep = '"+p.getCep()+"', cand_end_cidade = '"+p.getCidade()+"',cand_end_estado = '"+Integer.parseInt(p.getEstado().substring(0,2).trim())+"',"
                    + "cand_camp_nome = '"+p.getNomeFantasia()+"',cand_camp_nro = '"+p.getNumeroCampanha()+"',cand_vice_nome = '"+p.getNomeVice()+"',"
                    + "cand_vice_nro = '"+p.getNumeroCampanhaVice()+"',cand_partido = '"+Integer.parseInt(p.getPartido().substring(0,2).trim())+"'  where cand_cpf= '"+p.getCpf()+"';"); 
    
        desconBD();
    }
    
    //Para valores inteiros, pega-se as duas primeiras posições, retira os espaços (usando o .trim) e converte para inteiro
    public void insereDados(PrefeitoDAO p) throws SQLException, entradaInvalidaException{
        conectarBD();
        state = conexao.createStatement();
        
        state.executeUpdate("insert into CANDIDATO (cand_nome,cand_cpf,cand_tit_ele,cand_sexo,cand_nasc,cand_rg,cand_uf,cand_org_emissor,cand_tel1,cand_tel2,cand_end_rua,cand_end_nro,"
                + "         cand_end_bairro,cand_end_cep,cand_end_cidade,cand_end_estado,cand_camp_nome,cand_camp_nro,cand_vice_nome,cand_vice_nro,cand_partido)"
                    + "values ('"+p.getNomeReal()+"','"+p.getCpf()+"','"+p.getTituloEleitor()+"','"+Integer.parseInt(p.getSexo().substring(0,1))+"','"+p.getDataNasc()+"','"+p.getRg()+"','"+Integer.parseInt(p.getUfNasc().substring(0,2).trim())+"',"
                    + "'"+Integer.parseInt(p.getOrgaoEmissor().substring(0,2).trim())+"','"+p.getTelefone1()+"','"+p.getTelefone2()+"','"+p.getRua()+"','"+p.getNumeroRua()+"','"+p.getBairro()+"','"+p.getCep()+"',"
                + " '"+p.getCidade()+"','"+Integer.parseInt(p.getEstado().substring(0,2).trim())+"','"+p.getNomeFantasia()+"','"+p.getNumeroCampanha()+"','"+p.getNomeVice()+"','"+p.getNumeroCampanhaVice()+"','"+Integer.parseInt(p.getPartido().substring(0,2).trim())+"');");

        desconBD();
    }
 
    public PrefeitoDAO consultarCandidato(String cpf) throws SQLException{
        PrefeitoDAO f = new PrefeitoDAO();
        conectarBD();
        Statement state = conexao.createStatement();
        try(PreparedStatement p = conexao.prepareStatement("select * from CANDIDATO where cand_cpf = '"+cpf+"'")){
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                f.setCpf(rs.getString("cand_cpf"));
                f.setBairro(rs.getString("cand_end_bairro"));
                f.setCep(rs.getString("cand_end_cep"));
                f.setCidade(rs.getString("cand_end_cidade"));
                f.setDataNasc(rs.getString("cand_nasc"));
                f.setEstado(rs.getString("cand_end_estado"));
                f.setNomeFantasia(rs.getString("cand_camp_nome"));
                f.setNomeReal(rs.getString("cand_nome"));
                f.setNomeVice(rs.getString("cand_vice_nome"));
                f.setNumeroCampanha(rs.getInt("cand_camp_nro"));
                f.setNumeroCampanhaVice(rs.getInt("cand_vice_nro"));
                f.setNumeroRua(rs.getString("cand_end_nro"));
                f.setOrgaoEmissor(rs.getString("cand_org_emissor"));
                f.setPartido(rs.getString("cand_partido"));
                f.setRg(rs.getString("cand_rg"));
                f.setRua(rs.getString("cand_end_rua"));
                f.setSexo(rs.getString("cand_sexo"));
                f.setTelefone1(rs.getString("cand_tel1"));
                f.setTelefone2(rs.getString("cand_tel2"));
                f.setTituloEleitor(rs.getString("cand_tit_ele"));
                f.setUfNasc(rs.getString("cand_uf"));
            }
        }
        
       desconBD();          
       return f;
    }
    
    

   
public void popularComboBoxPartido(JComboBox j){
        
        try(PreparedStatement ps = conexao.prepareStatement("select * from partido")){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                j.addItem(""+rs.getString("part_id")+" "+rs.getString("part_sigla")+" - "+rs.getString("part_nome"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
                    
    }

public void popularComboBoxSexo(JComboBox j){


        try(PreparedStatement ps = conexao.prepareStatement("select * from sexo")){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                j.addItem(""+rs.getString("sex_id")+" "+rs.getString("sex_tipo"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
                    
    }

public void popularComboBoxEstado(JComboBox j){


        try(PreparedStatement ps = conexao.prepareStatement("select * from UF")){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                j.addItem(""+rs.getString("uf_id")+" "+rs.getString("uf_sigla")+"/"+rs.getString("uf_nome"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
                    
    }

public void popularComboBoxOrgaoEmissor(JComboBox j){

        try(PreparedStatement ps = conexao.prepareStatement("select * from orgao")){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                j.addItem(""+rs.getString("org_id")+"   "+rs.getString("org_sigla")+"/"+rs.getString("org_nome"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
                    
    }


public List<PrefeitoDAO> consultaTodos() throws SQLException{
        
    List<PrefeitoDAO> clis = new ArrayList<>();
        conectarBD();
        
        try (PreparedStatement pstm = conexao.prepareStatement("select cand_cpf, cand_camp_nome, cand_nome, cand_camp_nro, cand_partido, cand_vice_nome from CANDIDATO")) {
            ResultSet rs = pstm.executeQuery();
           
            while(rs.next()){              
                PrefeitoDAO cli = new PrefeitoDAO();
                
                cli.setCpf(rs.getString("cand_cpf"));
                cli.setNomeReal(rs.getString("cand_nome"));
                cli.setNomeFantasia(rs.getString("cand_camp_nome"));
                cli.setNumeroCampanha(rs.getInt("cand_camp_nro"));
                cli.setPartido(rs.getString("cand_partido"));
                cli.setNomeVice(rs.getString("cand_vice_nome"));
                
            clis.add(cli);
            }   
        }
        
       desconBD();
        
       return clis; 
        
    }

public List<PrefeitoDAO> consultaTodosPorCPF(String cpf) throws SQLException{
        
    List<PrefeitoDAO> clis = new ArrayList<>();
        conectarBD();
        
        try (PreparedStatement pstm = conexao.prepareStatement("select cand_cpf, cand_camp_nome, cand_nome, cand_camp_nro, cand_partido, cand_vice_nome from CANDIDATO where cand_cpf = '"+cpf+"' ")) {
            ResultSet rs = pstm.executeQuery();
           
            while(rs.next()){              
                PrefeitoDAO cli = new PrefeitoDAO();
                
                cli.setCpf(rs.getString("cand_cpf"));
                cli.setNomeReal(rs.getString("cand_nome"));
                cli.setNomeFantasia(rs.getString("cand_camp_nome"));
                cli.setNumeroCampanha(rs.getInt("cand_camp_nro"));
                cli.setPartido(rs.getString("cand_partido"));
                cli.setNomeVice(rs.getString("cand_vice_nome"));
                
            clis.add(cli);
            }   
        }
        
       desconBD();
        
       return clis; 
        
    }


}
