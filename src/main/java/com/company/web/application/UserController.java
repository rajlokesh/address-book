package com.company.web.application;

import com.company.business.dto.AssociationDTO;
import com.company.business.dto.OrganizationNameDTO;
import com.company.business.dto.UserDTO;
import com.company.business.service.AddressBookService;
import com.company.data.entity.Organization;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {


    private final AddressBookService addressBookService;

    public UserController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return this.addressBookService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return this.addressBookService.createUser(userDTO);
    }


    @PostMapping(value = "{userEmail}/organization")
    public String addAssociation(@PathVariable(value = "userEmail") String userEmail, @RequestBody OrganizationNameDTO organizationNameDTO) {
        AssociationDTO associationDTO = new AssociationDTO();
        associationDTO.setOrganizationName(organizationNameDTO.getName());
        associationDTO.setUserEmail(userEmail);
        this.addressBookService.createAssociation(associationDTO);
        return userEmail + " Added to " + organizationNameDTO.getName();
    }

    @DeleteMapping(value = "{userEmail}/organization")
    public String removeAssociation(@PathVariable(value = "userEmail") String userEmail, @RequestBody OrganizationNameDTO organizationNameDTO) {
        AssociationDTO associationDTO = new AssociationDTO();
        associationDTO.setOrganizationName(organizationNameDTO.getName());
        associationDTO.setUserEmail(userEmail);
        this.addressBookService.deleteAssociation(associationDTO);
        return userEmail + " Removed from " + organizationNameDTO.getName();
    }
    @GetMapping(value = "/{userEmail}/organization")
    public List<Organization> getOrganizationOfUser(@PathVariable(value = "userEmail") String userEmail){
        return this.addressBookService.getUserOrganizations(userEmail);
    }

}
