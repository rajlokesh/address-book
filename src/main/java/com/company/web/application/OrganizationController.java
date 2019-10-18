package com.company.web.application;

import com.company.business.dto.OrganizationDTO;
import com.company.business.service.AddressBookService;
import com.company.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/organization")
public class OrganizationController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public List<OrganizationDTO> getOrganizations() {

        return this.addressBookService.getAllOrganization();
    }

    @PostMapping
    public OrganizationDTO createOrganization(@RequestBody OrganizationDTO organizationDTO) {

        return this.addressBookService.createOrganization(organizationDTO);
    }
    @GetMapping(value = "/{orgName}/user")
    public List<User> getUsersOfOrganization(@PathVariable(value = "orgName") String orgName){
        return this.addressBookService.getOrganizationUsers(orgName);
    }


}
