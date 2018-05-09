package com.finuniversally.service;

import javax.jms.Destination;

public interface IProducerService {

    public void sendMessage(Destination destination,  String message);

}