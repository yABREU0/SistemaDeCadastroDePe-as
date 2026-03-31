package SistemaCadastroPecas;

import java.util.Scanner;

public class SistemaPecas {
 static Scanner scanner = new Scanner(System.in);
 static Estoque estoque = new Estoque();

 // --- MENU PRINCIPAL --- ///

 public static void main(String[] args) {
  System.out.println("=================");
  System.out.println("   SISTEMA DE CADASTRO DE PECAS    ");
  System.out.println("=================");
  
  
  int opcao = 0;

  while(opcao != 5) {
   System.out.println();
   System.out.println("---MENU---");
   System.out.println("1. Cadastrar peca");
   System.out.println("2. listar peca");
   System.out.println("3. Buscar peca");
   System.out.println("4. remover peca");
   System.out.println("5. Sair");
   System.out.println();
   System.out.println("Escolha uma opcao:  ");

   if(scanner.hasNextInt()) {
    opcao = scanner.nextInt();
    scanner.nextLine();

   }else{
    scanner.nextLine();
    System.out.println("Digite apenas um numero de 1 a 5!");

    continue;

   }

   System.out.println();

   if (opcao == 1) {
    cadastrar();
  }else if (opcao == 2 ){
   listar();
  }else if (opcao == 3 ){
   buscar();
  }else if (opcao == 4 ){
   remover();

  }else if (opcao == 5 ){
   System.out.println("Encerrando o sistema. Ate logo!");
   
  } else {
   System.out.println("Opcao Invalida! Digite um nuemro de 1 a 5.");
   }
 
 }
 scanner.close();

 
}

//-- Cadastro--- //

static void cadastrar(){
 System.out.println("===  CADASTRAR NOVA PECA ===");
 System.out.println();

 String nome = "";
 boolean valido = false;

 while(!valido) {
  System.out.println("Nome da peca: ");
  nome = scanner.nextLine();

  if (Peca.validarNome(nome)) {
   valido = true;

  } else {
   System.out.println("Nome invalido! Digite pelo menos 2 caracteres.");

  }
 }
// --- MARCA / MODELO DO CARRO ---//
 String marca = "";
 valido = false;

 while (!valido) {
  System.out.println("Marca / Fabricante: ");
  marca = scanner.nextLine();

  if(Peca.validarMarca(marca)) {
   valido = true;

  } else {
   System.out.println("Marca invalida! Digite pelo menos 2 caracteres.");

  }
  
 }
// --- COMPATIBILIDADE --- ///
 String compativel = "";
 valido = false;

 while (!valido) {
  System.out.println("Compativel com (modelo do carro):  ");
  compativel = scanner.nextLine();

  if(Peca.validarCompativel(compativel)) {
   valido = true;

  } else {
   System.out.println("Informe pelo menos o modelo do carro.");

  }

 }
 // ---- Preço ---- ///
 double preco = 0;
 valido = false;
 while (!valido) {
  System.out.println("Preco (R$): ");

  if (scanner.hasNextDouble()) {
   preco = scanner.nextDouble();
   scanner.nextLine();

   if (Peca.validarPreco(preco)) {
    valido = true;

   } else {
    System.out.println("O preco deve ser maior que zero!"); 

    }
   }else {
    scanner.nextLine();
    System.out.println("Preco invalido! Use numeros. Ex: 49.90");
   }
  }


// -- QUANTIDADE --- /// 


   int quantidade = 0;
   valido = false;

   while (!valido) {
    System.out.println("Quantidade em estoque: ");

    if (scanner.hasNextLine()) {
     quantidade = scanner.nextInt();
     scanner.nextLine();

     if (Peca.validarQuantidade(quantidade)) {
      valido = true;
     }else{
      System.out.println("A quantidade nao pode ser negatica!");
     }
    }else {
     scanner.nextLine();
     System.out.println("Quantida invalida! Digite um numero inteiro.");

    }
   }

   Peca novaPeca = new Peca(nome, marca, compativel, preco, quantidade);
   estoque.adicionar(novaPeca);

 }

 /// ---- LISTAR ----- ///


 static void listar(){
  System.out.println("=== PECAS CADASTRADAS ===");
  System.out.println();

// Delega a listagem para o objeto estoque
  estoque.listar();
 }

 /// ---- BUSCAR ---- ////


 static void buscar(){
  System.out.println("=== BUSCAR PECA ===");
  System.out.println();

  if (estoque.estaVazio()) {
   System.out.println("Nenhuma peca cadastrada ainda");

   return;
  }
  System.out.println("Digite o nome da peca parta buscar: ");
  String termo = scanner.nextLine();

  System.out.println();

  //Delega a busca para o objeto estoque 
  estoque.buscar(termo);
 }

 /// REMOVER ///


 static void remover(){
  System.out.println("=== REMOVER PECA ===");
  System.out.println();

  if (estoque.estaVazio()) {
   System.out.println("Nenhuma peca cadastrada ainda.");
   return;
  }
   // Mostra a lista para o usuario escolher qual remover 
   estoque.listar();
   int numero = 0;
   boolean valido = false;

   while (!valido){
    System.out.println("Digite o numero da peca que deseja remover: ");

    if (scanner.hasNextInt()) {
     numero = scanner.nextInt();
     scanner.nextLine();

     if (estoque.numeroValido(numero)) {
      valido = true;
     
     } else {
      System.out.println("Numero invalido! Digite entre 1 e " + estoque.total + ".");
     }
    } else {
      scanner.nextLine();
      System.out.println("Digite apenas um numero!");
     }

    }

    // confirmaçao antes de remover
    System.out.println("Confirma a remocao? (s/n): ");
    String confirmacao = scanner.nextLine();

    if (confirmacao.equalsIgnoreCase("s")) {
     estoque.remover(numero);

    } else {
     System.out.println("Remocao cancelada");
    }
      
  
 }
 }

