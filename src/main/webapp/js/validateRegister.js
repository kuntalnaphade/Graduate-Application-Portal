 $("#register-form").validate({
  	rules: {
  		first_name: "required",
  		last_name:"required",
  		password: {
  			required: true
  		},
  		email_id: {
  	    required: true,
  			email: true
  		}
  		
    },
	  errorClass: "form-invalid",
	  errorPlacement: function( label, element ) {
  	  	label.insertAfter( element ); 
  	  
    }
  });

  // Form Submission
  $("#register-form").submit(function() {
  	remove_loading($(this));
		
		if(options['useAJAX'] == true)
		{
			// Dummy AJAX request (Replace this with your AJAX code)
		  // If you don't want to use AJAX, remove this
  	  dummy_submit_form($(this));
		
		  // Cancel the normal submission.
		  // If you don't want to use AJAX, remove this
  	  return false;
		}
  });
