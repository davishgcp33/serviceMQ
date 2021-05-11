package com.davish.serviceMQ;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
@Component
public class ServiceLogic {
	
	
	@Autowired
	MessageRepositoryImpl repository;
	
	@Autowired
	RabbitTemplate template;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	
	public void createCell(FemtoRequestModel model)
	{
		
		System.out.println(model.getServiceModel().getDeviceId().toString());
		
		
		if(repository.findFemtos(model.getServiceModel().getDeviceId().toString())!=null)
		{
			System.out.println("its already present");
			try {
				template.convertAndSend("TestExchange","test",new ObjectMapper().writeValueAsString(model));
			} catch (AmqpException | JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			repository.addFemtos(model);
			serviceRepository.save(model.getServiceModel());
			
			repository.deleteFemtos(model.getServiceModel().getDeviceId().toString());
			System.out.println("Cell created");
		}
		
		
	}
	
	public void updateCell(FemtoRequestModel model)
	{
		
		if(repository.findFemtos(model.getServiceModel().getDeviceId()+"")!=null)
		{
			template.convertAndSend("TestExchange","test",model);
		}
		else
		{
			repository.updateFemtos(model);
			
			
			serviceRepository.save(model.getServiceModel());
			repository.deleteFemtos(model.getServiceModel().getDeviceId()+"");
		}
		
		
	}
	
	
	public void deleteCell(FemtoRequestModel model)
	{
		
		if(repository.findFemtos(model.getServiceModel().getDeviceId()+"")!=null)
		{
			template.convertAndSend("TestExchange","test",model);
		}
		else
		{
			repository.updateFemtos(model);
			
			
			//serviceRepository.save(model.getServiceModel());
			//serviceRepository.delete(model.getServiceModel();
			serviceRepository.deleteById(model.getServiceModel().getDeviceId());
			repository.deleteFemtos(model.getServiceModel().getDeviceId()+"");
		}
		
		
	}
	


}
