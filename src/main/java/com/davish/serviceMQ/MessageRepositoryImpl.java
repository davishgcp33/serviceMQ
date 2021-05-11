package com.davish.serviceMQ;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
	
	
	
	
RedisTemplate< String,FemtoRequestModel> redisTemplate;
HashOperations hashOperations;
	
	
 public MessageRepositoryImpl(RedisTemplate<String, FemtoRequestModel> template) {
	// TODO Auto-generated constructor stub
	 this.redisTemplate=template;
	 this.hashOperations=redisTemplate.opsForHash();
	 
}
	
	

	@Override
	public Map<String, FemtoRequestModel> findAllFemtos() {
		// TODO Auto-generated method stub
		return hashOperations.entries("Femtos");
	}

	@Override
	public void addFemtos(FemtoRequestModel model) {
		
		hashOperations.put("Femtos",model.getServiceModel().getDeviceId().toString(),model);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFemtos(String id) {
		hashOperations.delete(id, "Femtos");
		// TODO Auto-generated method stub

	}

	@Override
	public FemtoRequestModel findFemtos(String id) {
		// TODO Auto-generated method stub
		 return (FemtoRequestModel) hashOperations.get("Femtos", id);
	}

	@Override
	public void updateFemtos(FemtoRequestModel model) {
		hashOperations.put("Femtos", model.getServiceModel().getDeviceId(), model);
		// TODO Auto-generated method stub

	}

}
