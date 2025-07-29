import java.util.Scanner;

public class Conta {

    Scanner sc = new Scanner(System.in);

    int numero;
    double saldo;
    boolean especial;
    double limite;
    double chequeEspecial = 500;
    
    char resposta;
    double deposito;
    double saque;
   
    void exibirInfo(){
         int acao;
    do {
        System.out.println("\n===========");
        System.out.println("Bem vindo!");
        System.out.println("Número da conta: " + numero);
        System.out.println();
        System.out.println("Qual ação deseja realizar? ");
        System.out.println("(1) Consultar Saldo");
        System.out.println("(2) Realizar Saque");
        System.out.println("(3) Depositar");
        System.out.println("(0) sair");
        System.out.print("Opção: ");
        acao = sc.nextInt();

        switch(acao){
            case 1 : consultarSaldo(); break;
            case 2 : realizarSaque(); break;
            case 3 : depositarDinheiro(); break;
            case 0 : System.out.println("Encerrando..."); break;
            default : System.out.println("Opção inválida.");
        }
     } while (acao != 0);
    }
    
    void realizarSaque(){
        
         System.out.println("Quanto deseja sacar? ");
            saque = sc.nextDouble();

        if(saldo <= 0 && especial == false){
            System.out.println("Impossivel sacar, não há saldo suficiente.");
        }
        else if(saldo <= 0 && especial == true){
           do{
            System.out.println("Saldo insuficiente. Deseja usar o cheque especial no valor de: R$" + chequeEspecial + "?");
            System.out.println("Deseja usar? (S/N) ");

            resposta = sc.next().toUpperCase().charAt(0);

            switch(resposta){
              case 'S' : 
               System.out.println("Saque autorizado com cheque especial");
               System.out.println("R$" + chequeEspecial + " disponíveis para saque.");
               saque = sc.nextDouble();
               
               if(saque > chequeEspecial){
                System.out.println("Erro, saque maior do que o limite especial.");
               } else {
                  System.out.println("Saque realizado!");
                  chequeEspecial -= saque;
               }
               break;

               case 'N' :
               System.out.println("Operação não realizada");
               break;

               default : System.out.println("Operação inválida. Insira somente 'S' ou 'N'.");
            }
        } while (resposta != 'S' && resposta != 'N');
        }
        else if (saque > limite || saque > saldo) {
            System.out.println("Saque não autorizado: saldo e limite insuficientes.");
        }
        else {
            System.out.println("Saque realizado!");
            System.out.println("Você sacou: " + saque);
            saldo -= saque;
        }
    }

    void depositarDinheiro(){

        System.out.println("Quanto deseja depositar? ");
        deposito = sc.nextDouble();
        saldo += deposito;
        System.out.println("Depósito realizado. Saldo atual: " + saldo);
    }

    void consultarSaldo(){
        System.out.println("Saldo atual: " + saldo);
        if(especial){
            System.out.println("Limite de cheque especial restante: R$" + chequeEspecial);
        }
    }

}