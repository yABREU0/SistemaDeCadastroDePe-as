package SistemaCadastroPecas;

public class Estoque {

 Peca[] pecas = new Peca[100];
 int total = 0;

 public void adicionar(Peca peca) {
  if (total == pecas.length) {
   System.out.println("Estoque cheio! Nao e possivel cadastrar mais pecas.");
   return;
  }

  pecas[total] = peca;
  total++;
  System.out.println("Peca cadastrada com sucesso!");
 }

 public void listar() {
  if (total == 0) {
   System.out.println("Nenhuma peca cadastrada ainda. ");
   return;
  }
  System.out.println("Total: " + total + "peca(s)");
  System.out.println();

  for (int i = 0; i < total; i++) {
   pecas[i].exibir(i + 1);
   
  }
 }

 public void buscar(String termoBusca) {
  boolean encontrou = false;

  for (int i = 0; i < total; i++) {

   if(pecas[i].nome.toLowerCase().contains(termoBusca.toLowerCase())) {
    if (!encontrou){
     System.out.println("Resultado(s) encontrado(s): ");
     System.out.println();
    }
    
    encontrou = true;
    pecas[i].exibir(i + 1);
   }
   
  }
  if(!encontrou) {
   System.out.println("Nnhuma peca encontrada com o nome\"" + termoBusca + "\".");

  }
 }
 public void remover(int numero) {
  int indice = numero - 1;
  System.out.println("Peca removida: " + pecas[indice].nome);

  for (int i = 0; i < total - 1; i++) {
   pecas[i] = pecas[i + 1];
   
  }
  pecas[total - 1] = null;
  total--;
  System.out.println("Peca removida com sucesso!");
 }

 public boolean estaVazio(){
  return total == 0;
 }

 public boolean numeroValido(int numero){
  return numero >= 1 && numero <= total;
 }

 
}
