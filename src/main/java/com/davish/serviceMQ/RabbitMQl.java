package com.davish.serviceMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQl {
	
	@Autowired
	ServiceLogic serviceLogic;
	
	
	@RabbitListener(queues = "RoutedQueue")
	public void recievedMessage(String message) {
		System.out.println("Recieved Message From RabbitMQ: " + message);
		try {
			FemtoRequestModel model=new ObjectMapper().readValue(message, FemtoRequestModel.class);
			if(model.getTypeOfRequest().equals("CREATE_CELL"))
			{
				serviceLogic.createCell(model);
			}
			else if(model.getTypeOfRequest().equals("UPDATE_CELL"))
			{
				serviceLogic.updateCell(model);
				
			}
			else if(model.getTypeOfRequest().equals("DELETE_CELL"))
			{
				serviceLogic.deleteCell(model);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			

	}

}
