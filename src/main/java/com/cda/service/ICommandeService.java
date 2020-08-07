package com.cda.service;

import com.cda.entity.Panier;

public interface ICommandeService {

	public String checkout(Panier panier);

	public void updateStatus(String numeroCmd);
}
