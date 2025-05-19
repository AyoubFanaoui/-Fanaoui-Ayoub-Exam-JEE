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

    private CreditRepository creditRepository;
    private final org.app.banckfanaoui.respositories.ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    public CreditService(CreditRepository creditRepository, ClientRepository clientRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
        this.creditMapper = creditMapper;
    }

    public CreditDTO createCredit(CreditDTO dto) {
        Credit credit = creditMapper.toEntity(dto);
        // gérer la liaison client
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        credit.setClient(client);

        credit = creditRepository.save(credit);
        return creditMapper.toDto(credit);
    }

    public CreditDTO getCredit(Long id) {
        return creditRepository.findById(id)
                .map(creditMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
    }

    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(creditMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }


}
