package com.company.business.service;

import com.company.business.dto.AssociationDTO;
import com.company.business.dto.OrganizationDTO;
import com.company.business.dto.UserDTO;
import com.company.data.entity.Association;
import com.company.data.entity.Organization;
import com.company.data.entity.User;
import com.company.data.repository.AssociationRepository;
import com.company.data.repository.OrganizationRepository;
import com.company.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final AssociationRepository associationRepository;


    @Autowired
    public AddressBookService(UserRepository userRepository, OrganizationRepository organizationRepository, AssociationRepository associationRepository) {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.associationRepository = associationRepository;
    }


    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        this.userRepository.save(user);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        this.userRepository.findAll().forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setAddress(user.getAddress());
            userDTOList.add(userDTO);
        });
        return userDTOList;
    }

    public void createAssociation(AssociationDTO associationDTO) {

        Association association = new Association();
        association.setOrganizationId(
                this.organizationRepository.findByName(
                        associationDTO.getOrganizationName()).get(0).getId());
        association.setUserId(
                this.userRepository.findByEmail(
                        associationDTO.getUserEmail()).get(0).getUserId());

        this.associationRepository.save(association);
    }

    public AssociationDTO deleteAssociation(AssociationDTO associationDTO) {
        long orgId = this.organizationRepository.findByName(
                associationDTO.getOrganizationName()).get(0).getId();
        long userId = this.userRepository.findByEmail(
                associationDTO.getUserEmail()).get(0).getUserId();
        Optional<Association> associationList = this.associationRepository.findByOrganizationIdAndUserId(orgId, userId);
        associationList.ifPresent(this.associationRepository::delete);
        return associationDTO;
    }

    public List<Organization> getUserOrganizations(String userEmail) {
        List<Organization> organizationList = new ArrayList<>();
        long userID = this.userRepository.findByEmail(userEmail).get(0).getUserId();
        List<Association> associationList = this.associationRepository.findByUserId(userID);
        associationList.forEach(association ->
                organizationList.add(this.
                        organizationRepository.
                        findById(association.getOrganizationId()).get()));
        return organizationList;

    }


    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setName(organizationDTO.getName());
        organization.setAddress(organizationDTO.getAddress());
        organization.setPhone(organizationDTO.getPhone());
        this.organizationRepository.save(organization); //TODO: handle unique
        return organizationDTO;
    }

    public List<OrganizationDTO> getAllOrganization() {
        List<OrganizationDTO> organizationDTOList = new ArrayList<>();
        for (Organization organization : this.organizationRepository.findAll()) {
            OrganizationDTO organizationDTO = new OrganizationDTO();
            organizationDTO.setName(organization.getName());
            organizationDTO.setPhone(organization.getPhone());
            organizationDTO.setAddress(organization.getAddress());
            organizationDTOList.add(organizationDTO);
        }
        return organizationDTOList;
    }

    public List<User> getOrganizationUsers(String orgName) {
        List<User> userList = new ArrayList<>();
        long organizationId = this.organizationRepository.findByName(orgName).get(0).getId();
        List<Association> associationList = this.associationRepository.findByOrganizationId(organizationId);
        associationList.forEach(association ->
                userList.add(this.
                        userRepository.
                        findById(association.getUserId()).get()));
        return userList;
    }

}
