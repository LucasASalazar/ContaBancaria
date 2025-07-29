import java.util.Scanner;

public class TesteConta {
    public static void main(String[] args){
      
      Scanner sc = new Scanner(System.in);
      Conta conta = new Conta();
      conta.limite = 5000;
      char contaEspecial;

      System.out.println("Insira o número da conta: ");
      conta.numero = sc.nextInt();

      System.out.println("Insira o saldo da conta: ");
      conta.saldo = sc.nextDouble();

     do{ 
      System.out.println("Conta especial? (S/N)");
      contaEspecial = sc.next().toUpperCase().charAt(0);

      switch(contaEspecial){
        case 'S' : conta.especial = true; break;
        case 'N' : conta.especial = false; break;
        default : System.out.println("Opção inválida. Digite apenas 'S' ou 'N' "); break;
      }
   } while (contaEspecial != 'S' && contaEspecial != 'N');
     
   conta.exibirInfo();
      sc.close();

    }
}