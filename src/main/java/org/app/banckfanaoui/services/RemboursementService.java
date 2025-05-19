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

    public RemboursementService(RemboursementRepository remboursementRepository, CreditRepository creditRepository) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
    }

    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementRepository.findAll()
                .stream()
                .map(RemboursementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        return RemboursementMapper.toDTO(remboursement);
    }

    public RemboursementDTO saveRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = RemboursementMapper.toEntity(dto);

        if (dto.getCreditId() != null) {
            Credit credit = creditRepository.findById(dto.getCreditId())
                    .orElseThrow(() -> new RuntimeException("Credit not found"));
            remboursement.setCredit(credit);
        }

        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return RemboursementMapper.toDTO(savedRemboursement);
    }

    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}

