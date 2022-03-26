package org.sid.demospringdatarest.services;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
    @Override
    public double salaireAnnuel(double salaire) {
        return salaire*12;
    }
}
