package SistemaCadastroPecas;

public class Peca {

 String nome;
 String marca;
 String compativel;
 double preco;
 int quantidade;

 public Peca(String nome, String marca, String compativel, double preco, int quantidade) {
  this.nome = nome;
  this.marca = marca;
  this.compativel = compativel;
  this.preco = preco;
  this.quantidade = quantidade; 
 }
 public static boolean validarNome(String nome) {
  return nome.length() >=2;

 }
 public static boolean validarMarca(String marca) {
  return marca.length() >=2;
 }
 public static boolean validarCompativel(String compativel) {
  return compativel.length() >=2;
 }
 public static boolean validarPreco(double preco) {
  return preco >=0;
 }
 public static boolean validarQuantidade(int quantidade) {
  return quantidade >=0;
 }

 public void exibir(int numero) {
  System.out.println("---- Peca #" + numero + " ----");
        System.out.println("Nome.........: " + nome);
        System.out.println("Marca........: " + marca);
        System.out.println("Compativel...: " + compativel);
        System.out.printf( "Preco........: R$ %.2f%n", preco);
        System.out.println("Estoque......: " + quantidade + " unidade(s)");
        System.out.println();
 }
}
