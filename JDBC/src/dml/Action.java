package dml;

import dao.UserPessoa;
import server.Link;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Action {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rsP = null;
    Statement stP = null;
    UserPessoa use = new UserPessoa();


    public void createUser() throws SQLException {
        boolean x = true;
        Scanner scan = new Scanner(System.in);

        while (x){
            System.out.print("\nDigite seu nome: ");
            String nome = scan.nextLine();


            System.out.print("Digite seu CPF: ");
            String cpf = scan.next();

            System.out.print("Digite seu e-mail: ");
            String email = scan.next();

            System.out.print("Digite seu senha: ");
            String senha = scan.next();

            System.out.print("Digite seu telefone: ");
            String telefone = scan.next();

            while (true) {
                System.out.print("\nOs dados inseridos estão corretos? 1) Sim 2) Não \n" +
                                    "Digite: ");
                int opcao = scan.nextInt();
                scan.nextLine();

                if (opcao == 1) {
                    use.setNome(nome);
                    use.setCpf(cpf);
                    use.setEmail(email);
                    use.setSenha(senha);
                    use.setTelefone(telefone);

                    x = false;
                    break;
                } else if (opcao == 2) {
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }

        try {
            conn = Link.getConnection();

            // Protegendo o código
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("insert into tbl_pessoa (nomePessoa, cpfPessoa, emailPessoa, senhaPessoa, telefonePessoa ) values (?, ?, ?, ?, ?)");

            ps.setString(1, use.getNome());
            ps.setString(2, use.getCpf());
            ps.setString(3, use.getEmail());
            ps.setString(4, use.getSenha());
            ps.setString(5, use.getTelefone());

            ps.executeUpdate();

            // Se tudo der certo, altera os dados no SQL
            conn.commit();
            System.out.println("Usuário criado com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro no envio de dados. Erro: " + e.getMessage());
            try {

                // Caso de errado, volta ao estado anterior. (Backup)
                conn.rollback();
                System.out.println("Transaction rolled back! Cased by: " + e.getMessage());
            } catch (SQLException e1) {
                System.out.println("Rollback not realized. Error: " + e1.getMessage());
            }

        } finally {
            ps.close();
            conn.close();

        }
    }



    public void loginComparison() throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu e-mail: ");
        String email = scan.next();

        System.out.print("Digite a senha: ");
        String senha = scan.next();

        try {
            conn = Link.getConnection();
            stP = conn.createStatement();

            rsP = stP.executeQuery("select * from tbl_pessoa");

            boolean x = false;
            while (rsP.next()) {

                if (Objects.equals(email, rsP.getString("emailPessoa")) && Objects.equals(senha, rsP.getString("senhaPessoa"))) {
                    x = true;
                }
            }

            if (x == true) {
                System.out.println("Access approved!");
            } else {
                System.out.println("Access denied!");
            }

        } finally {
            rsP.close();
            stP.close();
            conn.close();
        }
    }

    public void alterPass() throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o e-mail: ");
        String email = scan.next();

        System.out.print("Digite a nova senha: ");
        String senha = scan.next();

        try {
            conn = Link.getConnection();
            stP = conn.createStatement();

            rsP = stP.executeQuery("select * from tbl_pessoa");

            boolean x = false;
            boolean y = false;
            while (rsP.next()) {
                if (Objects.equals(email, rsP.getString("emailPessoa"))) {
                    x = true;
                }
            }

            if (!x && !y) {
                System.out.println("E-mail inexistente na base de dados.");

            } else if (x == true) {
                conn.setAutoCommit(false);

                ps = conn.prepareStatement("update tbl_pessoa set senhaPessoa = ? where (emailPessoa = ?)");

                ps.setString(1, senha);
                ps.setString(2, email);

                ps.executeUpdate();

                conn.commit();

                System.out.println("Senha alterarda com sucesso!");

            } else if (y == true) {
                conn.setAutoCommit(false);

                ps = conn.prepareStatement("update tbl_pessoa_jurica set senhaJuridico = ? where (emailJuridico = ?)");

                ps.setString(1, senha);
                ps.setString(2, email);

                ps.executeUpdate();

                conn.commit();

                System.out.println("Senha alterarda com sucesso!");
            }

        } catch(SQLException e){
            System.out.println("Erro no envio de dados. Erro: " + e.getMessage());
            try {

                // Caso de errado, volta ao estado anterior. (Backup)
                conn.rollback();
                System.out.println("Transaction rolled back! Cased by: " + e.getMessage());
            } catch (SQLException e1) {
                System.out.println("Rollback not realized. Error: " + e1.getMessage());


            }
        } finally{
            rsP.close();
            stP.close();
            ps.close();
            conn.close();
        }
    }
}