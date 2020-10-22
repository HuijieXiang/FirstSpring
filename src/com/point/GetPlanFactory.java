package com.point;

public class GetPlanFactory {
	   //use getPlan method to get object of type Plan   
    public Plan getPlan(String planType) throws Exception{
    	System.out.println("input plan type:"+planType);
         if(planType == null){  
        	 throw new Exception(" input plan is empty");  
         }  
       if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
              return new DomesticPlan();  
            }   
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
             return new CommercialPlan();  
        }
       throw new Exception(" input plan is not valid: "+planType);  
    }
}
