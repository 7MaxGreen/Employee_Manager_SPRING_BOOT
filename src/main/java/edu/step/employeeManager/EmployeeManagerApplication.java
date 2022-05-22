package edu.step.employeeManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}
	// Daca noi cream clasele DTO pentru a securiza clasele model si DTO devine intermediarul intre Controller si Model prin DTOservice,
	// in acelasi timp, DTO e clasa cea mai importanta care gestioneaza flow-ul mai departe,
	// noi vom copia proprietatile private din clasa model in ea cu setteri si getteri,
	// DAR unele proprietati din model care nu le dorim sa fie vizibile pentru user-ul final le ascundem ( ex. salary),
	// de aici vine intrebarea - la ce etapa (ex. salariile) vor fi create/updated, daca lantul este Controller->DTO->DTOService->DAO->Repository,
	// si la initierea lantului noi apelam clasa DTO care nu are proprietatea (salariu), dar pe parcursul la flow-ul ista ea apeleaza
	// clasa DAO, in care oricum setam salariul; dc sa mai ascundem proprietatea din DTO initial, daca tot noi mai departe acordam acces ei?

	// ar fi din motivul ca anumele layere-le astea multiple ofera "securizare" si nu are access direct?
}
