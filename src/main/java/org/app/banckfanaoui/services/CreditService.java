package org.app.banckfanaoui.services;



import org.app.banckfanaoui.dtos.CreditDTO;
import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.entites.Credit;
import org.app.banckfanaoui.mappers.CreditMapper;


import org.app.banckfanaoui.respositories.ClientRepository;
import org.app.banckfanaoui.respositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;

    public CreditService(CreditRepository creditRepository, ClientRepository clientRepository) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
    }

    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll()
                .stream()
                .map(CreditMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CreditDTO getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        return CreditMapper.toDTO(credit);
    }

    public CreditDTO saveCredit(CreditDTO dto) {
        Credit credit = CreditMapper.toEntity(dto);

        // Rattacher le client à l'entité credit
        if (dto.getClientId() != null) {
            Client client = clientRepository.findById(dto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            credit.setClient(client);
        }

        Credit savedCredit = creditRepository.save(credit);
        return CreditMapper.toDTO(savedCredit);
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}