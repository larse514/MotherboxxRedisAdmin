;HTTP = {

	getCacheValue: function(query)
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + query,
		    type: 'GET',
		    success: RESPONSE.handleSuccess,
		    error: RESPONSE.handleError
		});
	},
	
	getHealthCheck: function()
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/healthCheck'
		    type: 'GET',
		    success: RESPONSE.handleStatus,
		    error: RESPONSE.handleError
		});
	},
	


	addCacheValue: function(data)
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + query,
		    type: 'POST',
		    data: data,
		    success: RESPONSE.handleSuccess,
		    error: RESPONSE.handleError
		});
	}

}
