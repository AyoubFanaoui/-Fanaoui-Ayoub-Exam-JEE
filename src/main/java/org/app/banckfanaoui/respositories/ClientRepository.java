package org.app.banckfanaoui.respositories;


import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.entites.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c JOIN c.credits cr WHERE cr.id = :creditId")
    List<Client> findByCreditId(@Param("creditId") Long creditId);

}

