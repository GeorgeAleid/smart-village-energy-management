package com.renewableenergy.SHS.entity;

public interface Observer {

	public void update(double producedEnergy, double consumedEnergyWithTariff, double consumedEnergyWithoutTarif);
}
