package com.test.bootify.bootify_test.service;

import com.test.bootify.bootify_test.domain.ClientProfile;
import com.test.bootify.bootify_test.model.ClientProfileDTO;
import com.test.bootify.bootify_test.repos.ClientProfileRepository;
import com.test.bootify.bootify_test.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ClientProfileService {

    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileService(final ClientProfileRepository clientProfileRepository) {
        this.clientProfileRepository = clientProfileRepository;
    }

    public List<ClientProfileDTO> findAll() {
        final List<ClientProfile> clientProfiles = clientProfileRepository.findAll(Sort.by("id"));
        return clientProfiles.stream()
                .map(clientProfile -> mapToDTO(clientProfile, new ClientProfileDTO()))
                .toList();
    }

    public ClientProfileDTO get(final Long id) {
        return clientProfileRepository.findById(id)
                .map(clientProfile -> mapToDTO(clientProfile, new ClientProfileDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ClientProfileDTO clientProfileDTO) {
        final ClientProfile clientProfile = new ClientProfile();
        mapToEntity(clientProfileDTO, clientProfile);
        return clientProfileRepository.save(clientProfile).getId();
    }

    public void update(final Long id, final ClientProfileDTO clientProfileDTO) {
        final ClientProfile clientProfile = clientProfileRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(clientProfileDTO, clientProfile);
        clientProfileRepository.save(clientProfile);
    }

    public void delete(final Long id) {
        clientProfileRepository.deleteById(id);
    }

    private ClientProfileDTO mapToDTO(final ClientProfile clientProfile,
            final ClientProfileDTO clientProfileDTO) {
        clientProfileDTO.setId(clientProfile.getId());
        clientProfileDTO.setUserId(clientProfile.getUserId());
        clientProfileDTO.setCreditScore(clientProfile.getCreditScore());
        clientProfileDTO.setLocation(clientProfile.getLocation());
        clientProfileDTO.setStatus(clientProfile.getStatus());
        return clientProfileDTO;
    }

    private ClientProfile mapToEntity(final ClientProfileDTO clientProfileDTO,
            final ClientProfile clientProfile) {
        clientProfile.setUserId(clientProfileDTO.getUserId());
        clientProfile.setCreditScore(clientProfileDTO.getCreditScore());
        clientProfile.setLocation(clientProfileDTO.getLocation());
        clientProfile.setStatus(clientProfileDTO.getStatus());
        return clientProfile;
    }

}
