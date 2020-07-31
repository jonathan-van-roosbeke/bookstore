package com.cda.entity;

import javax.persistence.*;

@Table(name = "roles")
public enum Roles {
    CLIENT, LIBRAIRE;
}