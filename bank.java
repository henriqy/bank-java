import java.util.scanner;
 class Agencia {
	
	int numero;
	String agencia;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	
}
 class Banco {
	
	Agencia[] listarAgencias = new Agencia[10];
	String nome;
	int control = 0;
	
	
	public void criarAgencia(int numero, String nome) {
		listarAgencias[control] = new Agencia();
		listarAgencias[control].setNumero(numero);
		listarAgencias[control].setAgencia(nome);
		control++;
	}
	
	public void removerAgencia(int numero, String nome) {
		 for (int i = 0 ; i < this.listarAgencias.length ; i++){
	            if (numero == this.listarAgencias[i].getNumero()){
	                this.listarAgencias[i] = null;
	                System.out.println("Operacao Concluida");
	                control += 1;
	                break;
	            }

	        }
		 for (int i = 0, j = 0 ; i < this.listarAgencias.length ; i++){
	            if (this.listarAgencias[i] != null){
	                this.listarAgencias[j] = this.listarAgencias[i];
	                j++;
	            }
	        }
		 for (int i = 1 ; i < this.listarAgencias.length ; i++){
	            if (this.listarAgencias[i] == this.listarAgencias[i - 1]){
	                this.listarAgencias[i] = null;
	            }
	        }

	        this.control--;
	}
	
	public void listarAgencia() {
		 System.out.println("----AGENCIAS----");
	        for (int i = 0 ; i < this.listarAgencias.length ; i++){
	            if(this.listarAgencias[i] != null){
	                System.out.printf("%d. %s - %d\n", i+1, this.listarAgencias[i].getAgencia(), this.listarAgencias[i].getNumero());
	            }
	        }
		}
	 public void setNome(String nome){
	        this.nome = nome;
	    }
	    public String getNome(){
	        return this.nome;
	    }
}


class InvalidoOp extends Exception{
    private int h;
    InvalidoOp(int h){
        this.h = h;
    }

    public String toString(){
        return "Opcao invalida";
    }

}
public class Tbanco{
    static void compute (int h) throws InvalidoOp {
        if ((h < 0) || (h > 5)){
            throw new InvalidoOp(h);     
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Banco d1 = new Banco();
        d1.setNome("Icomp");
        System.out.println("Bem vindo ao sistema de gerenciamento do Banco " + d1.getNome());
        while(true){
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("1. Criar agencia");
            System.out.println("2. Remover agencia");
            System.out.println("3. Listar agencia");
            System.out.println("4. Selecionar agencia");
            System.out.println("5. Sair");
        
            int opcaoDeMenu = 0;
            
            try{ 
					
                opcaoDeMenu = scan.nextInt();
                compute(opcaoDeMenu);
            }catch(InvalidoOp e){
					
                System.out.println(e);
            }catch(Exception e) {
					
                System.out.println("Insira um valor valido");
                scan.next();
            }
            if (opcaoDeMenu == 5){
					
                System.out.println("Volte Sempre :)");
                break;
            }
            switch(opcaoDeMenu){
            case 1:
                try{
                
                    System.out.println("Digite o nome da agencia");
                    String nome = scan.next();
						 
                    System.out.println("Digite o numero da agencia");
						 
                    int numero = scan.nextInt();
						 
                    d1.criarAgencia(numero, nome);
						 
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Capacidade maxima alcancada");
                }                  
                break;
              
            case 2:
						
                System.out.println("Digite o numero da agencia");
                d1.removerAgencia(scan.nextInt(), null);
                break;
              
            case 3:
						
                d1.listarAgencia();
                break;
              
            case 4:
						
                continue;
            }

        }
    scan.close();
   }

        
}

