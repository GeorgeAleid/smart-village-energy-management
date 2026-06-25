package com.renewableenergy.SGS.service;

import java.util.ArrayList;

import Mqtt.MqttPublisherImpl;

public class TarifService {
	public MqttPublisherImpl publisher;
	
	public void getTarif() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("gold");
		list.add("normal");
		int index = (int)(Math.random() * list.size());
		  
        System.out.println("Random Element is :"
                           +list.get(index));
		publisher=new MqttPublisherImpl();
		publisher.publishMessage("Tarif", list.get(index));
	}
}
