package application;

import dao.UserPessoa;
import dml.Action;
import dml.Message;

import java.sql.SQLException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) throws SQLException {
        Action use = new Action();
        Message msg = new Message();
        Scanner scan = new Scanner(System.in);

        msg.initial();
        int opcao = scan.nextInt();

        switch (opcao){
            case 1:
                use.loginComparison();
                break;

            case 2:
                use.alterPass();
                break;

            case 3:
                use.createUser();
                break;

            case 4:
                break;
        }
    }
}
