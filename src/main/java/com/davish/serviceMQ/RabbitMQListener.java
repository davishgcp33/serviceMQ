package com.davish.serviceMQ;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class RabbitMQListener/* implements MessageListener*/{

	
	@Autowired
	ServiceLogic serviceLogic;
	
	
//	@Override
//	public void onMessage(Message message) {
//		//ServiceLogic serviceLogic=new ServiceLogic();
//		    	
//		    	System.out.println(message.getBody());
//	try {
//		FemtoRequestModel model=new ObjectMapper().readValue(message.getBody(), FemtoRequestModel.class);
//		if(model.getTypeOfRequest().equals("CREATE_CELL"))
//		{
//			serviceLogic.createCell(model);
//		}
//		else if(model.getTypeOfRequest().equals("UPDATE_CELL"))
//		{
//			serviceLogic.updateCell(model);
//			
//		}
//		else if(model.getTypeOfRequest().equals("DELETE_CELL"))
//		{
//			serviceLogic.deleteCell(model);
//		}
//	} catch (JsonParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (JsonMappingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}			
//				
//					
//					
////			
////		
//		System.out.println(new String(message.getBody()));
//	//FemtoRequestModel model=(FemtoRequestModel)SerializationUtils.deserialize(message.getBody());
//		
////		
//		
//		
		
//	}

}
