package com.davish.serviceMQ;

import java.util.Map;



public interface MessageRepository {
	
	

	 Map<String,FemtoRequestModel>findAllFemtos();

	    void addFemtos(FemtoRequestModel model);

	    void deleteFemtos(String id);

	    FemtoRequestModel findFemtos(String id);
	    void updateFemtos(FemtoRequestModel model);


}
