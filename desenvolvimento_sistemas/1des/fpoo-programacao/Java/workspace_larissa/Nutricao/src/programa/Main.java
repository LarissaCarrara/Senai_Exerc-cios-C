package programa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		float totImc = 0, totPeso = 0, totAlt= 0, menorpeso, maiorpeso= 0 , max = 1, min = 1000, maxAlt=0.1f, minAlt= 3;
		int cont = 0, cont2 = 0, cont3 = 0, cont4 = 0;
		int diags[] = {0,0,0,0,0,0};
		Scanner scan = new Scanner(System.in);
		
		Paciente pacientes[] = new Paciente[10];
		
		
				
		for(int i=0; i<2; i++) {
			pacientes[i] = new Paciente();
			
			System.out.printf("\nDigite o %dº nome: ", i+1);
			pacientes[i].nome = scan.next();
			
			System.out.printf("\nDigite a altura: ");
			pacientes[i].altura = scan.nextFloat();
			
			System.out.printf("\nDigite o peso: ");
			pacientes[i].peso = scan.nextFloat();
			
			totImc += pacientes[i].imc();
			totPeso += pacientes[i].peso;
			totAlt += pacientes[i].altura;
			
		}
		for(int i=0; i<2; i++) {
			if(pacientes[i].peso < min) {
				
				min = pacientes[i].peso;
				cont = i;
			}
			
			if(pacientes[i].peso > max) {
				
				max = pacientes[i].peso;
				cont2 = i;
			}
			
			if(pacientes[i].altura < minAlt) {
				
				minAlt = pacientes[i].altura;
				cont3 = i;
			}
			
			if(pacientes[i].altura > maxAlt) {
				
				maxAlt = pacientes[i].altura;
				cont4 = i;
			}
			
			if(pacientes[i].diagnostico().equals("Subpeso Severo")) {
				diags[0]++;
			}
			
			if(pacientes[i].diagnostico().equals("Subpeso")) {
				diags[1]++;
			}
			
			if(pacientes[i].diagnostico().equals("Normal")) {
				diags[2]++;
			}
			
			if(pacientes[i].diagnostico().equals("Sobrepeso")) {
				diags[3]++;
			}
			if(pacientes[i].diagnostico().equals("Obeso")) {
				diags[4]++;
			}
			if(pacientes[i].diagnostico().equals("Obeso mórbido")) {
				diags[5]++;
			}
		}
		
		
		//processamento
		float mediaImc = totImc / 10f;
		float mediaPeso = totPeso / 10f;
		float mediaAltura = totAlt / 10f;
		
		System.out.printf("\nPaciente\tAltura\tPeso\tIMC\tDiagnostico");
		
		for (int i=0; i<2; i++) {
			
			System.out.printf("\n%s\t\t%.2f\t%.2f\t%.2f\t%s", pacientes[i].nome, pacientes[i].altura, pacientes[i].peso, pacientes[i].imc(), pacientes[i].diagnostico());
		}
		
		System.out.printf("\n\n\nMédia IMC\tMédia Altura\tMédia Peso\tPac.magro\tPac.obeso \tPac.alto\tPac.baixo ");
		System.out.printf("\n%.2f\t%.2f\t%.2f\t%s\t\t%s\t%s\t\t%s", mediaImc, mediaPeso, mediaAltura, pacientes[cont].nome, pacientes[cont2].nome, pacientes[cont4].nome,pacientes[cont3].nome);
	
	
		System.out.printf("\n\n\n\tSubpeso Severo\t %d", diags[0]);
		System.out.printf("\n\tSubpeso\t\t %d", diags[1]);
		System.out.printf("\n\tNormal\t\t %d", diags[2]);
		System.out.printf("\n\tSobrepeso\t %d", diags[3]);
		System.out.printf("\n\tObeso\t\t %d", diags[4]);
		System.out.printf("\n\tObeso Mórbido\t %d", diags[5]);
	
	}

		
}
