package org.app.banckfanaoui;

import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.entites.Credit;
import org.app.banckfanaoui.entites.CreditPersonnel;
import org.app.banckfanaoui.entites.Remboursement;
import org.app.banckfanaoui.enums.StatutCredit;
import org.app.banckfanaoui.enums.TypeRemboursement;
import org.app.banckfanaoui.respositories.ClientRepository;
import org.app.banckfanaoui.respositories.CreditRepository;
import org.app.banckfanaoui.respositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BanckFanaouiApplication  implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;

    public BanckFanaouiApplication(ClientRepository clientRepository,
                                   CreditRepository creditRepository,
                                   RemboursementRepository remboursementRepository) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.remboursementRepository = remboursementRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BanckFanaouiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Créer un client
        Client client = new Client();
        client.setNom("Fanaoui");
        client.setEmail("fanaoui@example.com");
        client = clientRepository.save(client);

        // Créer un crédit
        Credit credit = new CreditPersonnel();
        credit.setClient(client);
        credit.setDateDemande(LocalDate.now().minusDays(5));
        credit.setMontant(100000.0);
        credit.setTauxInteret(5.5);
        credit.setDureeRemboursement(36);
        credit.setStatut(StatutCredit.EN_COURS);
        ((CreditPersonnel) credit).setMotif("Achat voiture");  // propriété spécifique au crédit personnel
        credit = creditRepository.save(credit);

        // Créer un remboursement
        Remboursement r1 = new Remboursement();
        r1.setCredit(credit);
        r1.setDate(LocalDate.now());
        r1.setMontant(2800.0);
        r1.setType(TypeRemboursement.MENSUALITE);
        remboursementRepository.save(r1);

        System.out.println("Données de test insérées avec succès !");
    }
}

