/**
 * 
 */

 // First Request TO Server TO Create Order
   const paymentStart =()=>{
	   console.log("Payment Start...");
	   let amount=$("#payment_input").val();
	   console.log(amount);
	   if(amount==" " || amount==null)
	   {
		   alert("Amount Is Requried");
		   return;
	   }
	   
	   //Useing Ajex For Sending Request To Server And Creating Order
	   $.ajax(
		   {
			   url:"/pay2",
			   data:JSON.stringify({amount:amount,info:"Order_Request"}),
			   contentType:"appliction/json",
			   type:"POST",
			   dataType:"json",
			   success:function(response)
			   {
				   //invoke when sucess
				   console.log(response);
			   },
			   error:function(error)
			   {
				  //invoke when error
				   console.log(error);
				   alert("Somthing Went Wrong...");
				   
			   },
			   
		   });
   };
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   