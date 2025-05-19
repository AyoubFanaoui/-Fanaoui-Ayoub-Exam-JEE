package org.app.banckfanaoui.services;


import org.app.banckfanaoui.dtos.RemboursementDTO;
import org.app.banckfanaoui.entites.Credit;
import org.app.banckfanaoui.entites.Remboursement;
import org.app.banckfanaoui.mappers.RemboursementMapper;

import org.app.banckfanaoui.respositories.CreditRepository;
import org.app.banckfanaoui.respositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemboursementService {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    public RemboursementService(RemboursementRepository remboursementRepository, CreditRepository creditRepository, RemboursementMapper remboursementMapper) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }

    public RemboursementDTO createRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = remboursementMapper.toEntity(dto);

        // gestion liaison credit
        Credit credit = creditRepository.findById(dto.getCreditId())
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
        remboursement.setCredit(credit);

        remboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.toDto(remboursement);
    }

    public RemboursementDTO getRemboursement(Long id) {
        return remboursementRepository.findById(id)
                .map(remboursementMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Remboursement non trouvé"));
    }

    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(remboursementMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }


}

