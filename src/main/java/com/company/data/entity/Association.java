package com.company.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ASSOCIATION")
public class Association {
    @Id
    @Column(name = "ASSOCIATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long associationId;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "ORGANIZATION_ID")
    private long organizationId;

    public long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(long associationId) {
        this.associationId = associationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }
}
